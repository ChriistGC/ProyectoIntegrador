/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import reg.modelo.Cliente;

/**
 *
 * @author kriz_
 */
public class DetalleCliente extends javax.swing.JPanel {

    private Cliente cliente;
    private boolean editable;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditable() {
        return editable;

    }
    
    public void setEditablePerfil(boolean editable) {
        this.editable = editable;
        codigo.setEditable(false);
        nombres.setEditable(false);
        apellidos.setEditable(false);
        cedula.setEditable(false);
        telefono.setEditable(editable);
        direccion.setEditable(editable);
        correo.setEditable(editable);
        jRdBtNMas.setEnabled(editable);
        jRdBtnFem.setEnabled(editable);
        ciudad.setEditable(editable);
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        codigo.setEditable(editable);
        nombres.setEditable(editable);
        apellidos.setEditable(editable);
        cedula.setEditable(editable);
        telefono.setEditable(editable);
        direccion.setEditable(editable);
        correo.setEditable(editable);
        jRdBtNMas.setEnabled(editable);
        jRdBtnFem.setEnabled(editable);
        ciudad.setEditable(editable);
    }

    public void loadData() {
        if (cliente != null) {
            codigo.setText(cliente.getCodigo() + "");
            nombres.setText(cliente.getNombres());
            apellidos.setText(cliente.getApellidos());
            cedula.setText(cliente.getCedula());
            telefono.setText(cliente.getTelefono());
            direccion.setText(cliente.getDireccion());
            correo.setText(cliente.getCorreo());
            if (cliente.getSexo().toUpperCase().equals("FEMENINO")) {
                jRdBtnFem.setSelected(true);
            } else if (cliente.getSexo().toUpperCase().equals("MASCULINO")) {
                jRdBtNMas.setSelected(true);
            }
            ciudad.setText(cliente.getCiudad());
        } else {
            codigo.setText("");
            nombres.setText("");
            apellidos.setText("");
            cedula.setText("");
            telefono.setText("");
            direccion.setText("");
            correo.setText("");
            jRdBtnFem.setSelected(false);
            jRdBtNMas.setSelected(false);
            ciudad.setText("");
        }

        codigo.requestFocus();
    }

    public void saveDate() {
        if (cliente == null) {
            cliente = new Cliente();

            cliente.setNuevo(true);
        } else {
            cliente.setNuevo(false);
        }

        cliente.setCodigo(Integer.parseInt(codigo.getText()));
        cliente.setNombres(nombres.getText());
        cliente.setApellidos(apellidos.getText());
        cliente.setCedula(cedula.getText());
        cliente.setTelefono(telefono.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setCorreo(correo.getText());
        if (jRdBtnFem.isSelected() == true) {
            cliente.setSexo("Femenino");
        } else if (jRdBtNMas.isSelected() == true) {
            cliente.setSexo("Masculino");
        }
        cliente.setCiudad(ciudad.getText());
    }

    public DetalleCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        nombres = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        jRdBtNMas = new javax.swing.JRadioButton();
        jRdBtnFem = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 56, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 98, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cedula");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 182, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 224, -1, -1));

        codigo.setToolTipText("");
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 14, 238, 28));
        add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 56, 238, 28));

        apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosActionPerformed(evt);
            }
        });
        add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 98, 238, 28));
        add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 140, 238, 28));

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 182, 238, 28));
        add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 224, 238, 28));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 266, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sexo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 308, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ciudad");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 350, 84, 28));
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 266, 238, 28));
        add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 350, 238, 28));

        buttonGroup1.add(jRdBtNMas);
        jRdBtNMas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jRdBtNMas.setForeground(new java.awt.Color(255, 255, 255));
        jRdBtNMas.setText("Masculino");
        jRdBtNMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdBtNMasActionPerformed(evt);
            }
        });
        add(jRdBtNMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 308, -1, -1));

        jRdBtnFem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jRdBtnFem.setForeground(new java.awt.Color(255, 255, 255));
        jRdBtnFem.setText("Femenino");
        buttonGroup1.add(jRdBtnFem);
        jRdBtnFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdBtnFemActionPerformed(evt);
            }
        });
        add(jRdBtnFem, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 308, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cascada.gif"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 518));
    }// </editor-fold>//GEN-END:initComponents

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void jRdBtnFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdBtnFemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRdBtnFemActionPerformed

    private void jRdBtNMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdBtNMasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRdBtNMasActionPerformed

    private void apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRdBtNMas;
    private javax.swing.JRadioButton jRdBtnFem;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
