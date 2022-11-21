Feature: Feature app todoist


  @Test
  Scenario Outline: Test “Create Project”
    Given I login with api todoist
    When I create new project with "<prjNmae>" API
    And I login app todoist
    Then I should see homescreen is displayed
    And I should see project shown on screen with name "<prjNmae>"
    Examples:
    |prjNmae|
    |apiTest|

  @Test
  Scenario Outline: Test “Create Task via mobile phone”
    Given I login with api todoist
    When I create new project with "<prjNmae>" API
    And I login app todoist
    And  I should see homescreen is displayed
    And I should see project shown on screen with name "<prjNmae>"
    And I create new task with message "<content>" in App
    Then I should see task rerutn in response with content "<content>"
    Examples:
      |prjNmae|content|
      |apiTest|task   |

  @Test
  Scenario Outline: Test “Reopen Task”
    Given I login app todoist
    And I should see homescreen is displayed
    And I login with api todoist
    When I create project todoies with name "<prjNmae>" in App
    And I create new task with message "<content>" in App
    And I get id task created with "<content>" API
    And I complete new task in App
    And I should see new task completed with message "Completed."
    And I reopen task with "<content>" API
    Then I should see task reopen successful with name "<content>"
    Examples:
      |prjNmae|content|
      |Test|test   |

    @Demo
    Scenario:
      And I login with api todoist
      When I create project todoies with name "abc" in App

