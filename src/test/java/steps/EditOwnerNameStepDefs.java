package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.OwnerDetails;

/**
 * Created by Bartek on 2017-10-25.
 */
public class EditOwnerNameStepDefs extends DriverFactory {
    private OwnerDetails ownerDetails = new OwnerDetails(driver);

    @And("^User changes owner name to \"([^\"]*)\"$")
    public void userChangesOwnerNameTo(String arg0) {
        ownerDetails.editOwner()
                .editOwnerFirstName(arg0)
                .updateOwner();
    }

    @Then("^Changes \"([^\"]*)\" should be saved and visible$")
    public void changesShouldBeSavedAndVisible(String arg0) {
        Assert.assertEquals("Wrong owner name after update!", arg0, ownerDetails.getOwnerName());
        System.out.println(ownerDetails.getOwnerName());
    }
}
