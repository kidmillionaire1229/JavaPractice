package 스트림.ch6;

import static java.util.stream.Collectors.reducing;

import 스트림.ch4.Dish;

public class Reducing {

    public static void main(String[] args) {
        System.out.println("Total Calories in menu: "+calculateTotalCalories());
    }

    //Collectors.reducing : (초기값, 변환 함수, 합계함수)
    private static int calculateTotalCalories(){
        return Dish.menu.stream().collect(reducing(0,Dish::getCalories,
                (Integer i, Integer j)->i+j));
    }
}
