package com.qa.pages;

import com.qa.utils.PetCategories;
import net.thucydides.core.annotations.findby.By;

//Static Imports for Table
import static net.thucydides.core.matchers.BeanMatchers.*;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

	private static String PROD_TABLE = "//div[@id='Catalog']/table";
	private static final String PRODUCT_TABLE = "//*[@id='Catalog']//table";
	private static final String ANCHOR = "//*[@id='Catalog']//table//td[normalize-space() = '";
	private static final String PROCEED_TO_CHECKOUT = "//a[contains(text(),'Proceed to Checkout')]";
	
	
	/**
	 *   Selecting the pet by providing a name
	 * @param petCategories
	 * @param petName
	 * @return
	 */
	public ProductsPage selectPetByName(PetCategories petCategories, String petName){
		waitForTextToAppear(petCategories.getValue());
		List<WebElement> rows = inTable( $(PROD_TABLE)).filterRows(the("Name", equalTo(petName)));
		rows.get(0).findElement(By.tagName("a")).click();
		return this;
	}
	
	
	/**
	 *  This method will add a pet to the shopping cart
	 * @param prodName
	 * @return
	 */
	public ProductsPage addCartSpecificProduct(String prodName){
		
		String addToCart = "//*[@id='Catalog']//table//td[normalize-space()='"+prodName+"']//parent::tr//a[contains(text(),'Add to Cart')]";
		waitFor(addToCart).$(addToCart).click();
		return this;
	}
	
	/**
	 *  Add an Item to the cart by viewing details of the pet
	 * @return
	 */
	public ProductsPage addToCartByViewingItemDetails(String specificProduct, String ...details){
		String viewItemLink = "//*[@id='Catalog']//table//td[normalize-space()='"+specificProduct+"']//parent::tr//a[contains(@href,'viewItem')]";
		waitFor(viewItemLink).$(viewItemLink).click();
		$("//a[@class='Button']").click();
		return this;
	}
	
	/**
	 * Selecting a product from the search results
	 * 
	 * @param productName
	 * @return
	 */
	public ProductsPage selectProductFromSearchTable( String productName) {
		
		String searchResultP1 = "']//parent::tr//img//parent::a";	
		String searchResultLink =  ANCHOR + productName + searchResultP1;
		waitFor(searchResultLink).$(searchResultLink).click();
		return this;
	}
	

	/**
	 * Click on proceed to checkout
	 * 
	 * @return
	 */
	public OrdersPage clickOnProceedToCheckout() {
		
		waitFor(PROCEED_TO_CHECKOUT).$(PROCEED_TO_CHECKOUT).click();
		return this.switchToPage(OrdersPage.class);
	}
}
