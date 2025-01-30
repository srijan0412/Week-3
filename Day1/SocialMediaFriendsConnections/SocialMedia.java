package SocialMediaFriendsConnections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class UserNode {                                                                                                    
    // Attributes 
    // User ID, Name, Age, and List of Friend IDs
    private String userId;
    private String name;
    private int age;
    public ArrayList<String> friends; 
    public UserNode nextNode;

    // Constructor 
    UserNode(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<String>();
        this.nextNode = null;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("User Id: " + userId);
        System.out.println("Name: " + name);
        System.out.println("age: " + age);
        System.out.println("Friends: ");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }

    // Getters and setters 
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    };
}

public class SocialMedia {
    // Attributes 
    private UserNode headNode;
    private UserNode tailNode;

    // Constructor 
    SocialMedia() {
        this.headNode = null;
        this.tailNode = null;
    }

    // Method to add a user (at the end of the list )
    public void addUser(String userId, String name, int age) {
        UserNode userNode = new UserNode(userId, name, age);

        // Condition if there is no social media accounts 
        if (headNode == null) {
            headNode = userNode;
            tailNode = userNode;
            return;
        }

        tailNode.nextNode = userNode;
        tailNode = userNode;
    }

    // Method to find the user with user-id
    public void findUserWithUserId(String userId) {
        UserNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getUserId() == userId) {
                tempNode.displayDetails();
                return;
            }
            tempNode = tempNode.nextNode;
        }

        System.out.println("User Id doesn't exits.");
    }

    // Method to find the user with name 
    public void findUserWithName(String name) {
        UserNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getName() == name) {
                tempNode.displayDetails();
                return;
            }
            tempNode = tempNode.nextNode;
        }

        System.out.println("User Name doesn't exits.");
    }

    // Method to add friend 
    public void addFriend(String userId1, String userId2) {
        UserNode tempNode = headNode;
        UserNode user1 = null;
        UserNode user2 = null;

        while (tempNode != null) {
            if (tempNode.getUserId() == userId1) {
                user1 = tempNode;
            }
            if (tempNode.getUserId() == userId2) {
                user2 = tempNode;
            }
            tempNode = tempNode.nextNode;
        }

        if (user1 == null || user2 == null) {
            System.out.println("Invalid User ids.");
        }
        else {
            user1.friends.add(userId2);
            user2.friends.add(userId1);
        }
    }

    // Method to remove a friend-Connection 
    public void findMutualFriends(String userId1, String userId2) {
        UserNode tempNode = headNode;
        UserNode user1 = null;
        UserNode user2 = null;

        while (tempNode != null) {
            if (tempNode.getUserId() == userId1) {
                user1 = tempNode;
            }
            if (tempNode.getUserId() == userId2) {
                user2 = tempNode;
            }
            tempNode = tempNode.nextNode;
        }

        if (user1 == null || user2 == null) {
            System.out.println("One or more user are not valid.");
            return;
        }
        
        Set<String> mutualFriends = new HashSet<>(user1.friends);
        mutualFriends.retainAll(user2.friends);

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } 
        else {
            System.out.println("Mutual Friends between " + user1.getName() + " and " + user2.getName() + ":");
            for (String friendId : mutualFriends) {
                System.out.println("friends: " + friendId);
            }
        }
        
    }

    // Method to find the number of friends for each user 
    public void countFriends() {
        UserNode tempNode = headNode;
        while (tempNode != null) {
            System.out.println("User " + tempNode.getName() + " has " + tempNode.friends.size() + " friends.");
            tempNode = tempNode.nextNode;
        }
    }
}

