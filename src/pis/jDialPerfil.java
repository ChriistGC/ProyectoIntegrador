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
import reg.modelo.Actividad;
import reg.modelo.Usuario;
import reg.modelo.Login;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author kriZ_
 */
public class jDialPerfil extends javax.swing.JDialog {

    /**
     * Creates new form jDialPerfil
     */
    private DAOManager manager;
    private int cod;
    private String user;

    public jDialPerfil(java.awt.Frame parent, boolean modal, DAOManager manager) throws DAOException {
        super(parent, modal);
        initComponents();
        this.manager = manager;
        this.setResizable(false);
        Datos();
        rsutilities.RSUtilities.setCentrarVentana(this);
    }

    public jDialPerfil(java.awt.Frame parent, boolean modal, DAOManager manager, int cod, String user) throws DAOException {
        super(parent, modal);
        initComponents();
        this.manager = manager;
        this.cod = cod;
        this.user = user;
        this.setResizable(false);
        rsutilities.RSUtilities.setCentrarVentana(this);
        Datos();
    }
        
    private Usuario getUsuarioSeleccionado() throws DAOException {
        return manager.getUsuarioDAO().obtener(cod);
    }

    private Login getLoginSeleccionado() throws DAOException {
        return manager.getLoginDAO().obtenerUser(user);
    }

    private void Datos() {
        try {
            Usuario cl = getUsuarioSeleccionado();
            Login lg = getLoginSeleccionado();
            perfil1.setUsuario(cl);
            perfil1.setLogin(lg);
            perfil1.setVentana2(this);
            perfil1.setManager(manager);
            perfil1.setEditable(false);
            perfil1.loadData();
        } catch (DAOException ex) {
            Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel2 = new javax.swing.JPanel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        btnPerfil = new RSMaterialComponent.RSButtonMaterialIconUno();
        btnComprar = new RSMaterialComponent.RSButtonMaterialIconUno();
        rSLabelSombra1 = new rojeru_san.rslabel.RSLabelSombra();
        btnSalir = new RSMaterialComponent.RSButtonMaterialIconUno();
        btnActividad = new RSMaterialComponent.RSButtonMaterialIconUno();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnl1 = new javax.swing.JPanel();
        perfil1 = new pis.Perfil();
        pnl2 = new javax.swing.JPanel();
        compra1 = new pis.Compra();
        pnl3 = new javax.swing.JPanel();
        actividad1 = new pis.jPanelActividad();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(38, 38, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoxd.png"))); // NOI18N
        jPanel2.add(rSLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 50));

        btnPerfil.setBackground(new java.awt.Color(38, 38, 38));
        btnPerfil.setText("Perfil");
        btnPerfil.setBackgroundHover(new java.awt.Color(0, 0, 0));
        btnPerfil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_BOX);
        btnPerfil.setSelected(true);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        jPanel2.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

        btnComprar.setBackground(new java.awt.Color(38, 38, 38));
        btnComprar.setText("COMPRAR");
        btnComprar.setBackgroundHover(new java.awt.Color(0, 0, 0));
        btnComprar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FLIGHT_TAKEOFF);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel2.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        rSLabelSombra1.setBackground(new java.awt.Color(255, 255, 255));
        rSLabelSombra1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelSombra1.setText("TuristApp");
        jPanel2.add(rSLabelSombra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 0, 102));
        btnSalir.setText("Salir");
        btnSalir.setBackgroundHover(new java.awt.Color(152, 0, 0));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 120, -1));

        btnActividad.setBackground(new java.awt.Color(38, 38, 38));
        btnActividad.setText("Actividad");
        btnActividad.setBackgroundHover(new java.awt.Color(0, 0, 0));
        btnActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActividadActionPerformed(evt);
            }
        });
        jPanel2.add(btnActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));

        pnl1.setBackground(new java.awt.Color(255, 255, 255));
        pnl1.setName("pnl1"); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(perfil1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addComponent(perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnl1, "card2");

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setName("pnl2"); // NOI18N

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(compra1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(compra1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        rSPanelsSlider1.add(pnl2, "card3");

        pnl3.setBackground(new java.awt.Color(255, 255, 255));
        pnl3.setName("pnl3"); // NOI18N

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actividad1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        rSPanelsSlider1.add(pnl3, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:
        if (!this.btnPerfil.isSelected()) {
            this.btnPerfil.setSelected(true);
            this.btnComprar.setSelected(false);
            this.btnActividad.setSelected(false);

            rSPanelsSlider1.setPanelSlider(1, pnl1, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        if (!this.btnComprar.isSelected()) {
            this.btnPerfil.setSelected(false);
            this.btnComprar.setSelected(true);
            this.btnActividad.setSelected(false);
            try {
                Usuario cl = getUsuarioSeleccionado();
                compra1.setUsuario(cl);
                compra1.setManager(manager);
                compra1.setEditable();
                compra1.loadData();
            } catch (DAOException ex) {
                Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }

            rSPanelsSlider1.setPanelSlider(1, pnl2, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        jFrmPrincipal ventana= new jFrmPrincipal();
        ventana.setVisible(true);
        ventana.pack();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActividadActionPerformed
        // TODO add your handling code here:
        if (!this.btnActividad.isSelected()) {
            this.btnPerfil.setSelected(false);
            this.btnComprar.setSelected(false);
            this.btnActividad.setSelected(true);
            try {
                Usuario cl = getUsuarioSeleccionado();
                actividad1.llenarTabla(manager, cl.getCodigo());
            } catch (DAOException ex) {
                Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }

            rSPanelsSlider1.setPanelSlider(1, pnl3, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnActividadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
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
            java.util.logging.Logger.getLogger(jDialPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDialPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDialPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDialPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        DAOManager manager = new OracleDaoManager("jdbc:oracle:thin:@localhost:1521:XE", "turistapp", "042395");
        java.awt.EventQueue.invokeLater(() -> {
            try {
                jDialPerfil dialog = new jDialPerfil(new javax.swing.JFrame(), true, manager);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(jDialPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pis.jPanelActividad actividad1;
    private RSMaterialComponent.RSButtonMaterialIconUno btnActividad;
    private RSMaterialComponent.RSButtonMaterialIconUno btnComprar;
    private RSMaterialComponent.RSButtonMaterialIconUno btnPerfil;
    private RSMaterialComponent.RSButtonMaterialIconUno btnSalir;
    private pis.Compra compra1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private pis.Perfil perfil1;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojeru_san.rslabel.RSLabelSombra rSLabelSombra1;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    // End of variables declaration//GEN-END:variables
}
