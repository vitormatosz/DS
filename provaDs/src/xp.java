import javax.swing.*;
import java.awt.*;

public class xp {
    public void calcXp(){
        JFrame janela = new JFrame(" O 'Calculador de XP' (Sistema de RPG/Games)");
        janela.setSize(400, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painel = new JPanel(new GridLayout(9, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Input do Nivel atual
        JLabel Lnvatual = new JLabel();
        Lnvatual.setText("Nivel Atual");
        Lnvatual.setForeground(Color.WHITE);
        Lnvatual.setFont(new Font("", Font.BOLD, 13));

        JTextField Rnvatual = new JTextField(10);
        Rnvatual.setBorder(null);

        //Input do XP Acumulado
        JLabel Lxpacumu = new JLabel();
        Lxpacumu.setText("XP Acumulado");
        Lxpacumu.setForeground(Color.WHITE);
        Lxpacumu.setFont(new Font("", Font.BOLD, 13));

        JTextField Rxpacumu = new JTextField(10);
        Rxpacumu.setBorder(null);

        //Select da dificuldade
        String[] opcoes = {"Fácil", "Média", "Difícil"};
        JLabel Ldificul = new JLabel();
        Ldificul.setText("Dificuldade");
        Ldificul.setForeground(Color.WHITE);
        Ldificul.setFont(new Font("", Font.BOLD, 13));

        JComboBox<String> options = new JComboBox<>(opcoes);

        JButton btn = new JButton("Calcular");

        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setBorder(null);
        
        JLabel resul = new JLabel();
        JLabel nivel = new JLabel();

        resul.setFont(new Font("", Font.BOLD, 16));
        nivel.setFont(new Font("", Font.BOLD, 16));

        resul.setHorizontalAlignment(resul.CENTER);
        nivel.setHorizontalAlignment(nivel.CENTER);

        resul.setForeground(Color.WHITE);
        nivel.setForeground(Color.WHITE);

        btn.addActionListener(e -> {
            int nvatu = Integer.parseInt(Rnvatual.getText());
            double xpAcumulado = Double.parseDouble(Rxpacumu.getText());
            String op = (String) options.getSelectedItem();
            double base = 100.00;

            double xpFinal = base + xpAcumulado;

            if (op.equals("Média")) {
                xpFinal *= 1.5;
            } else if (op.equals("Difícil")) {
                xpFinal *= 2;
            }

            if (xpFinal <= 1000) {
                resul.setText("XP Acumulado: "+xpFinal);
                nivel.setText("Nivel: "+nvatu);
            } else if (xpFinal > 1000){
                resul.setText("XP Acumulado: "+xpFinal);
                nivel.setText("PARABÉNS! Você subiu para o nível "+(nvatu + 1));
            }

        });

        janela.add(painel);

        painel.add(Lnvatual);
        painel.add(Rnvatual);

        painel.add(Lxpacumu);
        painel.add(Rxpacumu);

        painel.add(Ldificul);
        painel.add(options);

        painel.add(btn);
        painel.add(resul);
        painel.add(nivel);

        painel.setBackground(Color.GRAY);

        janela.setVisible(true);

    }
}
