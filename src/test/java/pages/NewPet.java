package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2017-10-24.
 */
public class NewPet {
    private final WebDriver driver;

    @FindBy(id = "name")
    private WebElement petName;

    @FindBy(id = "type")
    private WebElement petType;

    @FindBy(id = "birthDate")
    private WebElement birthDateCalendar;

    @FindBy(css = ".form-actions button")
    private WebElement addPet;

    @FindBy(css = ".control-group.error span")
    private WebElement errorNameRequired;

    @FindBy(xpath = "//table[3]//dl/dd")
    private List<WebElement> petData;

    public NewPet(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method writes pet name
     *
     * @param name for new pet
     * @return return the current page object
     */
    public NewPet setPetName(String name) {
        petName.sendKeys(name);
        return this;
    }

    /**
     * Method chooses pet type
     *
     * @param type for new pet
     * @return return the current page object
     */
    public NewPet setPetType(String type) {
        List<WebElement> options = petType.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals(type)) {
                options.get(i).click();
            }
        }
        return this;
    }

    /**
     * Method selects birth date depending on chosen day
     * (birth date can be only from current month!)
     *
     * @param day of current month
     * @return return the current page object
     */
    public NewPet setBirthDate(String day) {
        birthDateCalendar.click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//tbody//a[contains(text(), '" + day + "')]")).click();
        return this;
    }

    /**
     * Method clicks add pet button
     */
    public void confirmAddPet() {
        addPet.click();
    }

    /**
     * Method checks if error message is visible near name field
     *
     * @return true if error message is visible
     */
    public boolean isErrorNameRequiredVisible() {
        return errorNameRequired.isDisplayed();
    }

    /**
     * Method checks if data for newly created pet are correct
     *
     * @return list with pet data
     */
    public List<String> getNewPetData() {
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < petData.size(); i++) {
            data.add(petData.get(i).getText());
        }
        return data;
    }
}
