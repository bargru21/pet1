package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Header;
import pages.Owners;

import java.util.List;

/**
 * Created by Bartek on 2017-10-24.
 */
public class FindAllOwnersStepDefs extends DriverFactory {
    private Header header = new Header(driver);
    private Owners owners = new Owners(driver);

    @When("^User opens Find owners tab$")
    public void userOpensFindOwnersTab() {
        header.clickFindOwnersTab();
    }

    @And("^User searches for all owners$")
    public void userSearchesForAllOwners() {
        owners.findAllOwners();
    }

    @Then("^User should see list of all owners$")
    public void userShouldSeeListOfAllOwners(DataTable table) {
        List<List<String>> list = table.raw();
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertEquals("Wrong owner name", list.get(i + 1).get(0), owners.getOwnersData("Names").get(i));
            Assert.assertEquals("Wrong owner address", list.get(i + 1).get(1), owners.getOwnersData("Address").get(i));
            Assert.assertEquals("Wrong owner city", list.get(i + 1).get(2), owners.getOwnersData("City").get(i));
            Assert.assertEquals("Wrong owner telephone", list.get(i + 1).get(3), owners.getOwnersData("Telephone").get(i));
            Assert.assertEquals("Wrong owner pet", list.get(i + 1).get(4), owners.getOwnersData("Pets").get(i));
        }
    }
}
