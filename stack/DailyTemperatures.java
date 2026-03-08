package stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temperature> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && stack.peek().temp < temperatures[i]) {
                Temperature t = stack.pop();
                res[t.day] = i - t.day;
            }
            stack.push(new Temperature(i, temperatures[i]));
        }
        return res;
    }

}

class Temperature {
    int day;
    int temp;

    public Temperature(int day, int temp) {
        this.day = day;
        this.temp = temp;
    }
}
