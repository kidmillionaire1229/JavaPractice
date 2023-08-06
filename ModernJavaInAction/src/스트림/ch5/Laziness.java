package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Laziness {

    public static void main(String[] args) {
        //filtering 을 모든 요소 다하고 -> mapping이 아니라
        //filtering 하는 중에, 조건을 통과한 요소가 있으면 -> mapping 실행
        //filtering+mapping이 한 연산 처럼 실행됨
        //limit이 2개이기 때문에 쇼트 서킷 기법 때문에 첫 2개 확정 되면 처리 안함

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoeEvenSquares = numbers.stream()
                .filter(n -> {
                    System.out.println("filtering" + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("mapping");
                    return n * n;
                })
                .limit(2)
                .collect(toList());
    }

}
