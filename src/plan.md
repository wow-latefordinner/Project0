Project0

  Idea 1:  Budget Tracker

1. Record Income and Expenses
    - Classify as income or expense
      - Condition:  I or E only valid choices
    - Provide description of income or expense
      - Condition:  Description required, as measure by not null (ignore quality of value)
    - Enter dollar amount
      - Condition:  positive number
2. View information
    - All entries
    - Total Income (future?)
      - Sum of entries where classification = "I"
    - Total Expense (future?)
      - Sum of entries where classification = "E"
    - Net Income (future?)
      - Sum of entries where classification = "I" minus Sum of entries where classification = "E"'
3. Future ideas
    - Expected date of item
    - Ability to update an item
    - Save budget for later viewing
    - Format output as US Dollars
    - Ability to delete budget entry
    - Assign unique entry id to each record using some form of sequence generator


   Idea 2: Gross Profit Calculator
1. Record information about item for sale:
   - Item Number
     - Condition: not null; integer
   - Item Description
     - Condition: not null
   - Item Selling Price
     - Condition: > 0 and <= 10,000
   - Item Unit Cost
     - Condition: > 0 and <= 10,000
   - Units sold
     - Condition: integer only
     - Condition: > 0
2. View information
   - Total Revenue (selling price * units sold)
   - Total Cost (unit cost * units sold)
   - Total Gross profit ((selling price - unit cost) * units sold)
3. Future ideas:
   - Constraint Selling Price and Unit Cost number in USD
   - add order functions to allow total revenue/cost/gross profit amounts
   - item number unique when > 1 items entered
