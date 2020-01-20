package com.qa.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.UseParametersRunnerFactory;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.qa.steps.PetStoreSteps;
import com.qa.utils.PetCategories;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/order-products/orders.csv")
public class OrderProductDDTest {

	
	private String USERNAME;
	private String PASSWORD;
	private String PRODUCTCATEGORY;
	private String PRODUCTNAME;
	private String SPECIFICPRODUCTNAME;
	private String CARDTYPE;
	private String CARDNUMBER;
	private String EXPIRYDATE;
	private String FIRSTNAME;
	private String LASTNAME;
	private String ADDR1;
	private String ADDR2;
	private String CITY;
	private String STATE;
	private String ZIP;
	private String COUNTRY;

	
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}


	public void setPRODUCTCATEGORY(String pRODUCTCATEGORY) {
		PRODUCTCATEGORY = pRODUCTCATEGORY;
	}


	public void setPRODUCTNAME(String pRODUCTNAME) {
		PRODUCTNAME = pRODUCTNAME;
	}


	public void setSPECIFICPRODUCTNAME(String sPECIFICPRODUCTNAME) {
		SPECIFICPRODUCTNAME = sPECIFICPRODUCTNAME;
	}


	public void setCARDTYPE(String cARDTYPE) {
		CARDTYPE = cARDTYPE;
	}

	public void setCARDNUMBER(String cARDNUMBER) {
		CARDNUMBER = cARDNUMBER;
	}


	public void setEXPIRYDATE(String eXPIRYDATE) {
		EXPIRYDATE = eXPIRYDATE;
	}


	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}


	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}


	public void setADDR1(String aDDR1) {
		ADDR1 = aDDR1;
	}


	public void setADDR2(String aDDR2) {
		ADDR2 = aDDR2;
	}


	public void setCITY(String cITY) {
		CITY = cITY;
	}


	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}


	public void setZIP(String zIP) {
		ZIP = zIP;
	}


	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}


	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	

	
	@Test
	@Title("Order a pets & verify purchase")
	public void verifyIfLoginIsSuccessful() {
	
		shopper.navigateToLoginPage();
		shopper.doLogin(USERNAME, PASSWORD);
		shopper.navigateToProductCategory(PetCategories.valueOf(PRODUCTCATEGORY));
		shopper.selectPetByName(PetCategories.valueOf(PRODUCTCATEGORY), PRODUCTNAME);
		shopper.addCartSpecificProduct(SPECIFICPRODUCTNAME);
		shopper.clickOnProceedToCheckout();
		shopper.enterPaymentAndBillingDetails(CARDTYPE, CARDNUMBER, EXPIRYDATE, FIRSTNAME, LASTNAME, ADDR1, ADDR2, 
				CITY, STATE, ZIP, COUNTRY);
		shopper.clickOnContinueBtn();
		shopper.clickOnConfirmBtn();
		shopper.verifyIfOrderSubmitted();
	}

}
