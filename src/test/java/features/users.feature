Feature: Users

  Background:


  Scenario Outline: User Creation
    Given I want to create user with <id> id, "<username>" username, "<firstName>" firstName, "<lastName>" lastName, "<password>" password, "<email>" email, "<phone>" phone, <status> status
    When I create new user
    Then User is created
    Examples:
      | id | username   | firstName | lastName  | password | email          | phone         | status |
      | 1  | dimonhouse | Dmitro    | Dusheyko  | 654321   | gggg@gmail.com | +380999999999 | 1      |
      | 2  | nanacop    | Anastasia | Gapusenko | 123123   | nnnn@gmail.com | +380888888888 | 1      |
