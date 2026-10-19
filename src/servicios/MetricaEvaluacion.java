package servicios;

import modelos.Modelo;

/**
 * Servicio que calcula métricas de evaluación para un modelo.
 * Se usa como DEPENDENCIA desde Modelo.calcularMetrica(MetricaEvaluacion).
 */
public class MetricaEvaluacion {

    /**
     * TODO estudiante:
     * Devuelve una métrica derivada del mejor loss del modelo.
     * Fórmula sugerida: 100.0 / (1 + modelo.mejorLoss())
     * Si mejorLoss() == Integer.MAX_VALUE (sin épocas), retorna 0.
     */
    public double calcular(Modelo modelo, String nombreMetrica) {
        if (modelo == null || modelo.mejorLoss() == Integer.MAX_VALUE) {
            return 0;
        }
        return 100.0 / (1 + modelo.mejorLoss());
    }
}