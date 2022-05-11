package com.lojaGames.lojaGames.Controller;

import java.util.List;

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

import com.lojaGames.lojaGames.model.CategoriaGame;
import com.lojaGames.lojaGames.repository.CategoriaGameRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaGameController {
	
	
	@Autowired
	private CategoriaGameRepository categoriaGameRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaGame>> getAll(){
	return ResponseEntity.ok(categoriaGameRepository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaGame> getById(@PathVariable Long id){
		return categoriaGameRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/categoria/{descricao}")
	public ResponseEntity<List<CategoriaGame>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriaGameRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
    public ResponseEntity<CategoriaGame>post(@Valid @RequestBody CategoriaGame descricao){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaGameRepository.save(descricao));
        }
	
	@PutMapping
    public ResponseEntity<CategoriaGame> put(@Valid @RequestBody CategoriaGame descricao){
        return categoriaGameRepository.findById(descricao.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(categoriaGameRepository.save(descricao)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        
	}
		
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		java.util.Optional<CategoriaGame> categoria = categoriaGameRepository.findById(id);
		
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		categoriaGameRepository.deleteById(id);
	}
}
