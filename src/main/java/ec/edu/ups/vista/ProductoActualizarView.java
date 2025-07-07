package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class ProductoActualizarView {
    private JTextField txtIngreseProducto;
    private JButton btnActualizar;
    private JTable table1;
    private JButton eliminarButton;
    private JButton btnBuscar;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public ProductoActualizarView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
    }

    public JTextField getTxtIngreseProducto() {
        return txtIngreseProducto;
    }

    public void setTxtIngreseProducto(JTextField txtIngreseProducto) {
        this.txtIngreseProducto = txtIngreseProducto;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }


}
