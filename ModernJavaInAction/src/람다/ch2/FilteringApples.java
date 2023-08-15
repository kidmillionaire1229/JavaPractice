package 람다.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(150, Color.GREEN),
                new Apple(120, Color.RED));

        System.out.println("filtering GreenApples : "+filterGreenApples(inventory));
        System.out.println("filtering Apples By Color(Red)"+filterApplesByColor(inventory,Color.RED));

    }

    //1. 녹색 사과 필터링
    //가장 기본적인 방법 : 특정 색과 동일한지 비교
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //2. 색을 파라미터화
    //만약 다른 색을 필터링하고 싶다면..?
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if (apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

}

