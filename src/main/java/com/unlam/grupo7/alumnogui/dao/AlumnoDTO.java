/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.dao;

import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public class AlumnoDTO {
    
    private Integer dni;
    
    private String nombre;
    
    private String apellido;
    
    private LocalDate fecNac;

    public void setCantMatAprobadas(int cantMatAprobadas) {
        this.cantMatAprobadas = cantMatAprobadas;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public int getCantMatAprobadas() {
        return cantMatAprobadas;
    }

    public Double getPromedio() {
        return promedio;
    }
    
    private int cantMatAprobadas;
    
    private Double promedio;
    
    private boolean activo;
    
    private char sexo;

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
    
}
