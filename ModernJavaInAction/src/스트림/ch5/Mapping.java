package 스트림.ch5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import 스트림.ch4.Dish;

public class Mapping {

    public static void main(String[] args) {

        //map함수 사용하여 Dish의 이름 추출 => List<String>
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(toList());

        System.out.println("dishNames = " + dishNames);

        //map함수 이용하여 글자의 길이들로 추출 후 변환
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordsLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("wordsLengths = " + wordsLengths);

        //잘못된 경우
        words.stream()
                .map(word->word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());


        //flatmap사용 1 (String 배열)
        //Arrays::strem은 String[] -> Stream<String>
        //Stream<Stream<String>> -> Stream<String>
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println("uniqueCharacters = " + uniqueCharacters);

        //flatmap사용 2 (Integer 배열)
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3,4);


        //[(1,3),(1,4),...와 같이 숫자 쌍으로 반환
        // i를 stream<int[]>로 반환하니까 그걸 flatMap으로 평면화 시켜야함
        List<int[]> makeParisFromList = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());


        //합이 3인 쌍만 반환
        List<int[]> pairsSumDividedBy3 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());
        pairsSumDividedBy3.forEach(pair -> System.out.println(pair[0]+","+pair[1]));
    }

}
