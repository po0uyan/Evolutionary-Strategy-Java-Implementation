package ES;
public class Eval {
	public static void eval(Individual in){
		int dimension=in.vars.length;
		double sum= 418.9829 * dimension;
		for (int j = 0; j < dimension; j++) {
            if (Math.abs(in.vars[j]) > 500)
 			in.fitness= Double.MAX_VALUE;             
			sum -= in.vars[j]*Math.sin(Math.sqrt(Math.abs(in.vars[j])));
        }
        in.fitness=sum;
            
        }
		
}