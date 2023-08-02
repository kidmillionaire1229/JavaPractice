package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import 스트림.ch4.Dish;

public class BuildingStreams {

    public static void main(String[] args) {
        System.out.println("Filtering with predicate");
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);


        //distinct 사용 : 고유 요소 거름 
        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i->i%2==0)
                .distinct()
                .forEach(System.out::println);
    }
}
