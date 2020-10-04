/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import re.dao.DAOException;
import re.dao.DAOManager;
import reg.modelo.DetalleFactura;
import reg.modelo.Factura;
import reg.modelo.Paquete;
import reg.modelo.Region;
import reg.modelo.Usuario;

/**
 *
 * @author kriZ_
 */
public class Compra extends javax.swing.JPanel {

    /**
     * Creates new form Compra
     */
    private DAOManager manager;
    private Usuario usuario;
    private Region region;
    private Paquete paquete;
    private Factura factura;
    private int interes;

    public Compra() {
        initComponents();
    }

    public DAOManager getManager() {
        return manager;
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public void setEditable() {
        txtCodigo.setEditable(false);
        txtCedula.setEditable(false);
        txtTelefono.setEditable(false);
        txtPresupuesto.setEditable(false);
        txtDireccion.setEditable(false);
        txtCorreo.setEditable(false);
        txtCiudad.setEditable(false);
        txtCodPaq.setEditable(false);
        txtRegion.setEditable(false);
        txtLugarTuristico.setEditable(false);
        txtCiudPaq.setEditable(false);
        txtDirPaq.setEditable(false);
        txtMtdoPago.setEditable(false);
        txtPrecio.setEditable(false);
        txtTotal.setEditable(false);
    }

    public void loadData() {
        if (usuario != null) {
            txtCodigo.setText(usuario.getCodigo() + "");
            txtCedula.setText(usuario.getCedula());
            txtTelefono.setText(usuario.getTelefono());
            txtDireccion.setText(usuario.getDireccion());
            txtCorreo.setText(usuario.getCorreo());
            txtCiudad.setText(usuario.getCiudad());

        } else {
            txtCodigo.setText("");
            txtCedula.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtCorreo.setText("");
            txtCiudad.setText("");
        }

        if (paquete != null) {
            txtCodPaq.setText(paquete.getId_paquete() + " ");
            txtRegion.setText(region.getRegion());
            txtLugarTuristico.setText(paquete.getLugarturistico());
            txtCiudPaq.setText(paquete.getCiudad());
            txtDirPaq.setText(paquete.getDireccion());
            txtPrecio.setText((paquete.getPresupuesto() - (paquete.getPresupuesto() * 0.12)) + "");
            txtTotal.setText(paquete.getPresupuesto() + " ");
        } else {
            txtCodPaq.setText("");
            txtRegion.setText("");
            txtLugarTuristico.setText("");
            txtCiudPaq.setText("");
            txtDirPaq.setText("");
            txtPrecio.setText("");
            txtTotal.setText("");
            fecha.setLimpiarFecha(true);
        }

        txtCodigo.requestFocus();
    }

    private void limpiarDatos() {
        setPaquete(null);
        loadData();
    }

    private void guardarDatos() {
        JFileChooser ventana = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        ventana.addChoosableFileFilter(filter);
        ventana.setFileFilter(filter);
        ventana.setDialogTitle("Guardar Factura");

        if (ventana.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = ventana.getSelectedFile();
                BufferedWriter bw;
                if (archivo.exists()) {
                    bw = new BufferedWriter(new FileWriter(archivo.getAbsoluteFile() + ".txt"));
                    bw.write("Factura #" + factura.getIdFactura() + "\nFecha de la compra: " + factura.getFechaVenta() + "\nNombre del Cliente: " + usuario.getNombres() + " " + usuario.getApellidos()
                            + "\nCedula: " + usuario.getCedula() + "\nCorreo: " + usuario.getCorreo() + "\nTelefono: " + usuario.getTelefono()
                            + "\nLugar Turistico: " + paquete.getLugarturistico() + "\nRegion: " + region.getRegion() + "\nCiudad: " + paquete.getCiudad()
                            + "\nDireccion" + paquete.getDireccion() + "\nFecha del viaje: " + factura.getFechaViaje() + "\nPrecio sin IVA: " + txtPrecio.getText()
                            + "\nInteres por tarjeta: "+factura.getInteresPago()+"\nIVA: " + factura.getIVA() + "\nTotal: " + factura.getTotal());
                } else {
                    bw = new BufferedWriter(new FileWriter(archivo.getAbsoluteFile() + ".txt"));
                    bw.write("Factura #" + factura.getIdFactura() + "\nFecha de la compra: " + factura.getFechaVenta() + "\nNombre del Cliente: " + usuario.getNombres() + " " + usuario.getApellidos()
                            + "\nCedula: " + usuario.getCedula() + "\nCorreo: " + usuario.getCorreo() + "\nTelefono: " + usuario.getTelefono()
                            + "\nLugar Turistico: " + paquete.getLugarturistico() + "\nRegion: " + region.getRegion() + "\nCiudad: " + paquete.getCiudad()
                            + "\nDireccion" + paquete.getDireccion() + "\nFecha del viaje" + factura.getFechaViaje() + "\nPrecio sin IVA: " + txtPrecio.getText()
                            + "\nInteres por tarjeta: "+factura.getInteresPago()+"\nIVA: " + factura.getIVA() + "\nTotal: " + factura.getTotal());
                }
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiarDatos();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSPanelShadow1 = new necesario.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon2 = new RSMaterialComponent.RSLabelIcon();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon3 = new RSMaterialComponent.RSLabelIcon();
        rSLabelIcon4 = new RSMaterialComponent.RSLabelIcon();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel8 = new javax.swing.JLabel();
        txtCiudad = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon6 = new RSMaterialComponent.RSLabelIcon();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon7 = new RSMaterialComponent.RSLabelIcon();
        txtPresupuesto = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel10 = new javax.swing.JLabel();
        rSLabelIcon8 = new RSMaterialComponent.RSLabelIcon();
        btnPresupuesto = new RSMaterialComponent.RSButtonIconUno();
        rSPanelShadow2 = new necesario.RSPanelShadow();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnPaquete = new RSMaterialComponent.RSButtonIconUno();
        rSLabelIcon5 = new RSMaterialComponent.RSLabelIcon();
        jLabel7 = new javax.swing.JLabel();
        txtCodPaq = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon10 = new RSMaterialComponent.RSLabelIcon();
        jLabel12 = new javax.swing.JLabel();
        txtRegion = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon11 = new RSMaterialComponent.RSLabelIcon();
        jLabel13 = new javax.swing.JLabel();
        txtLugarTuristico = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon12 = new RSMaterialComponent.RSLabelIcon();
        jLabel14 = new javax.swing.JLabel();
        txtCiudPaq = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon13 = new RSMaterialComponent.RSLabelIcon();
        jLabel15 = new javax.swing.JLabel();
        txtDirPaq = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon14 = new RSMaterialComponent.RSLabelIcon();
        jLabel16 = new javax.swing.JLabel();
        fecha = new rojerusan.RSDateChooser();
        rSLabelIcon15 = new RSMaterialComponent.RSLabelIcon();
        jLabel17 = new javax.swing.JLabel();
        txtMtdoPago = new RSMaterialComponent.RSTextFieldMaterial();
        btnMtdoPago = new RSMaterialComponent.RSButtonIconUno();
        rSLabelIcon16 = new RSMaterialComponent.RSLabelIcon();
        jLabel18 = new javax.swing.JLabel();
        txtPrecio = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon17 = new RSMaterialComponent.RSLabelIcon();
        jLabel19 = new javax.swing.JLabel();
        txtTotal = new RSMaterialComponent.RSTextFieldMaterial();
        btnConfirmar = new rojerusan.RSButtonIconD();

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/source.gif"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(42, 148, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DATOS CLIENTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSLabelIcon1.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setPlaceholder("id usuario");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CEDULA");

        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula.setPlaceholder("Cedula usuario");
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        rSLabelIcon2.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FEATURED_VIDEO);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CORREO");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setPlaceholder("Correo usuario");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        rSLabelIcon3.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);

        rSLabelIcon4.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHONE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONO");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono.setPlaceholder("Telefono usuario");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CIUDAD");

        txtCiudad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCiudad.setPlaceholder("Ciudad Usuario");
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        rSLabelIcon6.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MAP);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DIRECCION");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion.setPlaceholder("Direccion usuario");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        rSLabelIcon7.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOME);

        txtPresupuesto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPresupuesto.setPlaceholder("Ingrese Presupuesto");
        txtPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresupuestoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PRESUPUESTO");

        rSLabelIcon8.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WEB_ASSET);

        btnPresupuesto.setBackground(new java.awt.Color(38, 38, 38));
        btnPresupuesto.setBackgroundHover(new java.awt.Color(38, 38, 38));
        btnPresupuesto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnPresupuesto.setInheritsPopupMenu(true);
        btnPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresupuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rSLabelIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(rSLabelIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(rSLabelIcon7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rSLabelIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rSLabelIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(62, 79, 187));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("DATOS DE PAQUETE");

        btnPaquete.setBackground(new java.awt.Color(38, 38, 38));
        btnPaquete.setBackgroundHover(new java.awt.Color(38, 38, 38));
        btnPaquete.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnPaquete.setInheritsPopupMenu(true);
        btnPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        rSLabelIcon5.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ID");

        txtCodPaq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodPaq.setPlaceholder("ID del paquete");
        txtCodPaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPaqActionPerformed(evt);
            }
        });

        rSLabelIcon10.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon10.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FEATURED_VIDEO);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("REGION");

        txtRegion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRegion.setPlaceholder("Region del lugar turistico");
        txtRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegionActionPerformed(evt);
            }
        });

        rSLabelIcon11.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon11.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ALL_OUT);
        rSLabelIcon11.setInheritsPopupMenu(true);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("LUGAR TURISTICO");

        txtLugarTuristico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLugarTuristico.setPlaceholder("Lugar Turistico");
        txtLugarTuristico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugarTuristicoActionPerformed(evt);
            }
        });

        rSLabelIcon12.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MAP);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("CIUDAD");

        txtCiudPaq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCiudPaq.setPlaceholder("Ciudad");
        txtCiudPaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudPaqActionPerformed(evt);
            }
        });

        rSLabelIcon13.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DEHAZE);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("DIRECCION");

        txtDirPaq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDirPaq.setPlaceholder("Direccion");
        txtDirPaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirPaqActionPerformed(evt);
            }
        });

        rSLabelIcon14.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon14.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DATE_RANGE);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("FECHA");

        fecha.setColorBackground(new java.awt.Color(0, 0, 0));
        fecha.setFormatoFecha("dd/MM/yyyy");
        fecha.setPlaceholder("Seleccione fecha");

        rSLabelIcon15.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon15.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CREDIT_CARD);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("METODO DE PAGO");

        txtMtdoPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMtdoPago.setPlaceholder("Seleccione metodo de pago");
        txtMtdoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMtdoPagoActionPerformed(evt);
            }
        });

        btnMtdoPago.setBackground(new java.awt.Color(38, 38, 38));
        btnMtdoPago.setBackgroundHover(new java.awt.Color(38, 38, 38));
        btnMtdoPago.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnMtdoPago.setInheritsPopupMenu(true);
        btnMtdoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMtdoPagoActionPerformed(evt);
            }
        });

        rSLabelIcon16.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon16.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ATTACH_MONEY);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("PRECIO");

        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecio.setPlaceholder("Precio sin IVA");
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        rSLabelIcon17.setForeground(new java.awt.Color(38, 38, 38));
        rSLabelIcon17.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DESCRIPTION);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("TOTAL(PRECIO+IVA)");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setPlaceholder("Precio con IVA");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(rSLabelIcon10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCiudPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(rSLabelIcon13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDirPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rSLabelIcon11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLugarTuristico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rSLabelIcon16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(rSLabelIcon17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rSLabelIcon14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rSLabelIcon15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMtdoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMtdoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 23, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLugarTuristico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSLabelIcon11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCiudPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDirPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMtdoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSLabelIcon15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(rSLabelIcon14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(30, 30, 30)))
                    .addComponent(btnMtdoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rSLabelIcon16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(2, 2, 2)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(rSLabelIcon17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow2.add(jPanel3, java.awt.BorderLayout.CENTER);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vcsnormal_93488.png"))); // NOI18N
        btnConfirmar.setText("CONFIRMAR COMPRA");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSPanelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSPanelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresupuestoActionPerformed

    private void txtCodPaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPaqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPaqActionPerformed

    private void txtRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegionActionPerformed

    private void txtLugarTuristicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarTuristicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarTuristicoActionPerformed

    private void txtCiudPaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudPaqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudPaqActionPerformed

    private void txtDirPaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirPaqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirPaqActionPerformed

    private void txtMtdoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMtdoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMtdoPagoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        if ((paquete == null && region == null) || txtMtdoPago.getText().isEmpty() || fecha.getFechaSeleccionada().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellena todos los datos", "Sistema", JOptionPane.ERROR_MESSAGE);
        } else {
            int n = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la compra?", "Mensaje del Sistema",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (n == JOptionPane.OK_OPTION) {
                try {
                    int id = 1;
                    try {

                        while (manager.getFacturaDAO().obtener(id) != null) {
                            id++;
                        }

                    } catch (DAOException ex) {
                        Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DateTimeFormatter date1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaactual = LocalDate.now();
                    LocalDate fechavuelo = LocalDate.parse(fecha.getFechaSeleccionada(), date1);
                    String fechaventa = fechaactual.format(date1);
                    Period periodo = Period.between(fechaactual, fechavuelo);
                    if (periodo.getYears() <= 0 && periodo.getMonths() <= 0 && periodo.getDays() <= 0) {
                        fecha.setLimpiarFecha(true);
                        JOptionPane.showMessageDialog(null, "Ingrese una fecha valida", "Sistema", JOptionPane.ERROR_MESSAGE);
                    } else {
                        factura = new Factura(id, fechaventa, fecha.getFechaSeleccionada(), txtMtdoPago.getText(), getInteres(), 12, Double.parseDouble(txtTotal.getText()));
                        manager.getFacturaDAO().insertar(factura);
                        DetalleFactura det = new DetalleFactura(usuario.getCodigo(), 0, paquete.getId_paquete(), factura.getIdFactura());
                        manager.getDetalleFacturaDAO().insertar(det);
                        guardarDatos();
                    }
                } catch (DAOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresupuestoActionPerformed
        // TODO add your handling code here:
        jDialPresupuesto ventana = new jDialPresupuesto(null, true);
        ventana.setVisible(true);
        txtPresupuesto.setText(ventana.getTxtPresupuesto());
    }//GEN-LAST:event_btnPresupuestoActionPerformed

    private void btnPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaqueteActionPerformed
        // TODO add your handling code here:
        ;
        try {
            if (txtPresupuesto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un presupuesto", "Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                JDlgRegiones ventana = new JDlgRegiones(null, true, getManager(), Double.parseDouble(txtPresupuesto.getText()));
                ventana.setVisible(true);
                Paquete pq = manager.getPaqueteDAO().obtener(ventana.getCod());
                Region rg = manager.getRegionDAO().obtener(pq.getId_region());
                setPaquete(pq);
                setRegion(rg);
                loadData();
            }
        } catch (DAOException ex) {
//            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPaqueteActionPerformed

    private void btnMtdoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMtdoPagoActionPerformed
        // TODO add your handling code here:
        double precio = paquete.getPresupuesto();
        jDmetodopago ventana = new jDmetodopago(null, true, precio);
        ventana.setVisible(true);
        ventana.pack();
        txtMtdoPago.setText(ventana.getMtdoPago());
        setInteres(ventana.getInteres());
        txtTotal.setText(ventana.getTxtTotal());
    }//GEN-LAST:event_btnMtdoPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconD btnConfirmar;
    private RSMaterialComponent.RSButtonIconUno btnMtdoPago;
    private RSMaterialComponent.RSButtonIconUno btnPaquete;
    private RSMaterialComponent.RSButtonIconUno btnPresupuesto;
    private rojerusan.RSDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon10;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon11;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon12;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon13;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon14;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon15;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon16;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon17;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon2;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon3;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon4;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon5;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon6;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon7;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon8;
    private rojerusan.RSPanelImage rSPanelImage1;
    private necesario.RSPanelShadow rSPanelShadow1;
    private necesario.RSPanelShadow rSPanelShadow2;
    private RSMaterialComponent.RSTextFieldMaterial txtCedula;
    private RSMaterialComponent.RSTextFieldMaterial txtCiudPaq;
    private RSMaterialComponent.RSTextFieldMaterial txtCiudad;
    private RSMaterialComponent.RSTextFieldMaterial txtCodPaq;
    private RSMaterialComponent.RSTextFieldMaterial txtCodigo;
    private RSMaterialComponent.RSTextFieldMaterial txtCorreo;
    private RSMaterialComponent.RSTextFieldMaterial txtDirPaq;
    private RSMaterialComponent.RSTextFieldMaterial txtDireccion;
    private RSMaterialComponent.RSTextFieldMaterial txtLugarTuristico;
    private RSMaterialComponent.RSTextFieldMaterial txtMtdoPago;
    private RSMaterialComponent.RSTextFieldMaterial txtPrecio;
    private RSMaterialComponent.RSTextFieldMaterial txtPresupuesto;
    private RSMaterialComponent.RSTextFieldMaterial txtRegion;
    private RSMaterialComponent.RSTextFieldMaterial txtTelefono;
    private RSMaterialComponent.RSTextFieldMaterial txtTotal;
    // End of variables declaration//GEN-END:variables
}
