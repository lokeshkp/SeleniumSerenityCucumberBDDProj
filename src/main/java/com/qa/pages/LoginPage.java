package com.qa.pages;

public class LoginPage extends BasePage {

	private static final String USER_NAME 			= "//input[@name='username']";
	private static final String PASSWORD 			= "//input[@name='password']";
	private static final String lOGIN_BUTTON 		= "//input[@name='signon']";
	private static final String REGISTER_NOW 		= "//a[text()='Register Now!']";
	private static final String INVALID_LOGIN_LAB	= "//li[contains(text(),'Invalid ')]";
	
	
	/**
	 *  Method used for login to the pet store application
	 * @param userName
	 * @param password
	 * @return
	 */
	public DashBoardPage doLogin(String userName, String password){
		//waitForTextToAppear("Please enter your username and password.");
		//waitForTextToAppear("Need a user name and password?");
		
		waitFor(USER_NAME).$(USER_NAME).typeAndTab(userName);
		waitFor(PASSWORD).$(PASSWORD).type(password);
		waitFor(lOGIN_BUTTON).$(lOGIN_BUTTON).click();
		return this.switchToPage(DashBoardPage.class);
	}

	/***
	 *  Method used to navigate Registration Page
	 * @return
	 */
	public AccountPage navigateToRegistrationPage(){
		waitForTextToAppear("Please enter your username and password.");
		waitForTextToAppear("Need a user name and password?");
		
		waitFor(REGISTER_NOW).$(REGISTER_NOW).click();
		return this.switchToPage(AccountPage.class);
	}
	
	/**
	 * Method used to checking invalid login message
	 * @return
	 */
	public String getMessageOnInvalidLogin(){
		return waitFor(INVALID_LOGIN_LAB).$(INVALID_LOGIN_LAB).getText();
	}
}
