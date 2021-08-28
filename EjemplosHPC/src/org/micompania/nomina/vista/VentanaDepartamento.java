package org.micompania.nomina.vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.micompania.nomina.controlador.NominaControlador;
import org.micompania.nomina.modelo.Departamento;
import org.micompania.nomina.util.NominaException;
import org.micompania.nomina.util.UtilidadesVista;
import org.micompania.nomina.vista.modelos.ModeloTablaDepto;

/**
 *
 * @author GTX1050
 */
public class VentanaDepartamento extends javax.swing.JFrame {

    private NominaControlador nomina;
    private Departamento deptoSeleccionado;
    private String codigoAnterior;
    private boolean estaEnModoEdicion;

    public VentanaDepartamento() {
        initComponents();
        this.cargarDatosTabla();
        estaEnModoEdicion = false;
        ponerModoEdicion();
    }

    public VentanaDepartamento(NominaControlador nomina) {
        this.nomina = nomina;
        initComponents();
        this.cargarDatosTabla();
        estaEnModoEdicion = false;
        ponerModoEdicion();
    }

    public NominaControlador getNomina() {
        return nomina;
    }

    private void cargarDatosTabla() {
        ModeloTablaDepto model;
        try {
            model = new ModeloTablaDepto(nomina.obtenerTodosLosDepartamentos());
            tblDepartamento.setModel(model);
            tblDepartamento.revalidate();
        } catch (NominaException ex) {
            UtilidadesVista.mostrarMensajeError(this, ex.getMessage());
        }

    }

    private void limpiarComponentes() {
        UtilidadesVista.limpiarComponenteTexto(txtCodigo, txtNombre);
    }

    private void ponerModoEdicion() {
        btnAgregar.setVisible(!estaEnModoEdicion);
        btnCancelarEdicion.setVisible(estaEnModoEdicion);
        btnEliminar.setVisible(estaEnModoEdicion);
        btnModificar.setVisible(estaEnModoEdicion);
        if (estaEnModoEdicion) {
            if (deptoSeleccionado != null) {
                txtCodigo.setText(deptoSeleccionado.getCodigo());
                txtNombre.setText(deptoSeleccionado.getNombre());
            }
        } else {
            this.limpiarComponentes();
        }
    }

    private void agregar() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        Departamento depto = new Departamento();
        depto.setCodigo(codigo);
        depto.setNombre(nombre);
        try {
            this.nomina.agregarDepartamento(depto);
            UtilidadesVista.limpiarComponenteTexto(txtCodigo, txtNombre);
            this.cargarDatosTabla();
            UtilidadesVista.mostrarMensajeInfo(this, "Se agregó el departamento correctamente");
        } catch (NominaException ex) {
            UtilidadesVista.mostrarMensajeError(this, ex.getMessage());
        }

    }

    private void modificar() {
        int respuestaMensaje = JOptionPane.showConfirmDialog(this, "Desea modificar los datos?",
                "Modificar Departamento", JOptionPane.YES_NO_OPTION);
        if (respuestaMensaje == JOptionPane.YES_OPTION) {
            deptoSeleccionado.setCodigo(txtCodigo.getText());
            deptoSeleccionado.setNombre(txtNombre.getText());
            try {
                this.nomina.actualizarDepartamento(deptoSeleccionado, this.codigoAnterior);
                estaEnModoEdicion = false;
                this.ponerModoEdicion();
                this.limpiarComponentes();
                this.cargarDatosTabla();
                UtilidadesVista.mostrarMensajeInfo(this, "Se modificó la información correctamente");
            } catch (NominaException ex) {
                UtilidadesVista.mostrarMensajeError(this, ex.getMessage());
            }
        } else if (respuestaMensaje == JOptionPane.NO_OPTION) {
            estaEnModoEdicion = false;
            this.ponerModoEdicion();
            this.limpiarComponentes();
            this.cargarDatosTabla();
        }
    }

    private void eliminar() {
        int respuestaMensaje = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el departamento seleccionado?",
                "Eliminar Departamento", JOptionPane.YES_NO_OPTION);
        if (respuestaMensaje == JOptionPane.YES_OPTION) {
            try {
                this.nomina.eliminarDepartamento(deptoSeleccionado);
                estaEnModoEdicion = false;
            this.ponerModoEdicion();
            this.limpiarComponentes();
            this.cargarDatosTabla();
            } catch (NominaException ex) {
                UtilidadesVista.mostrarMensajeError(this, ex.getMessage());
            }
            
        } else if (respuestaMensaje == JOptionPane.NO_OPTION) {
            estaEnModoEdicion = false;
            this.ponerModoEdicion();
            this.limpiarComponentes();
            this.cargarDatosTabla();
        }
    }

    public void setNomina(NominaControlador nomina) {
        this.nomina = nomina;
    }

    public Departamento getDeptoSeleccionado() {
        return deptoSeleccionado;
    }

    public void setDeptoSeleccionado(Departamento deptoSeleccionado) {
        this.deptoSeleccionado = deptoSeleccionado;
    }

    public boolean isEstaEnModoEdicion() {
        return estaEnModoEdicion;
    }

    public void setEstaEnModoEdicion(boolean estaEnModoEdicion) {
        this.estaEnModoEdicion = estaEnModoEdicion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btoSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamento = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelarEdicion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Departamentos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DEPARTAMENTO");

        lblCodigo.setText("Código");

        lblNombre.setText("Nombre");

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btoSalir.setText("Salir");
        btoSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btoSalirMouseClicked(evt);
            }
        });

        tblDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartamento);

        jLabel2.setText("Departamentos existentes (Doble click para seleccionar)");

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

        btnCancelarEdicion.setText("Cancelar Edicion");
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
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btoSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarEdicion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblNombre))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelarEdicion))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btoSalir)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btoSalirMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btoSalirMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        this.agregar();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void tblDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentoMouseClicked
        if (evt.getClickCount() > 1) {
            try {
                JTable tabla1 = (JTable) evt.getSource();
                this.codigoAnterior = (String) tabla1.getModel().getValueAt(tabla1.getSelectedRow(), 0);
                deptoSeleccionado = this.nomina.obtenerDepartmentoPorCodigo(this.codigoAnterior);
                estaEnModoEdicion = true;
                ponerModoEdicion();
            } catch (NominaException ex) {
                UtilidadesVista.mostrarMensajeError(this, "No se pudo seleccionado el departamento: "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblDepartamentoMouseClicked

    private void btnCancelarEdicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarEdicionMouseClicked
        estaEnModoEdicion = false;
        this.ponerModoEdicion();
    }//GEN-LAST:event_btnCancelarEdicionMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        this.modificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        this.eliminar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.limpiarComponentes();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelarEdicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btoSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDepartamento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the codigoAnterior
     */
    public String getCodigoAnterior() {
        return codigoAnterior;
    }

    /**
     * @param codigoAnterior the codigoAnterior to set
     */
    public void setCodigoAnterior(String codigoAnterior) {
        this.codigoAnterior = codigoAnterior;
    }

}
