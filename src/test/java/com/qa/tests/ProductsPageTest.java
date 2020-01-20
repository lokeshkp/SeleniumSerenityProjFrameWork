package com.qa.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.pages.ProductsPage;
import com.qa.steps.PetStoreSteps;
import com.qa.utils.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class ProductsPageTest {

	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps petStore;
	
	@Title("Select pet by category and name")
	@Test
	public void selectProductByName() throws InterruptedException{
		petStore.navigateToLoginPage();
		petStore.navigateToDashBoard();
		petStore.selectProductFromSideBarDisplay(PetCategories.DOGS);
		petStore.selectPetByName(PetCategories.DOGS, "Bulldog");
		//petStore.addCartSpecificProduct("Female Puppy Bulldog");
		petStore.addToCartByViewingItemDetails("Female Puppy Bulldog", "Friendly dog from England");
		Thread.sleep(3000);
	}
}
