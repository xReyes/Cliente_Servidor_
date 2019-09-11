
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Cliente4 extends javax.swing.JFrame {

    String usuario;
    String psw;
    String perfil;
    String cliente;
    String buscar;

    private DatagramSocket socket;
    Direccion_IP ip = new Direccion_IP();

    public Cliente4() {
        try {
            initComponents();
            socket = new DatagramSocket();
            txtUsuario.setEnabled(true);
            txtPassword.setEnabled(true);
            txtPerfil.setEnabled(true);
            txtCliente.setEnabled(true);

            btnBorrar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnEditar.setEnabled(false);

            setLocationRelativeTo(null);

        } catch (SocketException ex) {
            Logger.getLogger(Cliente4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JTextField();
        txtBuscar_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Perfil");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 200, 50, 20);

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 70, 20);

        jLabel3.setText("contraseña");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 160, 60, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(250, 120, 90, 23);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 110, 120, 30);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(100, 150, 120, 30);
        getContentPane().add(txtPerfil);
        txtPerfil.setBounds(100, 190, 120, 30);
        getContentPane().add(txtBuscar_nombre);
        txtBuscar_nombre.setBounds(100, 20, 120, 30);

        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 30, 70, 20);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(240, 20, 100, 23);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar);
        btnBorrar.setBounds(250, 150, 90, 23);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(250, 180, 90, 23);

        jLabel5.setText("Cliente");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 240, 50, 20);
        getContentPane().add(txtCliente);
        txtCliente.setBounds(100, 230, 120, 30);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            usuario = txtUsuario.getText();
            psw = txtPassword.getText();
            perfil = txtPerfil.getText();
            cliente = txtCliente.getText();

            String mensaje = "1 " + usuario + " " + perfil + " " + cifrarBase64(psw) + " " + cliente + " ";
            byte datos[] = mensaje.getBytes();
            JOptionPane.showMessageDialog(null, mensaje);
            //crear enviarPaquete

            DatagramPacket snd = ip.Direccion(datos);
            socket.send(snd);//enviar paquete
        } catch (IOException exceptionES) {
            exceptionES.printStackTrace();
        }
        try {
            socket = new DatagramSocket();
        } catch (SocketException excepcionSocket) {
            excepcionSocket.printStackTrace();
            System.exit(1);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            //obtener mensaje del campo de texto y convertirlo en arrreglo byte
            buscar = txtBuscar_nombre.getText();
            String mensaje = "2" + " " + buscar + " ";
            byte datos[] = mensaje.getBytes();
//          //crear enviarPaquete

            DatagramPacket snd = ip.Direccion(datos);
            socket.send(snd);
            //enviar paquete
        } catch (IOException exceptionES) {
            exceptionES.printStackTrace();
        }
        try {
            esperarPaquetes();
            socket = new DatagramSocket();
        } catch (SocketException excepcionSocket) {
            excepcionSocket.printStackTrace();
            System.exit(1);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            usuario = txtUsuario.getText();
            String mensaje = "3 " + usuario + " Registro Borrado";
            byte datos[] = mensaje.getBytes();
            //crear enviarPaquete

            DatagramPacket snd = ip.Direccion(datos);
            socket.send(snd);//enviar paquete
        } catch (IOException exceptionES) {
            exceptionES.printStackTrace();
        }
        try {
            socket = new DatagramSocket();
        } //atrapar los problemas que puedan ocurrir al crear objeto DatagramSocket
        catch (SocketException excepcionSocket) {
            excepcionSocket.printStackTrace();
            System.exit(1);
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtUsuario.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPerfil.setEnabled(true);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed
    private void esperarPaquetes() {
        try {
            //establecer el paquete
            byte datos[] = new byte[100];
            DatagramPacket recibirPaquete = new DatagramPacket(
                    datos, datos.length);
            socket.receive(recibirPaquete);//esperar un paquete
            String cad = (new String(recibirPaquete.getData(),
                    0, recibirPaquete.getLength()));
            String[] variables;
            variables = cad.split(" ");
            txtUsuario.setText(variables[0]);
            txtPerfil.setText(variables[1]);
            txtPassword.setText(variables[2]);
            txtCliente.setText(variables[3]);

        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }
    }//fin del metodo esperarPaquete

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Cliente4().setVisible(true);

            }
        });
    }

    public static String cifrarBase64(String a) {
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8));
        return b;
    }

    public static String descifrarBase64(String a) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);

        String b = new String(decodedByteArray);
        return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtBuscar_nombre;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPerfil;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
