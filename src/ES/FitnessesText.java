package ES;


/**
 * Created by pouyan on 6/9/17.
 */
public class FitnessesText {



    public static   String ackley="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tdouble sum1=0;\n" +
            "\t\tdouble sum2=0;\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tfor (int i = 0; i < dimension; i++)\n" +
            "\n" +
            "\t\t{\n" +
            "\n" +
            "\t\t\tsum1 = sum1 + in.vars[i] * in.vars[i];\n" +
            "\t\t\tsum2 = sum2 + (Math.cos(2 * Math.PI * in.vars[i]));\n" +
            "\t\t}\n" +
            "\t\tin.fitness = -20 * Math.exp(-0.2 * Math.sqrt(sum1 / dimension)) -\n" +
            "\t\t\t\tMath.exp(sum2 / dimension) + 20 + Math.exp(1);\n" +
            "}}";




    public static  String rastrigin="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tdouble sum=10.0 * dimension;\n" +
            "\t\tfor (int j = 0; j < dimension; j++) {\n" +
            "            if (Math.abs(in.vars[j]) > 5.12){ \n" +
            "            in.fitness= Double.MAX_VALUE; \n" +
            "            break;\n" +
            "            }\n" +
            "            sum += in.vars[j]*in.vars[j]-10.0*Math.cos(2.0*Math.PI*in.vars[j]);\n" +
            "        }\n" +
            "\t\tin.fitness =sum;\n" +
            "}}";


    public static  String griewangk="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tdouble sum = 0.0, prod = 1.0;\n" +
            "        for (int j = 0; j < dimension; j++) {\n" +
            "            sum += in.vars[j] * in.vars[j] / 4000.0;\n" +
            "            prod *= Math.cos((in.vars[j]) / Math.sqrt(j + 1));\n" +
            "        }\n" +
            "        in.fitness = 1.0 + sum - prod;\n" +
            "\t\t\n" +
            "}}";

    public static  String schwefel="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tdouble sum= 418.9829 * dimension;\n" +
            "\t\tfor (int j = 0; j < dimension; j++) {\n" +
            "            if (Math.abs(in.vars[j]) > 500)\n" +
            " \t\t\tin.fitness= Double.MAX_VALUE;             \n" +
            "\t\t\tsum -= in.vars[j]*Math.sin(Math.sqrt(Math.abs(in.vars[j])));\n" +
            "        }\n" +
            "        in.fitness=sum;\n" +
            "            \n" +
            "        }\n" +
            "\t\t\n" +
            "}";
    public static  String rosenbrock="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tdouble sum=0;\n" +
            "\t\tfor (int j = 1; j < dimension; j++) {\n" +
            "\t\t\tif (Math.abs(in.vars[j]) > 2.048) \n" +
            "\t\t\t\tin.fitness= Double.MAX_VALUE; // penalty\n" +
            "\t\t\tsum += 100.0 * (in.vars[j] - in.vars[j-1] * in.vars[j-1])\n" +
            "\t\t\t\t\t* (in.vars[j] - in.vars[j-1] * in.vars[j-1])\n" +
            "\t\t\t\t\t+ (1 - in.vars[j-1])*(1 - in.vars[j-1]);\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t//\n" +
            "        in.fitness=sum;\n" +
            "            \n" +
            "        }\n" +
            "\t\t\n" +
            "}";
    public static  String circle="package ES;\n" +
            "public class Eval {\n" +
            "\tpublic static void eval(Individual in){\n" +
            "\t\tint dimension=in.vars.length;\n" +
            "\t\tdouble sum = 0.0;\n" +
            "\t\tfor (int j = 0; j < dimension; j++) {\n" +
            "\t\t\tsum += in.vars[j] * in.vars[j];\n" +
            "\t\t}\n" +
            "        in.fitness=sum;\n" +
            "            \n" +
            "        }\n" +
            "\t\t\n" +
            "}";

}