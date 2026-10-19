package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int loss = this.numCapas * 10;
        for (int i = 0; i < getLossPorEpoca().length; i++) {
            registrarEpoca(loss);
            loss = Math.max(1, loss - 1);
        }
        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}