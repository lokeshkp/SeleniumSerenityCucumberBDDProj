package com.qa.pages;

import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage{

	// User Information
	private static final String USER_ID 					= "//input[@name='username']";
	private static final String NEW_PASSWORD 				= "//input[@name='password']";
	private static final String REP_PASSWORD 				= "//input[@name='repeatedPassword']";

	// Account Information
	private static final String FIRST_NAME 					= "//input[@name='account.firstName']";
	private static final String LAST_NAME 					= "//input[@name='account.lastName']";
	private static final String EMAIL	 					= "//input[@name='account.email']";
	private static final String PHONE	 					= "//input[@name='account.phone']";
	private static final String ADD1 						= "//input[@name='account.address1']";
	private static final String ADD2 						= "//input[@name='account.address2']";
	private static final String CITY 						= "//input[@name='account.city']";
	private static final String STATE 						= "//input[@name='account.state']";
	private static final String ZIP 						= "//input[@name='account.zip']";
	private static final String COUNTRY 					= "//input[@name='account.country']";
	
	// Profile Information
	private static final String LANG_PREF_DROP 				= "//select[@name='account.languagePreference']";
	private static final String FAVOURITE_CATE 				= "//select[@name='account.favouriteCategoryId']";
	private static final String MY_LIST_CHK					= "//input[@name='account.listOption']";
	private static final String MY_BANNER_CHK				= "//input[@name='account.bannerOption']";
	private static final String SAVE_ACCOUNT				= "//input[@name='newAccount']";

	
	/**
	 *   Adding New User Information
	 * @param userName
	 * @param password
	 * @param repPassword
	 * @return
	 */

	public AccountPage addNewUserInformation(String userName,String password, String repPassword){
		//waitFor("User Information");
		$(USER_ID).type(userName);
		$(NEW_PASSWORD).type(password);
		$(REP_PASSWORD).type(repPassword);
		return this;
	}
	
	/**
	 * 
	 * Adding New Account Information
	 */
	
	public AccountPage addAccountInformation(String fName,String lName,String email,String phone,
			String address1,String address2,String city,String state,String zip,String country){
		//waitFor("Account Information");
		$(FIRST_NAME).type(fName);
		$(LAST_NAME).type(lName);
		$(EMAIL).type(email);
		$(PHONE).type(phone);
		$(ADD1).type(address1);
		$(ADD2).type(address2);
		$(CITY).type(city);
		$(STATE).type(state);
		$(ZIP).type(zip);
		$(COUNTRY).type(country);
		return this;
	}
	

	/**
	 * 
	 * Adding New Profile Information
	 */
	public AccountPage addProfileInformation(String language, String category,boolean myList,boolean myBanner){
		//waitFor("Profile Information");
		$(LANG_PREF_DROP).selectByVisibleText(language);
		$(FAVOURITE_CATE).selectByVisibleText(category);
		
		setCheckbox($(MY_LIST_CHK),myList);
		setCheckbox($(MY_BANNER_CHK),myBanner);
		return this;
	}

	
	/***
	 * Saving Account Information
	 * @return
	 */
	public DashBoardPage clickSaveAccountInformation(){
		$(SAVE_ACCOUNT).click();
		return this.switchToPage(DashBoardPage.class);
	}

}
