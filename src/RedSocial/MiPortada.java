package RedSocial;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import javax.swing.ImageIcon;

public class MiPortada extends javax.swing.JFrame {

    static String UserLog;
    private static String URL;
    private static long FechaI;
    private static String EstadoI;
    static RandomAccessFile Usuarios;

    public MiPortada(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.UserLog = usuario;
        this.setTitle("Mi Perfil");
        this.setBackground(Color.DARK_GRAY);
        this.Panel2.setBackground(Color.LIGHT_GRAY);
        this.Panel.setBackground(Color.LIGHT_GRAY);
        this.Panel3.setBackground(Color.GRAY);
        try {
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            CargarDatos();
        } catch (Exception e) {
            Mensaje(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        VerImagen = new javax.swing.JLabel();
        NombreC = new javax.swing.JLabel();
        BtnEnviarTwit = new javax.swing.JButton();
        BtnTimeLine = new javax.swing.JButton();
        BtnInteracciones = new javax.swing.JButton();
        BtnHashtag = new javax.swing.JButton();
        BtnEditarPerfil1 = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Estado = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        UsuarioRegistrado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnEnviarTwit.setText("Mandar 1 Tweet");
        BtnEnviarTwit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarTwitActionPerformed(evt);
            }
        });

        BtnTimeLine.setText("TimeLine");
        BtnTimeLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTimeLineActionPerformed(evt);
            }
        });

        BtnInteracciones.setText("Interaccion");
        BtnInteracciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInteraccionesActionPerformed(evt);
            }
        });

        BtnHashtag.setText("Hashtag");
        BtnHashtag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHashtagActionPerformed(evt);
            }
        });

        BtnEditarPerfil1.setText("Editar Perfil");
        BtnEditarPerfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarPerfil1ActionPerformed(evt);
            }
        });

        BtnCerrarSesion.setText("Cerrar Sesion");
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Mi estado:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Se unio el :");

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(Panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VerImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnEditarPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnTimeLine, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BtnHashtag, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(BtnEnviarTwit)
                        .addGap(37, 37, 37)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(BtnInteracciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VerImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnTimeLine, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnEnviarTwit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnInteracciones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnHashtag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnEditarPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\src\\RedSocial\\twit.png")); // NOI18N

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UsuarioRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsuarioRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void CargarDatos() throws IOException {
        Usuarios.seek(0);
        ImageIcon Poster;
        Date date = new Date();
        String NombreCompleto, Usuario, Contraseña, Sexo;
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
            if (Usuario.equals(UserLog)) {
                Poster = new ImageIcon(URL);
                VerImagen.setIcon(Poster);
                Estado.setText(EstadoI);
                Estado.setFont(new Font("Arial", Font.BOLD, 12));
                date.setTime(FechaI);
                Fecha.setText(date.toString());
                Fecha.setFont(new Font("Arial", Font.BOLD, 12));
                NombreC.setText(NombreCompleto);
                NombreC.setFont(new Font("Arial", Font.BOLD, 12));
                UsuarioRegistrado.setText(Usuario);
                UsuarioRegistrado.setFont(new Font("Arial", Font.BOLD, 12));

            }
        }

    }


    private void BtnEnviarTwitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarTwitActionPerformed
        EnviarTwit enviarTwit = new EnviarTwit(UserLog);
        enviarTwit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEnviarTwitActionPerformed

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }


    private void BtnTimeLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTimeLineActionPerformed
        TimeLine timeLine = new TimeLine(UserLog);
        timeLine.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_BtnTimeLineActionPerformed

    private void BtnInteraccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInteraccionesActionPerformed
        Interacciones interacciones = new Interacciones(UserLog);
        interacciones.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_BtnInteraccionesActionPerformed

    private void BtnHashtagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHashtagActionPerformed
        BuscarHashtag buscarHashtag = new BuscarHashtag(UserLog);
        buscarHashtag.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnHashtagActionPerformed

    private void BtnEditarPerfil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarPerfil1ActionPerformed
        EditarPerfil editarPerfil = new EditarPerfil(UserLog);
        editarPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEditarPerfil1ActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnEditarPerfil1;
    private javax.swing.JButton BtnEnviarTwit;
    private javax.swing.JButton BtnHashtag;
    private javax.swing.JButton BtnInteracciones;
    private javax.swing.JButton BtnTimeLine;
    private javax.swing.JLabel Estado;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel NombreC;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JLabel UsuarioRegistrado;
    private javax.swing.JLabel VerImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
