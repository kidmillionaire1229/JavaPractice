package 람다.ch3;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import 람다.ch2.Apple;
import 람다.ch2.Color;
import 람다.ch2.FilteringApples;
import 람다.ch2.FilteringApples.ApplePredicate;

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
        
        //같은 무게 하나 추가 
        inventory.set(2,new Apple(120,Color.GREEN));
        System.out.println("inventory = " + inventory);

        //같은 값이 있다면 한번더 compare
        //Color에 compare이 있다고 가정
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        //Predicate 조합
        //1. negate
        Predicate<Apple> notGreenApple = new AppleColorPredicate().negate();

        //2.and
        Predicate<Apple> greenAndHeavyApple = new AppleColorPredicate().and(new AppleWeightPredicate());

        //3.or
        Predicate<Apple> greenOrHeavyApple = new AppleColorPredicate().or(new AppleWeightPredicate());

    }

    static class AppleColorPredicate implements Predicate<Apple> {

        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }
    }

    static class AppleWeightPredicate implements Predicate<Apple>{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

}
