import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

public class CalorieTracker {
    private int limit;
    private int totalCalories;
    private Stack<String> additions;
    private Map<String, Integer> calorieMap;

    public CalorieTracker() {
        this.additions = new Stack1L<>();
        this.calorieMap = new Map1L<>();
        this.limit = 0;
        this.totalCalories = 0;
    }

    private void setLimit(int l) {
        this.limit = l;
    }

    private void addCalories(String n, int c) {
        assert this.calorieMap.hasKey(n) && this.calorieMap.value(n) == c
                || !this.calorieMap.hasKey(n);
        assert c > 0;
        this.additions.push(n);
        if (!this.calorieMap.hasKey(n)) {
            this.calorieMap.add(n, c);
        }
        this.totalCalories += c;
    }

    private boolean overLimit() {
        return this.totalCalories > this.limit;
    }

    private int getTotal() {
        return this.totalCalories;
    }

    private void addMultiple(String n, int c, int x) {
        for (int i = 0; i < x; i++) {
            this.addCalories(n, c);
        }
    }

    private String getHighest() {
        int highest = 0;
        String result = "bluehg";
        for (String s : this.additions) {
            if (this.calorieMap.value(s) > highest) {
                highest = this.calorieMap.value(s);
                result = s;
            }
        }
        return result;
    }

    private String getLowest() {
        int highest = Integer.MAX_VALUE;
        String result = "bluehg";
        for (String s : this.additions) {
            if (this.calorieMap.value(s) < highest) {
                highest = this.calorieMap.value(s);
                result = s;
            }
        }
        return result;
    }

    private String removeLast() {
        assert this.additions.length() > 0;
        String s = this.additions.pop();
        this.totalCalories -= this.calorieMap.value(s);
        return s;
    }

    private String getTable() {
        String result = "";
        for (String s : this.additions) {
            result += s + ":\t" + this.calorieMap.value(s) + "\n";
        }
        result += "Total: " + this.totalCalories;
        return result;
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        CalorieTracker c = new CalorieTracker();
        c.setLimit(2000);
        out.println("Set limit to 2000 calories.");
        c.addCalories("burger", 500);
        out.println("Added burger worth 500 calories, over the limit: "
                + c.overLimit());
        c.addMultiple("nuclear waste", 10000, 4);
        out.println(
                "Added nuclear waste worth 10000 calories 4 times, Total calories: "
                        + c.getTotal());
        out.println("Over the limit: " + c.overLimit());
        out.println("\nList of items: ");
        out.println(c.getTable());
        out.println("\nHighest Calorie Food: " + c.getHighest());
        out.println("Lowest Calorie Food: " + c.getLowest());
        c.removeLast();
        c.removeLast();
        c.removeLast();
        c.removeLast();
        out.println("\nRemoved all the nuclear waste, over the limit: "
                + c.overLimit());
        out.println("List of items: ");
        out.println(c.getTable());
    }

}
