package com.devsuperior.dslist.mapper;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    GameDTO toGameDTO(Game game);

    List<GameMinDTO> toListGameMinDTO(List<Game> games);

    List<GameMinDTO> toListGameMinDTOProj(List<GameMinProjection> games);

    List<GameListDTO> toListGameListDTO(List<GameList> games);

    GameListDTO toGameListDTO(GameList gameList);


}
