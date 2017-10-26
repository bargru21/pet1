package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2017-10-23.
 */
public class Owners {
    private final WebDriver driver;

    @FindBy(css = "#search-owner-form .form-actions button")
    private WebElement findOwnerButton;

    @FindBy(css = "#lastName input")
    private WebElement searchbox;

    @FindBy(css = ".table tbody tr td:nth-child(1)")
    private List<WebElement> names;

    @FindBy(css = ".table tbody tr td:nth-child(2)")
    private List<WebElement> addresses;

    @FindBy(css = ".table tbody tr td:nth-child(3)")
    private List<WebElement> cities;

    @FindBy(css = ".table tbody tr td:nth-child(4)")
    private List<WebElement> telephones;

    @FindBy(css = ".table tbody tr td:nth-child(5)")
    private List<WebElement> pets;

    public Owners(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method clicks find owner button to list all owners
     */
    public void findAllOwners() {
        findOwnerButton.click();
    }

    /**
     * Method searches owner by last name
     *
     * @param surname
     */
    public void findOwner(String surname) {
        searchbox.sendKeys(surname);
        findOwnerButton.click();
    }

    /**
     * Method gets all owners data from table in Owners section
     *
     * @param column name
     * @return particular list with all records
     */
    public List<String> getOwnersData(String column) {
        List<String> ownersData = new ArrayList<String>();
        if (column.equals("Names")) {
            for (int i = 0; i < names.size(); i++) {
                ownersData.add(names.get(i).getText());
            }
        } else if (column.equals("Address")) {
            for (int i = 0; i < addresses.size(); i++) {
                ownersData.add(addresses.get(i).getText());
            }
        } else if (column.equals("City")) {
            for (int i = 0; i < cities.size(); i++) {
                ownersData.add(cities.get(i).getText());
            }
        } else if (column.equals("Telephone")) {
            for (int i = 0; i < telephones.size(); i++) {
                ownersData.add(telephones.get(i).getText());
            }
        } else if (column.equals("Pets")) {
            for (int i = 0; i < pets.size(); i++) {
                ownersData.add(pets.get(i).getText());
            }
        }
        return ownersData;
    }
}
