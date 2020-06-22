public class Main {

    public static void main(String[] args) {

        //Initialize inputs and outputs:
        double[][] inputs = new double[][] {
                {100, 155.1, 1101},
                {504, 132, 193.8},
                {190, 180, 170},
                {155.6, 1203, 203}
        };
        double[] outputs = new double[]{1000, 1654, 1100, 2400};

        //Train:
        PositiveCorrelationPerceptron neuron = new PositiveCorrelationPerceptron(inputs, outputs);
        neuron.train(1);

        //Export model and predict:
        Model model = neuron.exportModel();
        System.out.println(model.predict(new double[]{100, 155.1, 1181}));
    }
}
