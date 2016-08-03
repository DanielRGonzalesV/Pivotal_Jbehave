Narrative: My create project
As a user
I want create new project
In order to have projects

Feature: Testing for login Pivotal page

  Scenario: Create project
    Given I send a POST request to /projects
      | name   | TestCreateProjects |
      | public | true               |
    Then I expect the status code 200
