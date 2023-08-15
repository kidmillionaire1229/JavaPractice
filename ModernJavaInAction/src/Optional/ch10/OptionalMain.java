package Optional.ch10;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

        //Optional.ofNullable : null값을 저장할 수 있는 Optional
        Optional<Car> nullCarOpt2 = Optional.ofNullable(nullCar);

        //Optional의 map 메서드
        //Optional<Insurance> -> Optional<String>
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Insurance insuracneNull = null;
        Optional<Insurance> optInsuranceNull = Optional.ofNullable(insuracneNull);
        Optional<String> nullString = optInsuranceNull.map(Insurance::getName);
        System.out.println("nullString = " + nullString);

    }

    public static String getCarInsuraceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    //Optional::stream사용
    //Stream<Optional<String>> -> Stream<String>으로 변환
    //값이 있을땐 Stream<String>, 없을땐 Stream.empty를 반환
    //flatMap 실행시 Stream.empty는 제외하고 매핑 시킴
    //stream.filter(Optional::isPresent).map(Optional::get).collect(toSet());

    public Set<String> getCarInsuranceNames(List<Person> persons){
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(toSet());
    }

    /**
     * Optional<Person> -> 빈 값일땐 그대로 Optional.empty반환
     * Optional<Car> -> 빈 값일땐 그대로 Optional.empty 반환
     * 둘 다 값이 있을때만 Optional<Insurance>반환
     * findCheapesInsurace의 반환값은 Insurace 
    public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car){
        return person.flatMap(p->car.map(c->findCheapestInsurace(p,c)));
    }
     **/

    //optional이 빈 객체가 아니고 + predicate에 일치할때 그 값을 반환한다.
    //그렇지 않으면 빈 객체가 반환된다.
    //optional 자체가 빈 값이면 filter 연산은 아무 동작 하지 않는다.
    //
    public static void filteringOptional(Optional<Insurance> optInsurance){
        optInsurance.filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x-> System.out.println("ok"));
    }

    //Person들 중에서 minAge이상인 사람들의 보험 이름 반환
    public static void getCarInsuranceName(Optional<Person> person, int minAge){
        person.filter(p->p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

    //String -> Integer 변환
    //바꿀 수 없으면 NumberFormatException 예외처리 및 반환 
    public static Optional<Integer> stringToInt(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }
}
