import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Generic interface representing a candidate in an election
interface Candidate {
    String getName();

    String getDetails(); // Additional details method
}

// Generic class representing a voter
class Voter<T extends Candidate> {
    private String name;
    private String voterId;
    private int age;
    private String address;

    public Voter(String name, String voterId, int age, String address) {
        this.name = name;
        this.voterId = voterId;
        this.age = age;
        this.address = address;
    }

    // Generic method to cast a vote for a candidate
    public void castVote(T candidate) {
        System.out.println(name + " (Voter ID: " + voterId + ") is casting a vote for: " + candidate.getName());
        candidate.castVote(); // Added method to simulate casting a vote
    }

    // Additional details method
    public String getDetails() {
        return "Voter ID: " + voterId + ", Age: " + age + ", Address: " + address;
    }
}

// Generic class representing a party
class Party {
    private String name;
    private String ideology;

    public Party(String name, String ideology) {
        this.name = name;
        this.ideology = ideology;
    }

    public String getName() {
        return name;
    }

    public String getIdeology() {
        return ideology;
    }
}

// Generic class representing an election
class Election<T extends Candidate> {
    private List<T> candidates;

    public Election() {
        this.candidates = new ArrayList<>();
    }

    // Generic method to add a candidate to the election
    public void addCandidate(T candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    // Generic method to conduct the election and declare the winner
    public void conductElection() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates in the election.");
            return;
        }

        System.out.println("Election Results:");
        for (T candidate : candidates) {
            System.out.println(candidate.getName() + " (" + candidate.getDetails() + "): "
                    + Math.random() * 1000 + " votes");
        }

        // Declare the winner (for simplicity, just pick the first candidate)
        T winner = candidates.get(0);
        System.out.println("Winner: " + winner.getName());
    }
}

// Main class to demonstrate generics in the Online Elections System
public class GenericsOnlineElectionsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an election for a generic candidate
        Election<Candidate> genericElection = new Election<>();

        // Add generic candidates to the election
        System.out.print("Enter the name of Candidate A: ");
        String candidateAName = scanner.nextLine();
        System.out.print("Enter additional details for Candidate A (ID, Age, Address): ");
        String candidateADetails = scanner.nextLine();
        genericElection.addCandidate(new GenericCandidate(candidateAName, candidateADetails));

        System.out.print("Enter the name of Candidate B: ");
        String candidateBName = scanner.nextLine();
        System.out.print("Enter additional details for Candidate B (ID, Age, Address): ");
        String candidateBDetails = scanner.nextLine();
        genericElection.addCandidate(new GenericCandidate(candidateBName, candidateBDetails));

        // Conduct the generic election
        genericElection.conductElection();

        // Create an election for a specific type of candidate (e.g., PoliticalCandidate)
        Election<PoliticalCandidate> politicalElection = new Election<>();

        // Add political candidates to the election
        System.out.print("Enter the name of Political Candidate X: ");
        String politicalCandidateXName = scanner.nextLine();
        System.out.print("Enter the party of Political Candidate X: ");
        String politicalCandidateXParty = scanner.nextLine();
        System.out.print("Enter additional details for Political Candidate X (ID, Age, Address): ");
        String politicalCandidateXDetails = scanner.nextLine();
        politicalElection.addCandidate(new PoliticalCandidate(politicalCandidateXName, politicalCandidateXParty,
                politicalCandidateXDetails));

        System.out.print("Enter the name of Political Candidate Y: ");
        String politicalCandidateYName = scanner.nextLine();
        System.out.print("Enter the party of Political Candidate Y: ");
        String politicalCandidateYParty = scanner.nextLine();
        System.out.print("Enter additional details for Political Candidate Y (ID, Age, Address): ");
        String politicalCandidateYDetails = scanner.nextLine();
        politicalElection.addCandidate(new PoliticalCandidate(politicalCandidateYName, politicalCandidateYParty,
                politicalCandidateYDetails));

        // Conduct the political election
        politicalElection.conductElection();
    }
}

// Generic class representing a generic candidate
class GenericCandidate implements Candidate {
    private String name;
    private String details;

    public GenericCandidate(String name, String details) {
        this.name = name;
        this.details = details;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return details;
    }

    // Added method to simulate casting a vote
    public void castVote() {
        System.out.println(name + " received a vote!");
    }
}

// Generic class representing a political candidate
class PoliticalCandidate implements Candidate {
    private String name;
    private String party;
    private String details;

    public PoliticalCandidate(String name, String party, String details) {
        this.name = name;
        this.party = party;
        this.details = details;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return party + ", " + details;
    }

    // Added method to simulate casting a vote
    public void castVote() {
        System.out.println(name + " received a vote!");
    }
}
