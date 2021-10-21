package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    /* Instance level variables webdriver, wait */
    private WebDriver driver;
    private WebDriverWait wait;

    /* These are the page elements we will be interacting with */
    //Annotations https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
    @FindBy(name = "firstName") WebElement firstNameTxt; //package-private access modifier

    @FindBy(name = "lastName")
    private  WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy (name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy (id = "register-btn")
    private WebElement submitBtn;

    /* constructor
    *
    * Somebody else is going to initialize this driver, and we neeed to
    * storage it*/
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        /*Page Factory patron: Factory class to make using Page Objects simpler and easier.
        * This is going to search for each element of the pages. initialize them*/
        PageFactory.initElements(driver, this);
    }

    public void goTo(){ //navigateTo
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        // After navigate, wait for visibility of an Element, in this case is firstName.
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password){
        this.userNameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit(){
        this.submitBtn.click();

    }
}
