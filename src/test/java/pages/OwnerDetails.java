package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bartek on 2017-10-25.
 */
public class OwnerDetails {
    private WebDriver driver;

    @FindBy(linkText = "Add New Pet")
    private WebElement addNewPet;

    @FindBy(linkText = "Edit Owner")
    private WebElement editOwner;

    @FindBy(id = "firstName")
    private WebElement ownerFirstName;

    @FindBy(css = ".form-actions button")
    private WebElement updateOwner;

    @FindBy(css = ".table b")
    private WebElement ownerName;

    public OwnerDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method clicks Add New Pet button
     *
     * @return return a new page object representing the destination
     */
    public NewPet clickAddNewPet() {
        addNewPet.click();
        return new NewPet(driver);
    }

    /**
     * Method clicks edit owner button
     *
     * @return return the current page object
     */
    public OwnerDetails editOwner() {
        editOwner.click();
        return this;
    }

    /**
     * Method writes new first name for owner
     *
     * @param name first name
     * @return return the current page object
     */
    public OwnerDetails editOwnerFirstName(String name) {
        ownerFirstName.clear();
        ownerFirstName.sendKeys(name);
        return this;
    }

    /**
     * Method confirms owner update
     */
    public void updateOwner() {
        updateOwner.click();
    }

    /**
     * Method gets owner name
     *
     * @return full name as String
     */
    public String getOwnerName() {
        return ownerName.getText();
    }
}
