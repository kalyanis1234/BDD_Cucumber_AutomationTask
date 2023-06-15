package marsrover;

public class Rover {
    public static final int N = 1;
    public static final int E = 2;
    public static final int S = 3;
    public static final int W = 4;
    private int x = 0;
    private int y = 0;
    private int facing = N;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFacing() {
        return facing;
    }
    public Rover() {
    }

    public void setPosition(int x, int y, int facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public String getPosition() {
        char dir = 'N';
        if (facing == N) {
            dir = 'N';
        } else if (facing == E) {
            dir = 'E';
        } else if (facing == S) {
            dir = 'S';
        } else if (facing == W) {
            dir = 'W';
        }
        return x + " " + y + " " + dir;
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.charAt(idx));
        }
    }

    private void process(char command) {
        if (command == 'L') {
            turnLeft();
        } else if (command == 'R') {
            turnRight();
        } else if (command == 'M') {
            move();
        } else {
            throw new IllegalArgumentException("Speak in Mars language, please!");
        }
    }

    private void move() {
        if (facing == N) {
            this.y++;
        } else if (facing == E) {
            this.x++;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }

    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }

    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

    public void printPosition() {
        System.out.println(getPosition());
    }
}
