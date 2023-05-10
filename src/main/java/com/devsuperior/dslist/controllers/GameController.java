package com.devsuperior.dslist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;

	// -------------------------------------------------------------------------
	@GetMapping
	public List<GameMinDTO> findAll() {
		return gameService.findAll();
	}

	// -------------------------------------------------------------------------
	 @GetMapping("/{id}")
	    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
	        return ResponseEntity.ok(new GameDTO(gameService.findById(id)));
	    }

}
