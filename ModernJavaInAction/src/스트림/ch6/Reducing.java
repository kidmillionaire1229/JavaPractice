package 스트림.ch6;

import static java.util.stream.Collectors.reducing;

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
}
