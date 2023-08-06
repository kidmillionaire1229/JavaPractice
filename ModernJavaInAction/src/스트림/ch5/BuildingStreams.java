package 스트림.ch5;

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

    }


}
