import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Receitas extends JFrame{
    //private JFrame frame;

    public Receitas(){
        super("Interface");
        setSize(260, 260);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lTitulo = new JLabel("Receitas");
        lTitulo.setBounds(0, 0, 40, 40);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lTitulo);

        JButton BGerar = new JButton("Gerar");
        BGerar.setBounds(0, 120, 260, 20);
        add(BGerar);

        BGerar.addActionListener((ActionEvent e) ->{
            JOptionPane.showMessageDialog(null, "Gerando receita v1.0");
        });
    }

    

    public static void main(String[] args){
        Receitas windows = new Receitas();
    }
}