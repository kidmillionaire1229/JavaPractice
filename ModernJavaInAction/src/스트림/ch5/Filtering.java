package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import org.w3c.dom.ls.LSOutput;
import 스트림.ch4.Dish;

public class Filtering {

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
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        //스트림 슬라이스
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        System.out.println("Filtered sorted menu");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> {
                    return dish.getCalories() < 320;
                })
                .collect(toList());


    }

}
