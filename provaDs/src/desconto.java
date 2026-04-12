import javax.swing.*;
import java.awt.*;

public class desconto {
    public void calcDesconto(){
    JFrame janela = new JFrame("Sistemas de Vendas 'Black Friday'");
        janela.setSize(450, 450);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painel = new JPanel(new GridLayout(9, 1, 5, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel Lvalor = new JLabel();
        Lvalor.setText("Valor da Compra");
        Lvalor.setForeground(Color.WHITE);
        Lvalor.setFont(new Font("", Font.BOLD, 15));

        JTextField Rvalor = new JTextField(10);
        Rvalor.setBorder(null);

        JLabel Lcupom = new JLabel();
        Lcupom.setText("Código do Cupom");
        Lcupom.setForeground(Color.WHITE);
        Lcupom.setFont(new Font("", Font.BOLD, 15));

        JTextField Rcupom = new JTextField(10);
        Rcupom.setBorder(null);

        JButton btn = new JButton("Calcular");
        btn.setBackground(new Color(51, 112, 166));
        btn.setForeground(Color.WHITE);
        btn.setBorder(null);
        
        JLabel valor = new JLabel();
        JLabel desconto = new JLabel();
        JLabel vfinal = new JLabel();

        valor.setFont(new Font("", Font.BOLD, 16));
        desconto.setFont(new Font("", Font.BOLD, 16));
        vfinal.setFont(new Font("", Font.BOLD, 16));

        valor.setHorizontalAlignment(valor.CENTER);
        desconto.setHorizontalAlignment(desconto.CENTER);
        vfinal.setHorizontalAlignment(desconto.CENTER);

        valor.setForeground(Color.WHITE);
        desconto.setForeground(Color.WHITE);
        vfinal.setForeground(Color.WHITE);

        btn.addActionListener(e -> {
            double vl = Double.parseDouble(Rvalor.getText());
            double vfixo = Double.parseDouble(Rvalor.getText());
            String cp = Rcupom.getText();
            double desc = 0;

            if(vl >= 500.00){
                desc = vl *0.1;
                vl -= desc;
            }
            if (cp.equals("AMIGAO10")) {
                desc += 10;
                vl -= 10.00;
            }

            valor.setText("Valor Original: R$ "+vfixo);
            desconto.setText("Desconto Aplicado: R$ "+desc);
            vfinal.setText("Valor final "+vl);


        });

        janela.add(painel);

        painel.add(Lvalor);
        painel.add(Rvalor);

        painel.add(Lcupom);
        painel.add(Rcupom);

        painel.add(btn);
        painel.add(valor);
        painel.add(desconto);
        painel.add(vfinal);

        painel.setBackground(new Color(139, 180, 217));

        janela.setVisible(true);

}
}