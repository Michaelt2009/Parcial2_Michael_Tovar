package plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 * Plataforma que AGREGA experimentos.
 */
public class Plataforma {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    /** Agrega un experimento ya existente (agregación). */
    public void agregarExperimento(Experimento experimento) {
        if (experimento != null) {
            this.experimentos.add(experimento);
        }
    }

    /**
     * Reporte: una línea por experimento con su id y el mejor loss de su modelo.
     */
    public List<String> reporteMejorLoss() {
        List<String> reporte = new ArrayList<>();
        for (Experimento exp : this.experimentos) {
            if (exp != null && exp.getModelo() != null) {
                reporte.add(exp.getId() + ": " + exp.getModelo().mejorLoss());
            }
        }
        return reporte;
    }

    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}