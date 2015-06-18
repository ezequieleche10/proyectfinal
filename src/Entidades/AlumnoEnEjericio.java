/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Lucia
 */
public class AlumnoEnEjericio {
    
    private Alumno alumno;
    private float resultado;
    private float nota_parcial;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
    
    public void setNotaParcial (float nota_parcial){
        this.nota_parcial = nota_parcial;
    }
}
