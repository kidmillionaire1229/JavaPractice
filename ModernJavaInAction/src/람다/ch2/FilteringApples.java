package 람다.ch2;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

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

}

