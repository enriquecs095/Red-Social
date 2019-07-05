package RedSocial;

import java.awt.Color;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class EditarPerfil extends javax.swing.JFrame {

    static String UserLog;
    static RandomAccessFile Usuarios;

    public EditarPerfil(String usuario) {
        initComponents();
        this.UserLog = usuario;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.jPanel1.setBackground(Color.LIGHT_GRAY);
        try {
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            if (EstadoUsuario()) {
                ActivarUsuario.setEnabled(false);
                DesactivarUsuario.setEnabled(true);
            } else {
                ActivarUsuario.setEnabled(true);
                DesactivarUsuario.setEnabled(false);
            }
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
    }

    boolean ActivarUsuario() throws IOException {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String NombreCompleto, Usuario, Contraseña, Sexo, URL, Estado;
        int Edad;
        long Fecha;
        boolean Activo;
        boolean Cambiar = true;
        try {
            Usuarios.seek(0);
            while (Usuarios.getFilePointer() < Usuarios.length()) {
                NombreCompleto = Usuarios.readUTF();
                Usuario = Usuarios.readUTF();
                if (Usuario.equals(UserLog)) {
                    Contraseña = Usuarios.readUTF();
                    Sexo = Usuarios.readUTF();
                    Edad = Usuarios.readInt();
                    URL = Usuarios.readUTF();
                    Estado = Usuarios.readUTF();
                    Usuarios.skipBytes(8);
                    Usuarios.writeBoolean(Cambiar);
                    return true;
                } else {
                    Contraseña = Usuarios.readUTF();
                    Sexo = Usuarios.readUTF();
                    Edad = Usuarios.readInt();
                    URL = Usuarios.readUTF();
                    Estado = Usuarios.readUTF();
                    Fecha = Usuarios.readLong();
                    Activo = Usuarios.readBoolean();
                }
            }
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    boolean EstadoUsuario() throws IOException {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String NombreCompleto, Usuario, Contraseña, Sexo, URL, Estado;
        int Edad;
        long Fecha;
        boolean Activo;
        Usuarios.seek(0);
        while (Usuarios.getFilePointer() < Usuarios.length()) {
            NombreCompleto = Usuarios.readUTF();
            Usuario = Usuarios.readUTF();
            if (Usuario.equals(UserLog)) {
                Contraseña = Usuarios.readUTF();
                Sexo = Usuarios.readUTF();
                Edad = Usuarios.readInt();
                URL = Usuarios.readUTF();
                Estado = Usuarios.readUTF();
                Usuarios.skipBytes(8);
                Activo = Usuarios.readBoolean();
                if (Activo) {
                    return true;
                }
            } else {
                Contraseña = Usuarios.readUTF();
                Sexo = Usuarios.readUTF();
                Edad = Usuarios.readInt();
                URL = Usuarios.readUTF();
                Estado = Usuarios.readUTF();
                Fecha = Usuarios.readLong();
                Activo = Usuarios.readBoolean();
            }
        }
        return false;
    }

      boolean EstadoUsuario2(String usuario) throws IOException {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String NombreCompleto, Usuario, Contraseña, Sexo, URL, Estado;
        int Edad;
        long Fecha;
        boolean Activo;
        Usuarios.seek(0);
        while (Usuarios.getFilePointer() < Usuarios.length()) {
            NombreCompleto = Usuarios.readUTF();
            Usuario = Usuarios.readUTF();
            if (Usuario.equals(usuario)) {
                Contraseña = Usuarios.readUTF();
                Sexo = Usuarios.readUTF();
                Edad = Usuarios.readInt();
                URL = Usuarios.readUTF();
                Estado = Usuarios.readUTF();
                Usuarios.skipBytes(8);
                Activo = Usuarios.readBoolean();
                if (Activo) {
                    return true;
                }
            } else {
                Contraseña = Usuarios.readUTF();
                Sexo = Usuarios.readUTF();
                Edad = Usuarios.readInt();
                URL = Usuarios.readUTF();
                Estado = Usuarios.readUTF();
                Fecha = Usuarios.readLong();
                Activo = Usuarios.readBoolean();
            }
        }
        return false;
    }
    
    
    
    boolean DesactivarUsuario() throws IOException {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String NombreCompleto, Usuario, Contraseña, Sexo, URL, Estado;
        int Edad;
        long Fecha;
        boolean Activo;
        boolean Cambiar = false;
        try {
            Usuarios.seek(0);
            while (Usuarios.getFilePointer() < Usuarios.length()) {
                NombreCompleto = Usuarios.readUTF();
                Usuario = Usuarios.readUTF();
                if (Usuario.equals(UserLog)) {
                    Contraseña = Usuarios.readUTF();
                    Sexo = Usuarios.readUTF();
                    Edad = Usuarios.readInt();
                    URL = Usuarios.readUTF();
                    Estado = Usuarios.readUTF();
                    Usuarios.skipBytes(8);
                    Usuarios.writeBoolean(Cambiar);
                    return true;
                } else {
                    Contraseña = Usuarios.readUTF();
                    Sexo = Usuarios.readUTF();
                    Edad = Usuarios.readInt();
                    URL = Usuarios.readUTF();
                    Estado = Usuarios.readUTF();
                    Fecha = Usuarios.readLong();
                    Activo = Usuarios.readBoolean();
                }
            }
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        ActivarUsuario = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        DesactivarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnBuscar.setText("Buscar Personas");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        ActivarUsuario.setText("Activar Usuario");
        ActivarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarUsuarioActionPerformed(evt);
            }
        });

        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        DesactivarUsuario.setText("Desactivar Usuario");
        DesactivarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactivarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DesactivarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ActivarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(BtnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActivarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DesactivarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        BuscarPersonas buscarPersonas = new BuscarPersonas(UserLog);
        buscarPersonas.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnRegresarActionPerformed


    private void ActivarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarUsuarioActionPerformed
        int opcion = 0;
        MiPortada miPortada=new MiPortada(UserLog);
        try {
            opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea activar su cuenta?");
            if (opcion == 0) {
                if (ActivarUsuario()) {
                    Mensaje("Usuario activado");
                    miPortada.setVisible(true);
                    this.dispose();
                }
            }
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ActivarUsuarioActionPerformed

    private void DesactivarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesactivarUsuarioActionPerformed
        int opcion = 0;
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        try {
            opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea desactivar su cuenta?");
            if (opcion == 0) {
                if (DesactivarUsuario()) {
                    Mensaje("Usuario desactivado");
                    menuPrincipal.setVisible(true);
                    this.dispose();
                }
            }
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_DesactivarUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActivarUsuario;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JButton DesactivarUsuario;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
