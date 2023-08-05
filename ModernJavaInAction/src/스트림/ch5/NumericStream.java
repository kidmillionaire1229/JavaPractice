package 스트림.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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

        //boxed 이용하여 객체 스트림으로 복원
        IntStream intStream = Dish.menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        //max (기본값 없을 수도 있음) => optionalInt 반환
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(1);
        System.out.println("max = " + max);

        //숫자 범위 이용
        //range : 시작값과 종료값이 결과에 포함 x
        //rangeClosed : 시작값과 종료값이 결과에 포함
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println("짝수의 개수"+evenNumbers.count());

        //range 사용 : 1,100 포함하지 않음
        IntStream evenNumbers2 = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println("range 사용"+evenNumbers2.count());

        //피타고라스 수 예제
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));
    }

}
