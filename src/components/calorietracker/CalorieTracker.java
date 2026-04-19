package components.calorietracker;

/**
 * {@code CalorieTrackerKernel} enhanced with secondary methods.
 */
public interface CalorieTracker
        extends Comparable<CalorieTracker>, CalorieTrackerKernel {
    /**
     * Adds an item with name n and calorie amount c x times.
     *
     * @param n
     *            Name of the item
     * @param c
     *            Calories count of the item
     * @param x
     *            Number of times to add the item
     * @requires c > 0
     * @updates this
     * @ensures this has the item in its entries, this.additions has x amounts
     *          of the entry, and totalCalories is updated
     */
    void addMultiple(String n, int c, int x);

    /**
     * Returns the name of the item in this.additions with the highest calorie
     * amount.
     *
     * @return the name of the item with the highest calories
     * @requires |this.additions| > 0
     * @ensures getHighest = the name of the item with the highest calories
     */
    String getHighest();

    /**
     * Returns the name of the item in this.additions with the lowest calorie
     * amount.
     *
     * @return the name of the item with the lowest calories
     * @requires |this.additions| > 0
     * @ensures getHighest = the name of the item with the lowest calories
     */
    String getLowest();
}
