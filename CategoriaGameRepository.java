package com.lojaGames.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lojaGames.lojaGames.model.CategoriaGame;


	

	@Repository
		public interface CategoriaGameRepository extends JpaRepository<CategoriaGame, Long>{
			public List<CategoriaGame> findAllByDescricaoContainingIgnoreCase (@Param("descricao")String descricao);
		}



