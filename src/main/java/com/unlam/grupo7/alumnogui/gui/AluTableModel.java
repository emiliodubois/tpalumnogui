/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.gui;

import com.unlam.grupo7.alumnogui.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laboratorios
 */
public class AluTableModel extends AbstractTableModel {

    private List<Alumno> alumnos;
    
    private static final String[] columnas = {"DNI", "Nombre", "Apellido", "Estado"};

    public AluTableModel() {
        alumnos = new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alu = alumnos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return alu.getDni();
            case 1:
                return alu.getNombre();
            case 2:
                return alu.getApellido();
            case 3:
                return alu.getActivo()?"Activo":"Inactivo";
            default:
                return null;
        }
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
}
