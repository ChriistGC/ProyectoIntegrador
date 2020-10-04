
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import javax.swing.JTextField;

/**
 *
 * @author Astaroth
 */
public class jDmetodopago extends javax.swing.JDialog {

    /**
     * Creates new form jDmetodopago
     */
    private String mtdoPago;
    private double precioTot;
    private int interes;
    
    public jDmetodopago(java.awt.Frame parent, boolean modal, double precio) {
        super(parent, modal);
        initComponents();
        txtPrecio.setText(precio+"");
        txtOtro.setVisible(false);
    }

    public String getMtdoPago() {
        return mtdoPago;
    }

    public void setMtdoPago(String mtdoPago) {
        this.mtdoPago = mtdoPago;
    }

    public String getTxtTotal() {
        return txtTotal.getText();
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }
                     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdbCheque = new rojerusan.RSRadioButton();
        rdbEfectivo = new rojerusan.RSRadioButton();
        rdbTarCred = new rojerusan.RSRadioButton();
        rdbOtro = new rojerusan.RSRadioButton();
        txtOtro = new javax.swing.JTextField();
        rdbTarDeb = new rojerusan.RSRadioButton();
        jLabel3 = new javax.swing.JLabel();
        Jbtmpagoaceptar = new rscomponentshade.RSButtonShade();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo2.0.PNG"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, 0, 700, 120));

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Método de pago");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        rdbCheque.setForeground(new java.awt.Color(0, 0, 0));
        rdbCheque.setText("Cheque");
        rdbCheque.setColorCheck(new java.awt.Color(0, 0, 0));
        rdbCheque.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rdbCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbChequeActionPerformed(evt);
            }
        });
        getContentPane().add(rdbCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 90, 20));
        buttonGroup1.add(rdbCheque);

        rdbEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        rdbEfectivo.setText("Efectivo");
        rdbEfectivo.setColorCheck(new java.awt.Color(0, 0, 0));
        rdbEfectivo.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rdbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEfectivoActionPerformed(evt);
            }
        });
        getContentPane().add(rdbEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 20));
        buttonGroup1.add(rdbEfectivo);

        rdbTarCred.setForeground(new java.awt.Color(0, 0, 0));
        rdbTarCred.setText("Tarjeta de crédito");
        rdbTarCred.setColorCheck(new java.awt.Color(0, 0, 0));
        rdbTarCred.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rdbTarCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTarCredActionPerformed(evt);
            }
        });
        getContentPane().add(rdbTarCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, 20));
        buttonGroup1.add(rdbTarCred);

        rdbOtro.setForeground(new java.awt.Color(0, 0, 0));
        rdbOtro.setText("Otro");
        rdbOtro.setColorCheck(new java.awt.Color(0, 0, 0));
        rdbOtro.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rdbOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOtroActionPerformed(evt);
            }
        });
        getContentPane().add(rdbOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 70, 20));
        buttonGroup1.add(rdbOtro);
        getContentPane().add(txtOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 220, -1));

        rdbTarDeb.setForeground(new java.awt.Color(0, 0, 0));
        rdbTarDeb.setText("Tarjeta de débito ");
        rdbTarDeb.setColorCheck(new java.awt.Color(0, 0, 0));
        rdbTarDeb.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rdbTarDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTarDebActionPerformed(evt);
            }
        });
        getContentPane().add(rdbTarDeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 160, 20));
        buttonGroup1.add(rdbTarDeb);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Total a pagar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 110, -1));

        Jbtmpagoaceptar.setBackground(new java.awt.Color(51, 51, 51));
        Jbtmpagoaceptar.setText("Aceptar");
        Jbtmpagoaceptar.setAutoscrolls(true);
        Jbtmpagoaceptar.setBgHover(new java.awt.Color(102, 102, 102));
        Jbtmpagoaceptar.setBgShadeHover(new java.awt.Color(231, 152, 147));
        Jbtmpagoaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtmpagoaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Jbtmpagoaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        txtTotal.setEditable(false);
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 333, 27));

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Monto en efectivo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, -1));

        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 333, 27));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mpago.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbTarCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTarCredActionPerformed
        // TODO add your handling code here:
        txtOtro.setVisible(false);
        double r=Double.parseDouble(txtPrecio.getText());
        txtTotal.setText(String.valueOf(r+(r*0.15)));
        setMtdoPago(rdbTarCred.getText());
        setInteres(15);
    }//GEN-LAST:event_rdbTarCredActionPerformed

    private void rdbTarDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTarDebActionPerformed
        // TODO add your handling code here:
        txtOtro.setVisible(false);
        double r=Double.parseDouble(txtPrecio.getText());
        txtTotal.setText(String.valueOf(r+(r*0.1)));
        setMtdoPago(rdbTarDeb.getText());
        setInteres(10);
    }//GEN-LAST:event_rdbTarDebActionPerformed

    private void rdbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEfectivoActionPerformed
        // TODO add your handling code here:
        txtOtro.setVisible(false);
        txtTotal.setText(txtPrecio.getText());
        setMtdoPago(rdbEfectivo.getText());
        setInteres(0);
    }//GEN-LAST:event_rdbEfectivoActionPerformed

    private void rdbOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOtroActionPerformed
        // TODO add your handling code here:
        txtOtro.setVisible(true);
        txtTotal.setText(txtPrecio.getText());
        setMtdoPago(txtOtro.getText());
        setInteres(0);
    }//GEN-LAST:event_rdbOtroActionPerformed

    private void rdbChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbChequeActionPerformed
        // TODO add your handling code here:
        txtOtro.setVisible(false);
        txtTotal.setText(txtPrecio.getText());
        setMtdoPago(rdbCheque.getText());
        setInteres(0);
    }//GEN-LAST:event_rdbChequeActionPerformed

    private void JbtmpagoaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtmpagoaceptarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JbtmpagoaceptarActionPerformed

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
            java.util.logging.Logger.getLogger(jDmetodopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDmetodopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDmetodopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDmetodopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDmetodopago dialog = new jDmetodopago(new javax.swing.JFrame(), true, 4.00);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade Jbtmpagoaceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private rojerusan.RSRadioButton rdbCheque;
    private rojerusan.RSRadioButton rdbEfectivo;
    private rojerusan.RSRadioButton rdbOtro;
    private rojerusan.RSRadioButton rdbTarCred;
    private rojerusan.RSRadioButton rdbTarDeb;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}