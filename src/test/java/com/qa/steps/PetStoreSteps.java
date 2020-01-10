package com.qa.steps;

import com.qa.pages.AccountPage;
import com.qa.pages.BasePage;
import com.qa.pages.DashBoardPage;
import com.qa.pages.HelpPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.utils.PetCategories;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PetStoreSteps extends ScenarioSteps{

	BasePage basePage;
	LoginPage login;
	AccountPage account;
	DashBoardPage dashBoard;
	ProductsPage prodcuts;
	
	/****************************************************************************************************
	 * 
	 * 
	 * 							BASE PAGE STEPS
	 * 
	 * 
	 ****************************************************************************************************/
	
	
	@Step("Sign out from the store")
	public DashBoardPage signOut(){
		return basePage.signOut();
	}
	
	@Step("Navigating to Login Page")
	public LoginPage navigateToLoginPage(){
		return basePage.navigateToSignOnPage();
	}
	
	@Step("Nvigating to products page by clicking on: {0} link on header")
	public ProductsPage navigateToProductCategory(PetCategories productCategory){
		return basePage.navigateToProductCategory(productCategory);
	}
	
	@Step("Nvigating to products page by clicking on shopping cart")
	public ProductsPage navigateToShoppingCartPage(){
		return basePage.nvigateToShoppingCart();
	}
	
	@Step("Nvigating to Help Page")
	public HelpPage navigateToHelpPage(){
		return basePage.nvigateToHelpPage();
	}
	
	@Step("Clicking on Company Logo Navigating to the DashBoard ")
	public DashBoardPage navigateToDashBoard(){
		return basePage.navigateToDashBoard();
	}
	
	@Step("Navigating to My Account Page")
	public AccountPage navigateToMyAccountPage(){
		return basePage.navigateToAccountPage();
	}
	
	@Step("Searching for product: {0}")
	public ProductsPage searchForProduct(String productName){
		return basePage.searchForProducts(productName);
	}
	
	
	/****************************************************************************************************
	 * 
	 * 
	 * 							LOGIN PAGE STEPS
	 * 
	 * 
	 ****************************************************************************************************/
	
	
	@Step("Gettting Invalid Login Message")
	public String getMessageOnInvalidLogin(){
		return login.getMessageOnInvalidLogin();
	}
	
	@Step("Navigating to Account Registration Page")
	public AccountPage navigateToAccountRegistrationPage(){
		return login.navigateToAccountPage();
	}
	
	@Step("Logging into pet application with userName:{0} and password:{1}")
	public DashBoardPage doLogin(String userName, String password){
		return login.doLogin(userName, password);
	}
	

	/****************************************************************************************************
	 * 
	 * 
	 * 							ACCOUNT PAGE STEPS
	 * 
	 * 
	 ****************************************************************************************************/
	
	@Step("Adding new User information with userName: {0} ,password: {1} , repeatPassword: {2}")
	public AccountPage addNewUserInformation(String userName,String password, String repPassword){
		return account.addNewUserInformation(userName, password, repPassword);
	}
	
	@Step("Adding Account information with firstname:{0} , lastName:{1}," +
		 " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, "  +
		 "state:{7}, zip:{8}, country:{9} ")
	public AccountPage addAccountInformation(String fName,String lName,String email,String phone,
			String address1,String address2,String city,String state,String zip,String country){
		
		return account.addAccountInformation(fName, lName, email, phone, 
				address1, address2, city, state, zip, country);
	}
	
	@Step("Adding Profile information language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
	public AccountPage addProfileInformation(String language, String category, boolean myList, boolean myBanner){
		return account.addProfileInformation(language, category, myList, myBanner);
	}
	
	@Step("Saving Account information")
	public DashBoardPage clickSaveAccountInformation(){
		return account.clickSaveAccountInformation();
	}
	
	/****************************************************************************************************
	 * 
	 * 
	 * 							DASHBOARD PAGE STEPS
	 * 
	 * 
	 ****************************************************************************************************/
	
	@Step("Getting the greeting message")
	public String getGreetingMessage(){
		return dashBoard.getGreetingMessage();
	}
	
	@Step("Selecting {0} petcategory from center display")
	public ProductsPage selectProductFromCenterDisplay(PetCategories petCategories){
		return dashBoard.selectProductsFromCenterImage(petCategories);
	}
	
	@Step("Selecting {0} petcategory from side bar display")
	public ProductsPage selectProductFromSideBarDisplay(PetCategories petCategories){
		return dashBoard.selectProductsFromSideBar(petCategories);
	}
	
	/****************************************************************************************************
	 * 
	 * 
	 * 							PRODUCTS PAGE STEPS
	 * 
	 * 
	 ****************************************************************************************************/
	
	@Step("Selecting a Pet with pet category {0} and pet name {1}")
	public ProductsPage selectPetByName(PetCategories petCategory, String petName){
		return prodcuts.selectPetByName(petCategory, petName);
	}
}
