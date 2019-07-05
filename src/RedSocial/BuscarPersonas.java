package RedSocial;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class BuscarPersonas extends javax.swing.JFrame {

    static String UserLog;
    static RandomAccessFile Usuarios;
    static RandomAccessFile Following;
    static RandomAccessFile Follower;
    static ArrayList<Usuarios> Busqueda;
    static DefaultListModel ModeloLista;
    static String UsuarioVisitar;

    public BuscarPersonas(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);

        this.UserLog = usuario;
        Busqueda = new ArrayList<Usuarios>(100);
        ModeloLista = new DefaultListModel();
        Listado.setModel(ModeloLista);
        try {
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Following.twc", "rw");
            Follower = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Follower.twc", "rw");
            Guardar();
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
    }

    void Guardar() throws IOException {
        Usuarios.seek(0);
        String nombre, usuario, contraseña, sexo, url, estado;
        int edad;
        long fecha;
        boolean activo;
        while (Usuarios.getFilePointer() < Usuarios.length()) {
            nombre = Usuarios.readUTF();
            usuario = Usuarios.readUTF();
            contraseña = Usuarios.readUTF();
            sexo = Usuarios.readUTF();
            edad = Usuarios.readInt();
            url = Usuarios.readUTF();
            estado = Usuarios.readUTF();
            fecha = Usuarios.readLong();
            activo = Usuarios.readBoolean();
            if (activo) {
                Busqueda.add(new Usuarios(nombre, usuario, contraseña, sexo.charAt(0), edad, url, fecha, estado, activo));
            }
        }
    }

    boolean FindFollowing(String Usuario) {//si lo encuentra y esta activo devuelve true
        String usuario;
        long fecha;
        boolean EstaActivo;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                if (usuario.equals(Usuario)) {
                    Following.skipBytes(8);
                    EstaActivo = Following.readBoolean();
                    if (EstaActivo) {
                        return true;
                    }
                } else {
                    fecha = Following.readLong();
                    EstaActivo = Following.readBoolean();
                }
            }
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    void MostrarUsuarios() {
        String usuario = Buscar.getText();
        for (int i = 0; i < Busqueda.size(); i++) {
            if (Busqueda.get(i).getUsuario().contains(usuario) && (!Busqueda.get(i).getUsuario().equals(UserLog))) {
                if (FindFollowing(Busqueda.get(i).getUsuario())) {
                    ModeloLista.addElement(Busqueda.get(i).getUsuario() + "  " + "Siguiendo");
                } else {
                    ModeloLista.addElement(Busqueda.get(i).getUsuario() + "  " + "No se esta siguiendo");
                }
            }
        }
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Listado = new javax.swing.JList<>();
        BtnLimpiar = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        BtnVisitarPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escriba el usuario");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(Listado);

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        BtnVisitarPerfil.setText("Ir al Perfiil");
        BtnVisitarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVisitarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnVisitarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnVisitarPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegresar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        MostrarUsuarios();

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        ModeloLista.removeAllElements();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnVisitarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVisitarPerfilActionPerformed
        String Extraer = Listado.getSelectedValue();
        String Usuario;
        String[] parte;
        if (Listado.isSelectionEmpty()) {
            Mensaje("Por favor seleccione un usuario");
        } else {
            VisitarPerfil();
        }
    }//GEN-LAST:event_BtnVisitarPerfilActionPerformed

    void VisitarPerfil() {
        String Extraer = Listado.getSelectedValue();
        String[] parte;
        parte = Extraer.split(" ");
        UsuarioVisitar = parte[0];
        PerfilForaneo perfilForaneo = new PerfilForaneo(UserLog, UsuarioVisitar);
        perfilForaneo.setVisible(true);
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JButton BtnVisitarPerfil;
    private javax.swing.JTextField Buscar;
    private javax.swing.JList<String> Listado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
