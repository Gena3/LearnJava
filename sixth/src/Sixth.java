import Robot.*;

public class Sixth {

    public static void moveRobot(Robot robot, int toX, int toY) {
        int iStepsCount1, iStepsCount2, iCurrentP, iStep, toP;
        Direction   dirNeedDir;

        iCurrentP = robot.getX();
        toP = toX;
        for(int i = 0; i < 2; i++){
            if((iCurrentP >= 0 && toP >= 0) || (iCurrentP <= 0 && toP <= 0)){
                iStepsCount1 = toP - iCurrentP;
                iStepsCount2 = 0;
            }else{
                iStepsCount1 = -iCurrentP;
                iStepsCount2 = toP;
            }
            // move
            do {
                if(iStepsCount1 < 0){
                    dirNeedDir = i == 0 ? Direction.LEFT : Direction.DOWN;
                    iStep = 1;
                }else if(iStepsCount1 > 0){
                    dirNeedDir = i == 0 ? Direction.RIGHT : Direction.UP;
                    iStep = -1;
                }else{
                    break;
                }
                while (dirNeedDir != robot.getDirection()){
                    robot.turnLeft();
                }
                for(;iStepsCount1 != 0;iStepsCount1 += iStep) robot.stepForward();
                for(;iStepsCount2 != 0;iStepsCount2 += iStep) robot.stepForward();
            }while(false);
            iCurrentP = robot.getY();
            toP = toY;
        }
    }

    public static void main(String[] args){
        Robot myRobot = new Robot(100, 0, Direction.DOWN);
        moveRobot(myRobot,-5,3);
        System.out.println("Position: X = " + myRobot.getX() + "; Y = " + myRobot.getY());
    }
}
