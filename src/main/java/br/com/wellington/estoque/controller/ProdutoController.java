package br.com.wellington.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wellington.estoque.models.Produto;
import br.com.wellington.estoque.models.dto.ProdutoDTO;
import br.com.wellington.estoque.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/estoque")
@Api(value = "API RESTful de controle de estoque")
@ApiModel(description = "descricao da classe", parent = Produto.class, discriminator = "DISCRIMINATOR", reference = "REFERENCE", value = "VALUES")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@ApiOperation(value = "Recupera o catalodo de produto", notes = "Recupera todos os produtos do catalogo de produto", nickname = "retorna catalogo")
	@GetMapping("")
	public List<Produto> findAll() {
		return produtoService.findAll();
	}

	@ApiOperation(value = "Recupera um produto", notes = "Recupera um produto do catalogo referencia ao ID informado", nickname = "recupera produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "produto enviado com sucesso", response = Produto.class) })
	@GetMapping(value = "/{id}", headers = { "Accept=application/json" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto findById(@PathVariable(value = "id") long id) {
		return produtoService.findById(id);
	}

	@ApiOperation(value = "Modifica um produto", notes = "Altera os capos de um produto da tabela de produto", nickname = "Altera produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto atualizado com sucesso", response = Produto.class) })
	@PutMapping(headers = { "Accept=application/json" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto putProduto(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}

	@ApiOperation(value = "inclue um novo produto", notes = "Inclue um novo produto no catalogo de produto", nickname = "Inclue produto")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Produto incluido com sucesso", response = ProdutoDTO.class) })
	@PostMapping(headers = { "Accept=application/json" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto postProduto(@RequestBody ProdutoDTO produto) {
		return produtoService.save(produto);
	}

	@ApiOperation(value = "Deleta um produto através do ID", notes = "Deleta um produto do catalogo de produtos", nickname = "Deleta produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto deletado com sucesso", response = Produto.class) })
	@DeleteMapping(headers = { "Accept=application/json" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProduto(@RequestBody long id) {
		produtoService.deleteById(id);
	}

}
