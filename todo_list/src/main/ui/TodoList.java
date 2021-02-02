package ui;

import exceptions.DateException;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TodoList extends JFrame implements ActionListener {

    private ArrayList<Item> todolist = new ArrayList<>();
    private Date dueDate;
    private JLabel label;
    private JLabel dateLabel;
    private JLabel error;
    private JTextField field;
    private JTextField dateField;
    private JTextArea textArea;

    private TodoList() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());

        textArea = new JTextArea(10, 20);

        JButton addUrgentTask = new JButton(new AbstractAction("Add urgent task") {

            // MODIFIES: this
            // EFFECTS: if Urgent Item button is pressed makes a new Urgent Item and displays task list in
            //          the text area
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UrgentItem urgentItem = new UrgentItem(field.getText(), inputDueDate());
                    todolist.add(urgentItem);
                    error.setText("");

                } catch (ParseException ex) {
                    ex.printStackTrace();
                } catch (DateException e1) {
                    error.setText("This date already passed");
                }
                textArea.setText("Task list: " + todolist);
            }
        });
        addUrgentTask.addActionListener(this);

        JButton addRegularTask = new JButton(new AbstractAction("Add regular task") {

            // MODIFIES: this
            // EFFECTS: if Regular Item button is pressed makes a new Regular Item and displays task list in
            //          the text area
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RegularItem item = new RegularItem(field.getText(), inputDueDate());
                    todolist.add(item);
                    error.setText("");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                } catch (DateException e1) {
                    error.setText("This date already passed");
                }
                textArea.setText("Task list: " + todolist);
            }
        });

        addRegularTask.addActionListener(this);

        error = new JLabel("");
        label = new JLabel("Enter a task: ");
        field = new JTextField(12);

        dateLabel = new JLabel(("Due date (MM/dd/yyyy): "));
        dateField = new JTextField(15);

        add(label);
        add(field);
        add(dateLabel);
        add(dateField);
        add(addRegularTask);
        add(addUrgentTask);
        add(textArea);
        add(error);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: retrieves the due date from dateField and turns it into a date from a string,
    //          returns the due date in date format
    private String inputDueDate() throws ParseException {
        String dueDateString = dateField.getText();
        DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date unformatDate = inputFormatter.parse(dueDateString);

        DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String dueDate = formatDate.format(unformatDate);
        return dueDate;
    }

    // EFFECTS: makes a new TodoList
    public static void main(String[] args) {
        new TodoList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
