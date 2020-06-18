public class Model {

    public static double[] weights;

    //Initialize weights through constructor:
    public Model(double[] _weights) {
        weights = new double[_weights.length];
        for (int i = 0; i < _weights.length; i++) {
            weights[i] = _weights[i];
        }
    }

    //Predict based on static weights:
    public static double predict(double[] inputs) {
        double output = 0;
        for (int i = 0; i < inputs.length; i++) {
            output = output + (inputs[i] * weights[i]);
        }
        return output;
    }
}
