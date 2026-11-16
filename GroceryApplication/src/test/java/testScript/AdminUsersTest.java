package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{

	HomePage hp;	
	AdminUsersPage adm;
	
	@Test(description="User is trying to add a new user to the application")
	public void verifyWhetherUserisAbletoAddNewAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		adm = hp.clickMoreInfoButton();
		
		RandomDataUtility rdu = new RandomDataUtility();
		String username1 = rdu.generateRandomUsername();
		String password1 = rdu.generateRandomPassword();
		adm.clickNewButton().enterNewUsername(username1).enterNewPassword(password1).selectUserType().clickSaveButton();
		//assertEquals();
		String actual = adm.verifyAddUserAlertsDisplayed();
		String expected = "×\nAlert!\nUser Created Successfully";
		Assert.assertEquals(actual, expected, Constant.ADDINGUSERERROR);
		
	}
	
	@Test(description = "User is trying to search an added user")
	public void verifyWhetherUserisAbletoSearchtheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		hp.clickMoreInfoButton();
		
		String username1 = ExcelUtility.getStringData(0, 0, "AdminData");
		adm.clickSearchUserButton().enterUsernameToSearch(username1).selectUserTypetoSearch().clickSearchButton();
		//assertEquals()
		String actual = adm.verifySearchUsernameText();
		String expected = "prvtron";
		Assert.assertEquals(actual, expected, Constant.SEARCHINGUSERERROR);
	}
}
