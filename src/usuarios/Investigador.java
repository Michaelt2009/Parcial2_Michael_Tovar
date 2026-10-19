package usuarios;

import plataforma.Experimento;
import java.util.ArrayList;

/**
 * Investigador que se ASOCIA a varios experimentos (N:M).
 */
public class Investigador {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Investigador(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    /** Asocia el investigador a un experimento existente. */
    public void asociarExperimento(Experimento experimento) {
        if (experimento != null && !this.experimentos.contains(experimento)) {
            this.experimentos.add(experimento);
        }
    }

    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}