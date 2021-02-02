package model;

import exceptions.DateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UrgentItem extends Item {

    public UrgentItem(String description, String date) throws DateException, ParseException {
        itemDescription = description.toUpperCase();
        dueDate = date;

        if (getDateDueDate(dueDate).before(getToday())) {
            throw new DateException();
        }
    }
}