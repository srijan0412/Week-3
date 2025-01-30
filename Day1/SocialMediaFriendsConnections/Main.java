package SocialMediaFriendsConnections;

public class Main {
    // Main method to test the Social Media Friend Connection System
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser("alice", "Alice", 25);
        sm.addUser("bob", "Bob", 27);
        sm.addUser("charlie", "Charlie", 24);
        sm.addUser("david", "David", 26);

        sm.addFriend("alice", "bob");
        sm.addFriend("alice", "charlie");
        sm.addFriend("bob", "david");
        sm.addFriend("charlie", "david");

        System.out.println("\nDisplaying all friends:");
        sm.findUserWithUserId("alice");
        sm.findUserWithUserId("bob");
        sm.findUserWithUserId("charlie");
        sm.findUserWithUserId("david");

        System.out.println("\nFinding mutual friends:");
        sm.findMutualFriends("alice", "bob");
        sm.findMutualFriends("alice", "david");

        System.out.println("\nSearching for users:");
        sm.findUserWithUserId("charlie");
        sm.findUserWithName("Charlie");

        System.out.println("\nCounting friends:");
        sm.countFriends();
    }
}
