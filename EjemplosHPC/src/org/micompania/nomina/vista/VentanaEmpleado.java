package org.micompania.nomina.vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import org.micompania.nomina.controlador.NominaControlador;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.modelo.Empleado;
import org.micompania.nomina.modelo.Salario;
import org.micompania.nomina.util.NominaException;
import org.micompania.nomina.util.Utilidades;

/**
 *
 * @author GTX1050
 */
public class VentanaEmpleado extends javax.swing.JFrame {

    private Empleado empleadoSeleccionado;
    private boolean estaEnModoEdicion;

    public VentanaMostrarEmpleado getvMostrarEmpleados() {
        return vMostrarEmpleados;
    }

    public void setvMostrarEmpleados(VentanaMostrarEmpleado vMostrarEmpleados) {
        this.vMostrarEmpleados = vMostrarEmpleados;
    }

    private NominaControlador nominaActual;

    private VentanaMostrarEmpleado vMostrarEmpleados;

    public VentanaEmpleado() {
        initComponents();
        estaEnModoEdicion = false;
        ponerModoEdicion();
    }

    public VentanaEmpleado(NominaControlador nominaActual) {
        this.nominaActual = nominaActual;
        initComponents();
        estaEnModoEdicion = false;
        ponerModoEdicion();

    }

    public void llenarSalarios() {
        try {
            DefaultComboBoxModel modeloListaSalario = new DefaultComboBoxModel();
            for (Salario salario : this.nominaActual.obtenerTodosLosSalarios()) {
                modeloListaSalario.addElement(salario);
            }
            cboSalario.setModel(modeloListaSalario);
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this, "No se pudo cargar la "
                    + "lista de salarios");
        }
    }

    public void llenarListaDepartamentos() {
        try {
            DefaultComboBoxModel modeloLista = new DefaultComboBoxModel();
            for (Departamento depto : this.nominaActual.obtenerTodosLosDepartamentos()) {
                modeloLista.addElement(depto);
            }
            cboDepartamento.setModel(modeloLista);
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this, ex.getMessage());
        }
    }

    private void agregar() {
        Empleado emp = this.obtenerEmpleadoDeVista();
        try {
            nominaActual.agregarEmpleado(emp);
            Utilidades.mostrarMensajeInfo(this, "Se agregó empleado a la nómina");
            limpiarComponentes();
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this, ex.getMessage());
        }
    }

    private void modificar() {
        Empleado emp = this.obtenerEmpleadoDeVista();
        try {
            nominaActual.actualizarEmpleado(emp, this.vMostrarEmpleados.getCodigoAnterior());
            Utilidades.mostrarMensajeInfo(this, "Se actualizó empleado a la nómina");
            limpiarComponentes();
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this, ex.getMessage());
        }
    }

    private void eliminar() {
        Empleado emp = this.obtenerEmpleadoDeVista();
        try {
            this.nominaActual.eliminarPersona(emp);
            Utilidades.mostrarMensajeInfo(this, "Se eliminó empleado a la nómina");
            limpiarComponentes();
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this, ex.getMessage());
        }
    }

    private void limpiarComponentes() {
        if (cboDepartamento.getModel().getSize() > 0) {
            cboDepartamento.setSelectedIndex(0);
        }
        btoGrpTipoDocumento.clearSelection();
        Utilidades.limpiarComponenteTexto(txtApellido, txtCodigo,
                txtFechaNacimiento, txtNombre, txtNumeroDocumento,
                txtPassword, txtUsuario);
        btoGrpSexo.clearSelection();
        if (cboSalario.getModel().getSize() > 0) {
            cboSalario.setSelectedIndex(0);
        }
    }

    public void cargarEmpleado() {
        try {
            Empleado emp = this.nominaActual.obtenerEmpleadoPorCodigo(this.vMostrarEmpleados.getCodigoAnterior());
            cboDepartamento.setSelectedItem(emp.getDepartamento());
            switch (emp.getTipoDocumento()) {
                case 1:
                    optCC.setSelected(true);
                    break;
                case 2:
                    optCE.setSelected(true);
                    break;
                case 3:
                    optPas.setSelected(true);
                    break;
                default:
                    break;
            }
            txtNumeroDocumento.setText(emp.getDocumentoIdentidad());
            txtNombre.setText(emp.getNombres());
            txtApellido.setText(emp.getApellidos());
            txtFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy").format(emp.getFechaNacimiento()));
            if (emp.getSexo() == 'F') {
                optSexoF.setSelected(false);
            } else {
                optSexoM.setSelected(true);
            }
            txtCodigo.setText(String.valueOf(emp.getCodigo()));
            txtUsuario.setText(emp.getUsuario());
            txtPassword.setText(emp.getPassword());
            cboSalario.setSelectedItem(emp.getSalario());
            //Modo edicion
            this.ponerModoEdicion();
            txtApellido.revalidate();
        } catch (NominaException ex) {
            Utilidades.mostrarMensajeError(this,
                    "No se pudo mostrar el empleado seleccionado: "
                    + ex.getMessage());
        }
    }

    private void ponerModoEdicion() {
        btnAgregar.setVisible(!estaEnModoEdicion);
        btnCancelarEdicion.setVisible(estaEnModoEdicion);
        btnEliminar.setVisible(estaEnModoEdicion);
        btnModificar.setVisible(estaEnModoEdicion);
    }

    private Empleado obtenerEmpleadoDeVista() {
        int tipoDocumento = 0;
        if (optCC.isSelected()) {
            tipoDocumento = 1;
        } else if (optCE.isSelected()) {
            tipoDocumento = 2;
        } else if (optPas.isSelected()) {
            tipoDocumento = 3;
        }
        String documentoIdentidad = txtNumeroDocumento.getText();
        String nombres = txtNombre.getText();
        String apellidos = txtApellido.getText();

        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(txtFechaNacimiento.getText());
        } catch (Exception e) {
            Utilidades.mostrarMensajeError(this,
                    "No se pudo realizar el parseo de la fecha de nacimiento");
        }
        char sexo = 'F';
        if (optSexoF.isSelected()) {
            sexo = 'F';
        } else if (optSexoM.isSelected()) {
            sexo = 'M';
        }
        Departamento depto = (Departamento) cboDepartamento.getModel().getSelectedItem();

        Long codigoEmpleado = Long.valueOf(txtCodigo.getText());
        String usuario = txtUsuario.getText();
        String password = String.valueOf(txtPassword.getPassword());
        Salario salario = (Salario) cboSalario.getModel().getSelectedItem();
        Empleado empleado = new Empleado(codigoEmpleado, usuario, password,
                salario, codigoEmpleado, tipoDocumento, documentoIdentidad,
                nombres, apellidos, fechaNacimiento, sexo, depto);
        return empleado;
    }

    public NominaControlador getNominaActual() {
        return nominaActual;
    }

    public void setNominaActual(NominaControlador nominaActual) {
        this.nominaActual = nominaActual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btoGrpSexo = new javax.swing.ButtonGroup();
        btoGrpTipoDocumento = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        cboDepartamento = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblTipoDocumento = new javax.swing.JLabel();
        lblNroDocumento = new javax.swing.JLabel();
        txtNumeroDocumento = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblFecNacimiento = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        lblSexo = new javax.swing.JLabel();
        optSexoF = new javax.swing.JRadioButton();
        optSexoM = new javax.swing.JRadioButton();
        optCC = new javax.swing.JRadioButton();
        optCE = new javax.swing.JRadioButton();
        optPas = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblSalario = new javax.swing.JLabel();
        cboSalario = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelarEdicion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EMPLEADOS");

        lblDepartamento.setText("Departamento");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Persona"));

        lblTipoDocumento.setText("Tipo de documento");

        lblNroDocumento.setText("Número documento");

        lblNombre.setText("Nombres");

        lblApellido.setText("Apellidos");

        lblFecNacimiento.setText("Fecha Nacimiento");

        txtFechaNacimiento.setText("dd/MM/yyyy");

        lblSexo.setText("Sexo");

        btoGrpSexo.add(optSexoF);
        optSexoF.setText("Femenino");

        btoGrpSexo.add(optSexoM);
        optSexoM.setText("Masculino");

        btoGrpTipoDocumento.add(optCC);
        optCC.setText("CC");

        btoGrpTipoDocumento.add(optCE);
        optCE.setText("CE");

        btoGrpTipoDocumento.add(optPas);
        optPas.setText("PAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoDocumento)
                    .addComponent(lblNroDocumento)
                    .addComponent(lblNombre)
                    .addComponent(lblFecNacimiento)
                    .addComponent(lblSexo)
                    .addComponent(lblApellido))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(optSexoF)
                        .addGap(18, 18, 18)
                        .addComponent(optSexoM))
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(optCC)
                        .addGap(10, 10, 10)
                        .addComponent(optCE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optPas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDocumento)
                    .addComponent(optCC)
                    .addComponent(optCE)
                    .addComponent(optPas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNroDocumento)
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecNacimiento)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(optSexoF)
                    .addComponent(optSexoM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        lblCodigo.setText("Código");

        lblUsuario.setText("Usuario");

        lblPassword.setText("Password");

        lblSalario.setText("Salario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblCodigo)
                    .addComponent(lblPassword)
                    .addComponent(lblSalario))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtUsuario)
                    .addComponent(txtPassword)
                    .addComponent(cboSalario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(cboSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregar.setText("Guardar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        jButton1.setText("Listar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnCancelarEdicion.setText("Cancelar Edición");
        btnCancelarEdicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarEdicionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(lblDepartamento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                    .addComponent(cboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42))
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(cboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnSalir)
                    .addComponent(jButton1)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelarEdicion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        this.agregar();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        vMostrarEmpleados = new VentanaMostrarEmpleado(nominaActual);
        vMostrarEmpleados.setVentanaPadre(this);
        vMostrarEmpleados.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnCancelarEdicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarEdicionMouseClicked
        this.estaEnModoEdicion = false;
        this.ponerModoEdicion();
    }//GEN-LAST:event_btnCancelarEdicionMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        this.modificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        this.eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelarEdicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup btoGrpSexo;
    private javax.swing.ButtonGroup btoGrpTipoDocumento;
    private javax.swing.JComboBox<String> cboDepartamento;
    private javax.swing.JComboBox<String> cboSalario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblFecNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNroDocumento;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipoDocumento;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JRadioButton optCC;
    private javax.swing.JRadioButton optCE;
    private javax.swing.JRadioButton optPas;
    private javax.swing.JRadioButton optSexoF;
    private javax.swing.JRadioButton optSexoM;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the empleadoSeleccionado
     */
    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    /**
     * @param empleadoSeleccionado the empleadoSeleccionado to set
     */
    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    /**
     * @return the estaEnModoEdicion
     */
    public boolean isEstaEnModoEdicion() {
        return estaEnModoEdicion;
    }

    /**
     * @param estaEnModoEdicion the estaEnModoEdicion to set
     */
    public void setEstaEnModoEdicion(boolean estaEnModoEdicion) {
        this.estaEnModoEdicion = estaEnModoEdicion;
    }
}
