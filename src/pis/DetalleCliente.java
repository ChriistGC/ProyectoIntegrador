/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import reg.modelo.Cliente;

/**
 *
 * @author Gabriel
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

    public void setEditable(boolean editable) {
        this.editable = editable;
        codigo.setEditable(editable);
        telefono.setEditable(editable);
        nombres.setEditable(editable);
        cedula.setEditable(editable);
        apellidos.setEditable(editable);
        direccion.setEditable(editable);
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
            if(cliente.getSexo()=="FEMENINO"){
                jRdBtnFem.setSelected(true);
            }else if(cliente.getSexo()=="MASCULINO"){
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
        }
        else
             cliente.setNuevo(false);
        
        cliente.setCodigo(Integer.parseInt( codigo.getText()));
        cliente.setNombres(nombres.getText());
        cliente.setApellidos(apellidos.getText());
        cliente.setCedula(cedula.getText());
        cliente.setTelefono(telefono.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setCorreo(correo.getText());
        if(jRdBtnFem.isSelected()==true){
            cliente.setSexo("Femenino");
        }else if(jRdBtNMas.isSelected()==true){
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

        jLabel1.setText("Código");

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Cedula");

        jLabel5.setText("Telefono");

        jLabel6.setText("Direccion");

        codigo.setToolTipText("");
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosActionPerformed(evt);
            }
        });

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        jLabel8.setText("Correo");

        jLabel9.setText("Sexo");

        jLabel10.setText("Ciudad");

        buttonGroup1.add(jRdBtNMas);
        jRdBtNMas.setText("Masculino");
        jRdBtNMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdBtNMasActionPerformed(evt);
            }
        });

        jRdBtnFem.setText("Femenino");
        buttonGroup1.add(jRdBtnFem);
        jRdBtnFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdBtnFemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombres)
                    .addComponent(codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cedula)
                    .addComponent(apellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(direccion)
                    .addComponent(telefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(correo)
                    .addComponent(ciudad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRdBtNMas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRdBtnFem)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jRdBtNMas)
                    .addComponent(jRdBtnFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRdBtNMas;
    private javax.swing.JRadioButton jRdBtnFem;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
