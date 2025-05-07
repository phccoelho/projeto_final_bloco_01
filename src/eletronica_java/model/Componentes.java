package eletronica_java.model;

public class Componentes extends Produto{
	
	private String categoria;
	private String material;
	
	public Componentes(int codigo, String nome, int tipo, float preco, int quantidade, String categoria,
			String material) {
		super(codigo, nome, tipo, preco, quantidade);
		this.categoria = categoria;
		this.material = material;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria do componente: " + this.categoria);
		System.out.println("Material do componente: " + this.material);
	}
	
	
	
}
