public class LargestHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            Pair<Integer, Integer> prevH = null;
            int currH = heights[i];
            while (!stack.empty() && stack.peek().getValue() > currH) {
                prevH = stack.pop();
                int width = i - prevH.getKey();
                max = Math.max(max, prevH.getValue() * width);
            }
            if (prevH != null) {
                stack.push(new Pair<>(prevH.getKey(), currH));
            } else {
                stack.push(new Pair<>(i, currH));
            }
        }
        int end = heights.length;
        while (!stack.empty()) {
            Pair<Integer, Integer> rect = stack.pop();
            max = Math.max(max, rect.getValue() * (end - rect.getKey()));
        }
        return max;
    }
}
