package com.qa.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class Sample {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps petShopper;
	
	@Title("Navigating to SignOn Page")
	@Test
	public void navigateToSignOn(){
		petShopper.navigateToLoginPage();
	}
}
