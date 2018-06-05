package ES;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by pouyan on 6/8/17.
 */
public class ES {

    static final int num_gen = 50;
    static  int mu;
    static  int lambda ;
    static  int numvars;
    static  boolean isElitism;
    static  double permutP;
    static  double xoverP;
    static  double [][] intrval;


    static double globalTau;
    static double localTau;
    static final double beta = 0.0873;
    static final double epsilon = 0.05;
    static final double maxStepSize = 4.0;
    static  int numangles ;
    static int bestGenIndex=0;

    public ES(int mu, double [][] intrval ,boolean isElitism,double permutP,double xoverP){
        ES.mu=mu;
        ES.lambda=7*mu;
        ES.numvars=intrval[0].length;
        ES.isElitism=isElitism;
        ES.permutP=permutP;
        ES.xoverP=xoverP;
        ES.globalTau = 1/Math.sqrt(2*numvars);
        ES.localTau = 1/Math.sqrt(2*Math.sqrt(numvars));
        ES.numangles= numvars * (numvars - 1) / 2;
        ES.intrval=intrval;
        Individual.numAngles=numangles;
        Individual.numVars=numvars;

    }

    public static String start(){
        Random rnd = new Random();
        Individual [] population = new Individual[mu];
        Individual best =new Individual();
        best.fitness=Double.MAX_VALUE; //so that no one could be better than this


        for (int i = 0; i <mu ; i++) {
            population[i]=new Individual();


            for (int j = 0; j < numvars; j++) {
                double d = (rnd.nextDouble() - 0.5) * 2.0 * (intrval[1][j]-intrval[0][j]);
                population[i].vars[j]=((d<0) ?  d+intrval[1][j]:d+intrval[0][j]);
                System.out.println(population[i].vars[j]);
                population[i].sigmas[j] = rnd.nextDouble()*maxStepSize;
            }

            for (int j = 0; j < numangles; j++) {
                population[i].angles[j] = (rnd.nextDouble() - 0.5) * Math.PI;
            }

            Eval.eval(population[i]);
            best = (best.compareTo(population[i]) < 0) ? best : population[i];

        }
        System.out.println("Best in initial population:\n" + best);


        Individual[] tempPopulation = new Individual[lambda];

        Callable<Individual> myEs = () -> {
            Individual parent1 = population[rnd.nextInt(mu)];
            Individual parent2 = population[rnd.nextInt(mu)];
            Individual child = new Individual();

            //xover
            if(rnd.nextDouble()<xoverP) {
                for (int k = 0; k < numvars; k++) {
                    child.vars[k] = (rnd.nextBoolean()) ? parent1.vars[k]
                            : parent2.vars[k];
                    child.sigmas[k] = 0.5 * (parent1.sigmas[k] + parent2.sigmas[k]);
                }
                for (int k = 0; k < numangles; k++) {
                    child.angles[k] = 0.5 * (parent1.angles[k] + parent2.angles[k]);
                }
            }
            // mutate child - first standard deviations
            double global = globalTau * rnd.nextGaussian();
            for (int k = 0; k < numvars; k++) {
                child.sigmas[k] *=
                        Math.exp(global + localTau * rnd.nextGaussian());
                if (child.sigmas[k] < epsilon) {
                    child.sigmas[k] = epsilon;
                }
            }
            // mutate angles
            for (int k = 0; k < numangles; k++) {
                child.angles[k] += beta * rnd.nextGaussian();
                while (Math.abs(child.angles[k]) >  2* Math.PI) {
                    child.angles[k] = (child.angles[k] > 0)
                            ?  2*Math.PI : -2*Math.PI;  /** maybe not correct*/
                    System.out.println("shit");
                }
            }
            /** the change to the variables */
            double[] delta = new double[numvars];
            // now mutate variables
            for (int k = 0; k < numvars; k++) {
                delta[k] = child.sigmas[k] * rnd.nextGaussian();
            }
            // correlate the delta only if correlated mutation is enabled
            for (int l = 0;l < numvars; l++) {
                for (int k = 0; k < l; k++) {
                    double a = child.angles[index(k,l)];
                    double old_k = delta[k];
                    delta[k] = Math.cos(a) * old_k - Math.sin(a) * delta[l];
                    delta[l] = Math.cos(a) * delta[l] + Math.sin(a) * old_k;
                }
            }
            for (int k = 0; k < numvars; k++) {
                child.vars[k] += delta[k];
                        if(child.vars[k]>intrval[1][k])
                            child.vars[k]=intrval[1][k];
                        else if(child.vars[k]<intrval[0][k])
                            child.vars[k]=intrval[0][k];
            }

            // evaluate the child
            Eval.eval(child);
            // add child to temporary population



            return child;
        };

        Progress prgr= new Progress();
//ExecutorService executor ;
//            executor = Executors.newFixedThreadPool(lambda);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

            List<Future<Individual>> list = new ArrayList<Future<Individual>>();


            for (int j = 0; j < 1000; j++) {
                list.clear();
                prgr.setValue(j, population);
                for (int m = 0; m < lambda; m++) {
                    Future<Individual> future = executor.submit(myEs);
                    list.add(future);
                }
                int iter = 0;
                for (Future<Individual> fut : list) {
                    try {
                        tempPopulation[iter] = fut.get();
                        iter++;
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                Arrays.sort(tempPopulation);
//                if(j==0)
//                    for (int i = 0; i < tempPopulation.length; i++) {
//                        System.out.println(tempPopulation[i]);
//                    }
                for (int k = 0; k < mu; k++)
                    population[k] = tempPopulation[k];
                if (best.compareTo(population[0]) > 0) {
                    best = population[0];
                    bestGenIndex = j;
                }

            }
            executor.shutdown();





        return population[0]+"\n best: "+best+"\ngeneration index: "+bestGenIndex+" ";

    }
    public static int index(int p, int q)
    {
        return (2 * numvars - p - 1) * (p + 2) / 2 - 2 * numvars + q;
    }
}


