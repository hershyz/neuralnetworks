import java.util.List;

public class Main {

    public static void main(String[] args) {

        OutlierIdentifier outlierIdentifier = new OutlierIdentifier();

        double[][] inputs = new double[][] {
                {1, 2, 3},
                {1, 2, 3},
                {2, 3, 4},
                {9, 10, 2}
        };
        double[] outputs = new double[]{4, 19, 3.3, 0};

        List<double[]> newInput = outlierIdentifier.eliminateInputOutliers(inputs);
        List<Double> newOutput = outlierIdentifier.eliminateOutputOutliers(outputs);

        System.out.println("New Inputs:");
        for (int i = 0; i < newInput.size(); i++) {
            for (int j = 0; j < newInput.get(i).length; j++) {
                System.out.print(newInput.get(i)[j]);
                if (j < newInput.get(i).length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("New Outputs:");
        for (int i = 0; i < newOutput.size(); i++) {
            System.out.print(newOutput.get(i));
            if (i < newOutput.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
