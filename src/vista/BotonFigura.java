
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Jugador;
import modelo.Pais;

public class BotonFigura extends JButton implements ActionListener{
    private int codigo;
    private Jugador jugador;
    private Pais pais;
    public BotonFigura(int codigo,Pais pais,Jugador jugador,Color color,Color color2, String nombre, int x, int y){
        this.codigo=codigo;
        this.pais=pais;
        this.jugador=jugador;
        setFont(new Font("Georgia",1,9));
        setSize(40, 30);
        setMargin(new Insets(0, 0, 0, 0));
        setBackground(color);
        setForeground(color2);
        setText(nombre);
        setLocation(x, y);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accion(e);
    }
    
    private void accion(ActionEvent e){
        if(pais!=null) new DialogFigura(null, true,jugador,pais,codigo).setVisible(true);
        else JOptionPane.showMessageDialog(null, "Ingrese primero país","Jugador",JOptionPane.WARNING_MESSAGE);
    }
    
}
