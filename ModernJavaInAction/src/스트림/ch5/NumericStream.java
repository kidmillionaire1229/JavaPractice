package 스트림.ch5;

import java.util.Arrays;
import java.util.List;

public class NumericStream {

    public static void main(String[] args) {
        /**
         * menu.stream
         *      .map(Dish::getCalories)
         *      .sum(); => Stream안에 있는 요소들이 정수형이라는 보장이 없다. ex) Stream<Dish>
         */

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        numbers.stream()
                .forEach(System.out::println);
    }

}
