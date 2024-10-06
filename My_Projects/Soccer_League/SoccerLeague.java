import java.util.*;

// SoccerLeague class to simulate a soccer league
public class SoccerLeague {
    private Map<String, Team> teamMap;  // Stores the teams and their points
    private Random random;              // Random number generator for scores

    // Constructor to initialize the team map and random generator
    public SoccerLeague() {
        teamMap = new TreeMap<>();  // TreeMap keeps teams in alphabetical order
        random = new Random();      // Random instance for generating scores
    }

    // Generate realistic soccer scores with some bias to add variability
    private int generateRandomScore(int bias) {
        return random.nextInt(5 + bias); // Scores between 0 and 5 with an optional bias
    }

    // Simulate a match between two teams, generate random scores, and update points
    private void playRandomMatch(String team1Name, String team2Name) {
        // Add teams to the map if they don't already exist
        teamMap.putIfAbsent(team1Name, new Team(team1Name));
        teamMap.putIfAbsent(team2Name, new Team(team2Name));

        // Generate random scores with some variability
        int team1Score = generateRandomScore(1);  // Add a bias to team 1 for variability
        int team2Score = generateRandomScore(0);  // Team 2 without bias

        // Prevent too many draws by adjusting team 2's score in case of a tie
        if (team1Score == team2Score) {
            team2Score += random.nextInt(2);  // Slightly adjust team 2's score to reduce ties
        }

        // Print the match result
        System.out.println(team1Name + " " + team1Score + ", " + team2Name + " " + team2Score);

        // Update points based on the match result
        if (team1Score > team2Score) {
            teamMap.get(team1Name).addPoints(3);  // Team 1 wins, gets 3 points
        } else if (team1Score < team2Score) {
            teamMap.get(team2Name).addPoints(3);  // Team 2 wins, gets 3 points
        } else {
            teamMap.get(team1Name).addPoints(1);  // Draw, both teams get 1 point
            teamMap.get(team2Name).addPoints(1);
        }
    }

    // Method to simulate matches between pairs of teams
    public void playMatches(List<String> teams) {
        for (int i = 0; i < teams.size(); i += 2) {
            String team1 = teams.get(i);
            String team2 = teams.get(i + 1);
            playRandomMatch(team1, team2);  // Simulate a match between two teams
        }
    }

    // Print the final ranking of teams based on their points
    public void printRanking() {
        // Convert the map values (teams) into a sorted list
        List<Team> ranking = new ArrayList<>(teamMap.values());
        Collections.sort(ranking);  // Sort the teams by points and alphabetically for ties

        int rank = 1;  // Initial rank
        // Iterate through the sorted list and print the rankings
        for (int i = 0; i < ranking.size(); i++) {
            // If current team has the same points as the previous one, they share the same rank
            if (i > 0 && ranking.get(i).getPoints() != ranking.get(i - 1).getPoints()) {
                rank = i + 1;  // Adjust rank only when points are different
            }
            System.out.println(rank + ". " + ranking.get(i));  // Print rank and team info
        }
    }

    public static void main(String[] args) {
        SoccerLeague league = new SoccerLeague();  // Create a new soccer league

        // List of teams for the league
        List<String> teams = Arrays.asList(
                "Liverpool", "ManchesterUnited",
                "Tarantulas2", "FC Awesome",
                "Lions", "FCAwesome",
                "Grouches", "Tarantulas2"
        );

        // Simulate random matches between the teams
        league.playMatches(teams);

        // Print the final rankings based on points
        System.out.println("\nFinal Rankings:");
        league.printRanking();
    }
}
