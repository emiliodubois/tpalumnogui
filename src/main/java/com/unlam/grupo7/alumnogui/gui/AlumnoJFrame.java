/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unlam.grupo7.alumnogui.gui;

import com.unlam.grupo7.alumnogui.dao.AlumnoDTO;
import com.unlam.grupo7.alumnogui.dao.AlumnoDaoSql;
import com.unlam.grupo7.alumnogui.dao.AlumnoDaoTxt;
import com.unlam.grupo7.alumnogui.dao.DAO;
import com.unlam.grupo7.alumnogui.dao.DAOFactory;
import com.unlam.grupo7.alumnogui.exceptions.DAOException;
import com.unlam.grupo7.alumnogui.exceptions.DAOFactoryException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaException;
import com.unlam.grupo7.alumnogui.exceptions.PersonaNombreException;
import com.unlam.grupo7.alumnogui.model.Alumno;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUBOIS
 */
public class AlumnoJFrame extends javax.swing.JFrame {

    DAO<Alumno, Integer> dao;
    AlumnoDaoTxt daoTXT;
    AlumnoDaoSql daoSQL;
    private AluTableModel alumnoModel;

    /**
     * Creates new form AlumnoGUI
     */
    public AlumnoJFrame() {
        initComponents();
        setLocationRelativeTo(null);

        sqlPanel.setVisible(false);
        agregarButton.setEnabled(false);
        alumnoModel = new AluTableModel();
        alumnosTable.setModel(alumnoModel);
    }
    
    private AlumnoDTO alu2Dto(Alumno alu) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDni(alu.getDni());
        
        dto.setFecNac(alu.getFecNac());

        return dto;
    }
    
    private Alumno alumnoDto2Alu(AlumnoDTO dto) {
            Alumno alu = new Alumno();
        try {
            alu.setDni(dto.getDni());
            alu.setApellido(dto.getApellido());
            alu.setNombre(dto.getNombre());
            alu.setFecNac(dto.getFecNac());
            alu.setActivo(dto.isActivo());
            return alu;
        } catch (PersonaException ex) {
            Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaNombreException ex) {
            Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return alu;
        }
    }

    private Alumno getAlumnoSeleccionado() {
        int selectedRow = alumnosTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Error");
            return null;
        }
        return alumnoModel.getAlumnos().get(selectedRow);

    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grillaAlumnosPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alumnosTable = new javax.swing.JTable();
        botoneraPanel = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        filtrosPanel = new javax.swing.JPanel();
        tipoDAOComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtPanel = new javax.swing.JPanel();
        archivoSeleccionadoTextField = new javax.swing.JTextField();
        fileChooserButton = new javax.swing.JButton();
        sqlPanel = new javax.swing.JPanel();
        sqlConnButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passDBPasswordField = new javax.swing.JPasswordField();
        verEliminadosCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        grillaAlumnosPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alumnosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(alumnosTable);

        javax.swing.GroupLayout grillaAlumnosPanelLayout = new javax.swing.GroupLayout(grillaAlumnosPanel);
        grillaAlumnosPanel.setLayout(grillaAlumnosPanelLayout);
        grillaAlumnosPanelLayout.setHorizontalGroup(
            grillaAlumnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grillaAlumnosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        grillaAlumnosPanelLayout.setVerticalGroup(
            grillaAlumnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grillaAlumnosPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botoneraPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        consultarButton.setText("Consutar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoneraPanelLayout = new javax.swing.GroupLayout(botoneraPanel);
        botoneraPanel.setLayout(botoneraPanelLayout);
        botoneraPanelLayout.setHorizontalGroup(
            botoneraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoneraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botoneraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarButton)
                    .addComponent(modificarButton)
                    .addComponent(consultarButton)
                    .addComponent(eliminarButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        botoneraPanelLayout.setVerticalGroup(
            botoneraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoneraPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(agregarButton)
                .addGap(18, 18, 18)
                .addComponent(modificarButton)
                .addGap(18, 18, 18)
                .addComponent(consultarButton)
                .addGap(18, 18, 18)
                .addComponent(eliminarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filtrosPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tipoDAOComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TXT", "SQL" }));
        tipoDAOComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDAOComboBoxActionPerformed(evt);
            }
        });
        tipoDAOComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tipoDAOComboBoxPropertyChange(evt);
            }
        });

        jLabel1.setText("Seleccione tipo:");

        archivoSeleccionadoTextField.setEnabled(false);

        fileChooserButton.setText("...");
        fileChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtPanelLayout = new javax.swing.GroupLayout(txtPanel);
        txtPanel.setLayout(txtPanelLayout);
        txtPanelLayout.setHorizontalGroup(
            txtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(archivoSeleccionadoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileChooserButton)
                .addGap(64, 64, 64))
        );
        txtPanelLayout.setVerticalGroup(
            txtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileChooserButton)
                    .addComponent(archivoSeleccionadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sqlConnButton.setText("Conectar");
        sqlConnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlConnButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Conexión");

        jLabel3.setText("Usuario");

        jLabel4.setText("Clave");

        passDBPasswordField.setText("jPasswordField1");

        javax.swing.GroupLayout sqlPanelLayout = new javax.swing.GroupLayout(sqlPanel);
        sqlPanel.setLayout(sqlPanelLayout);
        sqlPanelLayout.setHorizontalGroup(
            sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sqlPanelLayout.createSequentialGroup()
                .addGroup(sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sqlPanelLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sqlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addGroup(sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(sqlPanelLayout.createSequentialGroup()
                        .addComponent(passDBPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(sqlConnButton)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        sqlPanelLayout.setVerticalGroup(
            sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sqlPanelLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sqlPanelLayout.createSequentialGroup()
                        .addGroup(sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sqlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passDBPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sqlConnButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sqlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26))))
        );

        verEliminadosCheckBox.setText("Ver Eliminados");
        verEliminadosCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEliminadosCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filtrosPanelLayout = new javax.swing.GroupLayout(filtrosPanel);
        filtrosPanel.setLayout(filtrosPanelLayout);
        filtrosPanelLayout.setHorizontalGroup(
            filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosPanelLayout.createSequentialGroup()
                .addGroup(filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtrosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(filtrosPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tipoDAOComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(filtrosPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sqlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verEliminadosCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtrosPanelLayout.setVerticalGroup(
            filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(filtrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDAOComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(txtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sqlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(verEliminadosCheckBox)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grillaAlumnosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botoneraPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(filtrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grillaAlumnosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoneraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        try {
            AlumnoDialog dialogo = new AlumnoDialog(this, true, null);
            dialogo.setVisible(true);

            dao.create(alumnoDto2Alu(dialogo.getDto()));

            System.out.println("Diálogo cerrado");
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        int selectedRow = alumnosTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Error");
            return;
        }

        Alumno alu = alumnoModel.getAlumnos().get(selectedRow);
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        Alumno alu = getAlumnoSeleccionado();
        if (alu != null) {
            AlumnoDialog dialogo = new AlumnoDialog(this, true, alu2Dto(alu));
            dialogo.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        Alumno alu = getAlumnoSeleccionado();
        if (alu != null) {
            int resp = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea eliminar a " + alu.getNombre() + "?", "Confirmación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (resp == JOptionPane.YES_OPTION) {
                try {
                    if (dao instanceof AlumnoDaoTxt) {
                        System.out.println("dao instanceof AlumnoDaoTxt");
                        dao.softDelete(alu.getDni());
                    } else {
                        System.out.println("dao instanceof AlumnoDaoSQL");
                        dao.hardDelete(alu.getDni());
                    }
                } catch (DAOException ex) {
                    Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
            }
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void tipoDAOComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDAOComboBoxActionPerformed
        txtPanel.setVisible(tipoDAOComboBox.getSelectedIndex() == 0);
        sqlPanel.setVisible(tipoDAOComboBox.getSelectedIndex() == 1);
    }//GEN-LAST:event_tipoDAOComboBoxActionPerformed

    private void tipoDAOComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tipoDAOComboBoxPropertyChange

    }//GEN-LAST:event_tipoDAOComboBoxPropertyChange

    private void fileChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserButtonActionPerformed
        try {
            if (daoTXT == null) {
                JFileChooser chooser = new JFileChooser();
                int resp = chooser.showOpenDialog(this);
                if (resp != JFileChooser.APPROVE_OPTION) {
                    return;
                }
                File file = chooser.getSelectedFile();
                archivoSeleccionadoTextField.setText(file.getAbsolutePath());
                Map<String, String> config = new HashMap<String, String>();
                config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
                config.put(DAOFactory.PATH_FILE, file.getAbsolutePath());

                daoTXT = (AlumnoDaoTxt) DAOFactory.getInstance().crearDAO(config);
            }
            dao = daoTXT;
            //alumnoModel.setAlumnos(dao.findAll(true));
            //List<Alumno> alus= dao.findAll(verEliminadosCheckBox.isSelected());
            List<Alumno> alus = new ArrayList<>();
            //
            alumnoModel.setAlumnos(alus);
            alumnoModel.fireTableDataChanged();

            agregarButton.setEnabled(true);
        } catch (DAOFactoryException ex) {
            Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_fileChooserButtonActionPerformed

    private void sqlConnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlConnButtonActionPerformed
        System.out.println("pass DB:" + String.valueOf(passDBPasswordField.getPassword()));
    }//GEN-LAST:event_sqlConnButtonActionPerformed

    private void verEliminadosCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEliminadosCheckBoxActionPerformed
        try {
            System.out.println("Checkbox = " + verEliminadosCheckBox.isSelected());
            dao.findAll(verEliminadosCheckBox.isSelected());
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoJFrame.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_verEliminadosCheckBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JTable alumnosTable;
    private javax.swing.JTextField archivoSeleccionadoTextField;
    private javax.swing.JPanel botoneraPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton fileChooserButton;
    private javax.swing.JPanel filtrosPanel;
    private javax.swing.JPanel grillaAlumnosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton modificarButton;
    private javax.swing.JPasswordField passDBPasswordField;
    private javax.swing.JButton sqlConnButton;
    private javax.swing.JPanel sqlPanel;
    private javax.swing.JComboBox<String> tipoDAOComboBox;
    private javax.swing.JPanel txtPanel;
    private javax.swing.JCheckBox verEliminadosCheckBox;
    // End of variables declaration//GEN-END:variables
}
