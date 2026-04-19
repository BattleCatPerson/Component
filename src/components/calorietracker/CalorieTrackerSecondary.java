package components.calorietracker;

import components.stack.Stack;
import components.stack.Stack1L;

/**
 * CalorieTracker with standard and enhanced secondary methods.
 */
public abstract class CalorieTrackerSecondary implements CalorieTracker {
    @Override
    public String toString() {
        String result = "";
        Stack<String> stack = new Stack1L<>();
        Stack<String> additions = this.getAdditions();
        while (additions.length() > 0) {
            stack.push(additions.pop());
        }
        while (stack.length() > 0) {
            String item = stack.pop();
            result += item + ":\t" + this.getCalorieMap().value(item) + "\n";
            additions.push(item);
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CalorieTracker)) {
            return false;
        }
        CalorieTracker c = (CalorieTracker) obj;
        return c.getCalorieMap().equals(this.getCalorieMap())
                && c.getAdditions().equals(this.getAdditions());
    }

    @Override
    public int hashCode() {
        return this.size();
    }

    @Override
    public int compareTo(CalorieTracker c) {
        int result = 0;
        if (this.getTotal() > c.getTotal()) {
            result = 1;
        } else if (this.getTotal() < c.getTotal()) {
            result = -1;
        }
        return result;
    }

    @Override
    public void addMultiple(String n, int c, int x) {
        assert c > 0 : "Violation of: c > 0";
        for (int i = 0; i < x; i++) {
            this.addCalories(n, c);
        }
    }

    @Override
    public String getHighest() {
        assert this.size() > 0 : "Violations of |this.additions| > 0";
        String result = "";
        Stack<String> stack = new Stack1L<>();
        Stack<String> additions = this.getAdditions();
        int highest = -1;
        while (additions.length() > 0) {
            String item = additions.pop();
            if (this.getCalorieMap().value(item) > highest) {
                result = item;
                highest = this.getCalorieMap().value(item);
            }
            stack.push(item);
        }
        while (stack.length() > 0) {
            String item = stack.pop();
            additions.push(item);
        }
        return result;
    }

    @Override
    public String getLowest() {
        assert this.size() > 0 : "Violations of |this.additions| > 0";
        String result = "";
        Stack<String> stack = new Stack1L<>();
        Stack<String> additions = this.getAdditions();
        int lowest = Integer.MAX_VALUE;
        while (additions.length() > 0) {
            String item = additions.pop();
            if (this.getCalorieMap().value(item) < lowest) {
                result = item;
                lowest = this.getCalorieMap().value(item);
            }
            stack.push(item);
        }
        while (stack.length() > 0) {
            String item = stack.pop();
            additions.push(item);
        }
        return result;
    }
}
