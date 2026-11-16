package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage hp;

	@Test(description = "User is trying to logout from the application")
	public void verifyWhetherUserisAbletoLoggedOutSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		hp.clickAdminButton();
		lp = hp.clickLogoutButton();
		//assertEquals()
		String actual = hp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.LOGGINGOUTERROR);
	}
	
}
