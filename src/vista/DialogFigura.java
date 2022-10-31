package vista;

import dao.DAOJugadorImpl;
import interfaces.DAOJugador;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Jugador;
import modelo.Pais;


public class DialogFigura extends javax.swing.JDialog {
    private String ruta;
    private Jugador jugador;
    private int cod;
    private Pais pais;

    public DialogFigura(java.awt.Frame parent, boolean modal,Jugador jugador,Pais pais,int cod) {
        super(parent, modal);
        initComponents();
        setLocation(600, 200);
        setResizable(false);
        
        this.jugador=jugador;
        this.cod=cod;
        this.pais=pais;
        this.ruta="";
        if(jugador!=null){
            lblNombre.setText(jugador.getNombre());
            txtNombre.setText(jugador.getNombre());
            txtEdad.setText(jugador.getEdad()+"");
            cbPosicion.setSelectedItem(jugador.getPosicion());
            ImageIcon imagen= new ImageIcon(jugador.getImagen());
            lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
             this.ruta=jugador.getImagen();
        }
        
        btnGuardare.setIcon(new ImageIcon("img/iconos/guardar.png"));
        btnSalir.setIcon(new ImageIcon("img/iconos/cancelar.png"));
        
        btnAgregarImg.setIcon(new ImageIcon("img/iconos/agregarImg.png"));
        btnQuitar.setIcon(new ImageIcon("img/iconos/quitarImg.png"));
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        btnAgregarImg = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnGuardare = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPosicion = new javax.swing.JComboBox<>();
        txtEdad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregarImg.setText("Agregar Imagen");
        btnAgregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImgActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Jugador:");

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardare.setText("Guardar Cambios");
        btnGuardare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardareActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar Imagen");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel3.setText("Posición:");

        jLabel4.setText("Edad:");

        cbPosicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquero", "Defensa", "Volante", "Delantero" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardare, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(cbPosicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEdad)
                                        .addGap(129, 129, 129))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardare, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImgActionPerformed
        JFileChooser file=new JFileChooser();
        FileNameExtensionFilter filtrado= new FileNameExtensionFilter("JGP, PNG y GIF", "jpg","png","gif");
        file.setFileFilter(filtrado);
        int resp= file.showOpenDialog(this);

        if(resp==JFileChooser.APPROVE_OPTION){
            ruta= file.getSelectedFile().getPath();
            ImageIcon imagen=new ImageIcon(ruta);
            lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
        }
    }//GEN-LAST:event_btnAgregarImgActionPerformed

    private void btnGuardareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardareActionPerformed
        try{
            String nombre=txtNombre.getText();   
            String edad=txtEdad.getText();
            int posicion=cbPosicion.getSelectedIndex();
            String msj="";
            String nuevaRuta;
            DAOJugador daoJugador= new DAOJugadorImpl();

            if(ruta.equals("")) msj+="Falta agregar Imagen\n";
            if(nombre.equals("")) msj+="Falta agregar nombre del jugador\n";
            if(edad.equals("")) msj+="Falta ingresar edad\n";
            if(posicion<0) msj+="Falta seleccionar posición\n";
            
            
            if(msj.equals("")){
                File archivo_imagen=new File(ruta);
                BufferedImage imagen=ImageIO.read(archivo_imagen);
                nuevaRuta="img/jugadores/"+pais.getIdPais()+cod+".png";
                ImageIO.write(imagen, "png", new File(nuevaRuta));

                if(jugador==null){//agregar
                    if(daoJugador.registrar(new Jugador(pais.getIdPais(),cod,nombre,cbPosicion.getSelectedItem().toString(),Integer.parseInt(edad),nuevaRuta))){
                        JOptionPane.showMessageDialog(null, "Jugador registrado","Registrar Jugador",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al registrar jugador","Registrar Jugador",JOptionPane.WARNING_MESSAGE);
                    }
                }else{//actualizar
                    if(daoJugador.modificar(new Jugador(jugador.getCodJugador(),pais.getIdPais(),cod,nombre,cbPosicion.getSelectedItem().toString(),Integer.parseInt(edad),nuevaRuta))){
                        JOptionPane.showMessageDialog(null, "Jugador actualizado","Modificar Jugador",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al actualizar jugador","Modificar Jugador",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, msj,"Jugador",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardareActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        lblImagen.setIcon(new ImageIcon(""));
        ruta="";
    }//GEN-LAST:event_btnQuitarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImg;
    private javax.swing.JButton btnGuardare;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbPosicion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
