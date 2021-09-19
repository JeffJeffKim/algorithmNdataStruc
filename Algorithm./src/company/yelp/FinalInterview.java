package company.yelp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

// Given the following data
// Input: [user0, user1, user2, user3, …, userN]
// Output: [(user1, user2), (user3, user4), …, (userY, userZ)]
// Part 1
// It is possible that some users will not get a match in a particular week, but we want to reduce that number to a minimum. In the basic case, at most one user should go without a match. The solution should take this special case into account.
// You can assume that the input is already random, so there’s no need to reshuffle the list.

// only 2 users, match rule no criteria,

// Part 2
// We don’t want users that are working on the same team to meet for coffee. We will include a new field, team, for each user in the input set, and no pair in the output set should have two users from the same team. As in part 1, minimize the number of users without a match.

class User {
    public String name;
    public String team;

    public User(String name, String team) {
        this.name = name;
        this.team = team;
    }
}

public class FinalInterview {
    // Test data
    public static List<User> test_users = Arrays.asList(

            new User("Da", "infra"),
            new User("Jen", "infra"),
            new User("Infra1", "infra"),
            new User("Infra2", "infra"),
            new User("Infra3", "infra"),
            new User("Alan", "search"),
            new User("Kevin", "search"),
            new User("Neha", "ux"),
            new User("Rachel", "ux")
    );

    public static void main(String[] args) {
        // List<List<String>> result = getMeetings(List.of("A", "B", "C", "D"));
        // System.out.println(result);
        List<List<String>> result = getMeetings(test_users);
        for (List<String> strings : result) {
            System.out.println("strings = " + strings);
        }

        List<List<User>> resultList = getMeetingSet(test_users);
        for (List<User> users : resultList) {
            for (User user : users) {
                System.out.print(user.name+" in "+ user.team + " ");
            }
            System.out.println();
        }
    }

    public static List<List<User>> getMeetingSet(List<User> users) {
        List<List<User>> result = new ArrayList<>();

        // map by team
        Map<String, LinkedList<User>> map = new HashMap<>();
        for (User user : users) {
            if (map.containsKey(user.team)) {
                map.get(user.team).add(user);
            } else {
                LinkedList<User> list = new LinkedList<>();
                list.add(user);
                map.put(user.team, list);
            }
        }

        Queue<LinkedList<User>> membersByTeam = new PriorityQueue<>((o1, o2) -> o2.size() - o1.size());

        for (String team : map.keySet()) {
            membersByTeam.add(map.get(team));
        }

        // maximum two groups will be matched first
        while (!membersByTeam.isEmpty()) {
            LinkedList<User> majorTeam = membersByTeam.poll();
            User memberA = majorTeam.pollFirst();

            if (!membersByTeam.isEmpty()) {
                LinkedList<User> minorTeam = membersByTeam.poll();
                User memberB = minorTeam.pollFirst();

                if(memberA != null && memberB != null)
                    result.add(List.of(memberA, memberB));

                if(!minorTeam.isEmpty())
                    membersByTeam.add(minorTeam);
            }

            if(!majorTeam.isEmpty())
                membersByTeam.add(majorTeam);

        }

        return result;
    }

    public static List<List<String>> getMeetings(List<User> users) {
        List<List<String>> result = new ArrayList<>();

        Map<String, LinkedList<String>> map = new HashMap<>();
        for (User user : users) {
            if (map.containsKey(user.team)) {
                map.get(user.team).add(user.name);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(user.name);
                map.put(user.team, list);
            }
        }

        Queue<LinkedList<String>> membersByTeam = new PriorityQueue<>((o1, o2) -> o2.size() - o1.size());

        for (String team : map.keySet()) {
            membersByTeam.add(map.get(team));
        }

        while (!membersByTeam.isEmpty()) {
            LinkedList<String> majorTeam = membersByTeam.poll();
            String memberA = majorTeam.pollFirst();
            String memberB = "";
            if (!membersByTeam.isEmpty()) {
                LinkedList<String> minorTeam = membersByTeam.poll();
                memberB = minorTeam.pollFirst();
                if(!minorTeam.isEmpty())
                    membersByTeam.add(minorTeam);
            }

            if(!majorTeam.isEmpty())
                membersByTeam.add(majorTeam);

            if(!memberA.isEmpty() && !memberB.isEmpty()){
                result.add(List.of(memberA, memberB));
            }
        }

        return result;
    }

    static Map<String, List<String>> sortMap(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .sorted(comparingInt(e -> e.getValue().size()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
    }

//    public static List<List<User>> getMeetings(List<User> users) {
//        List<List<User>> result = new ArrayList<>();
//        boolean[] isUsed = new boolean[users.size()];
//
//        for (int i=0; i<users.size(); i++) {
//            if(isUsed[i])
//                continue;
//
//            List<User> internal = new ArrayList<>();
//            User user = users.get(i);
//            internal.add(user);
//            isUsed[i] = true;
//
//            for (int j=i; j<users.size(); j++) {
//                if(isUsed[j])
//                    continue;
//                User nextUser = users.get(j);
//                if(user.team.equals(nextUser.team))
//                    continue;
//                internal.add(nextUser);
//                isUsed[j] = true;
//                result.add(internal);
//                break;
//            }
//        }
//
//        return result;
//    }

    // public static List<List<String>> getMeetings (List<String> users) {
    //     int lastIdx = 0;

    //     if(users.size() % 2 == 0)
    //         lastIdx = users.size();
    //     else
    //         lastIdx = users.size()-1;

    //     List<List<String>> result = new ArrayList<>();

    //     for (int i=0; i<lastIdx; i += 2) {
    //         List<String> internal = new ArrayList<>();
    //         internal.add(users.get(i));
    //         internal.add(users.get(i+1));
    //         result.add(internal);
    //     }

    //     return result;
    // }
}

