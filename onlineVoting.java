import java.util.*;

public class onlineVoting {
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