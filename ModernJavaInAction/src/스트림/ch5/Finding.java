package 스트림.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import 스트림.ch4.Dish;

public class Finding {

    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegatarian Friendly");
        }
        System.out.println("isVegetarianFriendlyMenu() = " + isVegetarianFriendlyMenu());
        System.out.println("isHealthyMenu() = " + isHealthyMenu());
        System.out.println("isHealthyMenu2() = " + isHealthyMenu2());
        findAnyVegetarian();
        findFirstInList();

    }

    //anyMatch : 적어도 한 요소와 일치하는지 확인
    private static boolean isVegetarianFriendlyMenu(){
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }

    //allMatch : 모든 요소와 일치하는지
    private static boolean isHealthyMenu(){
        return Dish.menu.stream().allMatch(d->d.getCalories() < 1000);
    }
    
    //noneMatch : 하나도 일치하는 요소가 없는 지 
    private static boolean isHealthyMenu2(){
        return Dish.menu.stream().noneMatch(d->d.getCalories()>=1000);
    }

    //검색
    //findAny: 임의의 요소 반환 (가장 먼저 탐색)
    private static void findAnyVegetarian(){
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny()
                        .ifPresent(dish-> System.out.println("find Any dish = " + dish));

    }

    //findFirst : 검색된 요소들 중에 첫 번째 요소를 찾음
    private static void findFirstInList(){
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstNumber = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        firstNumber.ifPresent(number -> System.out.println("first number = " + number));
    }
}
