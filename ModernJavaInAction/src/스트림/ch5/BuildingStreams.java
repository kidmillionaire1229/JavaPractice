package 스트림.ch5;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) {
        // Stream.of : 값으로 스트림 만들기
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //Stream.ofNullabe : null이 될 수 있는 객체 생성
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));
        homeValueStream.forEach(System.out::println);

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(key));
        values.forEach(System.out::println);

        //Arrays.stream
        int[] numbers = {2,3,5,7,11,13};
        System.out.println("Stream in Array-> sum="+Arrays.stream(numbers).sum());

        //Stream.iterate : 무한 스트림 생성 (초깃값, 람다식)
        //limit 이용하여 10개로 제한
        System.out.println("infinite stream with Stream.iterate");
        Stream.iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::println);


        //피보나치 수열 집합
        Stream.iterate(new int[]{0,1},array->new int[]{array[1],array[0]+array[1]})
                .limit(10)
                .forEach(t-> System.out.println("("+t[0]+","+t[1]+")"));

        //피보나치 수열
        Stream.iterate(new int[]{0,1},array->new int[]{array[1],array[0]+array[1]})
                .limit(10)
                .forEach(t->System.out.println(t[0]));

        //자바 9 , predicate 이용 중단 지점 생성
        System.out.println("using predicate in iterate");
        IntStream.iterate(0,n->n<100,n->n+4)
                .forEach(System.out::println);

        //takeWhile 사용 중단 지점 생성
        System.out.println("using takeWhile in iterate");
        IntStream.iterate(0,n->n+4)
                .takeWhile(n->n<100)
                .forEach(System.out::println);

        //Stream.generate : 상태값을 저장하지 않을 경우 무한스트림을 생성
        System.out.println("make random number with Math.random");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //1반환 (람다식 이용)
        System.out.println("return 1s");
        IntStream.generate(()->1)
                .limit(5)
                .forEach(System.out::println);

        //2반환 (익명 객체 이용)
        System.out.println("return 2s");
        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5)
                .forEach(System.out::println);

        //피보나치 generate로 구현
        System.out.println("fibonacci with generate");
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib)
                .limit(5)
                .forEach(System.out::println);
    }


}
