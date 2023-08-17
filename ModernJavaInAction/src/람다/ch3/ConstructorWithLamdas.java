package 람다.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import 람다.ch2.Apple;
import 람다.ch2.Color;

public class ConstructorWithLamdas {

    public static void main(String[] args) {

        //생성자 참조
        //1. 매개변수가 없는 생성자 : Supplier () -> Apple
        Supplier<Apple> c1 = Apple::new;

        //2. 매개변수가 하나인 생성자 : Function <Apple, Integer>
        Function<Integer,Apple> c2 = Apple::new;

        //Function 인터페이스인 생성자 이용하여 객체 생성
        Apple a2 = c2.apply(110);

        //3. 매개변수가 2개인 생성자 : BiFunction <Color, Integer, Apple>
        BiFunction<Integer,Color,Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110, Color.GREEN);

        //etc) 매개변수가 3개인 생성자를 만들려면?
        //Color에 3개의 변수를 받는 생성자가 있다고 한다면 
        //TriFunction<Integer,Integer,Integer,Color> colorFactory = Color::new;

        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<Apple> appleListWithMap = map(weights, Apple::new);
        System.out.println("appleListWithMap = " + appleListWithMap);
    }

    public static List<Apple> map(List<Integer> weightList, Function<Integer,Apple> f){
        List<Apple> result = new ArrayList<>();
        for (Integer weight : weightList) {
            result.add(f.apply(weight));
        }
        return result;
    }

    public interface TriFunction<T,U,V,R> {

        R apply(T t, U u, V v);
    }

}
