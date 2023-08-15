package 람다.ch2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(150, Color.GREEN),
                new Apple(120, Color.RED));

        //1. 코드 전달
        //AppleComparator 구현
        inventory.sort(new AppleComparator());
        System.out.println("sort By AppleComparator"+inventory);

        //shuffle
        inventory.set(1,new Apple(30,Color.GREEN));
        //2.익명 클래스
        inventory.sort(new Comparator<Apple>(){
            @Override
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println("sort By 익명 클래스 "+inventory);

        //reshuffle
        inventory.set(1,new Apple(20,Color.RED));

        //3.람다식
        inventory.sort((a1,a2)-> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println("sort By Lamda Expression"+inventory);

        //Comparator의 comparing이용
        Comparator<Apple> c = Comparator.comparing((Apple a)-> a.getWeight());
        inventory.sort(Comparator.comparing(apple -> apple.getWeight()));

        //4.메서드 참조 

    }

    static class AppleComparator implements Comparator<Apple>{
        @Override
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

}
