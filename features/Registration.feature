Feature: Account Registration

@sanity
 Scenario: Successful Account Registration
  Given the user navigates to Account Registration Page
  When the user enter datail into all feild
  And the user selelct Privacy Policy
  And the user click on Continuu button
  Then the user account should successfully created
  