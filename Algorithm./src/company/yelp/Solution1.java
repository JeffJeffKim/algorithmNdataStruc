package company.yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

    public static void main(String[] args) {
        //     *         Business(id: 1, rating: 4.0, veganFriendly: true, price: 4, distance: 10.0),
//             *         Business(id: 2, rating: 2.5, veganFriendly: false, price: 2, distance: 5.0),
//             *         Business(id: 3, rating: 4.5, veganFriendly: false, price: 1, distance: 1.0),
//             *         Business(id: 4, rating: 3.0, veganFriendly: true, price: 2, distance: 3.4),
//             *         Business(id: 5, rating: 4.5, veganFriendly: true, price: 1, distance: 6.3),
//             *         Business(id: 6, rating: 3.5, veganFriendly: true, price: 2, distance: 1.2),
        Business b1 = new Business(1, 4.0f, true, 4, 10.0f);
        Business b2 = new Business(2, 2.5f, false, 2, 5.0f);
        Business b3 = new Business(3, 4.5f, false, 1, 1.0f);
        Business b4 = new Business(4, 3.0f, true, 2, 3.4f);
        Business b5 = new Business(5, 4.5f, true, 1, 6.3f);
        Business b6 = new Business(6, 3.5f, true, 2, 1.2f);
        filterAndSortBusinesses(List.of(b1, b2, b3, b4, b5, b6), false, null, null);
    }

    public static List<Integer> filterAndSortBusinesses(
            List<Business> businesses,
            boolean onlyVeganFriendly,
            Integer maxPrice,
            Float maxDistance
    ) {

        if(onlyVeganFriendly) {
            businesses = businesses.stream()
                    .filter(b ->
                            b.getVeganFriendly()
                            && (maxPrice == null || b.getPrice() <= maxPrice)
                            && ( maxDistance == null || b.getDistance() <= maxDistance))
                    .collect(Collectors.toList());
        } else {
            businesses = businesses.stream()
                    .filter(b ->
                            (maxPrice == null || b.getPrice() <= maxPrice)
                                    && ( maxDistance == null || b.getDistance() <= maxDistance))
                    .collect(Collectors.toList());
        }

//        Collections.sort(businesses, Comparator.comparing(b -> b.getRating()));
//        Collections.sort(businesses, (b1, b2) -> (b1.getRating().compareTo(b2.getRating())));
        Collections.sort(businesses, Collections.reverseOrder(Comparator.comparing(b -> b.getRating())));

        List<Integer> result = new ArrayList<>();
        for (Business business : businesses) {
            result.add(business.getId());
        }

        return result;
    }


    static class Business {
        Integer id;
        Float rating;
        boolean veganFriendly;
        Integer price;
        Float distance;

        public Business(
                Integer id,
                Float rating,
                Boolean veganFriendly,
                Integer price,
                Float distance
        ) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }

        public Integer getId() {
            return this.id;
        }
        public Float getRating() {
            return this.rating;
        }
        public Boolean getVeganFriendly() {
            return this.veganFriendly;
        }
        public Integer getPrice() {
            return this.price;
        }
        public Float getDistance() {
            return this.distance;
        }
    }
}
