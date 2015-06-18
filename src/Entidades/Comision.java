/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Datos.CatalogodeComisiones;

/**
 *
 * @author Lucia
 */
public class Comision {
    
    private int cod_comision;
    private String nombre;
    private String descripcion;
    private Examen examen;

    public Comision(int cod_comision,String nombre, String descripcion, Examen examen) {
        this.cod_comision = cod_comision;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.examen = examen;
    }
    
    

    public Examen getExamen() {
        return examen;
    }

    public int getCod_comision() {
        return cod_comision;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
   /* 
    public void agregarComision ()
    {
        CatalogodeComisiones cd = new CatalogodeComisiones();
        cd.agregarComision(this.getCod_comision(), this.getDescripcion(), this.getNombre(), this.getExamen().getCod_examen());
    }
    */
}
