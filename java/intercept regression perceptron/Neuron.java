import java.util.Arrays;

public class Neuron {

    public static double[][] inputs;
    public static double[] outputs;
    public static double[] weights;
    public static double intercept;

    //Constructor:
    public Neuron(double[][] passedInputs, double[] passedOutputs) {

        //Fills inputs:
        inputs = new double[passedInputs.length][passedInputs[0].length];
        for (int i = 0; i < passedInputs.length; i++) {
            for (int j = 0; j < passedInputs[i].length; j++) {
                inputs[i][j] = passedInputs[i][j];
            }
        }

        //Fills outputs:
        outputs = new double[passedOutputs.length];
        for (int i = 0; i < passedOutputs.length; i++) {
            outputs[i] = passedOutputs[i];
        }

        //Finds baseline intercept through average of outputs:
        double min = Double.MAX_VALUE;
        for (double val : outputs) {
            if (val < min) {
                min = val;
            }
        }
        intercept = min * 0.9;

        //Fills weights:
        weights = new double[passedInputs[0].length];
        Arrays.fill(weights, 0);
        for (int i = 0; i < passedInputs.length; i++) {
            for (int j = 0; j < passedInputs[i].length; j++) {
                weights[j] = weights[j] + ((outputs[i] - intercept) / inputs[i][j]);
            }
        }
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i] / inputs.length;
        }
    }

    //Auto training function:
    public static void train(int cycles) {

        int passedCycles = 0;

        //Trains till the program self determines that it is finished training:
        boolean trainingFinished = false;
        while (passedCycles < cycles) {

            int row = 0;
            int column = 0;
            for (row = 0; row < inputs.length; row++) {

                //Calculates test value:
                double test = intercept;
                double real = outputs[row];
                for (column = 0; column < inputs[row].length; column++) {
                    test = test + (inputs[row][column] * weights[column]);
                }

                //Adjusts weights according to error:
                double error = test - real;
                for (int i = 0; i < weights.length; i++) {
                    error = (error * inputs[row][i]) / 1000000;
                    weights[i] = weights[i] - error;
                }

                passedCycles++;
            }
        }

        //Displays final weights:
        System.out.println("Training finished according to error margin. Epochs completed: " + passedCycles);
        for (int i = 0; i < weights.length; i++) {
            System.out.println("weights[" + i + "]: " + weights[i] + " + " + intercept);
        }
    }

    //Exports the model:
    public static Model exportModel() {
        return new Model(weights, intercept);
    }
}
