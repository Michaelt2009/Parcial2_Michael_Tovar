package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas recurrentes.
 */
public class ModeloCNN extends Modelo {

    private int numCapas;

    public ModeloCNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    /**
     * TODO estudiante:
     * Simula el entrenamiento registrando hasta maxEpocas valores decrecientes
     * de loss. Retorna el mejor (menor) loss alcanzado.
     * Puedes usar un loss inicial proporcional a numCapas y decrementarlo
     * en cada época.
     */
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