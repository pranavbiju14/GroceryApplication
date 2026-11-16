package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {

public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newdelboy;
	@FindBy(xpath = "//input[@id='name']") WebElement name;
	@FindBy(xpath = "//input[@id='email']") WebElement email;
	@FindBy(xpath = "//input[@id='phone']") WebElement phone;
	@FindBy(xpath = "//textarea[@id='address']") WebElement address;
	@FindBy(xpath = "//input[@id='username']") WebElement username;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//button[@type='submit'and@class='btn btn-danger']") WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	
	public ManageDeliveryBoyPage clickNewButton() {
		newdelboy.click();
		return this;
	}
	public ManageDeliveryBoyPage enterName(String fullname) {
		name.sendKeys(fullname);
		return this;
	}
	public ManageDeliveryBoyPage enterEmail(String emailid) {
		email.sendKeys(emailid);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNum(String phoneno) {
		phone.sendKeys(phoneno);
		return this;
	}
	public ManageDeliveryBoyPage enteraAddress(String fulladdress) {
		address.sendKeys(fulladdress);
		return this;
	}
	public ManageDeliveryBoyPage enterUserName(String enteruser) {
		username.sendKeys(enteruser);
		return this;
	}
	public ManageDeliveryBoyPage enterPassword(String enterpass) {
		password.sendKeys(enterpass);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButton() {
		WebElement save = driver.findElement(By.xpath("//button[@type='submit'and@class='btn btn-danger']"));
		Actions act = new Actions(driver);
		act.click(save).perform();
		return this;
	}
	public String verifyAddDeliveryBoyAlertsDisplayed() {
		return successText.getText();
	}
}
