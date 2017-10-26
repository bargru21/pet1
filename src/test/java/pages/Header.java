package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-23.
 */
public class Header {
    private final WebDriver driver;

    @FindBy(css = ".navbar .nav li:nth-child(1)")
    private WebElement homeTab;

    @FindBy(css = ".navbar .nav li:nth-child(2)")
    private WebElement findOwnersTab;

    @FindBy(css = ".navbar .nav li:nth-child(3)")
    private WebElement veterinariansTab;

    @FindBy(css = ".navbar .nav li:nth-child(4)")
    private WebElement errorTab;

    @FindBy(css = ".navbar .nav li:nth-child(5)")
    private WebElement helpTab;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method clicks Home tab
     */
    public void clickHomeTab() {
        homeTab.click();
    }

    /**
     * Method clicks Veterinarians tab
     *
     * @return return a new page object representing the destination
     */
    public Veterinarians clickVeterinariansTab() {
        veterinariansTab.click();
        return new Veterinarians(driver);
    }

    /**
     * Method clicks Help tab
     *
     * @return return a new page object representing the destination
     */
    public Help clickHelpTab() {
        helpTab.click();
        return new Help();
    }

    /**
     * Method clicks Error tab
     *
     * @return return a new page object representing the destination
     */
    public Error clickErrorTab() {
        errorTab.click();
        return new Error();
    }

    /**
     * Method clicks Find owners tab
     *
     * @return return a new page object representing the destination
     */
    public Owners clickFindOwnersTab() {
        findOwnersTab.click();
        return new Owners(driver);
    }
}
