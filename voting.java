import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Scanner;

public class voting extends Applet {
    public int count1;
    public int count2;
    public int count3;
    public int count4;
    public int count5;

    public Button vote;
    TextField lp;
    TextField rp;
    TextField dp;
    TextField gp;
    TextField cp;

    public void init() {
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;

        this.setBackground(Color.green);
        setLayout(new BorderLayout());

        Panel p1 = new Panel();
        p1.setBackground(Color.lightGray);
        p1.setLayout(new GridLayout(8, 2, 3, 2));

        Checkbox ch1 = new Checkbox("Libertarian Party");
        Checkbox ch2 = new Checkbox("Republican Party");
        Checkbox ch3 = new Checkbox("Democratic Party");
        Checkbox ch4 = new Checkbox("Green Party");
        Checkbox ch5 = new Checkbox("Constitution Party");

        lp = new TextField("Lp: " + String.valueOf(count1));
        lp.setEditable(false);
        rp = new TextField("Rp: " + String.valueOf(count2));
        rp.setEditable(false);
        dp = new TextField("Dp: " + String.valueOf(count3));
        dp.setEditable(false);
        gp = new TextField("Gp: " + String.valueOf(count4));
        gp.setEditable(false);
        cp = new TextField("Cp: " + String.valueOf(count5));
        cp.setEditable(false);

        handlelp lpp = new handlelp();
        p1.add(ch1);
        ch1.addItemListener(lpp);
        p1.add(lp);

        handlerp rpp = new handlerp();
        p1.add(ch2);
        ch2.addItemListener(rpp);
        p1.add(rp);

        handledp dpp = new handledp();
        p1.add(ch3);
        ch3.addItemListener(dpp);
        p1.add(dp);

        handlegp gpp = new handlegp();
        p1.add(ch4);
        ch4.addItemListener(gpp);
        p1.add(gp);

        handlecp cpp = new handlecp();
        p1.add(ch5);
        ch5.addItemListener(cpp);
        p1.add(cp);

        add("North", p1);

        Label l = new Label("Choose a Party to which you want to give the vote");
        Font f = new Font("Helvetica", Font.BOLD, 32);
        l.setFont(f);
        add("Center", l);

        SingleAction sa = new SingleAction();
        vote = new Button("Count number of votes");
        vote.addActionListener(sa);
        add("South", vote);
    }

    class handlelp implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED)
                count1++;
        }
    }

    class handlerp implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED)
                ++count2;
        }
    }

    class handledp implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED)
                ++count3;
        }
    }

    class handlegp implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED)
                ++count4;
        }
    }

    class handlecp implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED)
                ++count5;
        }
    }

    class SingleAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            lp.setText("Lp :" + String.valueOf(count1));
            rp.setText("Rp :" + String.valueOf(count2));
            dp.setText("Dp :" + String.valueOf(count3));
            gp.setText("Gp :" + String.valueOf(count4));
            cp.setText("Cp :" + String.valueOf(count5));
        }
    }

    public class OnlineVotingSystem {

        private static int candidate1Votes;
        private static int candidate2Votes;

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("Welcome to the Online Voting System!");

            boolean votingClosed = false;
            while (!votingClosed) {
                System.out.println("Please vote for your preferred candidate:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");

                int vote = input.nextInt();

                if (vote == 1) {
                    candidate1Votes++;
                    System.out.println("Thank you for voting for Candidate A!");
                } else if (vote == 2) {
                    candidate2Votes++;
                    System.out.println("Thank you for voting for Candidate B!");
                } else {
                    System.out.println("Invalid vote. Please try again.");
                }

                System.out.println("Do you want to continue voting? (y/n)");
                String response = input.next();

                if (response.equals("n")) {
                    votingClosed = true;
                }
            }

            System.out.println("Voting has closed. Here are the final results:");
            System.out.println("Candidate A: " + candidate1Votes + " votes");
            System.out.println("Candidate B: " + candidate2Votes + " votes");

            if (candidate1Votes > candidate2Votes) {
                System.out.println("Candidate A has won the election!");
            } else if (candidate2Votes > candidate1Votes) {
                System.out.println("Candidate B has won the election!");
            } else {
                System.out.println("The election is a tie!");
            }

            System.out.println("Thank you for using the Online Voting System!");
        }
    }
}