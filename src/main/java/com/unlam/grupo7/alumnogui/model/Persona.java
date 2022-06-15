/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.model;

import com.unlam.grupo7.alumnogui.exceptions.PersonaException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaNombreException;
import java.time.LocalDate;

/**
 *
 * @author EDUBOIS
 */
public class Persona {

    public static String DELIM = "*";

    private Integer dni;

    protected String nombre;

    protected String apellido;

    protected LocalDate fecNac;
    
    protected char sexo;

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Persona() {
    }

    public Persona(Integer dni) {
        super();
        this.dni = dni;
    }

    public Persona(Integer dni, String nombre, String apellido, LocalDate fecNac)
            throws PersonaException, PersonaNombreException {
        super();
        setDni(dni);
        setNombre(nombre);
        this.apellido = apellido;
        this.fecNac = fecNac;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) throws PersonaException {
        if (dni == null || dni <= 0) {
            // lanzo una Exception
            throw new PersonaException("El dni debe ser positivo");
        }
        this.dni = dni;
/////////////////////////////////////////////////////////////
//		if (dni != null && dni > 0) {
//			this.dni = dni;
//		}
//		else {
//			// lanzo una Exception
//			throw new Exception("El dni debe ser positivo");
//		}
    }

    public String getNombre() {
        if (nombre == null) {
            return nombre;
        }
        return nombre.trim();
    }

    public void setNombre(String nombre) throws PersonaNombreException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new PersonaNombreException("El nombre no puede estar vacio");
        }
        // Validar que solo contenga letras (a-z / A-Z)
//		if (false) {// usar expresion regular
//			
//		}
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    @Override
    public String toString() {
        return "DNI = " + dni + System.lineSeparator()
                + "Nombre = " + getNombre() + " - " + getApellido() + System.lineSeparator();
    }
    
    public String toData(){
        return this.getDni() + DELIM
                + this.getApellido() + DELIM
                + this.getNombre() + DELIM
                + this.getFecNac() + DELIM
                + this.getSexo()
                ;
    }
    
}
