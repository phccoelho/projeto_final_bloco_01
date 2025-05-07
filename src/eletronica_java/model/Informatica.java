package eletronica_java.model;

public class Informatica extends Produto{
	
	private String modelo;
	private String fabricante;
	
	public Informatica(int codigo, String nome, int tipo, float preco, int quantidade, String modelo,
			String fabricante) {
		super(codigo, nome, tipo, preco, quantidade);
		this.modelo = modelo;
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Modelo do Produto: " + this.modelo);
		System.out.println("Fabricante do Produto: " + this.fabricante);
	}
	
}
