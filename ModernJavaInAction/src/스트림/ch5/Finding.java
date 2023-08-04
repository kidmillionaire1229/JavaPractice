package 스트림.ch5;

import 스트림.ch4.Dish;

public class Finding {

    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegatarian Friendly");
        }
    }

    //anyMatch : 적어도 한 요소와 일치하는지 확인
    private static boolean isVegetarianFriendlyMenu(){
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }
}
