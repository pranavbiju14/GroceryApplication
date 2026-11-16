package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AddCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddCategoryTest extends Base{

	HomePage hp;
	AddCategoryPage acp;
	
	@Test(description = "User is trying to add a new category")
	public void verifyWhetherUserisAbletoAddNewCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		
		acp = hp.clickMoreInfoofCategory();
		
		acp.clickNewCategoryButton().enterCategoryName().clickSelectGroupsButton().uploadImageButton().clickSaveCategoryButton();
		
		//Assertion
				String actual = acp.verifyAddCategoryAlertsDisplayed();
				String expected = "�\nAlert!\nCategory Created Successfully";
				Assert.assertEquals(actual, expected, Constant.ADDINGCATEGORYERROR );
		
	}
	
	@Test(description = "User is trying to search an added category")
	public void verifyWhetherUserisAbletoSearchaCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		acp = hp.clickMoreInfoofCategory();
		
		acp.clickSearchCategoryButtonMain().enterCategoryNametoSearch().clickFinalSearchButton();
		
		//assertion
		String actual = acp.verifySearchCategoryText();
		String expected = "Veggies";
		Assert.assertEquals(actual, expected, Constant.SEARCHINGCATEGORYERROR);
	}
}


// verifyWhetherUserisAbletoAddNewCategory