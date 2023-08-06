package 스트림.ch6;

import static java.util.stream.Collectors.*;


import java.util.Comparator;
import java.util.Optional;
import 스트림.ch4.Dish;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Number of dishes: "+howManyDishes());
        findMostCaloricDish();
        System.out.println("total Calories : "+calculateTotalCalories());
        System.out.println("average calories: "+calculateAverageCalories());
    }

    //Collectors.counting : stream 개수 반환
    private static long howManyDishes(){
        return Dish.menu.stream().collect(counting());
    }

    //Collectors.maxBy : 최댓값 검색
    //Comparator의 구현체를 인자로 받는다.
    private static void findMostCaloricDish(){
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalireDish = Dish.menu.stream()
                .collect(maxBy(dishCaloriesComparator));
        System.out.println("mostCalireDish.get() = " + mostCalireDish.get());
    }

    //Collectors.summingInt
    //객체를 int 형으로 매핑한 후, 합을 도출
    private static int calculateTotalCalories(){
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    //Collectors.averageInt
    //객체를 int 형으로 매핑한 후, 평균을 도출
    private static Double calculateAverageCalories(){
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

}
