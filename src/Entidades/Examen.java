/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Datos.CatalogodeComisiones;
import Datos.CatalogodeEjercicios;
import Datos.CatalogoNotasExamen;
import Entidades.NotaExamenAlumno;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucia
 */
public class Examen {
    
    private int cod_examen;
    private String descripcion;
    private String tipo_examen;
    private int anio;
    private String estado;
    private List<Ejercicio> listaEjercicios;
    private List<NotaExamenAlumno> listaNotaExamenAlumno; 
    private Comision comision;

   public Examen(){}

    public int getCod_examen() {
        return cod_examen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo_examen() {
        return tipo_examen;
    }

    public int getAnio() {
        return anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setCod_examen(int cod_examen) {
        this.cod_examen = cod_examen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo_examen(String tipo_examen) {
        this.tipo_examen = tipo_examen;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public Examen(int cod_Examen ,String tipo_examen, int anio, String estado, String descripcion) {
        this.descripcion = descripcion;
        this.tipo_examen = tipo_examen;
        this.anio = anio;
        this.estado = estado;
        this.cod_examen=cod_Examen;
    }

    public Examen(String tipo_examen, int anio, String estado, String descripcion) {
        this.descripcion = descripcion;
        this.tipo_examen = tipo_examen;
        this.anio = anio;
        this.estado = estado;
    }
    
    public void crearComision() {
        
        CatalogodeComisiones cd = new CatalogodeComisiones();
        
    }
    
   public void crearListaEjercicios() {
       
    }
    
    public void agregarEjercicio(String nombre, String descripcion, int cant_item, float porcentaje) throws Exception {
        
        Ejercicio ej = new Ejercicio(nombre, descripcion, cant_item, porcentaje);
        CatalogodeEjercicios ejData = new CatalogodeEjercicios();
        ejData.agregarEjercicio(this.getCod_examen(), ej);
        
       
    }
    
    public ArrayList<Alumno> obtenerAlumnos() throws Exception {
        ArrayList<Alumno> alAprob = new ArrayList<Alumno>();
        CatalogoNotasExamen nea = new CatalogoNotasExamen();
       ArrayList<NotaExamenAlumno> listaEA=new ArrayList<NotaExamenAlumno>();
       listaEA= nea.listarNotaExamenAlumno(this.getCod_examen());
           
        // en este metodo se devolvio la lista de examen alumno para el examen del codigo enviado,
        // comprobar estado y generar una lista con los alumnos aprobados para devolverla al controlador
        //el controlador le da el examen nuevo esa lista para que cree las notaexamen alumno para el examen
        if (listaEA.size()!=0)
        {
           
           for(int i=0;i<listaEA.size();i++)
           {
               String cond = listaEA.get(i).getCondicion();
               if (cond.equals("aprobado"))
               {
                   alAprob.add(listaEA.get(i).getAlumno());
               }
           }
        }
       return alAprob;
    }

    public List<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }
    
    public void agregarAlumnos (ArrayList<Alumno> alumnos) throws Exception
    {
        CatalogoNotasExamen nead = new CatalogoNotasExamen();
        ArrayList<NotaExamenAlumno> listaNotas= new ArrayList<NotaExamenAlumno>();
        for(int i=0;i<alumnos.size();i++)
        {
            listaNotas.add(new NotaExamenAlumno(0,"sin cargar",alumnos.get(i)));
        }
        
        nead.agregarAlumnos(listaNotas, this.getCod_examen());
       
    }
    
    
    
}
