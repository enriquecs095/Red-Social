package RedSocial;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class EnviarTwit extends javax.swing.JFrame {

    static String UserLog;
    RandomAccessFile Hashtag;

    public EnviarTwit(String usuario) {
        initComponents();
        this.UserLog = usuario;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.jPanel1.setBackground(Color.LIGHT_GRAY);
        try {
            Hashtag = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Hashtag.twc", "rw");
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextoTwit = new javax.swing.JTextField();
        BtnEnviar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escribir Twit (maximo 140 caracteres)");

        BtnEnviar.setText("Enviar Twit");
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoTwit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(BtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoTwit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Regresar))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        EnviarTwit();
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    void EnviarTwit() {
        EditarPerfil editarPerfil=new EditarPerfil(UserLog);
        MiPortada miPortada = new MiPortada(UserLog);
        String mensaje = TextoTwit.getText();
        String[] parte = mensaje.split(" ");
        String usuario = "";
        String usuarioI = "";
        int limite = 140;
        long fecha = Calendar.getInstance().getTimeInMillis();
        CrearCuenta crearCuenta = new CrearCuenta();
        if (mensaje.length() > limite) {
            Mensaje("Se sobrepaso el limite del twit");
        } else if (mensaje.length() == 0) {
            Mensaje("Por favor escriba un mensaje");
        } else {
            try {
                if (mensaje.contains("@")) {
                    for (int i = 0; i < parte.length; i++) {
                        if (parte[i].contains("@")) {
                            usuario = parte[i];
                        }
                    }
                    usuarioI = usuario.replace("@", "");
                    if (crearCuenta.BuscarUsuarioTwit(usuarioI)) {                      
                        if (crearCuenta.GuardarTwit(UserLog, mensaje)) {
                            crearCuenta.TwitsAleatorios(UserLog, mensaje);//los twits aleatorios
                            Mensaje("Se envio el twit");
                            GuardarHashtag(mensaje);
                            miPortada.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        Mensaje("Usuario no existe");
                    }
                } else if (crearCuenta.GuardarTwit(UserLog, mensaje)) {
                    GuardarHashtag(mensaje);
                    crearCuenta.TwitsAleatorios(UserLog, mensaje);//los twits aleatorios
                    Mensaje("Se envio el twit");
                    miPortada.setVisible(true);
                    this.dispose();
                }

            } catch (IOException e) {
                Mensaje(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    void GuardarHashtag(String mensaje) {
        try {
            if (mensaje.contains("#")) {
                Hashtag.seek(Hashtag.length());
                Hashtag.writeUTF(UserLog);
                Hashtag.writeUTF(mensaje);
                Hashtag.writeLong(Calendar.getInstance().getTimeInMillis());
            }
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEnviar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField TextoTwit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
