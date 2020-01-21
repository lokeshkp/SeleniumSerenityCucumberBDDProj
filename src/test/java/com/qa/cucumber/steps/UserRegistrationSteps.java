package com.qa.cucumber.steps;

import static org.testng.Assert.assertEquals;

import com.github.javafaker.Faker;
import com.qa.cucumber.steps.serenity.PetStoreSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserRegistrationSteps {

	@Steps
	PetStoreSteps shopper;
	Faker faker = new Faker();

	@Given("I navigate to Registration Page")
	public void I_navigate_To_Registration_Page(){
		shopper.navigateToLoginPage();
		shopper.navigateToAccountRegistrationPage();
	}

	@And("I add a new user information")
	public void I_add_a_new_user_information(){
		
		String userName = "Lokesh"+faker.name().username();
		String password = faker.internet().password();
		String repPassword = password;
		
		Serenity.setSessionVariable("userName").to(userName);
		Serenity.setSessionVariable("password").to(password);

		shopper.addNewUserInformation(userName, password, repPassword);
	}


	@Given("^I add account information$")
	public void i_add_account_information() {
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phone = faker.phoneNumber().phoneNumber();
		String address1 = faker.address().buildingNumber();
		String address2 = faker.address().streetName();
		String city = faker.address().city();
		String state = faker.address().state();
		String zip = faker.address().zipCode();
		String country = faker.address().country();
		
		Serenity.setSessionVariable("fName").to(fName);

		shopper.addAccountInformation(fName, lName, email, phone, address1, address2, city, state, zip, country);
	}

	@Given("^I add profile information$")
	public void i_add_profile_information() {
		shopper.addProfileInformation("english", "DOGS", true, true);
	}

	@Given("^I save my information$")
	public void i_save_my_information() {
		shopper.clickSaveAccountInformation();
	}

	@When("^I login with my credentials$")
	public void i_login_with_my_credentials() {
		String userName = Serenity.sessionVariableCalled("userName");
		String password = Serenity.sessionVariableCalled("password");
		shopper.navigateToLoginPage();
		shopper.doLogin(userName, password);
	}

	@Then("^I must be able to view the welcome	greeting with my name$")
	public void i_must_be_able_to_view_the_welcome_greeting_with_my_name() {
		String gretMsg = shopper.getGreetingMessage();
		assertEquals("Welcome "+Serenity.sessionVariableCalled("fName").toString()+"!",gretMsg);
	}

}
