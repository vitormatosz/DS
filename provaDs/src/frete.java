import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class frete {
    public void calcular() {
        JFrame janela = new JFrame();
        janela.setSize(300, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painel = new JPanel();
        painel.setSize(200, 400);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setLayout(new GridLayout(10, 10, 10, 10));
        painel.setBorder(new EmptyBorder(40, 10, 0, 10)); 
        
        JLabel ldist = new JLabel();
        ldist.setText("Distancia (Km)");
        JTextField rdist = new JTextField(10);

        JLabel lpeso = new JLabel();
        lpeso.setText("Peso (Kg)");
        JTextField rpeso = new JTextField(10);
        

        JLabel lenvio = new JLabel();
        lenvio.setText("Envio (Expresso ou Padrão)");
        JTextField renvio = new JTextField(10);
       

        JButton btn = new JButton("Calcular");

        JLabel mensage = new JLabel();

        btn.addActionListener(e -> {
            String distancia = rdist.getText();
            String peso = rpeso.getText();
            String envio = renvio.getText();

            double base = 10.00;
            double kmrod = (Double.parseDouble(distancia) * 0.50);

            double vfinal = kmrod + base;

            if (Double.parseDouble(peso) >= 20.00) {
                vfinal += 30;
            }

            if (envio.equalsIgnoreCase("expresso")) {
                double taxa = vfinal * 0.2;
                vfinal += taxa;
            }

            mensage.setText("Resultado: R$ " + vfinal);

        });

        painel.add(ldist);
        painel.add(rdist);

        painel.add(lpeso);
        painel.add(rpeso);

        painel.add(lenvio);
        painel.add(renvio);

        painel.add(btn);

        painel.add(mensage);

        janela.add(painel);

        janela.setVisible(true);
        
    }
    
}
