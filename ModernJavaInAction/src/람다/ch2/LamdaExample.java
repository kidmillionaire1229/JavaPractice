package 람다.ch2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LamdaExample {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(150, Color.GREEN),
                new Apple(120, Color.RED));

        //1.익명 클래스 선언하여 Apple의 무게대로 정렬
        List<Apple> sortApple1 = inventory;
        sortApple1.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println("sort Apple By Weight(익명클래스)" + sortApple1);

        List<Apple> sortApple2 = inventory;
        sortApple2.sort((Apple a1, Apple a2)-> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println("sort Apple By Lamda"+sortApple2);
    }
}
