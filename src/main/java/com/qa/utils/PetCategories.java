package com.qa.utils;

public enum PetCategories {

	FISH ("Fish"),
	CATS ("Cats"),
	DOGS ("Dogs"),
	REPTILES ("Reptiles"),
	BIRDS ("Birds");
	
	private String prodCategories;
	
	private PetCategories(String prodCategories) {
		this.prodCategories=prodCategories;
	}
	
	public String getValue(){
		return prodCategories;
	}
}
