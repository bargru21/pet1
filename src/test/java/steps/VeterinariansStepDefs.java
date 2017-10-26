package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Header;
import pages.Veterinarians;

import java.util.List;
import java.util.Map;

/**
 * Created by Bartek on 2017-10-23.
 */
public class VeterinariansStepDefs extends DriverFactory {
    private Header header = new Header(driver);
    private Veterinarians vet = new Veterinarians(driver);

    @Given("^User is in Pet Clinic$")
    public void userIsInPetClinic() {
        driver.navigate().to("http://localhost:8080/petclinic/");
    }

    @When("^User opens Veterinarians tab$")
    public void userOpensVeterinariansTab() {
        header.clickVeterinariansTab();
    }

    @Then("^User should see all Veterinarians$")
    public void userShouldSeeAllVeterinarians(DataTable table) {
        Assert.assertEquals("Wrong first column!", "Name", vet.getFirstColumnName());
        Assert.assertEquals("Wrong second column!", "Specialties", vet.getSecondColumnName());
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> map : data) {
            Assert.assertEquals("Wrong Veterinarian specialty!", map.get("Specialties"), vet.getVeterinariansTable().get(map.get("Name")));
            Assert.assertTrue("Wrong Veterinarian name!", vet.getVeterinariansTable().containsKey(map.get("Name")));
        }
    }
}
