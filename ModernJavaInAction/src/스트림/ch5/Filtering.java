package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
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
        filteredMenu.forEach(System.out::println);

        //이미 정렬이 되어있기 때문에, 320 이후에는 필터링 하지 않음
        //takeWhile 사용
        System.out.println("Sorted menu sliced with takeWhile()");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        slicedMenu1.forEach(System.out::println);

        //dropWhile 사용
        System.out.println("sorted menu sliced with takeWhile()");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

    }

}
