package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPractice {

    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");
        List<User> list = new ArrayList<User>();
        list.add(a);
        list.add(b);
        list = List.of(a, b);
        List<User> users = Arrays.asList(a, b);

        list.remove(a);

    }

    static class User {
        String name;

        public User(String name) {
            this.name = name;
        }
    }
}
