Feature: Disk User

  Scenario: Disk user
    Given the user is on the disk by logging into yandex
    And the user selects an image
    And the download button is pressed
    And stopped
    And the image is being loaded
    And stopped
    Then a photo of the mountain has been downloaded, another photo has been uploaded

