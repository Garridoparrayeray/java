package examen2;

import java.io.Serializable;

public class Equipo implements Comparable<Equipo>, Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private int creacion;
    private int plantilla;
    private double presupuesto;

    // Constructor por defecto
    public Equipo() {
        this.codigo = "E00";
        this.nombre = "Equipo 00";
        this.creacion = 2024;
        this.plantilla = 10;
        this.presupuesto = 1000.0;
    }

    // Constructor personalizado
    public Equipo(String codigo, String nombre, int creacion, int plantilla, double presupuesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creacion = creacion;
        this.plantilla = plantilla;
        this.presupuesto = presupuesto;
    }

    // Constructor copia
    public Equipo(Equipo otro) {
        this.codigo = otro.codigo;
        this.nombre = otro.nombre;
        this.creacion = otro.creacion;
        this.plantilla = otro.plantilla;
        this.presupuesto = otro.presupuesto;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCreacion() { return creacion; }
    public void setCreacion(int creacion) { this.creacion = creacion; }
    public int getPlantilla() { return plantilla; }
    public void setPlantilla(int plantilla) { this.plantilla = plantilla; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    // toString
    @Override
    public String toString() {
        return codigo + " " + nombre + " " + creacion + " " + plantilla + " " + presupuesto;
    }

    // equals y hashCode (basados en código)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipo equipo = (Equipo) obj;
        return codigo.equals(equipo.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    // compareTo (creación descendente, nombre ascendente)
    @Override
    public int compareTo(Equipo otro) {
        if (this.creacion != otro.creacion) {
            return otro.creacion - this.creacion;
        } else {
            return this.nombre.compareTo(otro.nombre);
        }
    }
}