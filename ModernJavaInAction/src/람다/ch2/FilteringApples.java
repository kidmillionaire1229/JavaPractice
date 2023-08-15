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
        System.out.println("filtering Apples By minimum weight(100)" +filterApplesByWeight(inventory,100));
        System.out.println("filtering Apples By Color(Red) and minimum weight(100): "
                +filterApples(inventory,new AppleRedAndHeavyPredicate()));
        //5.익명 클래스 사용
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
        System.out.println("익명 클래스 사용(Red Apple)"+redApples);
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

    //3.무게를 파라미터화
    //기준이 색이 아니라 일정 이상의 무게가 된다면..?
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    //4. 추상적 조건으로 필터링
    //ApplePredicate의 구현체를 파라미터로 전달하여 필터링
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //선택 조건을 결정하는 인터페이스인 프레디케이트 인터페이스 정의
    interface ApplePredicate{
        public boolean test(Apple apple);
    }

    //무게를 기준으로 하여, ApplePredicate 구현
    static class AppleWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    //색깔을 기준으로 하여, ApplePredicate 구현
    //GREEN
    static class AppleColorPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }
    }

    //색깔 (Red), 무게 (150초과)를 기준으로 하는 ApplePredicate 구현
    static class AppleRedAndHeavyPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor())
                    && apple.getWeight()>100;
        }
    }

}

