package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongingPK id = new BelongingPK();
	
	private Integer position;

	public Belonging() {
	}

	public Belonging(Game game, GameList list, Integer position) {
		id.setGame(game);
		id.setGameList(list);
		this.position = position;
	}

}
