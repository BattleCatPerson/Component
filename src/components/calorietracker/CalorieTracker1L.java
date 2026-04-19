package components.calorietracker;

import components.map.Map;
import components.map.Map1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * @convention $this.limit > 0 && $this.total > 0 && this.additions != null &&
 *             this.calorieMap != null
 * @correspondence this = $this.calorieMap
 */
public class CalorieTracker1L extends CalorieTrackerSecondary {

    /**
     * Representation of this.
     */
    private Map<String, Integer> calorieMap;
    /**
     * Tracks additions.
     */
    private Stack<String> additions;
    /**
     * Tracks limit.
     */
    private int limit;
    /**
     * Tracks total calories.
     */
    private int total;

    /**
     * Creates initial representation.
     */
    private void createNewRep() {
        this.additions = new Stack1L<String>();
        this.calorieMap = new Map1L<String, Integer>();
        this.limit = 0;
        this.total = 0;
    }

    /**
     * No argument constructor.
     */
    public CalorieTracker1L() {
        this.createNewRep();
    }

    // Standard Methods
    @Override
    public final CalorieTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(CalorieTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof CalorieTracker1L : "Violation of: source is of dynamic type CalorieTracker1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        CalorieTracker1L localSource = (CalorieTracker1L) source;
        this.additions = source.getAdditions();
        this.calorieMap = source.getCalorieMap();
        this.limit = source.getLimit();
        this.total = source.getTotal();
        localSource.createNewRep();
    }

    // Kernel
    @Override
    public final void setLimit(int l) {
        assert l >= 0;
        this.limit = l;
    }

    @Override
    public final int getLimit() {
        return this.limit;
    }

    @Override
    public final void addCalories(String n, int c) {
        assert c >= 0;
        if (this.calorieMap.hasKey(n)) {
            assert this.calorieMap.value(n) == c;
        } else {
            this.calorieMap.add(n, c);
        }
        this.total += c;
        this.additions.push(n);

    }

    @Override
    public final boolean overLimit() {
        return this.total > this.limit;
    }

    @Override
    public final int getTotal() {
        return this.total;
    }

    @Override
    public final int size() {
        return this.additions.length();
    }

    @Override
    public Stack<String> getAdditions() {
        return this.additions;
    }

    @Override
    public Map<String, Integer> getCalorieMap() {
        return this.calorieMap;
    }
}
