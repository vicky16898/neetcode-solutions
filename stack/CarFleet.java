package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Kinematic> kinematics = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            kinematics.add(new Kinematic(position[i], speed[i]));
        }
        Collections.sort(kinematics, (a, b) -> b.pos - a.pos);
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < kinematics.size(); i++) {
            double time = (double) (target - kinematics.get(i).pos) / (double) kinematics.get(i).speed;
            if (stack.empty()) {
                stack.add(time);
            } else {
                if (stack.peek() < time)
                    stack.push(time);
            }

        }
        return stack.size();
    }
}

class Kinematic {
    int pos;
    int speed;

    public Kinematic(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
