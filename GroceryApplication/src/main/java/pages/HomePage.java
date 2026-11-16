package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreinfo;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement loginpagetext;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'") WebElement moreinfodelboy;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement moreinfocat;
	
	
	public HomePage clickAdminButton() {
		admin.click();
		return this;
	}
	
	public LoginPage clickLogoutButton() {
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUsersPage clickMoreInfoButton() {
		moreinfo.click();
		return new AdminUsersPage(driver);
	}
	public String verifyLoginTextIsDisplayed() {
		return loginpagetext.getText();
	}
	public ManageDeliveryBoyPage clickMoreInfoofDelBoyButton() {
		moreinfodelboy.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public AddCategoryPage clickMoreInfoofCategory() {
		moreinfocat.click();
		return new AddCategoryPage(driver);
	}
}
