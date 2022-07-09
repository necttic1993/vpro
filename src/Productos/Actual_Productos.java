//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Productos;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Clases.GenerarNumero;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_mone_def;
import Productos.items.SubCategorias_List;
import Productos.items.Categorias_List_up;
import Productos.items.CategoriaEspec_List;
import Productos.items.CategoriaEspec_List_up;
import Productos.items.Departamentos_List_up;
import Productos.items.Marca_list_up;
import Productos.items.SubCategorias_List_up;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//</editor-fold>
public class Actual_Productos extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, Consumio3 = 0, longitudBytes;
    String BienFormatado2, BienFormatado3, Preview2 = "", Preview3 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Actual_Productos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        String grado = Principal.lbl_class.getText();
        String nivel = ("8");

        int des = Integer.parseInt(grado);
        int nv = Integer.parseInt(nivel);
        if (des > nv) {
            txt_cant.setEnabled(true);
            txt_pre_compra.setEnabled(true);
        }
        if (Principal.lbl_tipo.getText().equals("SUPERVISOR")) {
            txt_cant.setEnabled(true);
            txt_pre_compra.setEnabled(true);
        }
        txtdes.setDocument(new machusculas());
        txt_espe.setDocument(new machusculas());
        txt_tama.setDocument(new machusculas());
        txt_resol_iva.setDocument(new machusculas());
        BuscarProductoEditarA(Productos.cod_pro_mod);
        txtcod.setEnabled(false);
        cargarCat();
        cargarDepa();
        cargarSubCat();
        cargarCatEspec();
        cargarMarca();
        cargarColor();

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_pro_actu = "";
    public static String cod_pro_cat_up = "";

    void cargarColor() {
        String mostrar = "SELECT * FROM color_productos ORDER BY color_des ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_color.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarDepa() {
        String mostrar = "SELECT * FROM depar_productos WHERE cod_dep='" + txt_id_dep.getText() + "'  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nom_dep.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarCat() {
        String mostrar = "SELECT * FROM cat_productos  WHERE cod_cat='" + txt_id_cate.getText() + "'  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nom_cate.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSubCat() {
        String mostrar = "SELECT * FROM sub_cat_productos  WHERE sub_cat_cod='" + txt_id_subcate.getText() + "'  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_des_subcate.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarCatEspec() {
        String mostrar = "SELECT * FROM cat_espec_productos  WHERE cat_espec_cod='" + txt_id_especate.getText() + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nom_especate.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarMarca() {
        String mostrar = "SELECT * FROM marc_productos  WHERE marc_cod='" + txt_idmarca.getText() + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_des_marca.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void BuscarProductoEditarA(String cod) {

        try {

            String codi = "", cod_barra = "", desc = "", esp = "", cant = "", precio = "", precio_a = "", precio_b = "";
            String atacado = "", volum = "", resol_cb = "", iva = "", peso = "", color_cb = "", tama = "", tipo_pro = "";
            String dep_cb = "", cat_cb = "", sub_cat_cb = "", esp_cat_cb = "", marca_cb = "", cant_min = "", ncm = "", pre_d = "", pro_imagen = "";
            String po = "", kg = "", uni = "", volumen = "", tipo = "", pro_pre_o = "";
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                codi = rs.getString(1);
                cod_barra = rs.getString(2);
                desc = rs.getString(3);
                esp = rs.getString(4);
                cant = rs.getString(5);
                precio = rs.getString(6);
                precio_a = rs.getString(7);
                precio_b = rs.getString(8);
                atacado = rs.getString(9);
                volum = rs.getString(10);
                resol_cb = rs.getString(11);
                iva = rs.getString(12);
                peso = rs.getString(13);
                color_cb = rs.getString(14);
                tama = rs.getString(15);
                // provee = rs.getString(16);
                dep_cb = rs.getString(17);
                cat_cb = rs.getString(18);
                sub_cat_cb = rs.getString(19);
                esp_cat_cb = rs.getString(20);
                marca_cb = rs.getString(21);
                cant_min = rs.getString(22);
                tipo_pro = rs.getString(24);
                ncm = rs.getString(54);

                po = rs.getString(55);
                kg = rs.getString(56);
                uni = rs.getString(57);
                volumen = rs.getString(58);
                tipo = rs.getString(59);
                pre_d = rs.getString(60);
                pro_pre_o = rs.getString(61);
                pro_imagen = rs.getString(62);
            }

            txtcod.setText(codi);
            txt_cod_barra.setText(cod_barra);
            txtdes.setText(desc);
            txt_espe.setText(esp);
            txt_cant.setText(cant);
            txt_pre_compra.setText(precio);
            txt_pre_a.setText(precio_a);
            txt_pre_b.setText(precio_b);
            txt_pre_atacado.setText(atacado);
            txt_vol.addItem(volum);
            cb_status.setSelectedItem(tipo_pro);
            txt_resol_iva.setText(resol_cb);
            txt_iva.setText(iva);
            txt_peso.setText(peso);
            cb_color.setSelectedItem(color_cb);
            txt_tama.setText(tama);
            txt_id_dep.setText(dep_cb);
            txt_id_cate.setText(cat_cb);
            txt_id_subcate.setText(sub_cat_cb);
            txt_id_especate.setText(esp_cat_cb);
            txt_idmarca.setText(marca_cb);
            txt_cant_mini.setText(cant_min);
            txt_ncm.setText(ncm);
            txt_po.setText(po);
            txt_kg.setText(kg);
            txt_udcaja.setText(uni);
            txt_volum.setText(volumen);
            cb_tipo_merca.setSelectedItem(tipo);
            txt_precio_d.setText(pre_d);
            txt_pre_outlet.setText(pro_pre_o);
            txt_url_imagen.setText(pro_imagen);
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_cod_barra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_pre_compra = new javax.swing.JTextField();
        txt_pre_a = new javax.swing.JTextField();
        txt_pre_b = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pre_atacado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tama = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_cant_mini = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_iva = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btn_ima = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_espe = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_resol_iva = new javax.swing.JTextField();
        cb_color = new org.jdesktop.swingx.JXComboBox();
        cb_status = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        txt_vol = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_ncm = new javax.swing.JTextField();
        txt_id_dep = new javax.swing.JTextField();
        txt_nom_dep = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txt_id_cate = new javax.swing.JTextField();
        txt_nom_cate = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_peso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_id_subcate = new javax.swing.JTextField();
        txt_des_subcate = new javax.swing.JTextField();
        txt_nom_especate = new javax.swing.JTextField();
        txt_id_especate = new javax.swing.JTextField();
        txt_idmarca = new javax.swing.JTextField();
        txt_des_marca = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cb_tipo_merca = new javax.swing.JComboBox();
        txt_volum = new javax.swing.JTextField();
        txt_po = new javax.swing.JTextField();
        txt_kg = new javax.swing.JTextField();
        txt_udcaja = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_precio_d = new javax.swing.JTextField();
        txt_pre_outlet = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_url_imagen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Productos");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Código de Barra:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, 30));

        txt_cod_barra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_barra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_barraActionPerformed(evt);
            }
        });
        txt_cod_barra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_barraKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cod_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 270, 28));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        txtdes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdesActionPerformed(evt);
            }
        });
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 580, 28));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Precio Costo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 30));

        txt_pre_compra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_pre_compra.setText("0");
        txt_pre_compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_pre_compra.setEnabled(false);
        txt_pre_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_compraActionPerformed(evt);
            }
        });
        txt_pre_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pre_compraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pre_compraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pre_compraKeyTyped(evt);
            }
        });
        jPanel1.add(txt_pre_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, 28));

        txt_pre_a.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_pre_a.setText("0");
        txt_pre_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_aActionPerformed(evt);
            }
        });
        txt_pre_a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pre_aKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pre_aKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pre_aKeyTyped(evt);
            }
        });
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 110, 28));

        txt_pre_b.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_pre_b.setText("0");
        txt_pre_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_bActionPerformed(evt);
            }
        });
        txt_pre_b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pre_bKeyReleased(evt);
            }
        });
        jPanel1.add(txt_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 160, 28));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        txt_cant.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cant.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cant.setEnabled(false);
        txt_cant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantActionPerformed(evt);
            }
        });
        txt_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cantKeyReleased(evt);
            }
        });
        jPanel1.add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 74, 28));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Categoría:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 70, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Tamaño/Calce:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 90, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Precio A:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 60, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Precio B*:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 70, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Código:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 30));

        txtcod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, 28));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Mínimo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 60, 30));

        txt_pre_atacado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_pre_atacado.setForeground(new java.awt.Color(204, 0, 0));
        txt_pre_atacado.setText("0");
        txt_pre_atacado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_atacadoActionPerformed(evt);
            }
        });
        txt_pre_atacado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pre_atacadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pre_atacadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pre_atacadoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_pre_atacado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 160, 28));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Res. S/N:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 60, 30));

        txt_tama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_tama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tamaActionPerformed(evt);
            }
        });
        txt_tama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tamaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tamaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tamaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_tama, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, 28));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Departamento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Color:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, 30));

        txt_cant_mini.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cant_mini.setText("0");
        txt_cant_mini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cant_miniActionPerformed(evt);
            }
        });
        txt_cant_mini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cant_miniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cant_miniKeyReleased(evt);
            }
        });
        jPanel1.add(txt_cant_mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, 28));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("I.V.A:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 40, 30));

        txt_iva.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_iva.setText("10");
        txt_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ivaActionPerformed(evt);
            }
        });
        txt_iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ivaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ivaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 74, 28));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/modificar.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Actualizar");
        btnguardar.setBorder(null);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 110, 40));

        btn_ima.setBackground(new java.awt.Color(255, 255, 255));
        btn_ima.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_ima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/foto.png"))); // NOI18N
        btn_ima.setText("Imagen");
        btn_ima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ima, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, -1, 40));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Específicación:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        txt_espe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_espe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_espeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_espe, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 580, 28));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("URL Imagen:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, 30));

        txt_resol_iva.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_resol_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_resol_ivaActionPerformed(evt);
            }
        });
        txt_resol_iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_resol_ivaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_resol_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 30, 28));

        cb_color.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 180, 30));

        cb_status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "I", "S", "P", "M" }));
        jPanel1.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 50, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Tipo:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 30));

        txt_vol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_vol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UD", "CM", "G" }));
        jPanel1.add(txt_vol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 90, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Producción en:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("NCM:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 40, 30));

        txt_ncm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_ncm, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 160, 28));

        txt_id_dep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_dep.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_dep.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_dep.setEnabled(false);
        jPanel1.add(txt_id_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 90, 30));

        txt_nom_dep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_dep.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_dep.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_dep.setEnabled(false);
        jPanel1.add(txt_nom_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 430, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 60, 30));

        txt_id_cate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_cate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cate.setEnabled(false);
        jPanel1.add(txt_id_cate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 90, 30));

        txt_nom_cate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cate.setEnabled(false);
        jPanel1.add(txt_nom_cate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 430, 30));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 60, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Costo Medio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 80, 30));

        txt_peso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_peso.setText("0");
        txt_peso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_peso.setEnabled(false);
        txt_peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesoActionPerformed(evt);
            }
        });
        txt_peso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pesoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pesoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 110, 28));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Sub Categoría:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 100, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Categoría Espec:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 100, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Marca:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 100, 30));

        txt_id_subcate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_subcate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_subcate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_subcate.setEnabled(false);
        jPanel1.add(txt_id_subcate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 90, 30));

        txt_des_subcate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_des_subcate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_subcate.setEnabled(false);
        jPanel1.add(txt_des_subcate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 430, 30));

        txt_nom_especate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_especate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_especate.setEnabled(false);
        jPanel1.add(txt_nom_especate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 430, 30));

        txt_id_especate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_especate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_especate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_especate.setEnabled(false);
        jPanel1.add(txt_id_especate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 90, 30));

        txt_idmarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_idmarca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_idmarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_idmarca.setEnabled(false);
        jPanel1.add(txt_idmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 90, 30));

        txt_des_marca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_des_marca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_marca.setEnabled(false);
        jPanel1.add(txt_des_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 430, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 60, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 60, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 60, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exclusivo para productos  import/export", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Formato:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 60, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Peso:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("PO:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 30));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("UD p/ Caja:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 70, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Volumen:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 70, 30));

        cb_tipo_merca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tipo_merca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UD", "CA", "LI" }));
        jPanel2.add(cb_tipo_merca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 30));

        txt_volum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_volum.setText("0");
        jPanel2.add(txt_volum, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 60, 30));

        txt_po.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(txt_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 250, 30));

        txt_kg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_kg.setText("0");
        txt_kg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_kgKeyReleased(evt);
            }
        });
        jPanel2.add(txt_kg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 90, 30));

        txt_udcaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_udcaja.setText("0");
        jPanel2.add(txt_udcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 60, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 680, 90));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Precio D:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 60, 30));

        txt_precio_d.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_precio_d.setText("0");
        txt_precio_d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precio_dKeyReleased(evt);
            }
        });
        jPanel1.add(txt_precio_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 160, 30));

        txt_pre_outlet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_pre_outlet.setText("0");
        txt_pre_outlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pre_outletKeyReleased(evt);
            }
        });
        jPanel1.add(txt_pre_outlet, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 160, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("P.  OUTLET:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 70, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Stock Mínimo:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, 30));

        txt_url_imagen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_url_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 580, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_resol_ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_resol_ivaKeyTyped
        int cant = 1;
        if (txt_resol_iva.getText().length() >= cant) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_resol_ivaKeyTyped

    private void txt_resol_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_resol_ivaActionPerformed

    }//GEN-LAST:event_txt_resol_ivaActionPerformed

    private void txt_espeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_espeActionPerformed
        txt_espe.transferFocus();
    }//GEN-LAST:event_txt_espeActionPerformed

    private void btn_imaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imaActionPerformed
        cod_pro_actu = txtcod.getText();

        Update_ima rm;
        rm = new Update_ima(new javax.swing.JDialog(), true);
        rm.setVisible(true);
    }//GEN-LAST:event_btn_imaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtdes.getText().length() != 0 && txt_id_dep.getText().length() != 0 && txt_id_cate.getText().length() != 0) {
            String sql = "UPDATE tienda_productos SET pro_cod_barra = '" + txt_cod_barra.getText()
                    + "',pro_des ='" + txtdes.getText()
                    + "',pro_des_espec ='" + txt_espe.getText()
                    + "',pro_cant ='" + txt_cant.getText()
                    + "',pro_pre_costo = '" + txt_pre_compra.getText()
                    + "',pro_pre_a = '" + txt_pre_a.getText()
                    + "',pro_pre_b ='" + txt_pre_b.getText()
                    + "',pro_pre_atacado ='" + txt_pre_atacado.getText()
                    + "',pro_vol ='" + txt_vol.getSelectedItem()
                    + "',pro_resol ='" + txt_resol_iva.getText()
                    + "',pro_iva = '" + txt_iva.getText()
                    + "',pro_peso = '" + txt_peso.getText()
                    + "',pro_color ='" + cb_color.getSelectedItem().toString()
                    + "',pro_tama ='" + txt_tama.getText()
                    + "',pro_depa ='" + txt_id_dep.getText()
                    + "',pro_cat = '" + txt_id_cate.getText()
                    + "',pro_sub_cat = '" + txt_id_subcate.getText()//
                    + "',pro_cat_esp = '" + txt_id_especate.getText()
                    + "',pro_marca = '" + txt_idmarca.getText()
                    + "',pro_mini ='" + txt_cant_mini.getText()
                    + "',pro_stock ='" + cb_status.getSelectedItem().toString()
                    + "',cod_ncm ='" + txt_ncm.getText()
                    + "',pro_po ='" + txt_po.getText()
                    + "',pro_kg ='" + txt_kg.getText()
                    + "',pro_unicaja ='" + txt_udcaja.getText()
                    + "',pro_volumen ='" + txt_volum.getText()
                    + "',pro_presenta ='" + cb_tipo_merca.getSelectedItem().toString()
                    + "',pro_pre_d ='" + txt_precio_d.getText()
                    + "',pro_pre_o ='" + txt_pre_outlet.getText()
                    + "',pro_imagen ='" + txt_url_imagen.getText()
                    + "' WHERE pro_cod = '" + txtcod.getText() + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado");
                limpiar();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios o imagen es null");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txt_ivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ivaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ivaKeyReleased

    private void txt_ivaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ivaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ivaKeyPressed

    private void txt_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ivaActionPerformed
        txt_iva.transferFocus();
    }//GEN-LAST:event_txt_ivaActionPerformed

    private void txt_cant_miniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cant_miniKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cant_miniKeyReleased

    private void txt_cant_miniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cant_miniKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cant_miniKeyPressed

    private void txt_cant_miniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cant_miniActionPerformed

    }//GEN-LAST:event_txt_cant_miniActionPerformed

    private void txt_tamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tamaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tamaKeyTyped

    private void txt_tamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tamaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tamaKeyReleased

    private void txt_tamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tamaKeyPressed

    private void txt_tamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tamaActionPerformed
        txt_tama.transferFocus();
    }//GEN-LAST:event_txt_tamaActionPerformed

    private void txt_pre_atacadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_atacadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pre_atacadoKeyTyped

    private void txt_pre_atacadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_atacadoKeyReleased
        ActivatedYourLifeA(txt_pre_atacado, evt);
    }//GEN-LAST:event_txt_pre_atacadoKeyReleased

    private void txt_pre_atacadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_atacadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pre_atacadoKeyPressed

    private void txt_pre_atacadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_atacadoActionPerformed
        txt_pre_atacado.transferFocus();
    }//GEN-LAST:event_txt_pre_atacadoActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void txt_cantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyReleased

    }//GEN-LAST:event_txt_cantKeyReleased

    private void txt_cantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyPressed

    }//GEN-LAST:event_txt_cantKeyPressed

    private void txt_cantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantActionPerformed
        txt_cant.transferFocus();
    }//GEN-LAST:event_txt_cantActionPerformed

    private void txt_pre_bKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_bKeyReleased
        ActivatedYourLife3(txt_pre_b, evt);
    }//GEN-LAST:event_txt_pre_bKeyReleased

    private void txt_pre_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_bActionPerformed
        txt_pre_b.transferFocus();
    }//GEN-LAST:event_txt_pre_bActionPerformed

    private void txt_pre_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_aKeyTyped

    }//GEN-LAST:event_txt_pre_aKeyTyped

    private void txt_pre_aKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_aKeyReleased
        ActivatedYourLife2(txt_pre_a, evt);
    }//GEN-LAST:event_txt_pre_aKeyReleased

    private void txt_pre_aKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_aKeyPressed

    }//GEN-LAST:event_txt_pre_aKeyPressed

    private void txt_pre_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_aActionPerformed
        txt_pre_a.transferFocus();
    }//GEN-LAST:event_txt_pre_aActionPerformed

    private void txt_pre_compraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_compraKeyTyped

    }//GEN-LAST:event_txt_pre_compraKeyTyped

    private void txt_pre_compraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_compraKeyReleased
        ActivatedYourLife(txt_pre_compra, evt);
    }//GEN-LAST:event_txt_pre_compraKeyReleased

    private void txt_pre_compraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_compraKeyPressed

    }//GEN-LAST:event_txt_pre_compraKeyPressed

    private void txt_pre_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_compraActionPerformed
        // TODO add your handling code here:
        txt_pre_compra.transferFocus();
    }//GEN-LAST:event_txt_pre_compraActionPerformed

    private void txtdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdesActionPerformed
        // TODO add your handling code here:
        txtdes.transferFocus();
    }//GEN-LAST:event_txtdesActionPerformed

    private void txt_cod_barraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_barraKeyTyped
        int cant = 13;
        if (txt_cod_barra.getText().length() >= cant) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_barraKeyTyped

    private void txt_cod_barraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_barraActionPerformed
        // TODO add your handling code here:
        txt_cod_barra.transferFocus();
    }//GEN-LAST:event_txt_cod_barraActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        Departamentos_List_up dl;
        dl = new Departamentos_List_up(new javax.swing.JDialog(), true);
        dl.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        Categorias_List_up cl;
        cl = new Categorias_List_up(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_pesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesoActionPerformed

    private void txt_pesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesoKeyPressed

    private void txt_pesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesoKeyReleased

    private void txt_pesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesoKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SubCategorias_List_up sc;
        sc = new SubCategorias_List_up(new javax.swing.JDialog(), true);
        sc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CategoriaEspec_List_up ce;
        ce = new CategoriaEspec_List_up(new javax.swing.JDialog(), true);
        ce.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Marca_list_up ml;
        ml = new Marca_list_up(new javax.swing.JDialog(), true);
        ml.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_precio_dKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precio_dKeyReleased
        ActivatedYourLifeD(txt_precio_d, evt);
    }//GEN-LAST:event_txt_precio_dKeyReleased

    private void txt_kgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kgKeyReleased
        ActivatedYourLifePeso(txt_kg, evt);
    }//GEN-LAST:event_txt_kgKeyReleased

    private void txt_pre_outletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pre_outletKeyReleased
        ActivatedYourLifeO(txt_pre_outlet, evt);
    }//GEN-LAST:event_txt_pre_outletKeyReleased
    //<editor-fold defaultstate="collapsed" desc="METODOS PRINCIPAL">

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
            java.util.logging.Logger.getLogger(Actual_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actual_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actual_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actual_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Actual_Productos dialog = new Actual_Productos(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }// FIN METODO PRINCIPAL
    //</editor-fold>   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ima;
    private javax.swing.JButton btnguardar;
    private org.jdesktop.swingx.JXComboBox cb_color;
    private javax.swing.JComboBox cb_status;
    private javax.swing.JComboBox cb_tipo_merca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_cant_mini;
    private javax.swing.JTextField txt_cod_barra;
    public static javax.swing.JTextField txt_des_marca;
    public static javax.swing.JTextField txt_des_subcate;
    private javax.swing.JTextField txt_espe;
    public static javax.swing.JTextField txt_id_cate;
    public static javax.swing.JTextField txt_id_dep;
    public static javax.swing.JTextField txt_id_especate;
    public static javax.swing.JTextField txt_id_subcate;
    public static javax.swing.JTextField txt_idmarca;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_kg;
    private javax.swing.JTextField txt_ncm;
    public static javax.swing.JTextField txt_nom_cate;
    public static javax.swing.JTextField txt_nom_dep;
    public static javax.swing.JTextField txt_nom_especate;
    private javax.swing.JTextField txt_peso;
    private javax.swing.JTextField txt_po;
    private javax.swing.JTextField txt_pre_a;
    private javax.swing.JTextField txt_pre_atacado;
    private javax.swing.JTextField txt_pre_b;
    private javax.swing.JTextField txt_pre_compra;
    private javax.swing.JTextField txt_pre_outlet;
    private javax.swing.JTextField txt_precio_d;
    private javax.swing.JTextField txt_resol_iva;
    private javax.swing.JTextField txt_tama;
    private javax.swing.JTextField txt_udcaja;
    private javax.swing.JTextField txt_url_imagen;
    private javax.swing.JComboBox txt_vol;
    private javax.swing.JTextField txt_volum;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdes;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    public String Mascara(String ValorGuarani) {

        DecimalFormat format = new DecimalFormat("###,###,###");

        long NumeroIntacto = OL;
        String NroFormatado = "";
        String ValorViejo = ValorGuarani;

        String a = ValorViejo.replace(",", "");

        NumeroIntacto = Long.parseLong(a);
        NroFormatado = format.format(NumeroIntacto);
        String formato = NroFormatado;
        return formato;

    }

    void limpiar() {
        txt_cod_barra.setText("");
        txtdes.setText("");
        txt_espe.setText("");
        txt_pre_compra.setText("");
        txt_cant.setText("");
        txt_pre_a.setText("");
        txt_pre_b.setText("");
        txt_pre_atacado.setText("");
        //  txt_vol.setText("");
        txt_iva.setText("");
        txt_peso.setText("");
        txt_tama.setText("");
        txt_cant_mini.setText("");

    }

    void codigos() {

        String c = "";
        String SQL = "select max(pro_cod) from tienda_productos";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtcod.setText("00000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                txtcod.setText(gen.serie());
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Actual_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* public void calcular() {

     String imp = "0", lucro = "0", porcento = "0", multipor100;
     //precio compra
     BigDecimal precio_compra = ingreso.TransformReales(txtpre.getText().toString().replaceAll("\\s", ""));
     //precio compra 2
     BigDecimal precio_compra2 = ingreso.TransformReales(txtpre.getText().toString().replaceAll("\\s", ""));
     //precio venta
     BigDecimal precio_venta = ingreso.TransformReales(txtpre_venta.getText().toString().replaceAll("\\s", ""));
     //porcentaje
     //  BigDecimal lucroPor = ingreso.TransformReales(txt_por.getText().toString().replaceAll("\\s", ""));
     //atrapa el valor 100
     BigDecimal cien = ingreso.TransformReales(txt_cien.getText().toString().replaceAll("\\s", ""));
     //multiplica el valor de la division con 100
     multipor100 = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(precio_compra.multiply(lucroPor).toString());
     //valor de la multiplicacion  con la division con 100
     txt_final_calc.setText(multipor100);
     //atrapa el valor de la division con 100
     BigDecimal calpor = ingreso.TransformReales(txt_final_calc.getText().toString().replaceAll("\\s", ""));
     //precio compra divide por porcentaje
     porcento = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(calpor.divide(cien).toString());
     //valor de porcentaje insertada en text_cal
     txt_cal.setText(porcento);
     //valor captado de txt_cal seria la division de precio compra con porcentaje
     BigDecimal multipor = ingreso.TransformReales(txt_cal.getText().toString().replaceAll("\\s", ""));

     //suma el porciento con el precio ce compra para totalizar precio de venta
     lucro = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(precio_compra2.add(multipor).toString());
     //valor de precio de venta
     txtpre_venta.setText(lucro);
     //calcula la diferencia de precio de compra con venta
     imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(precio_venta.subtract(precio_compra).toString());
     //valor del lucro
     txt_lucro.setText(imp);

     }*/
    //</editor-fold>
    public String ActivatedYourLife(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_pre_compra.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_pre_compra.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre_compra.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String ActivatedYourLife2(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_pre_a.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_pre_a.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre_a.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String ActivatedYourLife3(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_pre_b.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_pre_b.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre_b.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String ActivatedYourLifeA(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_pre_atacado.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_pre_atacado.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre_atacado.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String ActivatedYourLifeD(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_precio_d.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_precio_d.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_precio_d.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String MaskaraEnteros(String ValorGuaranies) {
        //<editor-fold defaultstate="collapsed" desc="IF">        
        ValorGuaranies = ValorGuaranies.replaceAll("\\s", "").replaceAll("\\D", "");
        if (ValorGuaranies.contains(".")) {
            BigDecimal Rounder = new BigDecimal(ValorGuaranies);
            Rounder = Rounder.setScale(0, BigDecimal.ROUND_HALF_UP);
            ValorGuaranies = Rounder.toString();
            if (ValorGuaranies.contains(".")) {
                ValorGuaranies = ValorGuaranies.substring(0, ValorGuaranies.indexOf("."));
            }
        }// FIN IF
        //</editor-fold>        
        DecimalFormat Formato = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String Puro = ValorViejo.replace(",", "");
        NumeroIntacto = Long.parseLong(Puro);
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;
    }// FIN METODO

    public String ActivatedYourLifePeso(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = ("EXTRANJERO");
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_kg.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_kg.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_kg.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String ActivatedYourLifeO(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_pre_outlet.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_pre_outlet.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre_outlet.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

}//FIN CLASE
