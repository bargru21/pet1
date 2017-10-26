Feature: Owner name edition
  Verification of editing owner name

  @smoke
  Scenario: Edit owner name
    Given User is in Pet Clinic
    When User opens details for owner "Black"
    And User changes owner name to "Bob"
    Then Changes "Bob Black" should be saved and visible