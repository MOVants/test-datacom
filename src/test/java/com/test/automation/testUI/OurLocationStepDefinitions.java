package com.test.automation.testUI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class OurLocationStepDefinitions {
    WebDriver driver;
    String Url = "https://datacom.com/nz/en/contact-us";
    String dataComHeader = "Contact Us — Get In Touch";


    @Given("user is on Homepage")
    public void userIsOnHomepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user validate Our locations page")
    public void userValidateOurLocationsPage() throws InterruptedException {
        try {
            if(driver.findElement(By.xpath("//div[@class='ot-sdk-row']")).isDisplayed()){
                driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            }
            sleep(1000);
            String getOurLocationTabHeaderText = driver.findElement(By.xpath("//div/div[@class='cmp-title']/h2")).getText();
            String getOurLocationPageDetailsText = driver.findElement(By.cssSelector("div[class='responsivegrid responsivegrid--section-margin-top aem-GridColumn aem-GridColumn--default--12'] p")).getText();
            String ourLocationHeaderText = "Our locations";
            String ourLocationPageDetailsText = "Contact one of our global offices or one of our teams to find out more about how we can help you, or to answer any query you may have.";
            assertEquals(getOurLocationTabHeaderText, ourLocationHeaderText);
            assertTrue(getOurLocationPageDetailsText.contains(ourLocationPageDetailsText));
        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Not able to verify Our Locations tab details");
        }
    }

    @Then("list of Locations are present")
    public void listOfLocationsArePresent() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//li[@data-tab-section-id='.item0'][contains(.,'New Zealand')]")).click();
            sleep(1000);
            driver.findElement(By.xpath("//li[@data-tab-section-id='.item1'][contains(.,'Australia')]")).click();
            sleep(1000);
            driver.findElement(By.xpath("//li[@data-tab-section-id='.item2'][contains(.,'Asia')]")).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Not able to verify list of locations");
        }
    }

    @When("user navigate to NewZealand tab")
    public void userNavigateToNewZealandTab() throws InterruptedException {
        try {
            sleep(2000);

            driver.findElement(By.xpath("//li[@data-tab-section-id='.item0'][contains(.,'New Zealand')]")).click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Not able navigate to Location New Zealand");
        }
    }

    @Then("user able to view each locations under NewZealand")
    public void userAbleToViewEachLocationsUnderNewZealand() throws InterruptedException {
        try {
        JavascriptExecutor js = (JavascriptExecutor) driver;

//
// Auckland Location
            js.executeScript("window.scrollBy(0,300)", "");
            String getAucklandDetails = driver.findElement(By.xpath("(//div[contains(@class,'details')])[1]")).getText();
            assertTrue(getAucklandDetails.contains("58 Gaunt Street, Auckland CBD, Auckland 1010"));
            assertTrue(getAucklandDetails.contains("+64 9 303 1489"));
            assertTrue(getAucklandDetails.contains("reception.gaunt@datacom.co.nz"));
            sleep(1000);
            driver.findElement(By.xpath("(//a[contains(.,'Get directions')])[1]")).click();
            String getMapHeader = driver.getTitle();
            assertEquals(getMapHeader, "Datacom Auckland - Google Maps");
            driver.navigate().back();
            sleep(1000);
            assertEquals(driver.getTitle(), dataComHeader);


// Christchurch Location
            js.executeScript("window.scrollBy(0,400)", "");
            sleep(2000);
            driver.findElement(By.id("section-1")).click();
            String getChristchurchDetails = driver.findElement(By.xpath("(//div[contains(@class,'details')])[2]")).getText();
            assertTrue(getChristchurchDetails.contains("67 Gloucester Street, Christchurch 8013"));
            assertTrue(getChristchurchDetails.contains("+64 3 379 7775"));
            assertTrue(getChristchurchDetails.contains("reception.christchurch@datacom.co.nz"));
            sleep(1000);
            driver.findElement(By.xpath("(//a[contains(.,'Get directions')])[2]")).click();
            String getMapChristchurchHeader = driver.getTitle();
            assertEquals(getMapChristchurchHeader, "Datacom Christchurch - Google Maps");
            driver.navigate().back();
            sleep(1000);
            assertEquals(driver.getTitle(), dataComHeader);

// Dunedin Location
        js.executeScript("window.scrollBy(0,500)", "");
        sleep(2000);
        driver.findElement(By.id("section-2")).click();
        String getDunedinDetails = driver.findElement(By.xpath("(//div[contains(@class,'details')])[3]")).getText();
        assertTrue(getDunedinDetails.contains("Level 1, 77 Vogel Street, Dunedin 9011"));
        assertTrue(getDunedinDetails.contains("+64 3 379 7775"));
        assertTrue(getDunedinDetails.contains("reception.christchurch@datacom.co.nz"));
        sleep(1000);
        driver.findElement(By.xpath("(//a[contains(.,'Get directions')])[3]")).click();
        String getMapDunedinHeader = driver.getTitle();
        assertEquals(getMapDunedinHeader, "Level 1/77 Vogel Street - Google Maps");
        driver.navigate().back();
        sleep(1000);
        assertEquals(driver.getTitle(), dataComHeader);

// Hamilton Location
        js.executeScript("window.scrollBy(0,500)", "");
        sleep(2000);
        driver.findElement(By.id("section-3")).click();
        String getHamiltonDetails = driver.findElement(By.xpath("(//div[contains(@class,'details')])[4]")).getText();
        assertTrue(getHamiltonDetails.contains("Level 2, 94 Bryce Street, Hamilton 3204"));
        assertTrue(getHamiltonDetails.contains("+64 7 834 1666"));
        assertTrue(getHamiltonDetails.contains("reception.hamilton@datacom.co.nz"));
        sleep(1000);
        driver.findElement(By.xpath("(//a[contains(.,'Get directions')])[4]")).click();
        String getMapHamiltonHeader = driver.getTitle();
        assertEquals(getMapHamiltonHeader, "Level 2/94 Bryce Street - Google Maps");
        driver.navigate().back();
        sleep(1000);
        assertEquals(driver.getTitle(), dataComHeader);

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("No location are present under New Zealand tab");
        }
    }
}