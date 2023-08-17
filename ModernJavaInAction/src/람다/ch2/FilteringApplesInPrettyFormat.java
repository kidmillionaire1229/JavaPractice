package 람다.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApplesInPrettyFormat {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(150, Color.GREEN),
                new Apple(120, Color.RED));
        prettyPrintApple(inventory,new AppleFancyFormatter());
        prettyPrintApple(inventory,new AppleSimpleFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println("output = " + output);
        }
    }
    interface AppleFormatter{
        String accept(Apple a);
    }

    static class AppleFancyFormatter implements AppleFormatter{
        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " +apple.getColor() + " apple";
        }
    }

    static class AppleSimpleFormatter implements AppleFormatter{

        @Override
        public String accept(Apple apple) {
            return "An apple of "+apple.getWeight()+"g";
        }
    }

}

