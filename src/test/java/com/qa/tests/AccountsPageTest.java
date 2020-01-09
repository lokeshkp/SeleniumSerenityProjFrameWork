package com.qa.tests;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.qa.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccountsPageTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps petStore;
	
	@Title("Registering New Account")
	@Test
	public void addNewUserToStoreandVerify(){
		
		Faker faker = new Faker();
		String userName 	= "Lokesh"+faker.number().randomNumber(100,false);
		String password 	= faker.internet().password();
		String repPassword 	= password;
		String fName 		= faker.name().firstName();
		String lName 		= faker.name().lastName();
		String email 		= faker.internet().emailAddress();
		String phone 		= faker.phoneNumber().cellPhone();
		String address1		= faker.address().streetAddress();
		String address2		= faker.address().buildingNumber();
		String city 		= faker.address().city();
		String state		= faker.address().state();
		String zip			= faker.address().zipCode();
		String country		= faker.address().country();
		
		petStore.navigateToLoginPage();
		petStore.navigateToAccountRegistrationPage();
		petStore.addNewUserInformation(userName, password, repPassword);
		petStore.addAccountInformation(fName, lName, email, phone, address1, address2, city, state, zip, country);
		petStore.addProfileInformation("english", "DOGS", true, true);
		petStore.clickSaveAccountInformation();
		
		petStore.navigateToLoginPage();
		petStore.doLogin(userName, password);
		String gretMSg = petStore.getGreetingMessage();
		assertEquals("Welcome "+fName+"!", gretMSg);
	}
}
