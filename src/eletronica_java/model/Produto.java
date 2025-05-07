package eletronica_java.model;

import java.text.NumberFormat;

public abstract class Produto {
		
	private int codigo;
	private String nome;
	private int tipo;
	private float preco;
	private int quantidade;
	
	public Produto(int codigo, String nome, int tipo, float preco, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
			case 1 -> tipo = "Componentes";
			case 2 -> tipo = "Informática";
			default -> tipo = "Inválido";
		}

		System.out.println("***************************************");
		System.out.println("DADOS DO PRODUTO                       ");
		System.out.println("***************************************");
		System.out.println("ID do Produto: " + this.codigo);
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("Tipo do Produto: " + tipo);
		System.out.println("Preço do Produto: " + nfMoeda.format(this.preco));
		System.out.println("Quantidade do Produto: " + this.quantidade);
		
	}
	
}
