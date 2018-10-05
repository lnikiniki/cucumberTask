Feature: Gmail sign in

  Scenario: Successful sign in
    Given Open gmail page
    When I enter correct username lnitesttest@gmail.com and password lnikiniki
    Then I should successfully sign in and page title should contain 'Inbox'

  Scenario: Failed sign in
    Given Open gmail page
    When I enter correct username lnitesttest@gmail.com and password qwertyui
    Then I should see alert message