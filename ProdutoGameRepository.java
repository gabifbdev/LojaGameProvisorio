package com.lojaGames.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lojaGames.lojaGames.model.ProdutoGame;

	
	
	@Repository
	public interface ProdutoGameRepository extends JpaRepository<ProdutoGame, Long>{
			 List<ProdutoGame> findAllByNomeContainingIgnoreCase (@Param("nome")String nome);
}
