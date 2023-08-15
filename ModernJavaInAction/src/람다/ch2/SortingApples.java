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
    }

    static class AppleComparator implements Comparator<Apple>{
        @Override
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

}
