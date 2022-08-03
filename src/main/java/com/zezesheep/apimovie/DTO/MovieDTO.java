package com.zezesheep.apimovie.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MovieDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal earnings;

}
