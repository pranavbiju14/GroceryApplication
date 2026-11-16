package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	HomePage home;
	
	@Test(priority = 1, description = "User is trying to Login with Valid Credentials", groups = { "smoke" })
	public void verifyWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = lp.clickLoginButton();
		// assertTrue()
		boolean dashboardvalue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardvalue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to Login with Valid Username and Invalid Password", retryAnalyzer = retry.Retry.class)
	public void verifyWithValidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginData");
		String password = ExcelUtility.getStringData(1, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();
		// assertEquals()
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDANDINVALIDERROR);
	}

	@Test(priority = 3, description = "User is trying to Login with Invalid Username and Valid Password")
	public void verifyWithInvalidUsernameandValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginData");
		String password = ExcelUtility.getStringData(2, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();
		// assertEquals()
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDANDVALIDERROR);
	}

	@Test(priority = 4, description = "User is trying to Login with Invalid Credentials", groups = { "smoke" } , dataProvider = "LoginData")
	public void verifyWithInvalidCredentials(String username,String password) throws IOException {
		//String username = ExcelUtility.getStringData(3, 0, "LoginData");
		//String password = ExcelUtility.getStringData(3, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();
		// assertEquals()
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Admin", "admin22" }, new Object[] { "Admin12", "adm3" }, };
	}
}
