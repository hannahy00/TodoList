package tests;

import exceptions.DateException;
import org.junit.jupiter.api.Test;
import model.Item;
import model.RegularItem;
import model.UrgentItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item;
    private List<Item> itemList = new ArrayList<>();
    private RegularItem item1;
    private static String itemDescription = "description";

    @Test
    void testToSting() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2019");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        Item item = new RegularItem("description", dueDate);
        assertEquals("description due on 12/12/2019", item.toString());
    }

    @Test
    public void testGetRegularItemDescription() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2019");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        Item item = new RegularItem("description", dueDate);
        assertEquals("description", item.getItemDescription());
    }

    @Test
    public void testGetUrgentItemDescription() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2019");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        Item item = new UrgentItem("description", dueDate);
        assertEquals("DESCRIPTION", item.getItemDescription());
    }

    @Test
    public void testGetDueDate() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2019");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        Item item = new RegularItem("description", dueDate);
        assertEquals("12/12/2019", item.getDueDate());
    }

    @Test
    void testRegularThrowDateException() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2018");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        try {
            Item item = new RegularItem("description", dueDate);
            fail("exception not caught");
        } catch (DateException e) {
            System.out.println("date has already passed");
        }
    }

    @Test
    void testUrgentThrowDateException() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2018");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        try {
            Item item = new UrgentItem("description", dueDate);
            fail("exception not caught");
        } catch (DateException e) {
            System.out.println("date has already passed");
        }
    }

    @Test
    void testNotThrowDateException() throws ParseException, DateException {
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse("12/12/2019");

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        try {
            Item item = new RegularItem("description", dueDate);
        } catch (DateException e) {
            fail("exception not supposed to be caught");
        }
    }
}
