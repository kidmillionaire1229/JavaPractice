package 스트림.ch5;

import 스트림.ch4.Dish;

public class Finding {

    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegatarian Friendly");
        }
        System.out.println("isVegetarianFriendlyMenu() = " + isVegetarianFriendlyMenu());
        System.out.println("isHealthyMenu() = " + isHealthyMenu());

    }

    //anyMatch : 적어도 한 요소와 일치하는지 확인
    private static boolean isVegetarianFriendlyMenu(){
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }

    //allMatch : 모든 요소와 일치하는지
    private static boolean isHealthyMenu(){
        return Dish.menu.stream().allMatch(d->d.getCalories() < 1000);
    }
}
