package com.devsuperior.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_game")
@AllArgsConstructor
@NoArgsConstructor
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	private Integer gameYear;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(columnDefinition = "TEXT")
	private String longDescription;

}
