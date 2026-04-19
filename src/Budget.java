import components.calorietracker.CalorieTracker;
import components.calorietracker.CalorieTracker1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class Budget {
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("What is your budget (in dollars and cents)? ");
        double budget = in.nextDouble();
        String answer = "y";
        CalorieTracker tracker = new CalorieTracker1L();
        tracker.setLimit((int) (budget * 100));
        while (answer.equals("y")) {
            out.print("Enter the name of the item: ");
            String name = in.nextLine();
            out.print(
                    "Enter its price in dollars and cents (make sure if you adding an item already added before that the prices are the same)): ");
            double price = in.nextDouble();
            out.print("How many times would you like to add that item? ");
            int times = in.nextInteger();
            tracker.addMultiple(name, (int) (price * 100), times);
            if (tracker.overLimit()) {
                out.println("You are over your budget.");
            }
            out.print("Would you like to add another item (y/Y for yes)? ");
            answer = in.nextLine();
        }
        System.out.format("Total: $%.2f%n", tracker.getTotal() / 100.0);
        if (tracker.overLimit()) {
            out.println("Over budget: yes");
        } else {
            out.println("Over budget: no");
        }
        if (tracker.size() > 0) {
            out.println("Most expensive item: " + tracker.getHighest());
            out.println("Least expensive item: " + tracker.getLowest());
        }
        in.close();
        out.close();
    }

}
