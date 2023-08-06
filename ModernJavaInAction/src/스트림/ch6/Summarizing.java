package 스트림.ch6;

import static java.util.stream.Collectors.*;

import 스트림.ch4.Dish;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Number of dishes: "+howManyDishes());
    }

    //Collectors.counting : stream 개수 반환 
    private static long howManyDishes(){
        return Dish.menu.stream().collect(counting());
    }

}
