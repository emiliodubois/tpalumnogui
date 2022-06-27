/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.model;

import com.unlam.grupo7.alumnogui.exceptions.AlumnoException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaNombreException;
import java.time.LocalDate;

/**
 *
 * @author EDUBOIS
 */
public class Alumno extends Persona{
	
	private Integer cantMatAprob;
	
	private Double promedio;
        
        private boolean activo;
	
	public Alumno() {
		super();
	}
	
	public Alumno(Integer dni) {
		super(dni);
	}

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fecNac, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(dni, nombre, apellido, fecNac);
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}
        
        public Alumno(Integer dni, String nombre, String apellido, boolean activo) throws PersonaException, PersonaNombreException{
            super(dni, nombre, apellido, null);
            this.activo = activo;
        }

	public Alumno(Persona persona, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(persona.getDni(), persona.nombre, persona.apellido, persona.fecNac);
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}

    public Alumno(String dniAlu, String apellido, String nombre, String fechaNac, String sexo, String promedio, String cantMatAprobadas, String activo) throws PersonaException, PersonaNombreException {
        super(Integer.valueOf(dniAlu), nombre, apellido, LocalDate.parse(fechaNac));
        this.cantMatAprob = Integer.valueOf(cantMatAprobadas);
        this.promedio = Double.valueOf(promedio);
        this.sexo = sexo.charAt(0);
        this.activo = Boolean.valueOf(activo);
    }

	public Integer getCantMatAprob() {
		return cantMatAprob;
	}

	public void setCantMatAprob(Integer cantMatAprob) {
		this.cantMatAprob = cantMatAprob;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) throws AlumnoException {
		if (promedio<0 || promedio>10)  {
			throw new AlumnoException("El promedio es inv�lido");
		}
		
		this.promedio = promedio;
	}
   
        

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getActivo() {
        return activo;
    }
    
    public String toData(){
        return super.toData() + DELIM
                + this.getPromedio() + DELIM
                + this.getCantMatAprob() + DELIM
                + this.getActivo() + DELIM
                ;
    }
    
}
