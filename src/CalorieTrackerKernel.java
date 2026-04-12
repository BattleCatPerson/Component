import components.map.Map;
import components.stack.Stack;
import components.standard.Standard;

/**
 * Calorie tracker kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathsubtypes <pre>
 * PARTIAL_FUNCTION is finite set of (key: String, value: Integer)
 *  exemplar m
 *  constraint
 *   for all key1, key2: String, value1, value2: Integer
 *     where ((key1, value1) is in m  and  (key2, value2) is in m)
 *    (if key1 = key2 then value1 = value2)
* </pre>
 * @mathdefinitions <pre>
 * DOMAIN(
 *   m: PARTIAL_FUNCTION
 *  ): finite set of String satisfies
 *  for all key: String (key is in DOMAIN(m) iff
 *   there exists value: Integer ((key, value) is in m))
 * </pre>
 * @mathmodel type NaturalNumberKernel is modeled by PARTIAL_FUNCTION
 */
public interface CalorieTrackerKernel extends Standard<CalorieTracker> {
    /**
     * Sets calories limit of {@this}
     *
     * @param l
     *            the {@code int} the limit will become
     * @requires l >= 0
     * @updates this
     * @ensures limit = l
     */
    void setLimit(int l);

    /**
     * Returns calorie limit of {@this}
     *
     * @ensures getLimit = this.limit
     */
    int getLimit();

    /**
     * Adds an item with a name and calorie amount to this
     *
     * @param n
     *            name of the item
     * @param c
     *            calories in the item
     * @updates this
     * @requires c == this.value(n) if n is in this.keys()
     * @requires c >= 0
     * @ensures this = #this union {(n, c)}, this.additions gains the entry, and
     *          this.calories is updated
     */
    void addCalories(String n, int c);

    /**
     * Returns whether total calories is over the calorie limit
     *
     * @return true if total calories is over the limit
     * @ensures overLimit = totalCalories > limit
     */
    boolean overLimit();

    /**
     * Returns total calories
     *
     * @return total calories
     * @ensures getTotal = totalCalories
     */
    int getTotal();

    /**
     * Returns the size of additions
     *
     * @return the calorie amount
     * @ensures {size = |this.additions|}
     */
    int size();

    /**
     * Returns additions
     *
     * @return this.additions
     * @ensures {getAdditions = this.additions}
     */
    Stack<String> getAdditions();

    /**
     * Returns calorieMap
     *
     * @return calorieMap
     * @ensures {getCalorieMap = this.calorieMap}
     */
    Map<String, Integer> getCalorieMap();
}
