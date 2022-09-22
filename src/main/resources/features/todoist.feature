Feature: Feature app todoist

  @TEST
  Scenario: Todoios moblie
    Given I login app todoist
    And I should see homescreen is displayed
    When I create project todoies with name "sotatek"
    And I create new task with message "test"
    And I complete new task
    Then I should see new task completed with message "Completed."

  @API
  Scenario: Todoios api
    Given I login with api todoist
    And I get projects todoist
    When I create new project with name "demoApi"
    And I add new task with content "Test"
    And I compete task
    And I delete project