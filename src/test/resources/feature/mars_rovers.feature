Feature: Mars Rovers
  Scenario: Moving the Rover
    Given the upper-right coordinates of the plateau are "5 5"
    And a rover is positioned at "1 2 N"
    When the rover receives the command "LMLMLMLMM"
    Then the rover's position should be "1 3 N"
