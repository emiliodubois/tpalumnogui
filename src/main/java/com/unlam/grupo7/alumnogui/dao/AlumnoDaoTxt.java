/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.dao;

import com.unlam.grupo7.alumnogui.exceptions.DAOException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaNombreException;
import com.unlam.grupo7.alumnogui.model.Alumno;
import com.unlam.grupo7.alumnogui.model.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorios TEST COMMIT
 */
public class AlumnoDaoTxt extends DAO<Alumno, Integer> {

    private RandomAccessFile raf;

    private static AlumnoDaoTxt instance;
    
    private static String paths;

    public static AlumnoDaoTxt getInstance(String path) {
        paths = path;
        try {
            if (instance == null) {
                instance = new AlumnoDaoTxt(path);
            }
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }

    private AlumnoDaoTxt(String fullPath) throws DAOException {
        File file = new File(fullPath);

        try {
            raf = new RandomAccessFile(file, "rws");
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.INFO, "CONEXIÓN TXT ESTABLECIDA");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Archivo no encontrado ==> " + ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alu) throws DAOException {

        try {

            if (exist(alu.getDni())) {
                throw new DAOException("El alumno ya existe (DNI =" + alu.getDni() + ")");
            }
            raf.seek(raf.length());
            raf.writeBytes(alu.toData() + System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar el alumno  ==> " + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Alumno alu) throws DAOException {
 try {
            
    RandomAccessFile rafNew = new RandomAccessFile(paths + "temp", "rws");
            raf.seek(0);
            // recorrer
            String linea;
            String[] campos;
//            long puntero=0;
            while ((linea = raf.readLine()) != null) {
//                puntero++;
                campos = linea.split(Persona.DELIM);
                if (alu.getDni().equals(Integer.valueOf(campos[0]))) {
//                   raf.seek(puntero--);
                   rafNew.writeBytes(alu.toData() + System.lineSeparator());
                }
                else
                {
                   rafNew.writeBytes(linea + System.lineSeparator()); 
                }
            }
            raf.close();
            rafNew.close();
            File temp = new File(paths + "temp");
            File old = new File(paths);
            old.delete();
            temp.renameTo(old);
            
            File file = new File(paths);
            raf = new RandomAccessFile(file, "rws");
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de I/O  ==> " + ex.getMessage());
        } 
    }

    @Override
    public void hardDelete(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void softDelete(Integer dni) throws DAOException {
        List<Alumno> lista = findAll(true);
        Alumno morir = null;
        
        for (Alumno s : lista){
            if(s.getDni().compareTo(dni) == 0)
                morir = s;
            
        }
       
        if (morir != null){
            morir.setActivo(false);
            update(morir);
        }

    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {

        List<Alumno> alumnos = new ArrayList<>();

        try {

            raf.seek(0);

            String linea;
            String[] campos;
            while ((linea = raf.readLine()) != null) {
                campos = linea.split(Persona.DELIM);
                alumnos.add(new Alumno(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]));
            }

        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaNombreException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumnos;
        
    }

    @Override
    public void close() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param dni
     * @return
     * @throws DAOException
     * @throws PersonaException
     */
    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {
            raf.seek(0);
            // recorrer
            String linea;
            String[] campos;
            while ((linea = raf.readLine()) != null) {
                campos = linea.split(Persona.DELIM);
                if (dni.equals(Integer.valueOf(campos[0]))) {
                    throw new DAOException("Persona existente con DNI " + dni);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de I/O  ==> " + ex.getMessage());
        }
        return false;
    }

    /*private Alumno str2Alu(String[] campos) throws NumberFormatException, PersonaException {
        int i = 0;
        Long dniAlu = Long.valueOf(campos[i++].trim());
        String nombre = campos[i++].trim();

        String apellido = campos[i++].trim();

        String[] fecha = campos[i++].split("/");
        LocalDate fechaNac = LocalDate.parse(fecha[0].trim() + fecha[1].trim() + fecha[2]);

        char sexo = campos[i++].charAt(0);

        fecha = campos[i++].split("/");
        LocalDate fechaIng = LocalDate.parse(fecha[0].trim() + fecha[1].trim() + fecha[2]);

        Integer cantMatAprob = Integer.valueOf(campos[i++].trim());
        Double promedio = Double.valueOf(campos[i++].trim().replaceAll(",", "."));

        boolean activo = campos[i].equals("A");

        return new Alumno(dniAlu, nombre, apellido, fechaNac, fechaIng, cantMatAprob, promedio, sexo, activo);
    }*/
}
