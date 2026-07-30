package models;

public class Peca {
    private final int id;
    private final String nome;
    private final int quantidade;
    private final double precoUnitario;

    public Peca(int id, String nome, int quantidade, double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getValorTotalEmEstoque() {
        return quantidade * precoUnitario;
    }
}
