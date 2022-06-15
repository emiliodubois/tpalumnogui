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

	private LocalDate fecIng;
	
	private Integer cantMatAprob;
	
	private Double promedio;
        
        private boolean activo;
	
	public Alumno() {
		super();
	}
	
	public Alumno(Integer dni) {
		super(dni);
	}

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fecNac,
			LocalDate fecIng, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(dni, nombre, apellido, fecNac);
		this.fecIng = fecIng;
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}
        
        public Alumno(Integer dni, String nombre, String apellido, boolean activo) throws PersonaException, PersonaNombreException{
            super(dni, nombre, apellido, null);
            this.activo = activo;
        }

	public Alumno(Persona persona,
			LocalDate fecIng, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(persona.getDni(), persona.nombre, persona.apellido, persona.fecNac);
		this.fecIng = fecIng;
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}

    public Alumno(Long dniAlu, String nombre, String apellido, LocalDate fechaNac, LocalDate fechaIng, Integer cantMatAprob, Double promedio, char sexo, boolean activo) {
        
    }


	public LocalDate getFecIng() {
		return fecIng;
	}

	public void setFecIng(LocalDate fecIng) {
		this.fecIng = fecIng;
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
	
	@Override
	public String toString() {
		return super.toString()+"Promedio = "+getPromedio()+System.lineSeparator()+
				"Fecha de Ingreso = "+fecIng;
	}
        
        

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getActivo() {
        return activo;
    }
    
    public String toData(){
        return super.toData() + DELIM
                + this.getFecIng() + DELIM
                + this.getPromedio() + DELIM
                + this.getCantMatAprob() + DELIM
                + this.getActivo() + DELIM
                ;
    }
    
}
