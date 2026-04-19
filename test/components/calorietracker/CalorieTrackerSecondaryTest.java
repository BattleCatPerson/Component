package components.calorietracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.stack.Stack;

/**
 * Tests for calorie tracker secondary and standard methods.
 */
public class CalorieTrackerSecondaryTest {
    /**
     * Returns a valid class that extends CalorieTrackerSecondary.
     *
     * @return the valid class
     */
    private CalorieTrackerSecondary constructor() {
        return new CalorieTracker1L();
    }

    /**
     * Tests toString with initial values.
     */
    @Test
    public void testToStringEmpty() {
        CalorieTrackerSecondary c = this.constructor();
        assertEquals(c.toString(), "");
    }

    /**
     * Tests toString with a single item.
     */
    @Test
    public void testToStringOne() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("food", 10);
        assertEquals(c.toString(), "food:\t10\n");
    }

    /**
     * Tests toString with multiple items.
     */
    @Test
    public void testToStringMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("foode", 20);
        c.addCalories("foodee", 30);
        assertEquals(c.toString(), "food:\t10\nfoode:\t20\nfoodee:\t30\n");
    }

    /**
     * Tests equals with two empty calorie trackers.
     */
    @Test
    public void testEqualsEmpty() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        assertEquals(c.equals(c2), true);
    }

    /**
     * Tests equals with two non-equal calorie trackers.
     */
    @Test
    public void testEqualsFalse() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c2.addCalories("hhh", 0);
        assertEquals(c.equals(c2), false);
    }

    /**
     * Tests equals with both calorie trackers having the same item.
     */
    @Test
    public void testEqualsOne() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("hhh", 0);
        c2.addCalories("hhh", 0);
        assertEquals(c.equals(c2), true);
    }

    /**
     * Tests equals with both calorie trackers having multiple same items.
     */
    @Test
    public void testEqualsMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("hhh", 0);
        c.addCalories("ggg", 1);
        c.addCalories("iii", 2);
        c2.addCalories("hhh", 0);
        c2.addCalories("ggg", 1);
        c2.addCalories("iii", 2);
        assertEquals(c.equals(c2), true);
    }

    /**
     * Tests equals with both calorie trackers having multiple different items.
     */
    @Test
    public void testEqualsMultipleFalse() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("hhh", 0);
        c.addCalories("ggg", 1);
        c.addCalories("iii", 2);
        c2.addCalories("hhhaa", 0);
        c2.addCalories("ggggggg", 1);
        c2.addCalories("iiiffff", 2);
        assertEquals(c.equals(c2), false);
    }

    /**
     * Tests hashcode with two empty calorie trackers.
     */
    @Test
    public void testHashCode() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        assertEquals(c.hashCode(), c2.hashCode());
    }

    /**
     * Tests hashcode with two calorie trackers with the same item.
     */
    @Test
    public void testHashCodeNonEmpty() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("hi", 1);
        c2.addCalories("hi", 1);
        assertEquals(c.hashCode(), c2.hashCode());
    }

    /**
     * Tests hashcode with two calorie trackers with the multiple items.
     */
    @Test
    public void testHashCodeMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("hi", 1);
        c.addCalories("hi2", 1);
        c.addCalories("hi3", 1);
        c2.addCalories("hi", 1);
        c2.addCalories("hi2", 1);
        c2.addCalories("hi3", 1);
        assertEquals(c.hashCode(), c2.hashCode());
    }

    /**
     * Tests compareTo with two empty calorie trackers.
     */
    @Test
    public void testCompareToEmpty() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        assertEquals(c.compareTo(c2), 0);
    }

    /**
     * Tests compareTo where one calorie tracker is less in total calories than
     * the other.
     */
    @Test
    public void testCompareToNegative() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("h", 2);
        c2.addCalories("h", 400);
        assertEquals(c.compareTo(c2), -1);
    }

    /**
     * Tests compareTo where one calorie tracker is greater in total calories
     * than the other.
     */
    @Test
    public void testCompareToPositive() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("h", 20000);
        c2.addCalories("h", 400);
        assertEquals(c.compareTo(c2), 1);
    }

    /**
     * Tests compareTo where one calorie tracker is equal in total calories with
     * the other but both are non-empty.
     */
    @Test
    public void testCompareToEqualNonEmpty() {
        CalorieTrackerSecondary c = this.constructor();
        CalorieTrackerSecondary c2 = this.constructor();
        c.addCalories("h", 20000);
        c.addCalories("h2", 20000);
        c.addCalories("h3", 20000);
        c2.addCalories("h", 20000);
        c2.addCalories("h2", 20000);
        c2.addCalories("h3", 20000);
        assertEquals(c.compareTo(c2), 0);
    }

    /**
     * Tests addMultiple 0 times.
     */
    @Test
    public void testAddMultipleZero() {
        CalorieTrackerSecondary c = this.constructor();
        c.addMultiple("food", 10, 0);
        assertEquals(c.getTotal(), 0);
        assertEquals(c.size(), 0);
    }

    /**
     * Tests addMultiple one time.
     */
    @Test
    public void testAddMultipleSingle() {
        CalorieTrackerSecondary c = this.constructor();
        c.addMultiple("food", 10, 1);
        assertEquals(c.getTotal(), 10);
        assertEquals(c.size(), 1);
        Stack<String> stack = c.getAdditions();
        assertEquals(stack.pop(), "food");
        stack.push("food");
        Map<String, Integer> map = c.getCalorieMap();
        assertEquals(map.hasKey("food"), true);
        int value = map.value("food");
        assertEquals(value, 10);
    }

    /**
     * Tests addMultiple multiple times.
     */
    @Test
    public void testAddMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        c.addMultiple("food", 10, 5);
        assertEquals(c.getTotal(), 50);
        assertEquals(c.size(), 5);
        Stack<String> stack = c.getAdditions();
        assertEquals(stack.pop(), "food");
        assertEquals(stack.pop(), "food");
        assertEquals(stack.pop(), "food");
        assertEquals(stack.pop(), "food");
        assertEquals(stack.pop(), "food");
        stack.push("food");
        stack.push("food");
        stack.push("food");
        stack.push("food");
        stack.push("food");
        Map<String, Integer> map = c.getCalorieMap();
        assertEquals(map.hasKey("food"), true);
        int value = map.value("food");
        assertEquals(value, 10);
    }

    /**
     * Tests getHighest with a calorie tracker with one item.
     */
    @Test
    public void testGetHighestOne() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("h", 1);
        assertEquals(c.getHighest(), "h");
    }

    /**
     * Tests getHighest with a calorie tracker with multiple items.
     */
    @Test
    public void testGetHighestMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("h", 1);
        c.addCalories("hi", 2);
        c.addCalories("hig", 2000);
        c.addCalories("high", 1999);
        assertEquals(c.getHighest(), "hig");
    }

    /**
     * Tests getLowest with a calorie tracker with one item.
     */
    @Test
    public void testGetLowestOne() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("h", 1);
        assertEquals(c.getLowest(), "h");
    }

    /**
     * Tests getLowest with a calorie tracker with multiple items.
     */
    @Test
    public void testGetLowestMultiple() {
        CalorieTrackerSecondary c = this.constructor();
        c.addCalories("h", 1);
        c.addCalories("hi", 2);
        c.addCalories("hig", 2000);
        c.addCalories("high", 1999);
        c.addCalories("highe", 0);
        assertEquals(c.getLowest(), "highe");
    }
}
