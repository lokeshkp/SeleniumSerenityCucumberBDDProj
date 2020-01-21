package com.qa.cucumber.steps;

import java.util.List;

import com.qa.cucumber.steps.serenity.PetStoreSteps;
import com.qa.utils.PetCategories;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdersSteps {

	@Steps
	PetStoreSteps shopper;


	@Given("^I login to the application with valid (.*) and (.*)$")
	public void i_login_to_the_application_with_valid_test_and_test(String userName, String password) {
		shopper.navigateToLoginPage();
		shopper.doLogin(userName, password);
	}

	@When("^I search for a (.*) it must show up in the search results$")
	public void i_search_for_a_Bulldog_it_must_show_up_in_the_search_results(String petType) {
		shopper.searchForProduct(petType);
		shopper.selectProductFromSearchTable(petType);
	}
	
	@When("^I view details about the pet (>*)and add it to cart$")
	public void i_view_details_about_the_pet_Male_Adult_Bulldog_and_add_it_to_cart(String pet) {
		shopper.addCartSpecificProduct(pet);
	}

	@When("^I proceed to checkout$")
	public void i_proceed_to_checkout() {
		shopper.clickOnProceedToCheckout();
	}

	@When("^I enter my payment details (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void i_enter_my_payment_details_Visa_Lokesh_KP_Wdrive_Mobile_AP_India(String cardType, String cardNumber, String expiryDate, String firstname,
			String lastname, String addr1, String addr2, String city, String state, String zip, String country) {
		shopper.enterPaymentAndBillingDetails(cardType, cardNumber, expiryDate, firstname, lastname, addr1, addr2, city, state, zip, country);
	}

	@When("^I click on Continue$")
	public void i_click_on_Continue() {
		shopper.clickOnContinueBtn();
	}

	@When("^I Submit the order, the store must provide me a confirmation message on the place order$")
	public void i_Submit_the_order_the_store_must_provide_me_a_confirmation_message_on_the_place_order() {
		shopper.clickOnConfirmBtn();
		shopper.verifyIfOrderSubmitted();
	}

	@When("^I view details about the pet (.+) and add it to cart$")
	public void i_view_details_about_the_pet_Female_Puupy_Bulldog_and_add_it_to_cart(String pet) {
		shopper.addCartSpecificProduct(pet);
	}

	@When("^I enter my payment details$")
	public void i_enter_my_payment_details_Visa_Lokesh_KP_Wdrive_Mobile_KA_India(DataTable arg1) {
		List<String> searchVal =  arg1.asList(String.class);

		for( String s : searchVal ) {
			shopper.navigateToProductCategory(PetCategories.valueOf(s));
		}
	}
	

	@When("^I click on a category, then a category is displayed$")
	public void i_click_on_a_category_then_a_category_is_displayed(DataTable arg1) {
		
		List<String> searchVal =  arg1.asList(String.class);

		for( String s : searchVal ) {
			shopper.navigateToProductCategory(PetCategories.valueOf(s));
		}
		
	}
}
