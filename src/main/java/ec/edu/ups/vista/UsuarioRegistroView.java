package ec.edu.ups.vista;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class UsuarioRegistroView extends JFrame {
    private JPanel panelPrincipal;
    private JTextField txtNombreCompleto;
    private JTextField txtFechaNacimiento;
    private JTextField txtCorreoElectronico;
    private JTextField txtTelefono;
    private JButton btnRegistrarse;
    private JLabel lblNombreCompleto;
    private JLabel lblFechaNacimiento;
    private JLabel lblCorreoElectronico;
    private JLabel lblRespuesta1;
    private JLabel lblRespuesta2;
    private JLabel lblRespuesta3;
    private JLabel lblSistemaRegistro;
    private JTextField txtIngreseUsuario;
    private JTextField txtIngreseContrasenia;
    private JLabel lblusuario;
    private JLabel lblContrasenia;
    private JLabel lblTelefono;
    private JComboBox<Rol> cbxRol;
    private JTextField txtRespuestaSeguridad1;
    private JTextField txtRespuestSeguridad2;
    private JLabel lblPregunta2;
    private JLabel lblPregunta1;
    private JTextField txtRespuestaSeguridad3;
    private JLabel lblPregunta3;
    private JLabel lblRol;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public UsuarioRegistroView(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
        initComponents();
        actualizarTextos();
        cbxRol.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Rol) {
                    renderer.setText(mensajeHandler.get(((Rol) value).getKey()));
                }
                return renderer;
            }
        });

    }
    private void initComponents() {
        setSize(500, 500);
        setTitle("Registro de Usuario");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        lblPregunta1.setText("¿Cuál es el primer nombre de su padre?");
        lblPregunta2.setText("¿Cuál es su comida favorita?");
        lblPregunta3.setText("¿Cuál es su película o serie favorita?");

       cbxRol.removeAllItems();
        for (Rol rol : Rol.values()) {
            cbxRol.addItem(rol);
       }

    }
    public enum Rol {
        ADMIN("rol.admin"),
        USER("rol.user");
        private final String key;
        Rol(String key) { this.key = key; }
        public String getKey() { return key; }
    }

    public void actualizarTextos() {
        setTitle(mensajeHandler.get("registro.titulo"));
        lblNombreCompleto.setText(mensajeHandler.get("registro.nombreCompleto"));
        lblFechaNacimiento.setText(mensajeHandler.get("registro.fechaNacimiento"));
        lblCorreoElectronico.setText(mensajeHandler.get("registro.correoElectronico"));
        lblTelefono.setText(mensajeHandler.get("registro.telefono"));
        lblusuario.setText(mensajeHandler.get("registro.usuario"));
        lblContrasenia.setText(mensajeHandler.get("registro.contrasenia"));
        lblRol.setText(mensajeHandler.get("registro.rol"));
        btnRegistrarse.setText(mensajeHandler.get("registro.boton.registrarse"));
        lblSistemaRegistro.setText(mensajeHandler.get("registro.sistemaRegistro"));
        lblPregunta1.setText(mensajeHandler.get("registro.pregunta1"));
        lblPregunta2.setText(mensajeHandler.get("registro.pregunta2"));
        lblPregunta3.setText(mensajeHandler.get("registro.pregunta3"));
        lblRespuesta1.setText(mensajeHandler.get("registro.respuesta1"));
        lblRespuesta2.setText(mensajeHandler.get("registro.respuesta2"));
        lblRespuesta3.setText(mensajeHandler.get("registro.respuesta3"));
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }


    public JTextField getTxtNombreCompleto() {
        return txtNombreCompleto;
    }

    public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
        this.txtNombreCompleto = txtNombreCompleto;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public JTextField getTxtCorreoElectronico() {
        return txtCorreoElectronico;
    }

    public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
        this.txtCorreoElectronico = txtCorreoElectronico;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;

    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JLabel getLblFechaNacimiento() {
        return lblFechaNacimiento;
    }

    public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
        this.lblFechaNacimiento = lblFechaNacimiento;
    }

    public JLabel getLblNombreCompleto() {
        return lblNombreCompleto;
    }

    public void setLblNombreCompleto(JLabel lblNombreCompleto) {
        this.lblNombreCompleto = lblNombreCompleto;
    }

    public JLabel getLblCorreoElectronico() {
        return lblCorreoElectronico;
    }

    public void setLblCorreoElectronico(JLabel lblCorreoElectronico) {
        this.lblCorreoElectronico = lblCorreoElectronico;
    }

    public JLabel getLblRespuesta1() {
        return lblRespuesta1;
    }

    public void setLblRespuesta1(JLabel lblRespuesta1) {
        this.lblRespuesta1 = lblRespuesta1;
    }

    public JLabel getLblRespuesta2() {
        return lblRespuesta2;
    }

    public void setLblRespuesta2(JLabel lblRespuesta2) {
        this.lblRespuesta2 = lblRespuesta2;
    }

    public JLabel getLblRespuesta3() {
        return lblRespuesta3;
    }

    public void setLblRespuesta3(JLabel lblRespuesta3) {
        this.lblRespuesta3 = lblRespuesta3;
    }

    public JLabel getLblSistemaRegistro() {
        return lblSistemaRegistro;
    }

    public void setLblSistemaRegistro(JLabel lblSistemaRegistro) {
        this.lblSistemaRegistro = lblSistemaRegistro;
    }

    public JTextField getTxtIngreseUsuario() {
        return txtIngreseUsuario;
    }

    public void setTxtIngreseUsuario(JTextField txtIngreseUsuario) {
        this.txtIngreseUsuario = txtIngreseUsuario;
    }

    public JTextField getTxtIngreseContrasenia() {
        return txtIngreseContrasenia;
    }

    public void setTxtIngreseContrasenia(JTextField txtIngreseContrasenia) {
        this.txtIngreseContrasenia = txtIngreseContrasenia;
    }

    public JLabel getLblusuario() {
        return lblusuario;
    }

    public void setLblusuario(JLabel lblusuario) {
        this.lblusuario = lblusuario;
    }

    public JLabel getLblContrasenia() {
        return lblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        this.lblContrasenia = lblContrasenia;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }

    public JComboBox getCbxRol() {
        return cbxRol;
    }

    public void setCbxRol(JComboBox cbxRol) {
        this.cbxRol = cbxRol;
    }

    public JTextField getTxtRespuestaSeguridad1() {
        return txtRespuestaSeguridad1;
    }

    public void setTxtRespuestaSeguridad1(JTextField txtRespuestaSeguridad1) {
        this.txtRespuestaSeguridad1 = txtRespuestaSeguridad1;
    }

    public JTextField getTxtRespuestSeguridad2() {
        return txtRespuestSeguridad2;
    }

    public void setTxtRespuestSeguridad2(JTextField txtRespuestSeguridad2) {
        this.txtRespuestSeguridad2 = txtRespuestSeguridad2;
    }

    public JLabel getLblPregunta2() {
        return lblPregunta2;
    }

    public void setLblPregunta2(JLabel lblPregunta2) {
        this.lblPregunta2 = lblPregunta2;
    }

    public JLabel getLblPregunta1() {
        return lblPregunta1;
    }

    public void setLblPregunta1(JLabel lblPregunta1) {
        this.lblPregunta1 = lblPregunta1;
    }

    public JTextField getTxtRespuestaSeguridad3() {
        return txtRespuestaSeguridad3;
    }

    public void setTxtRespuestaSeguridad3(JTextField txtRespuestaSeguridad3) {
        this.txtRespuestaSeguridad3 = txtRespuestaSeguridad3;
    }

    public JLabel getLblPregunta3() {
        return lblPregunta3;
    }

    public void setLblPregunta3(JLabel lblPregunta3) {
        this.lblPregunta3 = lblPregunta3;
    }

    public JLabel getLblRol() {
        return lblRol;
    }

    public void setLblRol(JLabel lblRol) {
        this.lblRol = lblRol;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }
//    public void cambiarIdioma(java.util.Locale nuevolenguaje) {
//        mensajeHandler.setLenguaje(nuevolenguaje);
//        actualizarTextos();
//    }

}
