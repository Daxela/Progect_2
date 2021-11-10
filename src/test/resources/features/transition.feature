Feature: Transition User

  Scenario: Transition user
    Given the user is logged in to Yandex, located on the main page
    When the user will go to the passport
    And the user will go to the mail
    And the user will switch to my services
    And the user will switch to disk
    Then the user will see the yandex disk page
