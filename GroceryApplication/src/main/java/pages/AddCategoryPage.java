package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {

public WebDriver driver;
	
	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newcategory;
	@FindBy(xpath = "//input[@id='category']") WebElement entercategory;
	@FindBy(xpath = "//li[@id='4-selectable']") WebElement selectgroups;
	@FindBy(xpath = "//input[@id='main_img']") WebElement image;
	@FindBy(xpath = "//input[@name='top_menu'and@value=\"yes\"]") WebElement topmenu;
	@FindBy(xpath = "//input[@name='show_home'and@value='yes']") WebElement leftmenu;
	@FindBy(xpath = "//button[@class='btn btn-danger'and@type=\"submit\"]") WebElement catsave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchcat;
	@FindBy(xpath = "//input[@name='un']") WebElement catname;
	@FindBy(xpath = "//button[@type='submit']") WebElement lastsearch;
	@FindBy(xpath = "//td[text()='Veggies']") WebElement searchcategorytext;
	
	public AddCategoryPage clickNewCategoryButton() {
		newcategory.click();
		return this;
	}
	public AddCategoryPage enterCategoryName() {
		entercategory.sendKeys("Veggies");
		return this;
	}
	public AddCategoryPage clickSelectGroupsButton() {
		selectgroups.click();
		return this;
	}
	public AddCategoryPage uploadImageButton() {
		image.sendKeys("C:\\Users\\HP\\Downloads\\vegetables img.jpg");
		return this;
	}
	public AddCategoryPage clickSaveCategoryButton() {
		WebElement catsave = driver.findElement(By.xpath("//button[@class='btn btn-danger'and@type='submit']"));
		Actions act = new Actions(driver);
		act.click(catsave).perform();
		return this;
	}
	public String verifyAddCategoryAlertsDisplayed() {
		return successText.getText();
	}
	public AddCategoryPage clickSearchCategoryButtonMain() {
		searchcat.click();
		return this;
	}
	public AddCategoryPage enterCategoryNametoSearch() {
		catname.sendKeys("Veggies");
		return this;
	}
	public AddCategoryPage clickFinalSearchButton() {
		lastsearch.click();
		return this;
	}
	public String verifySearchCategoryText() {
		return searchcategorytext.getText();
	}
}
