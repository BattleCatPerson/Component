package components.calorietracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Tests for calorie tracker kernel methods.
 */
public class CalorieTrackerKernelTest {
    /**
     * Constructor for kernel.
     *
     * @return valid CalorieTrackerKernel
     */
    private CalorieTracker constructor() {
        return new CalorieTracker1L();
    }

    /**
     * Test for addCalories.
     */
    @Test
    public final void testAddCalories() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
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
     * Test for addCalories with multiple items.
     */
    @Test
    public final void testAddCaloriesMultiple() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("food2", 110);
        c.addCalories("food3", 1110);
        assertEquals(c.getTotal(), 1230);
        assertEquals(c.size(), 3);
        Stack<String> stack = c.getAdditions();
        assertEquals(stack.pop(), "food3");
        assertEquals(stack.pop(), "food2");
        assertEquals(stack.pop(), "food");
        stack.push("food");
        stack.push("food2");
        stack.push("food3");
        Map<String, Integer> map = c.getCalorieMap();
        assertEquals(map.hasKey("food"), true);
        assertEquals(map.hasKey("food2"), true);
        assertEquals(map.hasKey("food3"), true);
        int value = map.value("food");
        assertEquals(value, 10);
        value = map.value("food2");
        assertEquals(value, 110);
        value = map.value("food3");
        assertEquals(value, 1110);
    }

    /**
     * Test for setLimit with value of 0.
     */
    @Test
    public final void testSetLimitZero() {
        CalorieTracker c = this.constructor();
        c.setLimit(0);
        assertEquals(c.getLimit(), 0);
    }

    /**
     * Test for setLimit with non-zero value.
     */
    @Test
    public final void testSetLimit() {
        CalorieTracker c = this.constructor();
        c.setLimit(500);
        assertEquals(c.getLimit(), 500);
    }

    /**
     * Test for getLimit with initial value of 0.
     */
    @Test
    public final void testGetLimitZero() {
        CalorieTracker c = this.constructor();
        assertEquals(c.getLimit(), 0);
    }

    /**
     * Test for getLimit with a non-zero limit.
     */
    @Test
    public final void testGetLimit() {
        CalorieTracker c = this.constructor();
        c.setLimit(500);
        assertEquals(c.getLimit(), 500);
    }

    /**
     * Test for overLimit where it should return true.
     */
    @Test
    public final void testOverLimitTrue() {
        CalorieTracker c = this.constructor();
        c.addCalories("yo", 599);
        c.setLimit(1);
        assertEquals(c.overLimit(), true);
    }

    /**
     * Test for overLimit where it should retunr false.
     */
    @Test
    public final void testOverLimitFalse() {
        CalorieTracker c = this.constructor();
        c.addCalories("yo", 599);
        c.setLimit(1000);
        assertEquals(c.overLimit(), false);
    }

    /**
     * Test for getTotal with a total of 0.
     */
    @Test
    public final void testGetTotalZero() {
        CalorieTracker c = this.constructor();
        assertEquals(c.getTotal(), 0);
    }

    /**
     * Test for getTotal for one item.
     */
    @Test
    public final void testGetTotalOne() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        assertEquals(c.getTotal(), 10);

    }

    /**
     * Test for getTotal with multiple items.
     */
    @Test
    public final void testGetTotalMultiple() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        assertEquals(c.getTotal(), 40);
    }

    /**
     * Test for size with no items.
     */
    @Test
    public final void testSizeZero() {
        CalorieTracker c = this.constructor();
        assertEquals(c.size(), 0);
    }

    /**
     * Test for size with one item.
     */
    @Test
    public final void testSizeOne() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        assertEquals(c.size(), 1);
    }

    /**
     * Test for size with many items.
     */
    @Test
    public final void testSizeMany() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        assertEquals(c.size(), 4);
    }

    /**
     * Test for getAdditions with no items.
     */
    @Test
    public final void testGetAdditionsEmpty() {
        CalorieTracker c = this.constructor();
        assertEquals(c.getAdditions(), new Stack1L<String>());
    }

    /**
     * Test for getAdditions with one item.
     */
    @Test
    public final void testGetAdditionsOne() {
        CalorieTracker c = this.constructor();
        c.addCalories("hello", 0);
        Stack<String> stack = new Stack1L<String>();
        stack.push("hello");
        assertEquals(c.getAdditions(), stack);
    }

    /**
     * Test for getAdditions with many items.
     */
    @Test
    public final void testGetAdditionsMany() {
        CalorieTracker c = this.constructor();
        c.addCalories("hello", 0);
        c.addCalories("hello2", 0);
        c.addCalories("hello3", 0);
        Stack<String> stack = new Stack1L<String>();
        stack.push("hello");
        stack.push("hello2");
        stack.push("hello3");
        assertEquals(c.getAdditions(), stack);
    }

    /**
     * Test for getCalorieMap with no items.
     */
    @Test
    public final void testGetCalorieMapEmpty() {
        CalorieTracker c = this.constructor();
    }

    /**
     * Test for getCalorieMap with one item.
     */
    @Test
    public final void testGetCalorieMapOne() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        Map<String, Integer> map = new Map1L<String, Integer>();
        map.add("food", 10);
        assertEquals(map, c.getCalorieMap());
    }

    /**
     * Test for getCalorieMap with multiple of the same item.
     */
    @Test
    public final void testGetCalorieMapMultipleSame() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        c.addCalories("food", 10);
        Map<String, Integer> map = new Map1L<String, Integer>();
        map.add("food", 10);
        assertEquals(map, c.getCalorieMap());
    }

    /**
     * Test for getCalorieMap with multiple different items.
     */
    @Test
    public final void testGetCalorieMapMultipleDifferent() {
        CalorieTracker c = this.constructor();
        c.addCalories("food", 10);
        c.addCalories("food2", 10);
        c.addCalories("food3", 10);
        c.addCalories("food4", 10);
        Map<String, Integer> map = new Map1L<String, Integer>();
        map.add("food", 10);
        map.add("food2", 10);
        map.add("food3", 10);
        map.add("food4", 10);
        assertEquals(map, c.getCalorieMap());
    }
}