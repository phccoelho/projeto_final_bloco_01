package eletronica_java.controller;

import java.util.ArrayList;
import java.util.Optional;

import eletronica_java.model.Produto;
import eletronica_java.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	// Criar a Collection ArrayList
		private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

		// Variável para controlar os números das produtos
		int codigo = 0;

		@Override
		public void procurarPorCodigo(int codigo) {

			Optional<Produto> produto = buscarNaCollection(codigo);

			if (produto.isPresent())
				produto.get().visualizar();
			else
				System.out.printf("\nO Produto número %d não foi encontrado", codigo);

		}

		@Override
		public void listarTodos() {
			for (var produto : listaProdutos) {
				produto.visualizar();
			}
		}

		@Override
		public void cadastrar(Produto produto) {
			listaProdutos.add(produto);
			System.out.println("O Produto foi criado com sucesso!");
		}

		@Override
		public void atualizar(Produto produto) {
			Optional<Produto> buscaProduto = buscarNaCollection(produto.getCodigo());

			if (buscaProduto.isPresent()) {
				listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
				System.out.printf("\nO Produto ID %d foi atualizado com sucesso!", produto.getCodigo());
			} else
				System.out.printf("\nO Produto ID %d não foi encontrado", produto.getCodigo());

		}

		@Override
		public void deletar(int codigo) {
			Optional<Produto> produto = buscarNaCollection(codigo);

			if (produto.isPresent()) {
				if (listaProdutos.remove(produto.get()) == true)
					System.out.printf("\nO Produto código %d foi excluído com sucesso!", codigo);
			} else
				System.out.printf("\nO Produto código %d não foi encontrado", codigo);

		}

		// Métodos Auxiliares

		public int gerarCodigo() {
			return ++codigo;
		}

		public Optional<Produto> buscarNaCollection(int codigo) {
			for (var produto : listaProdutos) {
				if (produto.getCodigo() == codigo)
					return Optional.of(produto);
			}

			return Optional.empty();
		}
		@Override
		public void vender(int codigo, int quantVendida) {
		    Optional<Produto> buscaProduto = buscarNaCollection(codigo);
		    //Verifica se existe o Produto ou não
		    if (buscaProduto.isPresent()) {
		        Produto produto = buscaProduto.get();
		        //Verifica se existe a quantidade vendida indicada
		        if (produto.getQuantidade() >= quantVendida) {
		            produto.setQuantidade(produto.getQuantidade() - quantVendida);
		            System.out.println("\nVenda realizada com sucesso!");
		        //Erro se a quantidade for menor que a vendida    
		        } else {
		            System.out.println("Estoque insuficiente!");		                   
		        }
		    } else {//Erro se não encontrar o código do produto
		        System.out.printf("\nProduto do código %d não encontrado.\n", codigo);
		    }
		
		}

}
