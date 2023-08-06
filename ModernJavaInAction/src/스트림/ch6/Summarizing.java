package 스트림.ch6;

import static java.util.stream.Collectors.*;


import java.util.Comparator;
import java.util.Optional;
import 스트림.ch4.Dish;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Number of dishes: "+howManyDishes());
        findMostCaloricDish();
    }

    //Collectors.counting : stream 개수 반환
    private static long howManyDishes(){
        return Dish.menu.stream().collect(counting());
    }

    //Collectors.maxBy : 최댓값 검색
    private static void findMostCaloricDish(){
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalireDish = Dish.menu.stream()
                .collect(maxBy(dishCaloriesComparator));
        System.out.println("mostCalireDish.get() = " + mostCalireDish.get());
    }

}
