package 스트림.ch5;

import java.util.Arrays;
import java.util.List;
import 스트림.ch4.Dish;

public class NumericStream {

    public static void main(String[] args) {
        /**
         * menu.stream
         *      .map(Dish::getCalories)
         *      .sum(); => Stream안에 있는 요소들이 정수형이라는 보장이 없다. ex) Stream<Dish>
         */

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        numbers.stream()
                .forEach(System.out::print);

        //mapToInt 사용하여 IntStream반환
        int totalCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("totalCalories = " + totalCalories);
    }

}
