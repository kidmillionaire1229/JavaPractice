package 스트림.ch6;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static 스트림.ch4.Dish.dishTags;
import static 스트림.ch4.Dish.menu;

import java.util.List;
import java.util.Map;
import java.util.Set;
import 스트림.ch4.Dish;


public class Grouping {

    enum CaloricLevel {DIET,NORMAL,FAT};

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: "+groupDishesByType());
        System.out.println("Dishes grouped by caloric level: "+groupDishesByCaloricLevel());
        System.out.println("caloric dishes grouped by type: "+groupCaloricDishesByType());
        System.out.println("Dishes names(string) grouped by type"+groupDishNamesByType());
        System.out.println("Dish Tags grouped by Type: "+groupDishTagsByType());
        System.out.println("Disheds grouped by type and caloric level: "+groupDishedByTypeAndCaloricLevel());
        System.out.println("Count Dishes in groups: "+countDishesInGroups());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel(){
        return Dish.menu.stream()
                .collect(groupingBy(dish->{
                        if(dish.getCalories()<=400) return CaloricLevel.DIET;
                        else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT;
                }));
    }

    private static Map<Dish.Type,List<Dish>> groupCaloricDishesByType(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType,filtering(dish->dish.getCalories()>500,toList())));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType,mapping(Dish::getName,toList())));
    }

    private static Map<Dish.Type, Set<String>> groupDishTagsByType(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType,flatMapping(dish->dishTags.get(dish.getName()).stream(),toSet())));
    }

    //groupingBy를 2번 사용하여 , 1번째 분류 함수 이후에 2번째 분류 함수를 통해 분류 작업 수행
    private static Map<Dish.Type,Map<CaloricLevel,List<Dish>>> groupDishedByTypeAndCaloricLevel(){
        return menu.stream().collect(
                groupingBy(Dish::getType,groupingBy((Dish dish)->{
                    if (dish.getCalories()<=400) return CaloricLevel.DIET;
                    else if (dish.getCalories()<=700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }))
        );
    }

    //Dish의 종류별 개수 반환
    private static Map<Dish.Type,Long> countDishesInGroups(){
        return menu.stream().collect(groupingBy(Dish::getType,counting()));
    }

}
