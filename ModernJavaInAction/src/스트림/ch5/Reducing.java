package 스트림.ch5;

import java.util.Arrays;
import java.util.List;

public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        //메서드 참조를 인자로 
        Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
    }
}
