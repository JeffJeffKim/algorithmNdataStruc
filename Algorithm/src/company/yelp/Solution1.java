package company.yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

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
        Collections.sort(businesses, (b1, b2) -> (b1.getRating().compareTo(b2.getRating())));

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

//     *         Business(id: 1, rating: 4.0, veganFriendly: true, price: 4, distance: 10.0),
//             *         Business(id: 2, rating: 2.5, veganFriendly: false, price: 2, distance: 5.0),
//             *         Business(id: 3, rating: 4.5, veganFriendly: false, price: 1, distance: 1.0),
//             *         Business(id: 4, rating: 3.0, veganFriendly: true, price: 2, distance: 3.4),
//             *         Business(id: 5, rating: 4.5, veganFriendly: true, price: 1, distance: 6.3),
//             *         Business(id: 6, rating: 3.5, veganFriendly: true, price: 2, distance: 1.2),
