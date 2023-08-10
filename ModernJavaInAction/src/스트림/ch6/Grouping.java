package 스트림.ch6;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import 스트림.ch4.Dish;


public class Grouping {

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: "+groupDishesByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType));
    }

}
