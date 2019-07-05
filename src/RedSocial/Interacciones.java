package RedSocial;

import java.awt.Color;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Interacciones extends javax.swing.JFrame {

    static String UserLog;
    ArrayList<TwitsEtiquetados> TwitsInteracciones;
    RandomAccessFile Twits;
    RandomAccessFile UsuariosA;

    public Interacciones(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.UserLog = usuario;
        TwitsInteracciones = new ArrayList<TwitsEtiquetados>(100);
        try {
            UsuariosA = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            Twits = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Twits.twc", "rw");
        } catch (Exception e) {
            Mensaje(e.getMessage());
        }
        CargarTwits();
        MostrarTwits();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Listar = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Listar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Listar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "    Usuario", "    Twit", "     Compartido el"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Listar.setRowHeight(30);
        jScrollPane1.setViewportView(Listar);

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    void CargarTwits() {
        try {
            UsuariosA.seek(0);
            String nombre, usuario, contraseña, sexo, url, estado;
            int edad;
            long fecha;
            boolean activo;
            while (UsuariosA.getFilePointer() < UsuariosA.length()) {
                nombre = UsuariosA.readUTF();
                usuario = UsuariosA.readUTF();
                contraseña = UsuariosA.readUTF();
                sexo = UsuariosA.readUTF();
                edad = UsuariosA.readInt();
                url = UsuariosA.readUTF();
                estado = UsuariosA.readUTF();
                fecha = UsuariosA.readLong();
                activo = UsuariosA.readBoolean();
                if (usuario != UserLog) {
                    if (activo) {
                        CargarTwits2(usuario);
                    }
                }
            }
        } catch (Exception e) {
            Mensaje(e.getMessage());
        }
    }

    void CargarTwits2(String Usuarios) {
        String usuario, Mensaje;
        long Fecha;
        try {
            Twits.seek(0);
            Twits = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + Usuarios + "\\Twits.twc", "rw");
            while (Twits.getFilePointer() < Twits.length()) {
                usuario = Twits.readUTF();
                Mensaje = Twits.readUTF();
                Fecha = Twits.readLong();
                if (Mensaje.contains("@" + UserLog)) {
                    TwitsInteracciones.add(new TwitsEtiquetados(usuario, Mensaje, Fecha));
                }
            }

        } catch (Exception e) {
            Mensaje(e.getMessage());
        }

    }

    void MostrarTwits() {
        DefaultTableModel modelo = (DefaultTableModel) Listar.getModel();
        String name;
        String mensaje;
        Date date = new Date();
        Collections.reverse(TwitsInteracciones);
        for (int i = 0; i < TwitsInteracciones.size(); i++) {
            name = TwitsInteracciones.get(i).getUsuario();
            mensaje = TwitsInteracciones.get(i).getMensaje();
            date.setTime(TwitsInteracciones.get(i).getFecha());
            modelo.addRow(new Object[]{name, mensaje, date.toString()});
        }
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Listar;
    private javax.swing.JButton Regresar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
