import org.example.Exception.BudgetTrackerException;

import org.example.Model.budgetTracker;
import org.example.Service.BudgetTrackerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestBudgetTracker {

    BudgetTrackerService budgetTrackerService;

//    Reset the budget tracker service before each test
    @Before
    public void setUp(){
        budgetTrackerService = new BudgetTrackerService();
    }

//    Test entering budget entry works

    @Test
    public void budgetTrackerServiceEntry(){
        String entryType = "I";
        String description = "bob";
        double amount = 1.00;

        try {
            budgetTrackerService.addBudgetTracker(entryType, description, amount);
            List<budgetTracker> budgets = budgetTrackerService.getBudgetTrackerList();
            budgetTracker actual = budgets.get(0);
            Assert.assertEquals(entryType, actual.getEntryType());
            Assert.assertEquals(description, actual.getDescription());
            Assert.assertEquals(amount, actual.getAmount(), 0.0);
        }
        catch (Exception exception) {
            Assert.fail("An exception was raised budget entry failed");        }
    }



    //    Test entering Entry type without I or E

    @Test
    public void budgetTrackerServiceEntryType(){
        String entryType = "i";
        String description = "bob";
        double amount = 1.00;

        try {
            budgetTrackerService.addBudgetTracker(entryType, description, amount);
            Assert.fail("BudgetTrackerException for invalid eventType failed");
        }
        catch (BudgetTrackerException ignored) {
//           This error should have been thrown, so nothing needed
        }
    }

    //    Test entering empty description

    @Test
    public void budgetTrackerDescription(){
        String entryType = "I";
        String description = "";
        double amount = 1.00;

        try {
            budgetTrackerService.addBudgetTracker(entryType, description, amount);
            Assert.fail("BudgetTrackerException for empty description value failed");
        }
        catch (BudgetTrackerException ignored) {
//           This error should have been thrown, so nothing needed
        }
    }

    //    Test entering negative number

    @Test
    public void budgetTrackerNegativeAmount(){
        String entryType = "I";
        String description = "sam";
        double amount = -1.00;

        try {
            budgetTrackerService.addBudgetTracker(entryType, description, amount);
            Assert.fail("BudgetTrackerException for negative amount failed");
        }
        catch (BudgetTrackerException ignored) {
//           This error should have been thrown, so nothing needed
        }
    }


    //    Test entering Amount > 10,000.00 number

    @Test
    public void budgetTrackerLargeAmount(){
        String entryType = "I";
        String description = "sam";
        double amount = 10000.999;

        try {
            budgetTrackerService.addBudgetTracker(entryType, description, amount);
            Assert.fail("BudgetTrackerException for large amount failed");
        }
        catch (BudgetTrackerException ignored) {
//           This error should have been thrown, so nothing needed
        }
    }


}
