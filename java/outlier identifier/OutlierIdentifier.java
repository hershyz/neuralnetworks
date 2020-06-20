import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutlierIdentifier {

    //Removes input outliers:
    public static List<double[]> eliminateInputOutliers(double[][] input) {

        List<Integer> outlierRowIndexes = new ArrayList<>();

        //Calculates averages of each input:
        double[] inputAverages = new double[input[0].length];
        Arrays.fill(inputAverages, 0);

        for (int i = 0; i < input[0].length; i++) {
            double average = 0;
            for (int j = 0; j < input.length; j++) {
                average = average + input[j][i];
            }
            average = average / input.length;
            inputAverages[i] = average;
        }

        //Compares inputs with mean values:
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                double currentInputAverage = inputAverages[j];
                double max = currentInputAverage * 1.5;
                double min = currentInputAverage * 0.5;
                double current = input[i][j];
                if (current > max) {
                    if (!outlierRowIndexes.contains(i)) {
                        outlierRowIndexes.add(i);
                    }
                }
                if (current < min) {
                    if (!outlierRowIndexes.contains(i)) {
                        outlierRowIndexes.add(i);
                    }
                }
            }
        }

        //Fills new input array without outliers:
        List<double[]> newInput = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (!outlierRowIndexes.contains(i)) {
                newInput.add(input[i]);
            }
        }

        return newInput;
    }

    //Removes output outliers:
    public static List<Double> eliminateOutputOutliers(double[] output) {

        List<Double> newOutput = new ArrayList<>();

        //Calculates mean output:
        double mean = 0;
        for (int i = 0; i < output.length; i++) {
            mean = mean + output[i];
        }
        mean = mean / output.length;

        //Compares outputs with mean values:
        double max = mean * 1.5;
        double min = mean * 0.5;
        for (int i = 0; i < output.length; i++) {
            double current = output[i];
            if (current < max) {
                if (current > min) {
                    newOutput.add(current);
                }
            }
        }

        return newOutput;
    }
}
