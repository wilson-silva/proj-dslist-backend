package com.devsuperior.dslist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
}
