package RedSocial;

import java.awt.Color;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarHashtag extends javax.swing.JFrame {

    static String UserLog;
    RandomAccessFile Hashtag;
    ArrayList<Hashtags> Datos;
    DefaultTableModel modelo;

    public BuscarHashtag(String usuario) {
        initComponents();
        this.UserLog = usuario;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        Datos = new ArrayList<>(100);
        modelo = (DefaultTableModel) Listado.getModel();
        try {
            Hashtag = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Hashtag.twc", "rw");
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
        CargarTwits();
    }

    void CargarTwits() {
        String usuario;
        String mensaje;
        long fecha;
        try {
            Hashtag.seek(0);
            while (Hashtag.getFilePointer() < Hashtag.length()) {
                usuario = Hashtag.readUTF();
                mensaje = Hashtag.readUTF();
                fecha = Hashtag.readLong();
                Datos.add(new Hashtags(usuario, mensaje, fecha));
            }
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    void MostrarTwits() {
        String palabra = Palabra.getText();
        String usuario;
        String mensaje;
        Date date = new Date();
        for (int i = 0; i < Datos.size(); i++) {
            usuario = Datos.get(i).getUsuario();
            mensaje = Datos.get(i).getMensaje();
            date.setTime(Datos.get(i).getFecha());
            if (mensaje.contains("#" + palabra)) {
                modelo.addRow(new Object[]{usuario, mensaje, date.toString()});
            }
        }
    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Listado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Palabra = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Listado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Listado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "        El  Usuario", "      escribio", "      el"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Listado.setRowHeight(30);
        jScrollPane2.setViewportView(Listado);

        jLabel1.setText("Ingrese el hastag:");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(Palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Palabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed


    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        MostrarTwits();

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) Listado.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }

    }//GEN-LAST:event_BtnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JTable Listado;
    private javax.swing.JTextField Palabra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
