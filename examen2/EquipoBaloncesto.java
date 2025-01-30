package examen2;

import java.io.Serializable;

public class EquipoBaloncesto extends Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ganados;
    private int perdidos;

    // Constructor por defecto
    public EquipoBaloncesto() {
        super();
        this.ganados = 0;
        this.perdidos = 0;
    }

    // Constructor personalizado
    public EquipoBaloncesto(String codigo, String nombre, int creacion, int plantilla, double presupuesto, int ganados, int perdidos) {
        super(codigo, nombre, creacion, plantilla, presupuesto);
        this.ganados = ganados;
        this.perdidos = perdidos;
    }

    // Constructor copia
    public EquipoBaloncesto(EquipoBaloncesto otro) {
        super(otro);
        this.ganados = otro.ganados;
        this.perdidos = otro.perdidos;
    }

    // Getters y Setters
    public int getGanados() { return ganados; }
    public void setGanados(int ganados) { this.ganados = ganados; }
    public int getPerdidos() { return perdidos; }
    public void setPerdidos(int perdidos) { this.perdidos = perdidos; }

    // Porcentaje de victorias
    public double porcentajeVictorias() {
        int total = ganados + perdidos;
        return total == 0 ? 0.0 : (ganados * 100.0) / total;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " " + ganados + " " + perdidos + " " + porcentajeVictorias() + "%";
    }

    // equals y hashCode (basados en código)
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // compareTo (ganados descendente, perdidos ascendente, nombre ascendente)
    @Override
    public int compareTo(Equipo otro) {
        if (otro instanceof EquipoBaloncesto) {
            EquipoBaloncesto otroEq = (EquipoBaloncesto) otro;
            if (this.ganados != otroEq.ganados) {
                return otroEq.ganados - this.ganados;
            } else if (this.perdidos != otroEq.perdidos) {
                return this.perdidos - otroEq.perdidos;
            } else {
                return this.getNombre().compareTo(otroEq.getNombre());
            }
        }
        return super.compareTo(otro);
    }
}