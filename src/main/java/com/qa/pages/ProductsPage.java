package com.qa.pages;

import com.qa.utils.PetCategories;
import net.thucydides.core.annotations.findby.By;

//Static Imports for Table
import static net.thucydides.core.matchers.BeanMatchers.*;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

	private static String PROD_TABLE = "//div[@id='Catalog']/table";
	
	public ProductsPage selectPetByName(PetCategories petCategories, String petName){
		waitForTextToAppear(petCategories.getValue());
		List<WebElement> rows = inTable( $(PROD_TABLE) ).filterRows(the("Name", equalTo(petName)));
		rows.get(0).findElement(By.tagName("a"));
		return this;
	}
}
