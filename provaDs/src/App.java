import java.lang.classfile.instruction.SwitchCase;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String opcao = JOptionPane.showInputDialog(null,
                "Escolha uma opção: \n \n Opção 1 - O Simulador de Frete 'Logística Express' \n Opção 2 -  Sistemas de Vendas 'Black Friday' \n Opção 3 - O 'Calculador de XP' (Sistema de RPG/Games) \n Opção 4 - O 'Filtro de Streamer' (Calculo de Donates/Subs) \n \n");

        switch (opcao) {
            case "1":
                frete janelaFrete = new frete();
                janelaFrete.calcFrete();
                break;

            case "2":
                desconto janelaDesc = new desconto();
                janelaDesc.calcDesconto();
                break;

            case "3":
                xp janelaXp = new xp();
                janelaXp.calcXp();
                ;
                break;

            case "4":
                filtro janelaFiltro = new filtro();
                janelaFiltro.calcDon();
                break;

            default:
                break;
        }
    }
}
