package 스트림.ch4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava(Dish.menu).forEach(System.out::println);
    }


    public static List<String> getLowCaloricDishesNamesInJava(List<Dish> dishes){
        return dishes.stream()
                .filter(dish -> {return dish.getCalories() < 400;})
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
