package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {

	HomePage hp;
	ManageDeliveryBoyPage mdp;

	
	@Test(description = "User is trying to add a new delivery boy details to the application")
	public void verifyWhetherUserisAbletoAddNewDeliveryBoyDetails() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginData");
		String password = ExcelUtility.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		hp = lp.clickLoginButton();
		
		mdp = hp.clickMoreInfoofDelBoyButton();
		
		RandomDataUtility rdu = new RandomDataUtility();
		String fullname = rdu.generateFullName();
		String emailid = rdu.generateRandomEmailId();
		String phoneno = rdu.generateRandomPhoneNumber();
		String fulladdress = rdu.generateRandomAddress();
		String enteruser = rdu.generateRandomUsername();
		String enterpass = rdu.generateRandomPassword();
		
		mdp.clickNewButton().enterName(fullname).enterEmail(emailid).enterPhoneNum(phoneno).enteraAddress(fulladdress).enterUserName(enteruser).enterPassword(enterpass).clickSaveButton();
		
		//Assertion
		String actual = mdp.verifyAddDeliveryBoyAlertsDisplayed();
		String expected = "×\nAlert!\nDelivery Boy Details Created Successfully";
		Assert.assertEquals(actual, expected, Constant.ADDINGDELIVERYBOYERROR);
	}
}
