package com.qa.pages;

import com.qa.utils.PetCategories;

public class DashBoardPage extends BasePage{

	private static final String GREETING_MSG 	= "//*[@id='WelcomeContent']";
	
	private static final String SIDEBAR_FISH_IMAGE		= "//div[@id='SidebarContent']/a[contains(@href, 'FISH')]";
	private static final String SIDEBAR_DOGS_IMAGE		= "//div[@id='SidebarContent']/a[contains(@href, 'DOGS')]";
	private static final String SIDEBAR_REPTILES_IMAGE	= "//div[@id='SidebarContent']/a[contains(@href, 'REPTILES')]";
	private static final String SIDEBAR_CATS_IMAGE		= "//div[@id='SidebarContent']/a[contains(@href, 'CATS')]";
	private static final String SIDEBAR_BIRDS_IMAGE		= "//div[@id='SidebarContent']/a[contains(@href, 'BIRDS')]";
	
	private static final String CENTER_IMAGE			= "//div[@id='MainImageContent'] area[href$='BIRDS']:nth-child(1)";
	private static final String FISH_IMAGE				= "//div[@id='MainImageContent']/map//area[@alt='Fish']";
	private static final String DOGS_IMAGE				= "//div[@id='MainImageContent']/map//area[@alt='Dogs']";
	private static final String REPTILES_IMAGE			= "//div[@id='MainImageContent']/map//area[@alt='Reptiles']";
	private static final String CATS_IMAGE				= "//div[@id='MainImageContent']/map//area[@alt='Cats']";
	private static final String BIRDS_IMAGE				= "//div[@id='MainImageContent']/map//area[@alt='Birds']";



	/**
	 *  Getting Greeting Message
	 * @return
	 */
	public String getGreetingMessage(){
		return waitFor(GREETING_MSG).$(GREETING_MSG).getText();
	}
	
	
	/**
	 *  Select pet category from sidebar
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromSideBar(PetCategories petCategories){
		
		switch(petCategories){
		
		case FISH:
			$(SIDEBAR_FISH_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
		
		case DOGS:
			$(SIDEBAR_DOGS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case REPTILES:
			$(SIDEBAR_REPTILES_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case CATS:
			$(SIDEBAR_CATS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case BIRDS:
			$(SIDEBAR_BIRDS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);

		default:
			break;
		}
		return null;
	}
	
	/**
	 *  Select pet category from center image
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromCenterImage(PetCategories petCategories){
		
		switch(petCategories){
		
		case FISH:
			$(FISH_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
		
		case DOGS:
			$(DOGS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case REPTILES:
			$(REPTILES_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case CATS:
			$(CATS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);
			
		case BIRDS:
			$(BIRDS_IMAGE).click();
			return this.switchToPage(ProductsPage.class);

		default:
			break;
		}
		return null;
	}

}
