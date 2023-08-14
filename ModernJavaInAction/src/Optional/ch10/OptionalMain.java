package Optional.ch10;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        //Optional.empty (정적 팩토리 메서드) 로 빈 객체를 얻을 수 있다.
        Optional<Car> empty = Optional.empty();

        //Optional.of로 null이 아닌 값을 포함하는 Optional 만듬
        //1. Car객체가 null이 아니므로, NPE X
        Car car = new Car();
        Optional<Car> optCar = Optional.of(car);

        //2.Car객체가 null이면 car에서 NPE 발생 => of함수는 값이 null이 아닌 값이 들어가야한다.
        Car nullCar = null;
        //Optional<Car> nullCarOpt = Optional.of(nullCar);

    }
}
