Feature: Authorization User

  Scenario: Authorization user
    Given yandex is open
    When the user will switch to authorization
    And a login will be entered
    And the login button is pressed
    And a password will be entered
    And the login button is pressed
    Then the user will see the yandex home page


