import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class clock extends JFrame {

    // declare variables to store date and time
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    String time;
    String day;
    String date;

    // create labels to display the date and time
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;

    // constructor for the clock class
    clock() {
        // set the properties of the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 220);
        this.setResizable(false);

        // initialize the time and date formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM, yyyy");

        // initialize the labels and set their properties
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.BOLD, 34));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.BOLD, 30));

        // add the labels to the window and make it visible
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        // start the timer to update the clock every second
        setTimer();
    }

    // method to update the clock every second
    public void setTimer() {
        while (true) {
            // get the current time, day, and date
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            // wait for 1 second before updating again
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    // main method to create a new instance of the clock class
    public static void main(String[] args) {
        new clock();
    }
}
