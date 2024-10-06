// Team class to represent a soccer team and its points
public class Team implements Comparable<Team> {
    private String name;   // Name of the team
    private int points;    // Points accumulated by the team

    // Constructor to initialize a team with its name
    public Team(String name) {
        this.name = name;
        this.points = 0;  // Initial points are set to 0
    }

    // Getter method to retrieve the team's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the team's points
    public int getPoints() {
        return points;
    }

    // Method to add points to the team's total
    public void addPoints(int points) {
        this.points += points;
    }

    // compareTo method to compare two teams based on points (and alphabetically if tied)
    @Override
    public int compareTo(Team other) {
        // If points are different, sort by points in descending order
        if (this.points != other.points) {
            return Integer.compare(other.points, this.points); // Higher points come first
        } else {
            return this.name.compareTo(other.name);  // If points are the same, sort alphabetically
        }
    }

    // toString method to return the team's name and points as a string
    @Override
    public String toString() {
        return name + " " + points;  // Format: TeamName Points
    }
}
