package eletronica_java.repository;

import eletronica_java.model.Produto;

public interface ProdutoRepository {
	
	
	public void procurarPorCodigo(int codigo);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int codigo);
	
	
	
}
