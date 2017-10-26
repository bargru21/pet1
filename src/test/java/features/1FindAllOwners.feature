Feature: Verification of finding all available owners
  Verification of all owners

  @smoke
  Scenario: Find all owners
    Given User is in Pet Clinic
    When User opens Find owners tab
    And User searches for all owners
    Then User should see list of all owners
      | Name              | Address               | City        | Telephone  | Pets         |
      | Jeff Black        | 1450 Oak Blvd.        | Monona      | 6085555387 | Lucky        |
      | Jean Coleman      | 105 N. Lake St.       | Monona      | 6085552654 | Max Samantha |
      | Betty Davis       | 638 Cardinal Ave.     | Sun Prairie | 6085551749 | Basil        |
      | Harold Davis      | 563 Friendly St.      | Windsor     | 6085553198 | Iggy         |
      | Maria Escobito    | 345 Maple St.         | Madison     | 6085557683 | Mulligan     |
      | Carlos Estaban    | 2335 Independence La. | Waunakee    | 6085555487 | Lucky Sly    |
      | George Franklin   | 110 W. Liberty St.    | Madison     | 6085551023 | Leo          |
      | Peter McTavish    | 2387 S. Fair Way      | Madison     | 6085552765 | George       |
      | Eduardo Rodriquez | 2693 Commerce St.     | McFarland   | 6085558763 | Jewel Rosy   |
      | David Schroeder   | 2749 Blackhawk Trail  | Madison     | 6085559435 | Freddy       |