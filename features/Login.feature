Feature: Login with Valid Credentials

  @regression
  Scenario: Successfull Login with Valid Credentials
    Given the user navigates to Login Page
    When the user enters email as "anyjohn12345@gmail.com" and password as "Anyjohn123@"
    And the user clicks on Login button
    Then the user should redirected to My Account page
