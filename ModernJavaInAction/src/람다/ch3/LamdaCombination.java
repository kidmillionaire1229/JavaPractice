package 람다.ch3;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import 람다.ch2.Apple;
import 람다.ch2.Color;

public class LamdaCombination {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(150, Color.GREEN),
                new Apple(120, Color.RED));

        //Comparator 조합
        //1. 역정렬
        //무게를 내림차순으로 정렬
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println("comparator.reversed :"+inventory);

    }

}
