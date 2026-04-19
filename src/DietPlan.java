import components.calorietracker.CalorieTracker;
import components.calorietracker.CalorieTracker1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class DietPlan {
    public static void main(String[] args) {
        CalorieTracker tracker = new CalorieTracker1L();
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("What is your calorie limit? ");
        int limit = in.nextInteger();
        tracker.setLimit(limit);
        String answer = "y";
        while (answer.equals("y")) {
            out.print("Enter the name of the item: ");
            String name = in.nextLine();
            out.print(
                    "Enter the number of calories it has (make sure if it shares the same name with another item that the number is the same): ");
            int calories = in.nextInteger();
            out.print("How many times would you like to add that item? ");
            int times = in.nextInteger();
            tracker.addMultiple(name, calories, times);
            if (tracker.overLimit()) {
                out.println("You are over your calorie limit.");
            }
            out.print("Would you like to add another item (y/Y for yes)? ");
            answer = in.nextLine();
        }
        out.println("Finished adding items.\nTotal Items: ");
        out.print(tracker.toString());
        if (tracker.overLimit()) {
            out.println("Over limit: yes");
        } else {
            out.println("Over limit: no");
        }
        in.close();
        out.close();
    }
}
