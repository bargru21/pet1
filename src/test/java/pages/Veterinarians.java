package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bartek on 2017-10-23.
 */
public class Veterinarians {
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement tabTitle;

    @FindBy(css = ".table tr th:nth-child(1)")
    private WebElement firstColumnName;

    @FindBy(css = ".table tr th:nth-child(2)")
    private WebElement secondColumnName;

    @FindBy(css = ".table tbody tr td:nth-child(1)")
    private List<WebElement> names;

    @FindBy(css = ".table tbody tr td:nth-child(2)")
    private List<WebElement> specialties;

    public Veterinarians(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method gets title of current opened tab
     *
     * @return title as String
     */
    public String getTabTitle() {
        return tabTitle.getText();
    }

    /**
     * Method gets title of first column
     *
     * @return title as String
     */
    public String getFirstColumnName() {
        return firstColumnName.getText();
    }

    /**
     * Method gets title of second column
     *
     * @return title as String
     */
    public String getSecondColumnName() {
        return secondColumnName.getText();
    }

    /**
     * Method gets table with all Veterinarians
     *
     * @return map with names and specialties
     */
    public Map<String, String> getVeterinariansTable() {
        Map<String, String> veterinariansTable = new HashMap<String, String>();
        for (int i = 0; i < names.size(); i++) {
            veterinariansTable.put(names.get(i).getText(), specialties.get(i).getText());
        }
        return veterinariansTable;
    }
}
