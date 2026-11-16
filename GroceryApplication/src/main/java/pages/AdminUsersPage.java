package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pu = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//i[@class='fas fa-edit']") WebElement newuser;
	@FindBy(xpath = "//input[@id='username']") WebElement usernamenew;
	@FindBy(xpath = "//input[@id='password']") WebElement passnew;
	@FindBy(xpath = "//select[@id='user_type']") WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']") WebElement save;
	@FindBy(xpath = "//i[@class=' fa fa-search']") WebElement searchuser;
	@FindBy(xpath = "//input[@id='un']") WebElement searchusername;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchusertype;	
	@FindBy(xpath = "//i[@class='fa fa-search']") WebElement search; 
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	@FindBy(xpath = "//td[text()='prvtron']") WebElement searchusernametext;
	
	public AdminUsersPage clickNewButton() {
		newuser.click();
		return this;
	}
	public AdminUsersPage enterNewUsername(String username1) {
		usernamenew.sendKeys(username1);
		return this;
	}
	public AdminUsersPage enterNewPassword(String password1) {
		passnew.sendKeys(password1);
		return this;
	}
	public AdminUsersPage selectUserType() {
		pu.selectDropdownWithValue(usertype, "admin");
		Select drop = new Select(usertype);
		drop.selectByValue("admin");
		return this;
	}
	public AdminUsersPage clickSaveButton() {
		save.click();
		return this;
	}
	public AdminUsersPage clickSearchUserButton() {
		searchuser.click();
		return this;
	}
	public AdminUsersPage enterUsernameToSearch(String username1) {
		searchusername.sendKeys(username1);
		return this;
	}
	public AdminUsersPage selectUserTypetoSearch() {
		pu.selectDropdownWithValue(searchusertype, "admin");
		Select drop1 = new Select(searchusertype);
		drop1.selectByValue("admin");
		return this;
	}
	public AdminUsersPage clickSearchButton() {
		search.click();
		return this;
	}
	public String verifyAddUserAlertsDisplayed() {
		return successText.getText();
	}
	public String verifySearchUsernameText() {
		return searchusernametext.getText();
	}
}
// create webelement for newbutton , username, password, usertype and save button.
//create a new sheet for this username and pass and name it as AdminUser.
