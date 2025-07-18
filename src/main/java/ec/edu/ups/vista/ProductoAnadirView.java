package ec.edu.ups.vista;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoAnadirView extends JInternalFrame {

    private JPanel panelPrincipal;
    private JTextField txtPrecio;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JButton btnAceptar;
    private JButton btnLimpiar;
    private JLabel lblPrecio;
    private JLabel lblNombre;
    private JLabel lblCodigo;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public ProductoAnadirView(MensajeInternacionalizacionHandler mensajeHandler) {

        this.mensajeHandler = mensajeHandler;
        initComponents();
//        setContentPane(panelPrincipal);
        setTitle("Datos del Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        actualizarTextos();


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMensaje("Producto añadido: " +
                        txtCodigo.getText() + " - " +
                        txtNombre.getText() + " - " +
                        txtPrecio.getText());
                limpiarCampos();
            }
        });
    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("producto.anadir.titulo"));
        lblCodigo.setText(mensajeHandler.get("producto.lbl.codigo"));
        lblNombre.setText(mensajeHandler.get("producto.lbl.nombre"));
        lblPrecio.setText(mensajeHandler.get("producto.lbl.precio"));
        btnAceptar.setText(mensajeHandler.get("producto.btn.aceptar"));
        btnLimpiar.setText(mensajeHandler.get("producto.btn.limpiar"));
    }

    private void initComponents() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(40, 40, 100, 30);
        panelPrincipal.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 40, 200, 30);
        panelPrincipal.add(txtCodigo);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 90, 100, 30);
        panelPrincipal.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 90, 200, 30);
        panelPrincipal.add(txtNombre);

        lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(40, 140, 100, 30);
        panelPrincipal.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 140, 200, 30);
        panelPrincipal.add(txtPrecio);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 210, 120, 40);
        panelPrincipal.add(btnAceptar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(220, 210, 120, 40);
        panelPrincipal.add(btnLimpiar);

        setContentPane(panelPrincipal);
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }

    public void mostrarProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println(producto);
        }

    }
}
