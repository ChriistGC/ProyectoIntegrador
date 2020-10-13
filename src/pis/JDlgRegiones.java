/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.DAOException;
import re.dao.DAOManager;
import re.dao.bd.OracleDaoManager;

/**
 *
 * @author Astaroth
 */
public class JDlgRegiones extends javax.swing.JDialog {

    /**
     * Creates new form JDlgRegiones
     */
    
    private DAOManager manager;
    private double presupuesto;
    private int cod;
    
    public JDlgRegiones(java.awt.Frame parent, boolean modal,DAOManager manager, double presupuesto) throws DAOException {
        super(parent, modal);
        initComponents();
        this.manager = manager;
        this.presupuesto=presupuesto;
        this.setLocationRelativeTo(null);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGalapagos = new javax.swing.JButton();
        btnCosta = new javax.swing.JButton();
        btnOriente = new javax.swing.JButton();
        btnSierra = new javax.swing.JButton();
        rSButtonMaterialIconUno1 = new RSMaterialComponent.RSButtonMaterialIconUno();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGalapagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Galapagos_region.gif"))); // NOI18N
        btnGalapagos.setText("jButton2");
        btnGalapagos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGalapagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGalapagosActionPerformed(evt);
            }
        });
        jPanel1.add(btnGalapagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 238, 238, 154));

        btnCosta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CostaEc.gif"))); // NOI18N
        btnCosta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCosta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCosta, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 14, 238, 154));

        btnOriente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Amazonia.gif"))); // NOI18N
        btnOriente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnOriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 238, 238, 154));

        btnSierra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quito1.gif"))); // NOI18N
        btnSierra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSierra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSierraActionPerformed(evt);
            }
        });
        jPanel1.add(btnSierra, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 14, 238, 154));

        rSButtonMaterialIconUno1.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonMaterialIconUno1.setText("Regresar");
        rSButtonMaterialIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_BACK);
        rSButtonMaterialIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconUno1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 130, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Sierra");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 168, 70, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Galapagos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 392, 84, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Costa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 168, 70, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Oriente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 392, 70, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 448, 560, 112));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ecuador.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 994, 586));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 588));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSierraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSierraActionPerformed
        // TODO add your handling code here:
        try {
            jDialSeleccion ventana = new jDialSeleccion(null, true, manager, 2, presupuesto);
            ventana.setVisible(true);
            setCod(ventana.getCod());
            ventana.pack();
            dispose();
        } catch (DAOException ex) {
            Logger.getLogger(JDlgRegiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSierraActionPerformed

    private void btnOrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrienteActionPerformed
        // TODO add your handling code here:
        try {
            jDialSeleccion ventana = new jDialSeleccion(null, true, manager, 3, presupuesto);
            ventana.setVisible(true);
            setCod(ventana.getCod());
            ventana.pack();
            dispose();
        } catch (DAOException ex) {
            Logger.getLogger(JDlgRegiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrienteActionPerformed

    private void btnGalapagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGalapagosActionPerformed
        // TODO add your handling code here:
        try {
            jDialSeleccion ventana = new jDialSeleccion(null, true, manager, 4, presupuesto);
            ventana.setVisible(true);
            setCod(ventana.getCod());
            ventana.pack();
            dispose();
        } catch (DAOException ex) {
            Logger.getLogger(JDlgRegiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGalapagosActionPerformed

    private void btnCostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostaActionPerformed
        try {
            jDialSeleccion ventana = new jDialSeleccion(null, true, manager, 1, presupuesto);
            ventana.setVisible(true);
            setCod(ventana.getCod());
            ventana.pack();
            dispose();
        } catch (DAOException ex) {
            Logger.getLogger(JDlgRegiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCostaActionPerformed

    private void rSButtonMaterialIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconUno1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_rSButtonMaterialIconUno1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws ClassNotFoundException, SQLException {
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
            java.util.logging.Logger.getLogger(JDlgRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        DAOManager manager = new OracleDaoManager("jdbc:oracle:thin:@localhost:1521:XE", "turistapp", "042395");
        java.awt.EventQueue.invokeLater(() -> {
            try {
                JDlgRegiones dialog = new JDlgRegiones(new javax.swing.JFrame(), true, manager, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(JDlgRegiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCosta;
    private javax.swing.JButton btnGalapagos;
    private javax.swing.JButton btnOriente;
    private javax.swing.JButton btnSierra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private RSMaterialComponent.RSButtonMaterialIconUno rSButtonMaterialIconUno1;
    // End of variables declaration//GEN-END:variables
}
