package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;

import com.devsuperior.dslist.exceptionhandler.GameListNotFoundException;
import com.devsuperior.dslist.exceptionhandler.GameNotFoundException;
import com.devsuperior.dslist.mapper.GameMapper;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    // -------------------------------------------------------------------------
    @Transactional(readOnly = true)
    public GameList findById(Long id) {
       return gameListRepository.findById(id)
               .orElseThrow(GameListNotFoundException::new);
    }

    // -------------------------------------------------------------------------
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return GameMapper.INSTANCE.toListGameListDTO(result);
    }

    // -------------------------------------------------------------------------
   @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
