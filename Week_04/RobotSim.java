package No874;

import java.util.HashSet;
import java.util.Set;

public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Set of obstacles indexes in the format of : obstacle[0] + " " + obstacle[1]
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0, y = 0, direction = 0, res = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {  // turn right
                direction = (direction + 1) % 4;
            } else if (commands[i] == -2) { // turn left
                direction = (direction + 3) % 4;
            } else { // Moves forward commands[i] steps
                int step = 0;
                while (step < commands[i] && !obstaclesSet.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }
}
