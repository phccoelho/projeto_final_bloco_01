package eletronica_java.repository;

import eletronica_java.model.Produto;

public interface ProdutoRepository {
	
	
	public void procurarPorId(int id);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);
	
	
}
