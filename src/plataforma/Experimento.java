package plataforma;

import datos.Dataset;
import modelos.*;

/**
 * Experimento que COMPONE un modelo.
 * El modelo se crea dentro del constructor (composición real).
 */
public class Experimento {

    private String id;
    private Modelo modelo;

    /**
     * Crea el modelo según el tipo indicado.
     * Tipo: "CNN", "RNN", "REGRESION".
     * Si el tipo es inválido, el modelo queda null.
     */
    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;
        if (tipoModelo != null) {
            switch (tipoModelo.toUpperCase()) {
                case "CNN":
                    this.modelo = new ModeloCNN(id, maxEpocas, 16);
                    break;
                case "RNN":
                    this.modelo = new ModeloRNN(id, maxEpocas, 2);
                    break;
                case "REGRESION":
                    this.modelo = new ModeloRegresion(id, maxEpocas, 1);
                    break;
                default:
                    this.modelo = null;
                    break;
            }
        } else {
            this.modelo = null;
        }
    }

    /** Ejecuta el entrenamiento del modelo sobre el dataset. */
    public double ejecutar(Dataset dataset) {
        if (this.modelo != null) {
            return this.modelo.entrenar(dataset);
        }
        return 0;
    }

    public String getId() { return id; }
    public Modelo getModelo() { return modelo; }
}