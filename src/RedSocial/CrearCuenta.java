package RedSocial;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CrearCuenta extends javax.swing.JFrame {

    static String NewUser;
    private String URL = "";
    private long FechaI;
    private String EstadoI;
    private File Carpetas = null;
    private RandomAccessFile UsuariosI;
    private RandomAccessFile Following;
    private RandomAccessFile Followers;
    private RandomAccessFile Twits;
    RandomAccessFile TwitsAleatorios;

    public CrearCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.Diseño.setBackground(Color.LIGHT_GRAY);
        try {
            UsuariosI = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
        } catch (Exception e) {
            Mensaje(e.getMessage());
        }
    }

    boolean BuscarUsuario(String usuario, String contraseña) throws IOException {
        UsuariosI.seek(0);
        String NombreCompleto, Usuario, Contraseña, Sexo;
        int Edad;
        boolean Activo;
        while (UsuariosI.getFilePointer() < UsuariosI.length()) {
            NombreCompleto = UsuariosI.readUTF();
            Usuario = UsuariosI.readUTF();
            Contraseña = UsuariosI.readUTF();
            Sexo = UsuariosI.readUTF();
            Edad = UsuariosI.readInt();
            URL = UsuariosI.readUTF();
            EstadoI = UsuariosI.readUTF();
            FechaI = UsuariosI.readLong();
            Activo = UsuariosI.readBoolean();
            if (Usuario.equals(usuario) && Contraseña.equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    boolean BuscarUsuarioTwit(String usuario) throws IOException {
        UsuariosI.seek(0);
        String nombreCompleto, usuarioI, contraseñaI, sexoI, urlI, estadoI;
        int edadI;
        long fechaI;
        boolean activoI;
        while (UsuariosI.getFilePointer() < UsuariosI.length()) {
            nombreCompleto = UsuariosI.readUTF();
            usuarioI = UsuariosI.readUTF();
            contraseñaI = UsuariosI.readUTF();
            sexoI = UsuariosI.readUTF();
            edadI = UsuariosI.readInt();
            urlI = UsuariosI.readUTF();
            estadoI = UsuariosI.readUTF();
             fechaI = UsuariosI.readLong();
            activoI = UsuariosI.readBoolean();
            if (usuarioI.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    boolean CrearRegistroUsuario(String NombreUsuario
    ) {
        try {
            Carpetas = new File("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + NombreUsuario);
            Carpetas.mkdirs();
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + NombreUsuario + "\\Following.twc", "rw");
            Followers = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + NombreUsuario + "\\Follower.twc", "rw");
            Twits = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + NombreUsuario + "\\Twits.twc", "rw");
            Registrar();
            return true;
        } catch (Exception e) {
            Mensaje(e.getMessage());
            return false;
        }
    }

    void Registrar() throws IOException {
        boolean cuenta = true;
        UsuariosI.seek(UsuariosI.length());
        UsuariosI.writeUTF(Nombre.getText());
        UsuariosI.writeUTF(Usuario.getText().trim());
        UsuariosI.writeUTF(Contraseña.getText().trim());
        UsuariosI.writeUTF(Sexo.getSelectedItem().toString());
        UsuariosI.writeInt(Integer.parseInt(Edad.getSelectedItem().toString()));
        UsuariosI.writeUTF(URL);
        UsuariosI.writeUTF(Estado.getText());//Estado 
        UsuariosI.writeLong(Calendar.getInstance().getTimeInMillis());//fecha de creacion de usuario
        UsuariosI.writeBoolean(cuenta);//Estado de la cuenta
    }

    private void Revisar() throws EmptyDataException {
        if (Nombre.getText().isEmpty()) {
            throw new EmptyDataException("Nombre");
        }
        if (Usuario.getText().isEmpty()) {
            throw new EmptyDataException("Usuario");
        }
        if (Contraseña.getText().isEmpty()) {
            throw new EmptyDataException("Contraseña");
        }
        if (VerificarContraseña.getText().isEmpty()) {
            throw new EmptyDataException("Debe verificar la contraseña");
        }
        if (Sexo.getSelectedItem().toString().equals("-")) {
            throw new EmptyDataException("Sexo");
        }
        if (Edad.getSelectedItem().toString().equals("-")) {
            throw new EmptyDataException("Edad");
        }
        if (Estado.getText().isEmpty()) {
            throw new EmptyDataException("Estado");
        }
        if (URL.equals("")) {
            throw new EmptyDataException("Imagen");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        Diseño = new javax.swing.JPanel();
        Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        VerificarContraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        Sexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Edad = new javax.swing.JComboBox<>();
        Agregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BtnAgregarImagen = new javax.swing.JButton();
        AgregarImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Estado = new javax.swing.JTextField();
        Regresar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre completo: ");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Verificar Contraseña:");

        jLabel5.setText("Sexo: ");

        Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "M", "F", " " }));

        jLabel6.setText("Edad: ");

        Edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", " " }));

        Agregar.setText("Registrarse");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Datos Personales");

        BtnAgregarImagen.setText("Agregar Foto de Perfil");
        BtnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarImagenActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado:");

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DiseñoLayout = new javax.swing.GroupLayout(Diseño);
        Diseño.setLayout(DiseñoLayout);
        DiseñoLayout.setHorizontalGroup(
            DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiseñoLayout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DiseñoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DiseñoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DiseñoLayout.createSequentialGroup()
                        .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DiseñoLayout.createSequentialGroup()
                                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(57, 57, 57)
                                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VerificarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Estado, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                            .addGroup(DiseñoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiseñoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiseñoLayout.createSequentialGroup()
                                .addComponent(BtnAgregarImagen)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiseñoLayout.createSequentialGroup()
                                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Regresar)
                                    .addComponent(AgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))))))
        );
        DiseñoLayout.setVerticalGroup(
            DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiseñoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(VerificarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(BtnAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(DiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiseñoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DiseñoLayout.createSequentialGroup()
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addGroup(DiseñoLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(AgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Diseño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Diseño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarImagenActionPerformed
        JFileChooser escoger = new JFileChooser();
        escoger.showOpenDialog(this);
        escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        URL = escoger.getSelectedFile().toString();
        ImageIcon Poster = new ImageIcon(URL);
        AgregarImagen.setIcon(Poster);
    }//GEN-LAST:event_BtnAgregarImagenActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        NewUser = Usuario.getText().trim();
        String contraseña = Contraseña.getText();
        String verificarContraseña = VerificarContraseña.getText().trim();
        EntrarPerfil entrarPerfil = new EntrarPerfil(NewUser);
        try {
            Revisar();
            if (BuscarUsuarioTwit(NewUser)) {
                Mensaje("Usuario ya exite, por favor ingrese otro usuario");
            } else {
                if (contraseña.equals(verificarContraseña)) {
                    if (CrearRegistroUsuario(NewUser)) {
                        Mensaje("Usuario creado");
                        entrarPerfil.setVisible(true);
                        this.dispose();
                    } else {
                        Mensaje("No se pudo crear el usuario");
                    }
                } else {
                    Mensaje("Contraseñas no coinciden");
                }
            }
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        } catch (EmptyDataException e) {
            Mensaje(e.getMessage());
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    boolean GuardarTwit(String usuario, String twit) throws IOException {
        if (BuscarUsuarioTwit(usuario)) {
            Twits = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + usuario + "\\Twits.twc", "rw");
            Twits.seek(Twits.length());
            Twits.writeUTF(usuario);
            Twits.writeUTF(twit);
            Twits.writeLong(Calendar.getInstance().getTimeInMillis());
            return true;
        }
        return false;
    }

    void TwitsAleatorios(String usuario, String twit) throws IOException {
        if (BuscarUsuarioTwit(usuario)) {
            TwitsAleatorios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\TwitsAleatorios.twc", "rw");
            TwitsAleatorios.seek(TwitsAleatorios.length());
            TwitsAleatorios.writeUTF(usuario);
            TwitsAleatorios.writeUTF(twit);
            TwitsAleatorios.writeLong(Calendar.getInstance().getTimeInMillis());
        }

    }

    void Mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JLabel AgregarImagen;
    private javax.swing.JButton BtnAgregarImagen;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JPanel Diseño;
    private javax.swing.JComboBox<String> Edad;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Regresar;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JTextField Usuario;
    private javax.swing.JPasswordField VerificarContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
