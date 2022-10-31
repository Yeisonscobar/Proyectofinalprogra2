
package vista;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.Album;
import modelo.Pais;


public class PaisLabel extends JLabel{
    private int cod;
    private Pais pais;
    private Album album;
    public PaisLabel(int cod,Pais pais,Album album,int x, int y){
        this.cod=cod;
        this.pais=pais;
        this.album=album;
        ImageIcon imagen=new ImageIcon((pais==null?"img/paises/pais.png":pais.getImg()));
        setIcon(new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        setBounds(x, y, 20, 20);

        addMouseListener(new MouseAdapter(){
                @Override
            public void mouseClicked(MouseEvent e) {
                accion(e);
            }
        });
    }
    
    private void accion(MouseEvent e){
        new DialogPais(null, true,pais,album,cod).setVisible(true);
    }
}
