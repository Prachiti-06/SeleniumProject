package testng.testcase;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Search;

/**
 * @author Prachiti
 */
public class TestSearch {
    WebDriver driver;
    Search search;
    testng.testcase.linkTest linkTest;

    @BeforeTest
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromewebdriver\\chromedriver.exe");
	  
	WebDriverManager.chromedriver().setup();
	            ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("--headless");
         chromeOptions.addArguments("--no-sandbox");
         chromeOptions.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
        search = new Search(driver);
        linkTest = new linkTest(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ratioform.at/");
    }

    @Test(priority = 1)
    public void tc_Search_1() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        WebElement actual = driver.findElement(By.xpath("//div[@class='suggest-search__box']"));
        Assert.assertEquals(actual.getText().contains("Produkte"), true);
        search.getSearch().clear();
    }
/*
    @Test(priority = 2)
    public void tc_Search_2() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        driver.findElement(By.xpath(
                "//html//body//div[2]//header-tag//div[2]//div[1]//div//div[1]//search-form//form//suggest-search//div//div//div//div//div[2]//a"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void tc_Search_3() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        driver.findElement(By.xpath(
                "//html//body//div[2]//header-tag//div[2]//div[1]//div//div[1]//search-form//form//suggest-search//div//div//div//div//div[2]//a"));
        String url = (driver.findElement(By.tagName("a"))).getAttribute("href");
        linkTest.checkUrl(url);
        search.getSearch().clear();
    }

    @Test(priority = 4)
    public void tc_Search_4() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        search.getSearchButton();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
        String actualmsg = driver.findElement(By.xpath("//div[@class='sort']")).getText();
        String expect = "75 Produkte gefunden";
        Assert.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();

    }

   @Test(priority = 5)
    public void tc_Search_5() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = driver.findElement(By.xpath("//div[@class='sort']")).getText();
        String expect = "75 Produkte gefunden";
        Assert.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    @Test(priority = 6)
    public void tc_Search_6() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        List<WebElement> webElementList = driver.findElements(By.xpath("//span[@class='suggestion-product__name']"));

        Iterator<WebElement> itr = webElementList.iterator();
        while (itr.hasNext()) {
            WebElement element = (WebElement) itr.next();
            String actualMsg = element.getText();
            Assert.assertEquals(actualMsg.toLowerCase().contains(productName), true);
        }
        search.getSearch().clear();
    }

     @Test(priority = 7)
    public void tc_Search_7() {
        String placeholder =
                driver.findElement(By.xpath("//input[@placeholder='Suchbegriff, Produktname, Artikelnummer...']"))
                        .getAttribute("placeholder");
        String actplaceholder = "Suchbegriff, Produktname, Artikelnummer...";
        Assert.assertEquals(placeholder.contains(actplaceholder), true);
    }

    @Test(priority = 8)
    public void tc_Search_8() {
        String productName = "%";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = driver.findElement(By.xpath("//div[@class='sort']")).getText();
        String expect = "0 Produkte gefunden";
        Assert.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    @Test(priority = 9)
    public void tc_Search_9() {
        String productName = "  ";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = driver.findElement(By.xpath("//div[@class='sort']")).getText();
        String expect = "0";
        Assert.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    @Test(priority = 12)
    public void tc_Search_10() throws InterruptedException {
        String productName = "wellpapp";
        search.searchproduct(productName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement all = driver.findElement(By.xpath(
                "//html//body//div[2]//header-tag//div[2]//div[1]//div//div[1]//search-form//form//suggest-search//div//div//div//div//div[6]//button"));
        Actions act = new Actions(driver);
        act.moveToElement(all).click().build().perform();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    @Test(priority = 10)
    public void tc_Search_11() {
        String productName = "";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = driver.findElement(By.xpath("//div[@class='sort']")).getText();
        String expect = "0"; // total 1243 product found
        Assert.assertEquals(actualmsg.contains(expect), false);
        driver.navigate().back();
    }

    @Test(priority = 11)
    public void tc_Search_12() {
        String productName = "wellpapp";
        search.searchproduct(productName);
        int actual = (driver.findElements(By.xpath("//div[@class='suggestion-product']")).size());
        Assert.assertEquals(actual, 5);
    }*/

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
