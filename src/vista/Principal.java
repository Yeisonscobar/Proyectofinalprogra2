
package vista;

import dao.DAOAlbumImpl;
import dao.DAOJugadorImpl;
import dao.DAOPaisImpl;
import dao.DAOUsuarioImpl;
import interfaces.DAOAlbum;
import interfaces.DAOJugador;
import interfaces.DAOPais;
import interfaces.DAOUsuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Album;
import modelo.Jugador;
import modelo.Pais;
import modelo.Usuario;

public class Principal extends javax.swing.JFrame {
    private Usuario us;
    private Login l;
    private ArrayList<Album> albunes;
    public Principal(Usuario us, Login l) {
        initComponents();
        setSize(1200, 700);
        setResizable(false);
        //cargarBotones();
        this.us=us;
        this.l=l;
        cargarAlbum();
        
        btnActualizar.setIcon(new ImageIcon("img/iconos/recargar.png"));
        btnEditarUsuario.setIcon(new ImageIcon("img/iconos/editar.png"));
        btnEliminarUsuario.setIcon(new ImageIcon("img/iconos/eliminarUs.png"));
        btnNuevoAlbum.setIcon(new ImageIcon("img/iconos/nuevoAlbum.png"));
        btnEditarAlbum.setIcon(new ImageIcon("img/iconos/editarAlbum.png"));
        btnEliminarAlbum.setIcon(new ImageIcon("img/iconos/eliminarAlbum.png"));
        btnSalir.setIcon(new ImageIcon("img/iconos/cerrarSesion.png"));

    }
    
    private void cargarAlbum(){
        DAOAlbum daoAlumbum= new DAOAlbumImpl();
        DefaultComboBoxModel modelo= (DefaultComboBoxModel) cbAlbunes1.getModel();
        try{
            albunes=daoAlumbum.listar(us.getId());
            if(albunes!=null){
                for(int i=0;i<albunes.size(); i++){
                    modelo.addElement(albunes.get(i).getNombre()+" "+ albunes.get(i).getAnio());
                }
                cbAlbunes1.setModel(modelo);
            }
        }catch(Exception ex){
            
        } 
    }
    
    public void cargarBotones(){
        int x;
        int y=10;
        Color color;
        boolean encontrado=false, paisEncontrado=false;
        DAOPais daoPais= new DAOPaisImpl();
        DAOJugador daoJugador= new DAOJugadorImpl();
        try {
            ArrayList<Pais> paises= daoPais.listar(albunes.get(cbAlbunes1.getSelectedIndex()).getIdAlbum());
            
            for(int i=0; i<32; i++){
                x=60;
                encontrado=false;
                if(paises!=null){
                    for(int j=0; j<paises.size(); j++){
                        if(paises.get(j).getCodPais()==(i+1)){
                            encontrado=true;
                            panelFigura.add(new PaisLabel((i+1),paises.get(j),albunes.get(cbAlbunes1.getSelectedIndex()), 17, y+8));
                            
                            Pais pais=paises.get(j);
                            ArrayList<Jugador> jugadores= daoJugador.listar(pais.getIdPais());
                            for(int k=0; k<19; k++){
                                paisEncontrado=false;
                                for(int m=0; m<jugadores.size(); m++){
                                    if(jugadores.get(m).getCod()==(k+1)){
                                        paisEncontrado=true;
                                        if(jugadores.get(m).getPosicion().equalsIgnoreCase("delantero")) color= new Color(185,36,15);
                                        else if(jugadores.get(m).getPosicion().equalsIgnoreCase("arquero")) color= Color.BLACK;
                                        else if(jugadores.get(m).getPosicion().equalsIgnoreCase("defensa")) color= new Color(26,41,149);
                                        else color= new Color(147,30,153);
                                        panelFigura.add(new BotonFigura((k+1),pais,jugadores.get(m),color,Color.WHITE, pais.getAbrevPais()+(k+1),x , y));
                                        x+=45;
                                        break;
                                    }
                                }
                                
                                if(!paisEncontrado){
                                    panelFigura.add(new BotonFigura((k+1),pais,null,Color.WHITE,Color.BLACK, "-----",x , y));
                                    x+=45;
                                }
                            }
                            y+=35;
                            break;
                        }
                    }
                    
                    if(!encontrado){
                        panelFigura.add(new PaisLabel((i+1),null,albunes.get(cbAlbunes1.getSelectedIndex()), 17, y+8));
                        for(int j=0; j<19; j++){
                            panelFigura.add(new BotonFigura((j+1),null,null,Color.WHITE,Color.BLACK, "-----",x , y));
                            x+=45;
                        }
                        y+=35;
                    }
                }else{
                    panelFigura.add(new PaisLabel((i+1),null,albunes.get(cbAlbunes1.getSelectedIndex()), 17, y+8));
                }
            }
        } catch (Exception ex) {
            
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnNuevoAlbum = new javax.swing.JButton();
        cbAlbunes1 = new javax.swing.JComboBox<>();
        btnEliminarAlbum = new javax.swing.JButton();
        btnEditarAlbum = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelFigura = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir);
        btnSalir.setBounds(40, 600, 150, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        btnEditarUsuario.setText("Editar Usuario");
        btnEditarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 340, 220, 140);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Album"));

        btnNuevoAlbum.setText("Nuevo Album");
        btnNuevoAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlbumActionPerformed(evt);
            }
        });

        cbAlbunes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlbunes1ActionPerformed(evt);
            }
        });

        btnEliminarAlbum.setText("Eliminar Album");
        btnEliminarAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        btnEditarAlbum.setText("Editar Album");
        btnEditarAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlbunes1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnEliminarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditarAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevoAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(cbAlbunes1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 90, 220, 220);

        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar);
        btnActualizar.setBounds(180, 10, 40, 40);

        panelFigura.setBackground(new java.awt.Color(255, 255, 255));
        panelFigura.setPreferredSize(new java.awt.Dimension(300, 1150));
        panelFigura.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelFiguraLayout = new javax.swing.GroupLayout(panelFigura);
        panelFigura.setLayout(panelFiguraLayout);
        panelFiguraLayout.setHorizontalGroup(
            panelFiguraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        panelFiguraLayout.setVerticalGroup(
            panelFiguraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelFigura);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        l.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlbumActionPerformed
       if(cbAlbunes1.getSelectedIndex()<0) JOptionPane.showMessageDialog(null, "Seleccione album","Modificar Album",JOptionPane.INFORMATION_MESSAGE);
       else{
            new DialogEditarAlbum(this, true, albunes.get(cbAlbunes1.getSelectedIndex())).setVisible(true);
            albunes=null;
            DefaultComboBoxModel modelo= (DefaultComboBoxModel) cbAlbunes1.getModel();
            modelo.removeAllElements();
            cargarAlbum();
       }
    }//GEN-LAST:event_btnEditarAlbumActionPerformed

    private void btnEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlbumActionPerformed
        if(cbAlbunes1.getSelectedIndex()<0) JOptionPane.showMessageDialog(null, "Seleccione album","Eliminar Album",JOptionPane.INFORMATION_MESSAGE);
        else{
            int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el album?", "Eliminar Album", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(op==0){
                try{
                     DAOAlbum dAOAlbum= new DAOAlbumImpl();
                    if(dAOAlbum.eliminar(albunes.get(cbAlbunes1.getSelectedIndex()).getIdAlbum())){
                        JOptionPane.showMessageDialog(null, "Album Eliminado","Eliminar Album",JOptionPane.INFORMATION_MESSAGE);
                        albunes=null;
                        DefaultComboBoxModel modelo= (DefaultComboBoxModel) cbAlbunes1.getModel();
                        modelo.removeAllElements();
                        cargarAlbum();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido eliminar Album","Eliminar Album",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error\n"+ex.getMessage(),"Eliminar Album",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnNuevoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlbumActionPerformed
        new DialogNuevoAlbum(this, true, us.getId()).setVisible(true);
        albunes=null;
        DefaultComboBoxModel modelo= (DefaultComboBoxModel) cbAlbunes1.getModel();
        modelo.removeAllElements();
        cargarAlbum();
    }//GEN-LAST:event_btnNuevoAlbumActionPerformed

    private void cbAlbunes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlbunes1ActionPerformed
        if(cbAlbunes1.getSelectedIndex()>=0){
            //
            panelFigura.removeAll();
            panelFigura.repaint();
            cargarBotones();
        }
    }//GEN-LAST:event_cbAlbunes1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(cbAlbunes1.getSelectedIndex()>=0){
            //
            panelFigura.removeAll();
            panelFigura.repaint();
            cargarBotones();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar Usuario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(op==0){
            try {
                DAOUsuario daoUsuario= new DAOUsuarioImpl();
                if(daoUsuario.eliminar(us.getId())){
                    JOptionPane.showMessageDialog(null, "Usuario eliminado","Eliminar Usuario",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    l.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar usuario","Eliminar Usuario",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }     
        }        
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed

        try {
            new DialogUsuarioEditar(this, true, us).setVisible(true);
            DAOUsuario daoUs= new DAOUsuarioImpl();
            us=daoUs.obtenerUsuario(us.getId());
        } catch (Exception ex) {
        }  
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditarAlbum;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarAlbum;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnNuevoAlbum;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbAlbunes1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFigura;
    // End of variables declaration//GEN-END:variables
}
