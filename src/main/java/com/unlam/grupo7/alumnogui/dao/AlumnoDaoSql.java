/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.dao;

import com.unlam.grupo7.alumnogui.exceptions.DAOException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaNombreException;
import com.unlam.grupo7.alumnogui.model.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorios
 */
public class AlumnoDaoSql extends DAO<Alumno, Integer>{
    
    private Connection conn;
    private PreparedStatement insertPS;
    private PreparedStatement selectPS;
    private PreparedStatement updatePS;
    private PreparedStatement deletePS;
    private final String insertSQL = "INSERT INTO alumnos\n"
                    + "(DNI,\n"
                    + "NOMBRE,\n"
                    + "APELLIDO,\n"
                    + "FEC_NAC,\n"
                    + "SEXO,\n"
                    + "CANT_MAT_APROB,\n"
                    + "ESTADO,\n"
                    + "PROMEDIO)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?);";
    
    private final String updateSQL = "UPDATE alumnos\n"
                    + "SET\n"
                    + "NOMBRE=?,\n"
                    + "APELLIDO=?,\n"
                    + "FEC_NAC=?,\n"
                    + "SEXO=?,\n"
                    + "CANT_MAT_APROB=?,\n"
                    + "ESTADO=?,\n"
                    + "PROMEDIO=?\n"
                    + "WHERE\n"
                    + "DNI = ?;";
    
    private final String deleteSQL = "DELETE FROM alumnos\n"
                    + "WHERE\n"
                    + "DNI = ?;";
    
    private static AlumnoDaoSql instance;
    
    public static AlumnoDaoSql getInstance(String url, String usuario, String password){
        try {
            if (instance == null)
                instance = new AlumnoDaoSql(url, usuario, password);
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    
    private AlumnoDaoSql(String url, String usuario, String password) throws DAOException {
        
        try {
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al conectarse con la BD ==> "+ex.getMessage());
        }

         
        String selectSQL = "SELECT * FROM alumnos where DNI = ?";
        
        try {
            selectPS = conn.prepareStatement(selectSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para SELECT ==> "+ex.getMessage());
        }

    }

    @Override
    public void create(Alumno alu) throws DAOException {
        try {

            insertPS = conn.prepareStatement(insertSQL);
                /*private final String insertSQL = "INSERT INTO alumnos\n"
                    + "(DNI,\n"
                    + "NOMBRE,\n"
                    + "APELLIDO,\n"
                    + "FEC_NAC,\n"
                    + "SEXO,\n"
                    + "CANT_MAT_APROB,\n"
                    + "ESTADO,\n"
                    + "PROMEDIO)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?);";*/            
            insertPS.setInt(1, alu.getDni());
            insertPS.setString(2, alu.getNombre());
            insertPS.setString(3, alu.getApellido());
            insertPS.setDate(4, Date.valueOf(alu.getFecNac()));
            insertPS.setString(5, String.valueOf(alu.getSexo()));
            insertPS.setInt(6, alu.getCantMatAprob());
            if(alu.getActivo())
                insertPS.setInt(7, 1); 
            else
                insertPS.setInt(7, 0); 
            insertPS.setDouble(8, alu.getPromedio());
            
            
            insertPS.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar en le BD ==>" + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        Alumno alu = null;
        try {
            selectPS.setInt(1, dni);
            ResultSet rs = selectPS.executeQuery();
            if (rs.next()) {
                alu = new Alumno();
                alu.setDni(dni);
//                alu.setNombre(rs.getString("NOMBRE"));
                alu.setApellido(rs.getString("APELLIDO"));
//                alu.setFechaNac(new MiCalendario(rs.getDate("FEC_NAC")));
//                alu.setSexo(rs.getString("SEXO").charAt(0));
                alu.setPromedio(rs.getDouble("PROMEDIO"));
            }
            
        } catch (SQLException | PersonaException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            // TODO throw new DAOException...
        }
        
        return alu;
    }

    @Override
    public void update(Alumno alu) throws DAOException{
        try {

            updatePS = conn.prepareStatement(updateSQL);         
            updatePS.setInt(8, alu.getDni());
            updatePS.setString(1, alu.getNombre());
            updatePS.setString(2, alu.getApellido());
            updatePS.setDate(3, Date.valueOf(alu.getFecNac()));
            updatePS.setString(4, String.valueOf(alu.getSexo()));
            updatePS.setInt(5, alu.getCantMatAprob());
            if(alu.getActivo())
                updatePS.setInt(6, 1); 
            else
                updatePS.setInt(6, 0); 
            updatePS.setDouble(7, alu.getPromedio());            
            
            updatePS.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al actualizar en le BD ==>" + ex.getMessage());
        }
    }

    
    @Override
    public void close() throws DAOException {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al cerrar la BD ==> "+ex.getMessage());
        }
    }

    @Override
    public void hardDelete(Integer pk) throws DAOException {
        try {
            deletePS = conn.prepareStatement(deleteSQL);         
            deletePS.setInt(1, pk);       
            
            deletePS.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al eliminar en le BD ==>" + ex.getMessage());
        }
    }

    @Override
    public void softDelete(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
        
        List<Alumno> lista = new ArrayList<>();
        
        try {
            
            String selectSQL = "SELECT DNI, NOMBRE, APELLIDO, FEC_NAC, CANT_MAT_APROB, PROMEDIO, SEXO, ESTADO FROM alumnos";
            
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(selectSQL);
            
            while(rs.next()){
//public Alumno(String dniAlu, String apellido, String nombre, String fechaNac, String sexo, String promedio, String cantMatAprobadas, String activo) throws PersonaException, PersonaNombreException {                
                lista.add(new Alumno(rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4), rs.getString(7), rs.getString(6), rs.getString(5), String.valueOf(rs.getBoolean(8))));                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaNombreException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    @Override
    public boolean exist(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
