package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;

import com.devsuperior.dslist.exceptionhandler.GameNotFoundException;
import com.devsuperior.dslist.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	// -------------------------------------------------------------------------
	@Transactional(readOnly = true)
	public Game findById(Long id) {
		return gameRepository.findById(id)
				.orElseThrow(GameNotFoundException::new);

	}

	// -------------------------------------------------------------------------
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return GameMapper.INSTANCE.toListGameMinDTO(result);
	}

	// -------------------------------------------------------------------------
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		if(result.isEmpty()){
			throw new GameNotFoundException();
		}
		return GameMapper.INSTANCE.toListGameMinDTOProj(result);
	}

}
