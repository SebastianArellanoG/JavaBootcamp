import java.util.ArrayList;

public class SmartWatch {
    public static void main(String[] args) {
        ArrayList<Integer> steps = new ArrayList<Integer>();
        for (String s: args) {
            steps.add(Integer.parseInt(s));
        }
        steps = clearSteps(steps);
        double avg = steps.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(avg);
    }

    public static ArrayList<Integer> clearSteps(ArrayList<Integer> steps) {
        ArrayList<Integer> clearedSteps = new ArrayList<Integer>();
        for (Integer step: steps) {
            if (step >= 200 && step <= 100000) {
                clearedSteps.add(step);
            }
        }
        return clearedSteps;
    }
}