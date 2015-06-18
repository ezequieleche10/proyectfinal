/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.CatalogodeAlumnos;
import Datos.CatalogodeProfesores;
import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.Comision;
import Entidades.Examen;
import Entidades.Profesor;
import Datos.CatalogodeCarreras;
import Datos.CatalogodeExamenes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class Controlador {
    
    private CatalogodeExamenes cde;
    private CatalogodeCarreras cdc;
    private CatalogodeAlumnos cda;
    private CatalogodeProfesores cdp;
    
    public Controlador() {
        cde = new CatalogodeExamenes();
        cdc = new CatalogodeCarreras();
        cda = new CatalogodeAlumnos();
        cdp= new CatalogodeProfesores();
        }
    
     public ArrayList<Carrera> buscarCarreras() throws Exception{
         return cdc.buscarCarreras();
     }
     
     public ArrayList<Profesor> buscarProfesores() throws Exception{
         return cdp.getAllProfesores();
     }
    
    
    public Examen mostrarExamenPendiente(int anio, int cod_carrera) {
        Carrera c= new Carrera(cod_carrera);
      
        Examen examen = new Examen();
        examen = c.listarExamen(anio);
        return examen;
        
    }
    
    public void agregarAlumnos(ArrayList<Alumno> alumnos) throws Exception
    {
    	cda.agregarAlumnos(alumnos);
    }
    
    public ArrayList<Alumno> listarAlumnos(int cod_examen) throws Exception {
        ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
        Examen ex = cde.buscaExamen(cod_examen);
        if (ex.getTipo_examen().equals("A"))
        {
           alumnos= cda.buscarAlumnos();
        }else 
        {
            Examen examenV= new Examen();
            if(ex.getTipo_examen().equals("B"))
            { 
                
              examenV= cde.buscarExamen("A",ex.getAnio());
              
            }else 
            {
              examenV= cde.buscarExamen("B",ex.getAnio());
            }
            //devuelve los alumnos que han aprobado el examen anterior
            alumnos = examenV.obtenerAlumnos();
            ex.agregarAlumnos(alumnos);
            
            
         }
        return alumnos;
        }
        
    
    
    public void confirmarExamen(int cod_examen) {
        
    }
    
    public void listarAlumnosEnCondiciones(int cod_examen) {
        
    }
    
    public Comision buscarExamen (int anio, int cod_carrera) throws Exception {
        
        Examen ex = new Examen();
        ex = cde.listarExamen(cod_carrera, anio);
        //resolver tema nombre y descripcion
        Comision c = new Comision(0, "", "", ex);
        return c;
        
        
    }
    
    public void asignarProfesor (Profesor profe, Comision comi) throws Exception
    {
      profe.AgregarComision(comi);
       
    }
        
    
    public void agregarEjercicio (int cod_examen, String nombre, String descripcion, int cant_item, float porcentaje) throws Exception{
        
        Examen exa = new Examen();
        exa = cde.buscaExamen(cod_examen);
        exa.agregarEjercicio(nombre, descripcion, cant_item, porcentaje);
        
        
    }
    
    public void agregarAlumnosEnEjercicio (int cod_examen) {
        
    }
    
    public void buscarProfesor (int cod_profesor) {
    	
        
    }
    
    public void mostrarEjercicios (int cod_examen){
        
    }
   
    public void buscarAlumnosEnEjercicio (int cod_examen, int cod_ejercicio){
        
    }
    
    public void cargarNota (Alumno alumno, int resultado){
        
    }
    
    public void agregarExamen (String tipo_examen, int cod_carrera, int año, String descripcion) throws Exception
    {
    	Examen ex= new Examen(tipo_examen,año,"sin generar",descripcion);
    	cde.agregarExamen(ex, cod_carrera);
    }
    public void agregarProfesor(String nombre, String apellido, String fecha_Nacimiento, String usu, String password) throws Exception
    {
    	Profesor p= new Profesor(nombre,apellido,fecha_Nacimiento,usu,password);
    	p.AgregarProfesor();
    }
    
    public void agregarAlumnosEnExamen (ArrayList<Alumno> alumnos, int cod_examen) throws Exception
    {
    	Examen ex = cde.buscaExamen(cod_examen);
    	ex.agregarAlumnos(alumnos);
    	
    }
    
}
