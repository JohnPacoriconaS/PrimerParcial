
package com.emergentes.modelo;

public class Estudiante {
    
    private int id;
    private String nombre;
    private int primer;
    private int segundo;
    private int fin;
    private int nota;


    
    public Estudiante(){
        
    }

    public Estudiante(int id, String nombre, int primer, int segundo, int fin,int nota) {
        this.id = id;
        this.nombre = nombre;
        this.primer = primer;
        this.segundo = segundo;
        this.fin = fin;
        this.nota=nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimer() {
        return primer;
    }

    public void setPrimer(int primer) {
        this.primer = primer;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
