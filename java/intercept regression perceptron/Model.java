public class Model {

    public static double[] weights;
    public static double intercept;

    public Model(double[] passedWeights, double passedIntercept) {
        weights = new double[passedWeights.length];
        for (int i = 0; i < passedWeights.length; i++) {
            weights[i] = passedWeights[i];
        }
        intercept = passedIntercept;
    }

    public static double predict(double[] inputs) {
        double output = intercept;
        for (int i = 0; i < inputs.length; i++) {
            output = output + (inputs[i] * weights[i]);
        }
        return output;
    }
}
