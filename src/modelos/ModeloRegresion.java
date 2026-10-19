package modelos;

import datos.Dataset;

/**
 * Modelo de regresión. Hiperparámetro: grado del polinomio.
 */
public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int loss = (this.grado + 1) * 10;
        for (int i = 0; i < getLossPorEpoca().length; i++) {
            registrarEpoca(loss);
            loss = Math.max(1, loss - 1);
        }
        return mejorLoss();
    }

    public int getGrado() { return grado; }
}