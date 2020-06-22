import java.util.Random;

public class Neuron {

    private static double[][] inputs;
    private static double[] outputs;
    private static double[] weights;

    //Constructor:
    public PositiveCorrelationPerceptron(double[][] passedInputs, double[] passedOutputs) {

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

        //Fills weights:
        weights = new double[inputs[0].length];
        Random rnd = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = 1 / Double.valueOf(inputs[0].length);
        }
    }

    //Auto training function:
    public static void train(double errorMargin) {

        int passedCycles = 0;

        //Trains until the program self determines that it is finished training:
        boolean trainingFinished = false;
        while (!trainingFinished) {

            //Calculates experimental value:
            int row = 0;
            int column = 0;
            for (row = 0; row < inputs.length; row++) {
                double test = 0;
                double real = outputs[row];
                for (column = 0; column < inputs[row].length; column++) {
                    test = test + (inputs[row][column] * weights[column]);
                }

                //Compares experimental with real value:
                double max = real + errorMargin;
                double min = real - errorMargin;
                if (test >= min) {
                    if (test <= max) {
                        trainingFinished = true;
                        break;
                    }
                }

                //Adjusts weights according to error:
                double error = test - real;
                for (int i = 0; i < inputs[row].length; i++) {
                    error = error * inputs[row][i] / 1000000;
                    weights[i] = weights[i] - error;
                }

                passedCycles++;
            }
        }

        //Displays final weights:
        System.out.println("Training finished according to error margin. Epochs completed: " + passedCycles);
        for (int i = 0; i < weights.length; i++) {
            System.out.println("weights[" + i + "]: " + weights[i]);
        }
    }

    //Exports the model:
    public static Model exportModel() {
        return new Model(weights);
    }
}
