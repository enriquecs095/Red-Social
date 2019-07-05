package RedSocial;

import java.awt.Color;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class TimeLine extends javax.swing.JFrame {

    static String UserLog;
    static String UserFollowing = "";
    RandomAccessFile Twits;
    RandomAccessFile Usuarios;
    RandomAccessFile TwitsForaneos;
    RandomAccessFile Following;
    RandomAccessFile TwitsAleatorios;
    ArrayList<TwitsGlobales> Datos;
    ArrayList<Seguidores> MisSeguidores;

    public TimeLine(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.UserLog = usuario;
        Datos = new ArrayList(100);
        MisSeguidores = new ArrayList<>(200);
        try {
            Twits = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Twits.twc", "rw");
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Following.twc", "rw");
            TwitsForaneos = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Twits.twc", "rw");
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            TwitsAleatorios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\TwitsAleatorios.twc", "rw");

        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
        // CargarTwits();
        //MostrarTwits();
        BuscarSeguidores();
        CargarTodosLosTwits();
        MostrarTwits();
    }

    /*
    void CargarTwits() {
        try {
            Twits.seek(0);
            String UsuarioM, MensajeM;
            long FechaM;
            while (Twits.getFilePointer() < Twits.length()) {
                UsuarioM = Twits.readUTF();
                MensajeM = Twits.readUTF();
                FechaM = Twits.readLong();
                Datos.add(new Twits(UsuarioM, MensajeM, FechaM));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
 /*
    void CargarTwitsForaneos(String usuario) { // esto es llamado por BuscarSeguidores
        try {
            TwitsForaneos = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + usuario + "\\Twits.twc", "rw");
            TwitsForaneos.seek(0);
            String UsuarioM, MensajeM;
            long FechaM;
            while (TwitsForaneos.getFilePointer() < TwitsForaneos.length()) {
                UsuarioM = TwitsForaneos.readUTF();
                MensajeM = TwitsForaneos.readUTF();
                FechaM = TwitsForaneos.readLong();
                Datos.add(new Twits(UsuarioM, MensajeM, FechaM));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }*/
    void CargarTodosLosTwits() {
        try {
            TwitsAleatorios.seek(0);
            String UsuarioM, MensajeM;
            long FechaM;
            while (TwitsAleatorios.getFilePointer() < TwitsAleatorios.length()) {
                UsuarioM = TwitsAleatorios.readUTF();
                MensajeM = TwitsAleatorios.readUTF();
                FechaM = TwitsAleatorios.readLong();
                if (!MisSeguidores.isEmpty()) {
                    for (int i = 0; i < MisSeguidores.size(); i++) {
                        if (UsuarioM.equals(UserLog) || UsuarioM.equals(MisSeguidores.get(i).getUsuario())) {
                            Datos.add(new TwitsGlobales(UsuarioM, MensajeM, FechaM));
                        }
                    }
                } else {
                    if (UsuarioM.equals(UserLog)) {
                        Datos.add(new TwitsGlobales(UsuarioM, MensajeM, FechaM));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void BuscarSeguidores() {
        try {
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Following.twc", "rw");
            Following.seek(0);
            String UsuarioM;
            long FechaM;
            boolean Siguiendo;
            while (Following.getFilePointer() < Following.length()) {
                UsuarioM = Following.readUTF();
                if (UsuariosActivos(UsuarioM.trim())) {
                    FechaM = Following.readLong();
                    Siguiendo = Following.readBoolean();
                    if (Siguiendo) {
                        MisSeguidores.add(new Seguidores(UsuarioM, FechaM));
                    }
                } else {
                    FechaM = Following.readLong();
                    Siguiendo = Following.readBoolean();
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

//Verifica si hay usuarios activos 
    boolean UsuariosActivos(String Usuario) throws IOException {
        try {
            Usuarios.seek(0);
            String nombre, usuario, contraseña, sexo, url, estado;
            int edad;
            long fecha;
            boolean activo;
            while (Usuarios.getFilePointer() < Usuarios.length()) {
                nombre = Usuarios.readUTF();
                usuario = Usuarios.readUTF();
                if (usuario.equals(Usuario)) {
                    contraseña = Usuarios.readUTF();
                    sexo = Usuarios.readUTF();
                    edad = Usuarios.readInt();
                    url = Usuarios.readUTF();
                    estado = Usuarios.readUTF();
                    Usuarios.skipBytes(8);
                    activo = Usuarios.readBoolean();
                    if (activo) {
                        return true;
                    }
                } else {
                    contraseña = Usuarios.readUTF();
                    sexo = Usuarios.readUTF();
                    edad = Usuarios.readInt();
                    url = Usuarios.readUTF();
                    estado = Usuarios.readUTF();
                    fecha = Usuarios.readLong();
                    activo = Usuarios.readBoolean();
                }
            }
        } catch (IOException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    void MostrarTwits() {
        Calendar calendar = Calendar.getInstance();
        DefaultTableModel modelo = (DefaultTableModel) Listado.getModel();
        String nombre;
        String mensaje;
        Date date = new Date();
        Collections.reverse(Datos);
        for (int i = 0; i < Datos.size(); i++) {
            nombre = Datos.get(i).getUsuario();
            mensaje = Datos.get(i).getMensaje();
            date.setTime(Datos.get(i).getFecha());
            modelo.addRow(new Object[]{nombre, mensaje, date.toString()});

        }
    }

    void Mensaje(String mensaje
    ) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Listado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Noticias y Chambres xD");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MiPortada miPortada = new MiPortada(UserLog);
        miPortada.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Listado;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
