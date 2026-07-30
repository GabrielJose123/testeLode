package layout;

import models.Peca;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class EstoqueLayout {

    public static void mostrar(List<Peca> pecas) {
        String[] colunas = {"ID", "Nome", "Quantidade", "Preco Unitario", "Valor Total"};
        Object[][] linhas = new Object[pecas.size()][5];
        double totalEstoque = 0;
        int indiceMaiorValor = 0;

        for (int i = 0; i < pecas.size(); i++) {
            Peca peca = pecas.get(i);
            double valorTotal = peca.getValorTotalEmEstoque();
            totalEstoque += valorTotal;
            if (valorTotal > pecas.get(indiceMaiorValor).getValorTotalEmEstoque()) {
                indiceMaiorValor = i;
            }

            linhas[i] = new Object[]{
                peca.getId(), peca.getNome(), peca.getQuantidade(),
                formatarReais(peca.getPrecoUnitario()), formatarReais(valorTotal)
            };
        }

        JTable tabela = new JTable(linhas, colunas);
        tabela.setDefaultRenderer(Object.class, destacarLinha(indiceMaiorValor));

        JLabel rodape = new JLabel(" Total do estoque: " + formatarReais(totalEstoque)
            + "  |  Item de maior valor: " + pecas.get(indiceMaiorValor).getNome());

        JFrame janela = new JFrame("Controle de Estoque");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new JScrollPane(tabela), BorderLayout.CENTER);
        janela.add(rodape, BorderLayout.SOUTH);
        janela.setSize(800, 400);
        janela.setVisible(true);
    }

    private static String formatarReais(double valor) {
        return String.format("R$ %.2f", valor);
    }

    private static DefaultTableCellRenderer destacarLinha(int linhaDestacada) {
        return new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable tabela, Object valor, boolean selecionado, boolean focado, int linha, int coluna) {
                Component celula = super.getTableCellRendererComponent(tabela, valor, selecionado, focado, linha, coluna);
                boolean ehLinhaDestacada = linha == linhaDestacada;
                celula.setBackground(ehLinhaDestacada ? new Color(255, 236, 150) : Color.WHITE);
                celula.setFont(celula.getFont().deriveFont(ehLinhaDestacada ? Font.BOLD : Font.PLAIN));
                return celula;
            }
        };
    }
}
