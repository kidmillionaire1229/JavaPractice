package 스트림.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import 스트림.ch4.Dish;

public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        //메서드 참조를 인자로
        Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);

        //최댓값 구하기
        Integer max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println("max = " + max);

        //최솟값 구하기
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min");
        min.ifPresent(System.out::println);


        //음식 총 칼로리 합계 구하기 
        Integer totalCalories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("totalCalories = " + totalCalories);

    }
}
