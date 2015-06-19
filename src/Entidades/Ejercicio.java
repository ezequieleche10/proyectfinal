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
    private int porcentaje;
    private List<AlumnoEnEjericio> listaAlumnos;

    public Ejercicio(String nombre, String descripcion, int cant_items, int porcentaje) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cant_items = cant_items;
        this.porcentaje = porcentaje;
    }

    public Ejercicio() {
		// TODO Auto-generated constructor stub
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

    public int getPorcentaje() {
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

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public void setCant_items(int cant_items) {
	this.cant_items = cant_items;
}

public void setPorcentaje(int porcentaje) {
	this.porcentaje = porcentaje;
}
    
    
}
