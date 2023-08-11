package 스트림.ch6;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import 스트림.ch4.Dish;


public class Grouping {

    enum CaloricLevel {DIET,NORMAL,FAT};

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: "+groupDishesByType());
        System.out.println("Dishes grouped by caloric level: "+groupDishesByCaloricLevel());
        System.out.println("caloric dishes grouped by type: "+groupCaloricDishesByType());
        System.out.println("Dishes names(string) grouped by type"+groupDishNamesByType());
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

}
