Feature: Search for people by age group
  In order to filter results
  As a user of the system
  I want to search only for people whose age is between 18 and 45

  Scenario: Filter people by age between 18 and 45
    Given a API containing several people of different ages
    When I run a search using the criterion “age between 18 and 45”
    Then the system must return only people whose age is >= 18 and <= 45
    And no people outside this age range must appear in the results
