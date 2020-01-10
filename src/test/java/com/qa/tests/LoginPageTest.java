package com.qa.tests;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginPageTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps petStore;
	
	@Title("Verify If user can Login successfully to the store with valid credentials")
	@Test
	public void verifyIfloginSuccessful(){
		petStore.navigateToLoginPage();
		petStore.doLogin("test", "test");
		String gretMsg = petStore.getGreetingMessage();
		assertEquals("Welcome test!", gretMsg);
	}
	
	@Title("Verify If user can Logout successfully from the store with valid credentials")
	@Test
	public void verifyIflogoutSuccessful(){
		petStore.navigateToLoginPage();
		petStore.doLogin("test", "test");
		petStore.signOut();
	}

	@Title("Verify if mesaage <b><i> invlid Username or password. Signon failed </b></i> is displayed for")
	@Test
	public void verifyIfMessageIsDisplayedForInvalidUser(){
		petStore.navigateToLoginPage();
		petStore.doLogin("abc", "test");
		String errMsg = petStore.getMessageOnInvalidLogin();
		assertEquals("Invalid username or password. Signon failed.", errMsg);
	}
	
	@AfterAll
	public void tearDown(){
		System.gc();
	}
}
