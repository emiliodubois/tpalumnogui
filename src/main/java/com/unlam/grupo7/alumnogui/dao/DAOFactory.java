/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unlam.grupo7.alumnogui.dao;

import com.unlam.grupo7.alumnogui.exceptions.DAOException;
import com.unlam.grupo7.alumnogui.exceptions.DAOFactoryException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorios
 */
public class DAOFactory {

    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    
    public static final String PATH_FILE = "PATH_FILE";
    public static final String SQL_CONN = "SQL_CONN";
    public static final String SQL_USER = "SQL_USER";
    public static final String SQL_PASS = "SQL_PASS";
    
    private static DAOFactory instance;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        
        if (instance==null) {
            instance = new DAOFactory();
        }
        
        return instance;
    }
    
    
    public DAO crearDAO(Map<String, String> config) throws DAOFactoryException {
        String tipoDAO = config.get(TIPO_DAO);
        switch (tipoDAO) {
            case TIPO_DAO_TXT:
                String path = config.get(PATH_FILE);
                return AlumnoDaoTxt.getInstance(path);
            case TIPO_DAO_SQL:
                return AlumnoDaoSql.getInstance(config.get(SQL_CONN), config.get(SQL_USER), config.get(SQL_PASS));
        }
        return null;
    }
    
    
}
