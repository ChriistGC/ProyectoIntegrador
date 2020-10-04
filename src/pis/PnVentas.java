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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import re.dao.DAOException;
import re.dao.DAOManager;
import reg.modelo.DetalleFactura;
import reg.modelo.Empleado;
import reg.modelo.Factura;
import reg.modelo.Paquete;
import reg.modelo.Region;
import reg.modelo.Usuario;

/**
 *
 * @author Astaroth
 */
public class PnVentas extends javax.swing.JPanel {
    private DAOManager manager;
    private Empleado empleado;
    private Region region;
    private Paquete paquete;
    private Usuario usuario;   
    private Factura factura;
    private int interes;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public DAOManager getManager() {
        return manager;
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
    
    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    /**
     * Creates new form PnVentas
     */
    public void setPaquete(Paquete paquete) {    
        this.paquete = paquete;
    }
    public void setEditable() {
        this.jTxidcliente.setEditable(true);
        this.jTxcedula.setEditable(true);
        this.jTxtelefono.setEditable(true);
        this.jTxdireccliente.setEditable(true);
        this.jTxcorreo.setEditable(true);
        this.jTxclienteciudad.setEditable(true);
        
        this.jTxIDPaquete.setEditable(false);
        this.jTxregion.setEditable(false);
        this.jTxsitio.setEditable(false);
        this.jTxpaqueteciudad.setEditable(false);
        this.jTxdireccionsitio.setEditable(false);
        this.jTxventasmetodo.setEditable(false);
        this.jTxprecio1.setEditable(false);
        this.jTxtotal.setEditable(false);
    }
    public void loadData() {
        if (paquete != null) {
            this.jTxIDPaquete.setText(paquete.getId_paquete() + " ");
            this.jTxregion.setText(region.getRegion());
            this.jTxsitio.setText(paquete.getLugarturistico());
            this.jTxpaqueteciudad.setText(paquete.getCiudad());
            this.jTxdireccionsitio.setText(paquete.getDireccion());
            this.jTxprecio1.setText((paquete.getPresupuesto() - (paquete.getPresupuesto() * 0.12)) + "");
            this.jTxtotal.setText(paquete.getPresupuesto() + " ");
        } else{
            this.jTxIDPaquete.setText("");
            this.jTxregion.setText("");
            this.jTxsitio.setText("");
            this.jTxpaqueteciudad.setText("");
            this.jTxdireccionsitio.setText("");
            this.jTxprecio1.setText("");
            this.jTxtotal.setText("");
        }
    }
    public void loadUsuario(){
        this.jTxidcliente.setText(usuario.getCodigo()+"");
        this.jTxtelefono.setText(usuario.getTelefono());
        this.jTxdireccliente.setText(usuario.getDireccion());
        this.jTxcorreo.setText(usuario.getCorreo());
        this.jTxclienteciudad.setText(usuario.getCiudad());
    }

    public PnVentas() {
        initComponents();
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
                            + "\nDireccion" + paquete.getDireccion() + "\nFecha del viaje: " + factura.getFechaViaje() + "\nPrecio sin IVA: " + jTxprecio1.getText()
                            + "\nInteres por tarjeta: "+factura.getInteresPago()+"\nIVA: " + factura.getIVA() + "\nTotal: " + factura.getTotal()+"\nVenta realizada por: "+empleado.getNombres()+" "+empleado.getApellidos());
                } else {
                    bw = new BufferedWriter(new FileWriter(archivo.getAbsoluteFile() + ".txt"));
                    bw.write("Factura #" + factura.getIdFactura() + "\nFecha de la compra: " + factura.getFechaVenta() + "\nNombre del Cliente: " + usuario.getNombres() + " " + usuario.getApellidos()
                            + "\nCedula: " + usuario.getCedula() + "\nCorreo: " + usuario.getCorreo() + "\nTelefono: " + usuario.getTelefono()
                            + "\nLugar Turistico: " + paquete.getLugarturistico() + "\nRegion: " + region.getRegion() + "\nCiudad: " + paquete.getCiudad()
                            + "\nDireccion" + paquete.getDireccion() + "\nFecha del viaje: " + factura.getFechaViaje() + "\nPrecio sin IVA: " + jTxprecio1.getText()
                            + "\nInteres por tarjeta: "+factura.getInteresPago()+"\nIVA: " + factura.getIVA() + "\nTotal: " + factura.getTotal()+"\nVenta realizada por: "+empleado.getNombres()+" "+empleado.getApellidos());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rSPanelVector2 = new rojeru_san.rspanel.RSPanelVector();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        jLabel1 = new javax.swing.JLabel();
        jBtcancelar = new rojeru_san.rsbutton.RSButtonRound();
        fecha = new rojerusan.RSDateChooser();
        jLabel4 = new javax.swing.JLabel();
        rSPanelVector3 = new rojeru_san.rspanel.RSPanelVector();
        jLabel3 = new javax.swing.JLabel();
        jBtiniciarregion = new rojeru_san.rsbutton.RSButtonRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxIDPaquete = new rojeru_san.RSMTextFull();
        jTxidcliente = new rojeru_san.RSMTextFull();
        jTxpaqueteciudad = new rojeru_san.RSMTextFull();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlbfecha = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTxregion = new rojeru_san.RSMTextFull();
        jTxtotal = new rojeru_san.RSMTextFull();
        jTxsitio = new rojeru_san.RSMTextFull();
        jBtgenarar = new rojeru_san.rsbutton.RSButtonRound();
        Jbtmpago = new rojeru_san.rsbutton.RSButtonRound();
        jLabel15 = new javax.swing.JLabel();
        jTxcorreo = new rojeru_san.RSMTextFull();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTxdireccionsitio = new rojeru_san.RSMTextFull();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTxventasmetodo = new rojeru_san.RSMTextFull();
        jLabel12 = new javax.swing.JLabel();
        jTxprecio1 = new rojeru_san.RSMTextFull();
        jLabel13 = new javax.swing.JLabel();
        jTxtelefono = new rojeru_san.RSMTextFull();
        jLabel17 = new javax.swing.JLabel();
        jTxcedula = new rojeru_san.RSMTextFull();
        jLabel18 = new javax.swing.JLabel();
        jTxpresupuesto = new rojeru_san.RSMTextFull();
        jLabel19 = new javax.swing.JLabel();
        jTxdireccliente = new rojeru_san.RSMTextFull();
        jLabel20 = new javax.swing.JLabel();
        jTxclienteciudad = new rojeru_san.RSMTextFull();
        jBtced = new RSMaterialComponent.RSButtonIconUno();
        jBteditpresupuesto1 = new RSMaterialComponent.RSButtonIconUno();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelVector2.setBackground(new java.awt.Color(255, 188, 72));
        rSPanelVector2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelHora1.setBackground(new java.awt.Color(0, 0, 0));
        rSLabelHora1.setForeground(new java.awt.Color(51, 51, 51));
        rSPanelVector2.add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 0, 81, 29));

        rSLabelFecha1.setForeground(new java.awt.Color(51, 51, 51));
        rSPanelVector2.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(978, 2, 79, 27));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Date:");
        rSPanelVector2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(939, 2, -1, 27));

        jBtcancelar.setBackground(new java.awt.Color(51, 51, 51));
        jBtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar.png"))); // NOI18N
        jBtcancelar.setText("   Cancelar");
        jBtcancelar.setColorBorde(new java.awt.Color(43, 43, 43));
        jBtcancelar.setColorHover(new java.awt.Color(102, 102, 102));
        jBtcancelar.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSPanelVector2.add(jBtcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 640, 180, -1));

        fecha.setBackground(new java.awt.Color(255, 188, 72));
        fecha.setColorBackground(new java.awt.Color(51, 51, 51));
        fecha.setColorButtonHover(new java.awt.Color(102, 102, 102));
        fecha.setColorForeground(new java.awt.Color(255, 188, 72));
        fecha.setColorTextDiaActual(new java.awt.Color(255, 188, 72));
        fecha.setFormatoFecha("dd/MM/yyyy");
        fecha.setPlaceholder("Seleccione fecha");
        rSPanelVector2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 270, -1));

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Venta de paquete:");
        rSPanelVector2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        rSPanelVector3.setBackground(new java.awt.Color(255, 188, 72));
        rSPanelVector3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo1.png"))); // NOI18N
        rSPanelVector3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 15, 557, 112));

        jBtiniciarregion.setBackground(new java.awt.Color(51, 51, 51));
        jBtiniciarregion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/register-machine_icon-icons.com_48487.png"))); // NOI18N
        jBtiniciarregion.setText("     Iniciar");
        jBtiniciarregion.setColorBorde(new java.awt.Color(43, 43, 43));
        jBtiniciarregion.setColorHover(new java.awt.Color(102, 102, 102));
        jBtiniciarregion.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        jBtiniciarregion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtiniciarregionActionPerformed(evt);
            }
        });
        rSPanelVector3.add(jBtiniciarregion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 160, 40));

        rSPanelVector2.add(rSPanelVector3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 140));

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Datos Paquete");
        rSPanelVector2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ciudad");
        rSPanelVector2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 20));

        jTxIDPaquete.setBackground(new java.awt.Color(255, 188, 72));
        jTxIDPaquete.setForeground(new java.awt.Color(51, 51, 51));
        jTxIDPaquete.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxIDPaquete.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxIDPaquete.setPlaceholder("ID paquete");
        jTxIDPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxIDPaqueteActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxIDPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 270, 32));

        jTxidcliente.setBackground(new java.awt.Color(255, 188, 72));
        jTxidcliente.setForeground(new java.awt.Color(51, 51, 51));
        jTxidcliente.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxidcliente.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxidcliente.setPlaceholder("ID del cliente");
        jTxidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxidclienteActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxidcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 270, 32));

        jTxpaqueteciudad.setEditable(false);
        jTxpaqueteciudad.setBackground(new java.awt.Color(255, 188, 72));
        jTxpaqueteciudad.setForeground(new java.awt.Color(51, 51, 51));
        jTxpaqueteciudad.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxpaqueteciudad.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxpaqueteciudad.setPlaceholder("Ciudad");
        jTxpaqueteciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxpaqueteciudadActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxpaqueteciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 270, 32));

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Dirección");
        rSPanelVector2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, 20));

        jLabel8.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Id Cliente");
        rSPanelVector2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));

        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Region");
        rSPanelVector2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, 20));

        jlbfecha.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jlbfecha.setForeground(new java.awt.Color(51, 51, 51));
        jlbfecha.setText("Fecha");
        rSPanelVector2.add(jlbfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, 20));

        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("S. turistico");
        rSPanelVector2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, 20));
        jLabel14.getAccessibleContext().setAccessibleName("S.Turístico");

        jTxregion.setBackground(new java.awt.Color(255, 188, 72));
        jTxregion.setForeground(new java.awt.Color(51, 51, 51));
        jTxregion.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxregion.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxregion.setPlaceholder("Region");
        jTxregion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxregionActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxregion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 270, 32));

        jTxtotal.setEditable(false);
        jTxtotal.setBackground(new java.awt.Color(255, 188, 72));
        jTxtotal.setForeground(new java.awt.Color(51, 51, 51));
        jTxtotal.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxtotal.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxtotal.setPlaceholder("Precio + Iva");
        jTxtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtotalActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 270, 32));

        jTxsitio.setEditable(false);
        jTxsitio.setBackground(new java.awt.Color(255, 188, 72));
        jTxsitio.setForeground(new java.awt.Color(51, 51, 51));
        jTxsitio.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxsitio.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxsitio.setPlaceholder("Sitio Turístico");
        jTxsitio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxsitioActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxsitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 640, 32));

        jBtgenarar.setBackground(new java.awt.Color(51, 51, 51));
        jBtgenarar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/factura.png"))); // NOI18N
        jBtgenarar.setText("  Generar Factura");
        jBtgenarar.setColorBorde(new java.awt.Color(43, 43, 43));
        jBtgenarar.setColorHover(new java.awt.Color(102, 102, 102));
        jBtgenarar.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        jBtgenarar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtgenararActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jBtgenarar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, -1, -1));

        Jbtmpago.setBackground(new java.awt.Color(51, 51, 51));
        Jbtmpago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mpagos.png"))); // NOI18N
        Jbtmpago.setText(" Metodo de pago");
        Jbtmpago.setColorBorde(new java.awt.Color(43, 43, 43));
        Jbtmpago.setColorHover(new java.awt.Color(102, 102, 102));
        Jbtmpago.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        Jbtmpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtmpagoActionPerformed(evt);
            }
        });
        rSPanelVector2.add(Jbtmpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 200, -1));

        jLabel15.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Id Paquete");
        rSPanelVector2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, 20));

        jTxcorreo.setBackground(new java.awt.Color(255, 188, 72));
        jTxcorreo.setForeground(new java.awt.Color(51, 51, 51));
        jTxcorreo.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxcorreo.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxcorreo.setPlaceholder("Correo del cliente");
        jTxcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxcorreoActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 270, 32));

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Facturación");
        rSPanelVector2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Correo");
        rSPanelVector2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));

        jTxdireccionsitio.setBackground(new java.awt.Color(255, 188, 72));
        jTxdireccionsitio.setForeground(new java.awt.Color(51, 51, 51));
        jTxdireccionsitio.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxdireccionsitio.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxdireccionsitio.setPlaceholder("Dirección");
        jTxdireccionsitio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxdireccionsitioActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxdireccionsitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 640, 32));

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Total");
        rSPanelVector2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, 20));

        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("M. de pago");
        rSPanelVector2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, 20));

        jTxventasmetodo.setEditable(false);
        jTxventasmetodo.setBackground(new java.awt.Color(255, 188, 72));
        jTxventasmetodo.setForeground(new java.awt.Color(51, 51, 51));
        jTxventasmetodo.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxventasmetodo.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxventasmetodo.setPlaceholder("Metodo de pago");
        jTxventasmetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxventasmetodoActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxventasmetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 270, 32));

        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Precio");
        rSPanelVector2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, -1, 20));

        jTxprecio1.setEditable(false);
        jTxprecio1.setBackground(new java.awt.Color(255, 188, 72));
        jTxprecio1.setForeground(new java.awt.Color(51, 51, 51));
        jTxprecio1.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxprecio1.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxprecio1.setPlaceholder("Precio");
        jTxprecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxprecio1ActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxprecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 270, 32));

        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Teléfono");
        rSPanelVector2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        jTxtelefono.setBackground(new java.awt.Color(255, 188, 72));
        jTxtelefono.setForeground(new java.awt.Color(51, 51, 51));
        jTxtelefono.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxtelefono.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxtelefono.setPlaceholder("Teléfono");
        jTxtelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtelefonoActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxtelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 270, 32));

        jLabel17.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Cedula");
        rSPanelVector2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, 20));

        jTxcedula.setBackground(new java.awt.Color(255, 188, 72));
        jTxcedula.setForeground(new java.awt.Color(51, 51, 51));
        jTxcedula.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxcedula.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxcedula.setPlaceholder("Cedula");
        jTxcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxcedulaActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 270, 32));

        jLabel18.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Presupuesto");
        rSPanelVector2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));

        jTxpresupuesto.setBackground(new java.awt.Color(255, 188, 72));
        jTxpresupuesto.setForeground(new java.awt.Color(51, 51, 51));
        jTxpresupuesto.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxpresupuesto.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxpresupuesto.setPlaceholder("Presupuesto");
        jTxpresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxpresupuestoActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxpresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 270, 32));

        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Ciudad");
        rSPanelVector2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, 20));

        jTxdireccliente.setBackground(new java.awt.Color(255, 188, 72));
        jTxdireccliente.setForeground(new java.awt.Color(51, 51, 51));
        jTxdireccliente.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxdireccliente.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxdireccliente.setPlaceholder("Direccion");
        jTxdireccliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxdirecclienteActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxdireccliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 32));

        jLabel20.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Dirección");
        rSPanelVector2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, 20));

        jTxclienteciudad.setBackground(new java.awt.Color(255, 188, 72));
        jTxclienteciudad.setForeground(new java.awt.Color(51, 51, 51));
        jTxclienteciudad.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        jTxclienteciudad.setBotonColor(new java.awt.Color(51, 51, 51));
        jTxclienteciudad.setPlaceholder("Ciudad");
        jTxclienteciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxclienteciudadActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jTxclienteciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 270, 32));

        jBtced.setBackground(new java.awt.Color(38, 38, 38));
        jBtced.setBackgroundHover(new java.awt.Color(38, 38, 38));
        jBtced.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        jBtced.setInheritsPopupMenu(true);
        jBtced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtcedActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jBtced, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 30, 30));

        jBteditpresupuesto1.setBackground(new java.awt.Color(38, 38, 38));
        jBteditpresupuesto1.setBackgroundHover(new java.awt.Color(38, 38, 38));
        jBteditpresupuesto1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        jBteditpresupuesto1.setInheritsPopupMenu(true);
        jBteditpresupuesto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBteditpresupuesto1ActionPerformed(evt);
            }
        });
        rSPanelVector2.add(jBteditpresupuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 30, 30));

        add(rSPanelVector2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void jTxcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxcorreoActionPerformed

    private void jTxsitioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxsitioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxsitioActionPerformed

    private void jTxtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtotalActionPerformed

    private void jTxregionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxregionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxregionActionPerformed

    private void jTxpaqueteciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxpaqueteciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxpaqueteciudadActionPerformed

    private void jTxidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxidclienteActionPerformed

    private void jTxIDPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxIDPaqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxIDPaqueteActionPerformed

    private void jTxdireccionsitioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxdireccionsitioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxdireccionsitioActionPerformed

    private void jTxventasmetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxventasmetodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxventasmetodoActionPerformed

    private void jTxprecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxprecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxprecio1ActionPerformed

    private void jTxtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtelefonoActionPerformed

    private void jTxcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxcedulaActionPerformed

    private void jTxpresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxpresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxpresupuestoActionPerformed

    private void jTxdirecclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxdirecclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxdirecclienteActionPerformed

    private void jTxclienteciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxclienteciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxclienteciudadActionPerformed

    private void jBtcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtcedActionPerformed
        String ced = this.jTxcedula.getText();
        try{
            Usuario user = manager.getUsuarioDAO().obtenerUser(ced);
            if(user != null){
                this.setUsuario(user);
                loadUsuario();
            }else{    
                System.out.println("entre");
            }
        } catch (DAOException ex) {
            Logger.getLogger(PnVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtcedActionPerformed

    private void jBtiniciarregionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtiniciarregionActionPerformed
       try {
            JDlgRegiones ventana = new JDlgRegiones(null, true, getManager(), Double.parseDouble(this.jTxpresupuesto.getText()));
            ventana.setVisible(true);
            Paquete pq=manager.getPaqueteDAO().obtener(ventana.getCod());
            Region rg=manager.getRegionDAO().obtener(pq.getId_region());
            setPaquete(pq);
            setRegion(rg);
            loadData();
        } catch (DAOException ex) {
            Logger.getLogger(PnVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtiniciarregionActionPerformed

    private void JbtmpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtmpagoActionPerformed
       double precio = paquete.getPresupuesto();
        jDmetodopago ventana = new jDmetodopago(null, true, precio);
        ventana.setVisible(true);
        ventana.pack();
        jTxventasmetodo.setText(ventana.getMtdoPago());
        setInteres(ventana.getInteres());
        jTxtotal.setText(ventana.getTxtTotal());
    }//GEN-LAST:event_JbtmpagoActionPerformed

    private void jBteditpresupuesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBteditpresupuesto1ActionPerformed
       jDialPresupuesto ventana = new jDialPresupuesto(null, true);
        ventana.setVisible(true);
        this.jTxpresupuesto.setText(ventana.getTxtPresupuesto());
    }//GEN-LAST:event_jBteditpresupuesto1ActionPerformed

    private void jBtgenararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtgenararActionPerformed
        // TODO add your handling code here:
        if ((paquete == null && region == null) || jTxventasmetodo.getText().isEmpty() || fecha.getFechaSeleccionada().isEmpty()) {
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
                        factura = new Factura(id, fechaventa, fecha.getFechaSeleccionada(), jTxventasmetodo.getText(), getInteres(), 12, Double.parseDouble(jTxtotal.getText()));
                        manager.getFacturaDAO().insertar(factura);
                        DetalleFactura det = new DetalleFactura(usuario.getCodigo(), empleado.getCod_empleado(), paquete.getId_paquete(), factura.getIdFactura());
                        manager.getDetalleFacturaDAO().insertar(det);
                        guardarDatos();
                    }
                } catch (DAOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBtgenararActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound Jbtmpago;
    private javax.swing.ButtonGroup buttonGroup1;
    private rojerusan.RSDateChooser fecha;
    private rojeru_san.rsbutton.RSButtonRound jBtcancelar;
    private RSMaterialComponent.RSButtonIconUno jBtced;
    private RSMaterialComponent.RSButtonIconUno jBteditpresupuesto1;
    private rojeru_san.rsbutton.RSButtonRound jBtgenarar;
    private rojeru_san.rsbutton.RSButtonRound jBtiniciarregion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private rojeru_san.RSMTextFull jTxIDPaquete;
    private rojeru_san.RSMTextFull jTxcedula;
    private rojeru_san.RSMTextFull jTxclienteciudad;
    private rojeru_san.RSMTextFull jTxcorreo;
    private rojeru_san.RSMTextFull jTxdireccionsitio;
    private rojeru_san.RSMTextFull jTxdireccliente;
    private rojeru_san.RSMTextFull jTxidcliente;
    private rojeru_san.RSMTextFull jTxpaqueteciudad;
    private rojeru_san.RSMTextFull jTxprecio1;
    private rojeru_san.RSMTextFull jTxpresupuesto;
    private rojeru_san.RSMTextFull jTxregion;
    private rojeru_san.RSMTextFull jTxsitio;
    private rojeru_san.RSMTextFull jTxtelefono;
    private rojeru_san.RSMTextFull jTxtotal;
    private rojeru_san.RSMTextFull jTxventasmetodo;
    private javax.swing.JLabel jlbfecha;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rspanel.RSPanelVector rSPanelVector2;
    private rojeru_san.rspanel.RSPanelVector rSPanelVector3;
    // End of variables declaration//GEN-END:variables
}
