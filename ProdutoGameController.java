package com.lojaGames.lojaGames.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lojaGames.lojaGames.model.ProdutoGame;
import com.lojaGames.lojaGames.repository.ProdutoGameRepository;




@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoGameController {

	
	@Autowired
	private ProdutoGameRepository produtoGameRepository;

	@GetMapping
	public ResponseEntity<List<ProdutoGame>> GetAll() {
		return ResponseEntity.ok(produtoGameRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoGame> getById(@PathVariable Long id){
		return produtoGameRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoGame>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoGameRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoGame> post(@Valid @RequestBody ProdutoGame produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoGameRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoGame> put(@Valid @RequestBody ProdutoGame produto){
		return produtoGameRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(produtoGameRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<ProdutoGame> produto = produtoGameRepository.findById(id);
		
		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtoGameRepository.deleteById(id);
	}
}
