public class Main {

    public static void main(String[] args) {

        double[][] inputs = new double[][] {
                {300, 2000},
                {250, 1500},
                {180, 1000},
                {400, 2000},
                {190, 1000}
        };
        double[] outputs = new double[]{200, 180, 160, 230, 165};

        Neuron neuron = new Neuron(inputs, outputs);
        neuron.train(100000);

        Model model = neuron.exportModel();
        System.out.println(model.predict(new double[]{190, 1000}));
    }
}
