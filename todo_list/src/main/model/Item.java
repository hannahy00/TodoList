package model;

import ui.TodoList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Item {

    protected String itemDescription;
    protected String dueDate;
    protected Date dateDate;
    protected Date today;

    // EFFECTS: returns itemDescription
    public String getItemDescription() {
        return itemDescription;
    }

    // EFFECTS: returns today's date
    public Date getToday() throws ParseException {
        Date date = new Date();
        String modDate = new SimpleDateFormat("MM/dd/yy").format(date);
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date today = formatter.parse(modDate);
        return today;
    }

    // EFFECTS: returns dueDate
    public String getDueDate() {
        return dueDate;
    }

    // REQUIRES: the due date in String format
    // MODIFIES: this
    // EFFECTS: returns the due date in Date format
    public Date getDateDueDate(String dueDate) throws ParseException {
        dateDate = new SimpleDateFormat("MM/dd/yyyy").parse(dueDate);
        return dateDate;
    }

    // EFFECTS: returns a String statement showing when the item is due
    @Override
    public String toString() {
        return itemDescription + " due on " + getDueDate();
    }
}

