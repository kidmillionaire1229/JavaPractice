package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.List;
import 스트림.ch4.Dish;

public class Mapping {

    public static void main(String[] args) {

        //map함수 사용하여 Dish의 이름 추출 => List<String>
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(toList());

        System.out.println("dishNames = " + dishNames);

        
    }

}
