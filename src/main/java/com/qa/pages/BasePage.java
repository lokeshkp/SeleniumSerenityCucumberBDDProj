package com.qa.pages;

import com.qa.utils.PetCategories;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject{

	private static final String JPET_STORE_LINK 	= "//a[text()='Enter the Store']";
	private static final String SIGN_IN_LINK 		= "//a[text()='Sign In']";
	private static final String LOGO_LINK 			= "//div[@id='LogoContent']";
	private static final String SIGN_OUT_LINK 		= "//div[@id='MenuContent']/a[contains(text(),'Sign Out')]";
	private static final String MY_ACC_LINK 		= "//a[contains(text(),'Register Now!')]";
	private static final String HELP_LINK 			=  "//*[id='MenuContent']/a[contains(text(),'?')]";
	private static final String SHOPPING_CART_LINK 	= "//*[id='MenuContent'] a[href$='?viewCart=']";
	private static final String SEARCH_INPUT 		= "//input[@name='keyword']"; 
	private static final String SEARCH_BUTTON 		= "//input[@name='searchProducts']"; 
	
	//Product Quick Links
	private static final String FISH_LINK 			= "//div[@id='QuickLinks']/a[contains(@href,'FISH')]";
	private static final String DOGS_LINK 			= "//div[@id='QuickLinks']/a[contains(@href,'DOGS')]"; 
	private static final String REPTILES_LINK 		= "//div[@id='QuickLinks']/a[contains(@href,'REPTILES')]";
	private static final String CATS_LINK 			= "//div[@id='QuickLinks']/a[contains(@href,'CATS')]"; 
	private static final String BIRDS_LINK 			= "//div[@id='QuickLinks']/a[contains(@href,'BIRDS')]"; 
	private static final String BANNER_IMG 			= "//*[@id='Banner']/img";

	
								
	/**
	 *  Method to Navigate to the SignOn Page
	 * 
	 */
	public LoginPage navigateToSignOnPage(){
		open();
		waitForTextToAppear("Welcome to JPetStore 6");
		waitFor(JPET_STORE_LINK).$(JPET_STORE_LINK).click();
		waitFor(SIGN_IN_LINK).$(SIGN_IN_LINK).click();
		return this.switchToPage(LoginPage.class);
	}
	
	/**
	 * 
	 * Click on the SignOn link
	 */
	public LoginPage clickSignOnLink(){
		waitFor(SIGN_IN_LINK).findBy(SIGN_IN_LINK).click();
		return this.switchToPage(LoginPage.class);
	}
	
	/**
	 * 
	 * SignOut form Store
	 */
	public DashBoardPage signOut(){
		waitFor(SIGN_OUT_LINK).$(SIGN_OUT_LINK).click();
		waitForAbsenceOf(SIGN_OUT_LINK).shouldNotBeVisible(By.xpath(SIGN_OUT_LINK));
		return(this.switchToPage(DashBoardPage.class));
	}
	
	public DashBoardPage navigateToDashBoard(){
		waitFor(LOGO_LINK).$(LOGO_LINK).click();
		return(this.switchToPage(DashBoardPage.class));
	}
	
	/**
	 * 
	 * Navigating to Account Page
	 */
	public AccountPage navigateToAccountPage(){
		waitFor(MY_ACC_LINK).$(MY_ACC_LINK).click();
		return(this.switchToPage(AccountPage.class));
	}
	
	/**
	 * 
	 * Search for Products
	 */
	public ProductsPage searchForProducts(String searchValue){
		waitFor(SEARCH_INPUT).$(SEARCH_INPUT).type(searchValue);
		waitFor(SEARCH_BUTTON).$(SEARCH_BUTTON).click();
		return(this.switchToPage(ProductsPage.class));
	}
	
	/**
	 * 
	 * Help Page
	 */
	public HelpPage nvigateToHelpPage(){
		waitFor(HELP_LINK).$(HELP_LINK).click();
		return(this.switchToPage(HelpPage.class));
	}
	
	/**
	 * 
	 * Click on Shopping Cart on the DashBoard
	 */
	public ProductsPage nvigateToShoppingCart(){
		waitFor(SHOPPING_CART_LINK).$(SHOPPING_CART_LINK).click();
		return(this.switchToPage(ProductsPage.class));
	}
	
	public ProductsPage navigateToProductCategory(PetCategories productCategory){
		
		switch(productCategory){
		
		case FISH:
			waitFor(FISH_LINK).$(FISH_LINK).click();
			return(this.switchToPage(ProductsPage.class));
			
		case DOGS:
			waitFor(DOGS_LINK).$(DOGS_LINK).click();
			return(this.switchToPage(ProductsPage.class));
		
		case REPTILES:
			waitFor(REPTILES_LINK).$(REPTILES_LINK).click();
			return(this.switchToPage(ProductsPage.class));
		
		case CATS:
			waitFor(CATS_LINK).$(CATS_LINK).click();
			return(this.switchToPage(ProductsPage.class));
			
		case BIRDS:
			waitFor(BIRDS_LINK).$(BIRDS_LINK).click();
			return(this.switchToPage(ProductsPage.class));
			
		default:
			break;
		}
		
		return null;
	}	

}
