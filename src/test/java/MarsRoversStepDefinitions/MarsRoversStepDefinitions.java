package MarsRoversStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marsrover.Rover;
import org.junit.Assert;

public class MarsRoversStepDefinitions {

    private Rover rover;

    @Given("the upper-right coordinates of the plateau are {string}")
    public void theUpperRightCoordinatesOfThePlateauAre(String coordinates) {

    }

    @And("a rover is positioned at {string}")
    public void aRoverIsPositionedAt(String position) {
        String[] parts = position.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        String direction = parts[2];
        int facing = convertDirectionToInt(direction);
        rover = new Rover();
        rover.setPosition(x, y, facing);
    }

    private int convertDirectionToInt(String direction) {
        switch (direction.toUpperCase()) {
            case "N":
                return Rover.N;
            case "E":
                return Rover.E;
            case "S":
                return Rover.S;
            case "W":
                return Rover.W;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    @When("the rover receives the command {string}")
    public void theRoverReceivesTheCommand(String command) {
        rover.process(command);
    }

    @Then("the rover's position should be {string}")
    public void theRoverSPositionShouldBe(String expectedPosition) {
        String[] parts = expectedPosition.split(" ");
        int expectedX = Integer.parseInt(parts[0]);
        int expectedY = Integer.parseInt(parts[1]);
        String expectedDirection = parts[2];
        Assert.assertEquals(expectedX, rover.getX());
        Assert.assertEquals(expectedY, rover.getY());
        Assert.assertEquals(expectedDirection, getDirectionSymbol(rover.getFacing()));
    }
    private String getDirectionSymbol(int facing) {
        switch (facing) {
            case Rover.N:
                return "N";
            case Rover.E:
                return "E";
            case Rover.S:
                return "S";
            case Rover.W:
                return "W";
            default:
                throw new IllegalArgumentException("Invalid facing value: " + facing);
        }
    }

}
