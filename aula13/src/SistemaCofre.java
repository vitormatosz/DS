import javax.swing.*;
import java.awt.FlowLayout;

// ==========================================
// CLASSE COFRE (ALUNO DEVERÁ ENCAPSULAR)
// ==========================================
class Cofre {
    // ATENÇÃO: Atributos públicos são perigosos!
    private String senhaEstrutural;
    private double dinheiroInterno;
    private boolean estaAberto;

    public Cofre(String senhaInicial) {
        this.senhaEstrutural = senhaInicial;
        this.dinheiroInterno = 0.0;
        this.estaAberto = false;
    }

    public double getDinheiroInterno() {
        return dinheiroInterno;
    }

    public boolean isEstaAberto() {
        return estaAberto;
    }

    public void tentarAbrir(String senhaDigitada) {
        if (senhaEstrutural.equals(senhaDigitada)) {
            estaAberto = true;
        } else {
            estaAberto = false;
        }
    }

    public boolean depositar(double valor) {
        if (estaAberto == true && valor > 0) {
            dinheiroInterno += valor;
            return true;
        }

        return false;
    }
}

// ==========================================
// INTERFACE GRÁFICA (PRONTA)
// ==========================================
public class SistemaCofre extends JFrame {
    private Cofre meuCofre = new Cofre("1234"); // Senha padrão inicial

    public SistemaCofre() {
        super("Cofre Digital v1.0");
        setLayout(new FlowLayout());

        JTextField txtSenha = new JTextField(8);
        JTextField txtValor = new JTextField(6);
        JButton btnAbrir = new JButton("Tentar Abrir");
        JButton btnDepositar = new JButton("Colocar Dinheiro");
        JLabel lblStatus = new JLabel("Status: TRANCADO | Saldo: R$ 0.0");

        // Ação de Abrir
        btnAbrir.addActionListener(e -> {

            meuCofre.tentarAbrir(txtSenha.getText());

            // Modo atual: verifica se a senha está correta e se sim abre o cofre, se não exibe mensagem de aviso
            if (meuCofre.isEstaAberto()) {
                lblStatus.setText("Status: ABERTO | Saldo: R$ " + meuCofre.getDinheiroInterno());
            } else {
                JOptionPane.showMessageDialog(this, "Senha Incorreta!");
            }
        });

        // Ação de Depositar
        btnDepositar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtValor.getText());

                // Modo atual: verifica se o cofre está aberto e/ou e se o valor é maior que zero
                boolean tentativa = meuCofre.depositar(valor);

                if (tentativa == true) {

                lblStatus.setText("Status: Modificado | Saldo: R$ " + meuCofre.getDinheiroInterno());

                } else {
                    JOptionPane.showMessageDialog(null, "Cofre não está aberto e/ou valor é menor que zero");
                }
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido!");
            }
        });

        add(new JLabel("Senha:"));
        add(txtSenha);
        add(btnAbrir);
        add(new JLabel("Valor (R$):"));
        add(txtValor);
        add(btnDepositar);
        add(lblStatus);

        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new SistemaCofre().setVisible(true);
    }
}