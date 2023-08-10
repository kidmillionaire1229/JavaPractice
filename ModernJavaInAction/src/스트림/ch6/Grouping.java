package 스트림.ch6;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import 스트림.ch4.Dish;


public class Grouping {

    enum CaloricLevel {DIET,NORMAL,FAT};

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: "+groupDishesByType());
        System.out.println("Dishes grouped by caloric level: "+groupDishesByCaloricLevel());
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

}
