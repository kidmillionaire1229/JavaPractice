package 스트림.ch4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
    }


    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        //칼로리 400 이하 dish 필터링
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }

        //칼로리가 낮은 순으로 정렬
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(dish -> {return dish.getCalories() < 400;})
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
