package model;

import exceptions.DateException;
import java.text.ParseException;

public class RegularItem extends Item {

    public RegularItem(String description, String date) throws DateException, ParseException {
        itemDescription = description;
        dueDate = date;

        if (getDateDueDate(dueDate).before(getToday())) {
            throw new DateException();
        }

    }

}