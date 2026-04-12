import javax.swing.*;
import java.awt.*;

public class filtro {
    public void calcDon() {
        JFrame janela = new JFrame("O 'Filtro de Streamer' (Calculo de Donates/Subs)");
        janela.setSize(400, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painel = new JPanel(new GridLayout(10, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input do Nivel atual
        JLabel Ldonates = new JLabel();
        Ldonates.setText("Valor Total de Donates");
        Ldonates.setForeground(Color.WHITE);
        Ldonates.setFont(new Font("", Font.BOLD, 13));

        JTextField Rdonates = new JTextField(10);
        Rdonates.setBorder(null);

        // Input do XP Acumulado
        JLabel Lsubs = new JLabel();
        Lsubs.setText("Número de Subs");
        Lsubs.setForeground(Color.WHITE);
        Lsubs.setFont(new Font("", Font.BOLD, 13));

        JTextField Rsubs = new JTextField(10);
        Rsubs.setBorder(null);

        // Select da dificuldade
        JLabel Lplat = new JLabel();
        Lplat.setText("Selecione a Plataforma");
        Lplat.setForeground(Color.WHITE);
        Lplat.setFont(new Font("", Font.BOLD, 13));
        JRadioButton youtube = new JRadioButton("YouTube");
        JRadioButton twitch = new JRadioButton("Twitch");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(youtube);
        grupo.add(twitch);

        youtube.setForeground(new Color(76, 30, 118));
        twitch.setForeground(new Color(76, 30, 118));

        JButton btn = new JButton("Calcular");

        btn.setBackground(new Color(76, 30, 118));
        btn.setForeground(Color.WHITE);
        btn.setBorder(null);

        JLabel resul = new JLabel();
        JLabel mensagem = new JLabel();

        resul.setFont(new Font("", Font.BOLD, 18));
        mensagem.setFont(new Font("", Font.BOLD, 18));

        resul.setHorizontalAlignment(resul.CENTER);
        mensagem.setHorizontalAlignment(mensagem.CENTER);

        resul.setForeground(Color.WHITE);
        mensagem.setForeground(Color.WHITE);

        btn.addActionListener(e -> {
            int subs = Integer.parseInt(Rsubs.getText());
            double donates = Double.parseDouble(Rdonates.getText());
            double donatesFinal = 0.00;

            boolean opY = false;
            boolean opT = false;

            if (youtube.isSelected()) {
                opY = true;
            } else if (twitch.isSelected()) {
                opT = true;
            }

            if (opT == true) {
                subs *= 0.5;
                donatesFinal = subs + donates;
            } else if (opY == true) {
                subs *= 0.3;
                donatesFinal = subs + donates;
            }

            if (donatesFinal < 100.00) {
                resul.setText("Valor Final: R$ " + donatesFinal);
                mensagem.setText("Saldo insuficiente para saque mínimo");
            } else if (donatesFinal >= 100.00) {
                resul.setText("Valor Final: R$ " + donatesFinal);
                mensagem.setText("");
            }

        });

        janela.add(painel);

        painel.add(Ldonates);
        painel.add(Rdonates);

        painel.add(Lsubs);
        painel.add(Rsubs);

        painel.add(Lplat);
        painel.add(youtube);
        painel.add(twitch);

        painel.add(btn);
        painel.add(resul);
        painel.add(mensagem);

        painel.setBackground(new Color(116, 67, 151));

        janela.setVisible(true);
    }
}
