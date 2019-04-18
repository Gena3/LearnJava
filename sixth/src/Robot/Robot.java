package Robot;

public class Robot {

    private Direction directionCurrent;
    private int X, Y;

    public Robot(int X, int Y, Direction direction){
        this.X = X;
        this.Y = Y;
        this.directionCurrent = direction;
    }

    public Robot(){
        this(0, 0, Direction.UP);
    }

    public Direction getDirection() {
        return directionCurrent;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void turnLeft() {

        switch (directionCurrent){
            case UP:
                directionCurrent = Direction.LEFT;
                break;
            case DOWN:
                directionCurrent = Direction.RIGHT;
                break;
            case LEFT:
                directionCurrent = Direction.DOWN;
                break;
            case RIGHT:
                directionCurrent = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        switch (directionCurrent){
            case UP:
                directionCurrent = Direction.RIGHT;
                break;
            case DOWN:
                directionCurrent = Direction.LEFT;
                break;
            case LEFT:
                directionCurrent = Direction.UP;
                break;
            case RIGHT:
                directionCurrent = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        switch (directionCurrent){
            case UP:
                Y++;
                break;
            case DOWN:
                Y--;
                break;
            case LEFT:
                X--;
                break;
            case RIGHT:
                X++;
                break;
        }
    }
}

