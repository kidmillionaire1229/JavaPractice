package Optional.ch10;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        //Optional.empty (정적 팩토리 메서드) 로 빈 객체를 얻을 수 있다.
        Optional<Car> empty = Optional.empty();

        //Optional.of로 null이 아닌 값을 포함하는 Optional 만듬
        Car car = new Car();
        Optional<Car> car2 = Optional.of(car);
    }
}
