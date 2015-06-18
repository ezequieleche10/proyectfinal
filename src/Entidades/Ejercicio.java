/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;

/**
 *
 * @author Lucia
 */
public class Ejercicio {
    
    private int cod_ejercicio;
    private String nombre;
    private String descripcion;
    private int cant_items;
    private float porcentaje;
    private List<AlumnoEnEjericio> listaAlumnos;

    public Ejercicio(String nombre, String descripcion, int cant_items, float porcentaje) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cant_items = cant_items;
        this.porcentaje = porcentaje;
    }

    public int getCod_ejercicio() {
        return cod_ejercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCant_items() {
        return cant_items;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public List<AlumnoEnEjericio> getListaAlumnos() {
        return listaAlumnos;
    }
    
   
  
   public void agregarAlumnos (List<Alumno> alumnos) {
       
   }
   
   public void buscarAlumnosEnEjercicio (int cod_examen, int cod_ejercicio){
        
    }
   
   public void cargarNota (Alumno alumno, int resultado){
        
    }
    
    
}
