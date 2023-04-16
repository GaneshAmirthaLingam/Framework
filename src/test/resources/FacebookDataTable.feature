Feature: Validate the Facebook with Proper Username and Password

  Scenario Outline: Validate the Facebook with one set of Username and Password
    Given Open the Facebook Application
      | Employee name | EmpId   |
      | Ravikumar     | 123@asd |
    When Enter the  "<Username>" and password
      | Courses  | Syllabus  |
      | abc@123  | Java      |
      | Selenium | Framework |
    And Click the Login button
      | Ram@1234  | Sarath@1234 |
      | Kumar@123 | Sarath@3432 |
    Then User validates the Facebook Successfully Login

    Examples: 
      | name      |
      | Ram@1234  |
      | Kumar@123 |
