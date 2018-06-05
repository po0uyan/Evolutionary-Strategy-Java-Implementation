package ES;

import java.text.DecimalFormat;

/**
 * Created by pouyan on 6/7/17.
 */
public class Individual implements Comparable {
    public static int  numVars;
    public static int  numAngles;
    public double      [] vars = new double[numVars];
    public double      [] sigmas = new double[numVars];
    public double      [] angles = new double[numAngles];
    public double      fitness;


    public  Individual() {

    }


    @Override
    public int compareTo(Object i) {

        if(this.fitness == ((Individual) i).fitness){
            return 0;
        }
        return (this.fitness<((Individual) i).fitness ? -1 : 1);

    }
     @Override
     public String toString(){
         String  varsStr="",
                 stndrDevStr="",
                 anglesStr="";
         for (int i = 0; i <numVars ; i++) {
             varsStr+=new DecimalFormat("###.######").format(this.vars[i])+" ";
             stndrDevStr+=new DecimalFormat("###.######").format(this.sigmas[i])+" ";
         }
         for (int i = 0; i <numAngles ; i++) {
             anglesStr+=new DecimalFormat("###.######").format(this.angles[i])+" ";

         }

         return "\n Angles: " + anglesStr +"\n  Variables: " + varsStr + "\n  Standard Deviations: " + stndrDevStr
                  + "\n  Fitness: " + this.fitness;
     }
}
