Feature: Feature app todoist

  @TEST
  Scenario: Todoios
    Given I login app todoist
    And I should see homescreen is displayed
    When I create project todoies with name "sotatek"
    And I create new task with message "test"
    And I complete new task
    Then I should see new task completed with message "Completed."