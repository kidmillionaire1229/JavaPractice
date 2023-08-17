package 스트림.ch6;

import static java.util.stream.Collectors.*;


import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import 스트림.ch4.Dish;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Number of dishes: "+howManyDishes());
        findMostCaloricDish();
        System.out.println("total Calories : "+calculateTotalCalories());
        System.out.println("average calories: "+calculateAverageCalories());
        System.out.println("Menu statistics : "+calculateMenuStatistics());
        System.out.println("short menu: "+getShortMenu());
        System.out.println("short menu comma separated: "+getShorMenuCommaSeparated());
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

    //Collectors.summarizingInt :요약 연산
    private static IntSummaryStatistics calculateMenuStatistics(){
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    //Collectors.joining : 스트림의 각 객체에 toString 메서드 호출하여 모든 문자열을 하나의 문자열로 반환
    private static String getShortMenu(){
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }

    //Collectors.joining : 콤마(,)로 구분 문자열을 설정하여, 연결 요소들을 콤마로 구분 
    private static String getShorMenuCommaSeparated(){
        return Dish.menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
