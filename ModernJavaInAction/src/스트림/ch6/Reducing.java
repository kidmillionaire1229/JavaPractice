package 스트림.ch6;

import static java.util.stream.Collectors.reducing;

import java.util.stream.Collectors;
import 스트림.ch4.Dish;

public class Reducing {

    public static void main(String[] args) {
        System.out.println("Total Calories in menu: "+calculateTotalCalories());
        System.out.println("Total Calories in menu: "+calculateTotalCaloriesWithMethodReference());
        System.out.println("Total Calories in menu: "+calculateTotalCaloriesUsingSum());
    }

    //Collectors.reducing : (초기값, 변환 함수, 합계함수)
    private static int calculateTotalCalories(){
        return Dish.menu.stream().collect(reducing(0,Dish::getCalories,
                (Integer i, Integer j)->i+j));
    }

    //Collectors.reducing -> 합계함수에 Integer::sum 사용하기
    private static int calculateTotalCaloriesWithMethodReference(){
        return Dish.menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
    }

    //기본적인 Intstream::sum함수 사용
    //정수 합계 기준 best practice : 간결하고 가독성이 높음 + 자동 언박싱 연산 수행
    private static int calculateTotalCaloriesUsingSum(){
        return Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    }

    /**
     * 리듀싱으로 문자열 연결하기 예제**/
    //Dish.menu.stream().map(Dish::getName).collect(joining()) 연산을 리듀싱으로 구현해보자
    private static void makeStringJoinWithReducing(){
        String shortMenu1 = Dish.menu.stream().map(Dish::getName).
                collect(reducing((s1, s2) -> s1 + s2)).get();
        String shortMenu2 = Dish.menu.stream()
                .collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        //잘못된 예제 : reducing은 BiFunction<R,R,R>을 인수로 받는다.
        //Dish.menu.stream().collect(reducing((d1,d2)->d1.getName()+d2.getName())).get();

    }

}
