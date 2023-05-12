package com.devsuperior.dslist.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {

	private Long id;
	private String title;
	private Integer gameYear;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;


}
