Feature: Verification of Veterinarians in Pet Clinic
  Verification of proper data in Veterinarians tab (names and specialties)

  @smoke
  Scenario: Verification of Veterinarians in Pet Clinic
    Given User is in Pet Clinic
    When User opens Veterinarians tab
    Then User should see all Veterinarians
      | Name           | Specialties       |
      | James Carter   | none              |
      | Linda Douglas  | dentistry surgery |
      | Sharon Jenkins | none              |
      | Helen Leary    | radiology         |
      | Rafael Ortega  | surgery           |
      | Henry Stevens  | radiology         |