package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Prachiti
 */
public class Search {
    WebDriver driver;

    @FindBy(name = "searchQuery")
    WebElement search;

    @FindBy(xpath = "//button[@class=' button button--expand search-form__submit']")
    WebElement searchButton;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchproduct(String productname) {
        search.sendKeys(productname);
    }

    public void btnclick() {
        searchButton.click();
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getSearch(){
        return search;
    }
}
