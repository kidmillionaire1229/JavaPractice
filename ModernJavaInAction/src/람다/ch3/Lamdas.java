package 람다.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lamdas {

    //함수형 인터페이스는 하나의 추상 메서드를 지정하는 인터페이스이다.
    //람다 표현식을 함수형 인터페이스의 인스턴스(함수형 인터페이스를 구현)로 취급
    //함수형 인터페이스를 인수로 받는 메서드에만 람다 표현식을 사용할 수 있다.

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("1","a","");
        List<String> nonEmptyStrings = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmptyStrings);
    }

    //Predicate 예제
    static Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

}
