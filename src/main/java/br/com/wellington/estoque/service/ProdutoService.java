package br.com.wellington.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wellington.estoque.models.Produto;
import br.com.wellington.estoque.models.dto.ProdutoDTO;
import br.com.wellington.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(long id) {
		return produtoRepository.findById(id);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto save(ProdutoDTO dto) {
		return produtoRepository.save(new Produto(dto));
	}

	public void deleteById(long id) {
		produtoRepository.deleteById(id);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}
}
