package data.users;

import java.util.ArrayList;
import java.util.Arrays;

public class UsersData {
    public static ArrayList<User> userList = new ArrayList<>(Arrays.asList(
            new User("1", "test@gmail.com", "Test", "User", "12345"),
            new User("2", "sample@gmail.com", "Sample", "User", "password")
    ));

    public static User currentUser = null;
}
