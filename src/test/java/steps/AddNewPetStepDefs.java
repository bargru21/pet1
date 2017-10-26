package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Header;
import pages.NewPet;
import pages.OwnerDetails;

import java.util.List;

/**
 * Created by Bartek on 2017-10-24.
 */
public class AddNewPetStepDefs extends DriverFactory {
    private Header header = new Header(driver);
    private OwnerDetails ownerDetails = new OwnerDetails(driver);
    private NewPet pet = new NewPet(driver);

    @When("^User opens details for owner \"([^\"]*)\"$")
    public void userOpensDetailsForOwner(String arg0) {
        header.clickFindOwnersTab()
                .findOwner(arg0);
    }

    @And("^User adds new pet$")
    public void userAddsNewPet(List<String> list) {
        ownerDetails.clickAddNewPet()
                .setPetName(list.get(0))
                .setBirthDate(list.get(2))
                .setPetType(list.get(1))
                .confirmAddPet();
    }

    @Then("^Newly added pet should be saved and visible$")
    public void newlyAddedPetShouldBeSavedAndVisible(List<String> list) {
        Assert.assertEquals("Wrong pet name", list.get(0), pet.getNewPetData().get(0));
        Assert.assertEquals("Wrong pet birthday", list.get(1), pet.getNewPetData().get(1));
        Assert.assertEquals("Wrong pet type", list.get(2), pet.getNewPetData().get(2));
    }

    @And("^User tries add new pet without name$")
    public void userTriesAddNewPetWithoutName() {
        ownerDetails.clickAddNewPet()
                .confirmAddPet();
    }

    @Then("^Proper error message should be visible and pet shouldnt be created$")
    public void properErrorMessageShouldBeVisibleAndPetShouldntBeCreated() {
        Assert.assertTrue("Error message is not visible!", pet.isErrorNameRequiredVisible());
    }
}
