Feature: Adding new pet for existing owner
  Verification of adding new pet
  Verification of adding new pet validation (name field is required!)

  @smoke
  Scenario: Add new pet
    Given User is in Pet Clinic
    When User opens details for owner "Black"
    And User adds new pet
      | Tweety |
      | bird   |
      | 10     |
    Then Newly added pet should be saved and visible
      | Tweety     |
      | 2017-10-10 |
      | bird       |

  @smoke
  Scenario: Add new pet validation - name required
    Given User is in Pet Clinic
    When User opens details for owner "Black"
    And User tries add new pet without name
    Then Proper error message should be visible and pet shouldnt be created