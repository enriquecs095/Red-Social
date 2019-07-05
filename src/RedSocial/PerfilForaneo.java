package RedSocial;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PerfilForaneo extends javax.swing.JFrame {

    static String UserLog;
    static String UsuarioVisitar;
    RandomAccessFile Usuarios;
    RandomAccessFile Following;
    RandomAccessFile Follower;
    ArrayList<Seguidores> Seguidores;
    ArrayList<Siguiendo> Siguiendo;

    public PerfilForaneo(String usuario, String usuarioForaneo) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.jPanel1.setBackground(Color.LIGHT_GRAY);
        this.UserLog = usuario;
        this.UsuarioVisitar = usuarioForaneo;
        Seguidores = new ArrayList<>(100);
        Siguiendo = new ArrayList<>(100);
        try {
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Following.twc", "rw");
            Follower = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UsuarioVisitar + "\\Follower.twc", "rw");
            CargarDatos();
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            if (FindFollowingActivo()) {
                BtnSeguir.setEnabled(false);
                BtnDejarSeguir.setEnabled(true);
            } else {
                BtnSeguir.setEnabled(true);
                BtnDejarSeguir.setEnabled(false);
            }
        } catch (Exception e) {

        }
    }

    void CargarDatos() throws IOException {
        Usuarios.seek(0);
        ImageIcon Poster;
        Date date = new Date();
        String NombreCompleto, Usuario, Contraseña, Sexo, URL, EstadoI;
        long FechaI;
        int Edad;
        boolean Activo;
        while (Usuarios.getFilePointer() < Usuarios.length()) {
            NombreCompleto = Usuarios.readUTF();
            Usuario = Usuarios.readUTF();
            Contraseña = Usuarios.readUTF();
            Sexo = Usuarios.readUTF();
            Edad = Usuarios.readInt();
            URL = Usuarios.readUTF();
            EstadoI = Usuarios.readUTF();
            FechaI = Usuarios.readLong();
            Activo = Usuarios.readBoolean();
            if (Usuario.equals(UsuarioVisitar)) {
                Poster = new ImageIcon(URL);
                CargarImagen.setIcon(Poster);
                Estado.setText(EstadoI);
                Estado.setFont(new Font("Arial", Font.BOLD, 12));
                date.setTime(FechaI);
                Fecha.setText(date.toString());
                Fecha.setFont(new Font("Arial", Font.BOLD, 12));
                Nombre.setText(NombreCompleto);
                Nombre.setFont(new Font("Arial", Font.BOLD, 12));
                EdadI.setText(Integer.toString(Edad));
                Genero.setText(Sexo);
                UsuarioForaneo.setText(Usuario);
                UsuarioForaneo.setFont(new Font("Arial", Font.BOLD, 12));
            }
        }
    }

    boolean AgregarFollowing() {
        boolean cambiar = true;
        try {
            Following.seek(Following.length());
            Following.writeUTF(UsuarioForaneo.getText());
            Following.writeLong(Calendar.getInstance().getTimeInMillis());
            Following.writeBoolean(cambiar);
            Follower.seek(Follower.length());
            Follower.writeUTF(UserLog);
            Follower.writeLong(Calendar.getInstance().getTimeInMillis());
            Follower.writeBoolean(cambiar);
            return true;
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    boolean ActualizarFollowing() {
        String usuario, usuario2;
        long fecha, fecha2;
        boolean activo, activo2;
        boolean Cambiar = true;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                if (usuario.trim().equals(UsuarioVisitar)) {
                    Following.skipBytes(8);
                    Following.writeBoolean(Cambiar);
                } else {
                    fecha = Following.readLong();
                    activo = Following.readBoolean();
                }
            }
            Follower.seek(0);
            while (Follower.getFilePointer() < Follower.length()) {
                usuario2 = Follower.readUTF();
                if (usuario2.trim().equals(UserLog)) {
                    Following.skipBytes(8);
                    Follower.writeBoolean(Cambiar);
                } else {
                    fecha2 = Following.readLong();
                    activo2 = Following.readBoolean();
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    boolean DejarFollowing() {
        String usuario, usuario2;
        long fecha, fecha2;
        boolean activo, activo2;
        boolean Cambiar = false;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                if (usuario.trim().equals(UsuarioVisitar)) {
                    Following.skipBytes(8);
                    Following.writeBoolean(Cambiar);
                } else {
                    fecha = Following.readLong();
                    activo = Following.readBoolean();
                }
            }
            Follower.seek(0);
            while (Follower.getFilePointer() < Follower.length()) {
                usuario2 = Follower.readUTF();
                if (usuario2.trim().equals(UserLog)) {
                    Follower.skipBytes(8);
                    Follower.writeBoolean(Cambiar);
                } else {
                    fecha2 = Follower.readLong();
                    activo2 = Follower.readBoolean();
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    boolean FindFollowing() { // si lo encuentra y esta inactivo retorna false, si no encuentra el usuario  devuelve true
        String usuario;
        long fecha;
        boolean EstaActivo;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                if (usuario.trim().equals(UsuarioVisitar)) {
                    return false;
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
        return true;
    }

    boolean FindFollowingInactivo() {// si es verdadero lo encontro inactivo
        String usuario;
        long fecha;
        boolean EstaActivo;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                if (usuario.trim().equals(UsuarioVisitar)) {
                    Following.skipBytes(8);
                    EstaActivo = Following.readBoolean();
                    if (!EstaActivo) {
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

    boolean FindFollowingActivo() {//si existe el usuario y esta activo devuelve true
        String usuario;
        long fecha;
        boolean EstaActivo;
        try {
            Following.seek(0);
            while (Following.getFilePointer() < Following.length()) {
                usuario = Following.readUTF();
                // fecha = Following.readLong();
                //EstaActivo = Following.readBoolean();
                if (usuario.trim().equalsIgnoreCase(UsuarioVisitar)) {
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

    void GuardarRegistros() {
        String usuario;
        long fecha;
        String follower = "seguidores";
        String following = "siguiendo";
        try {
            if (Following.length() != 0) {
                Following.seek(0);
                while (Following.getFilePointer() < Following.length()) {
                    usuario = Following.readUTF();
                    fecha = Following.readLong();
                    if (usuario != UsuarioVisitar) {
                        GuardarRegistros2(following, usuario, fecha);
                    }
                }
            }
            if (Follower.length() != 0) {
                Follower.seek(0);
                while (Follower.getFilePointer() < Follower.length()) {
                    usuario = Follower.readUTF();
                    fecha = Follower.readLong();
                    if (usuario != UserLog) {
                        GuardarRegistros2(follower, usuario, fecha);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
        }
    }

    void GuardarRegistros2(String tipo, String usuario, long fecha) {
        TipoFollow tipoFollow = TipoFollow.valueOf(tipo.toUpperCase());
        switch (tipoFollow) {
            case SEGUIDORES:
                Seguidores.add(new Seguidores(usuario, fecha));
                break;
            case SIGUIENDO:
                Siguiendo.add(new Siguiendo(usuario, fecha));
                break;
        }
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CargarImagen = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Genero = new javax.swing.JLabel();
        EdadI = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FollowingI = new javax.swing.JLabel();
        FollowerI = new javax.swing.JLabel();
        BtnSeguir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Estado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        UsuarioForaneo = new javax.swing.JLabel();
        BtnDejarSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Sexo");

        jLabel3.setText("Edad");

        jLabel4.setText("Followers");

        jLabel5.setText("Followings");

        BtnSeguir.setText("Seguir");
        BtnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeguirActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado");

        Estado.setEnabled(false);

        jLabel7.setText("Se unio el ");

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        BtnDejarSeguir.setText("Dejar de Seguir");
        BtnDejarSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDejarSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(UsuarioForaneo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(CargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDejarSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Estado)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(FollowingI, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(EdadI, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(FollowerI, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(Regresar)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioForaneo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EdadI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(FollowingI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FollowerI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnDejarSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeguirActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        int opcion;
        opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea seguir el usuario?");
        if (opcion == 0) {
            if (FindFollowing()) {// si no lo encontre me devuelve true
                if (AgregarFollowing()) {
                    Mensaje("Se esta siguiendo");
                    miPortada.setVisible(true);
                    this.dispose();
                }
            }
            if (FindFollowingInactivo()) {
                if (AgregarFollowing()) {
                    Mensaje("Se esta siguiendo");
                    miPortada.setVisible(true);
                    this.dispose();
                }
            }
        }

    }//GEN-LAST:event_BtnSeguirActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void BtnDejarSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDejarSeguirActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        int opcion;
        opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea dejar de seguir el usuario?");
        try {
            if (opcion == 0) {
                if (DejarFollowing()) {
                    Mensaje("Se dejo de seguir");
                    miPortada.setVisible(true);
                    this.dispose();
                }
            }
        } catch (NullPointerException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnDejarSeguirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDejarSeguir;
    private javax.swing.JButton BtnSeguir;
    private javax.swing.JLabel CargarImagen;
    private javax.swing.JLabel EdadI;
    private javax.swing.JTextField Estado;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FollowerI;
    private javax.swing.JLabel FollowingI;
    private javax.swing.JLabel Genero;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel UsuarioForaneo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
