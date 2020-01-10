package com.qa.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.PetStoreSteps;
import com.qa.utils.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class DashBoardPageTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps petStore;
	
	@Title("Accessing products from DashBoard Page")
	@Test
	public void verifyDashBoardProducts(){
		petStore.navigateToLoginPage();
		petStore.navigateToDashBoard();
		petStore.selectProductFromSideBarDisplay(PetCategories.FISH);
		petStore.navigateToDashBoard();
		petStore.selectProductFromCenterDisplay(PetCategories.DOGS);
	}
}
