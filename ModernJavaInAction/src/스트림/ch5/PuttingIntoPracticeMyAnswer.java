package 스트림.ch5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PuttingIntoPracticeMyAnswer {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> transactionin2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println("transactionin2011 = " + transactionin2011);

        //2.거래자가 근무하는 모든 도시를 중복 없이 나열하시오. 
        List<String> citiesOfTrader = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
        System.out.println("citiesOfTrader = " + citiesOfTrader);

        //책 답안 (람다)
        List<String> citiesOfTrader2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("citiesOfTrader2 = " + citiesOfTrader2);

        //3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<String> traderNamesInCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(transaction -> transaction.getTrader())
                .sorted(comparing(Trader::getName))
                .map(Trader::getName)
                .collect(toList());
        System.out.println("traderNamesInCambridge = " + traderNamesInCambridge);

        //3번 책 답안
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);

        //4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환 (문자열로 반환)
        String tradersName = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("tradersName = " + tradersName);

        //5. 밀라노에 거래자가 있는가?
        boolean isTraderExistsInMillan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println("isTraderExistsInMillan = " + isTraderExistsInMillan);

        //6. 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
        List<Integer> cambridgeTransactionValue = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());
        System.out.println("cambridgeTransactionValue = " + cambridgeTransactionValue);

        //6번 책 답안 (forEach 사용 출력)
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7. 전체 트랜잭션 중 최댓값은 얼마인가?
        Integer reduceMax = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, Integer::max);
        System.out.println("reduceMax = " + reduceMax);

        //8. 전체 트랜잭션 중 최솟값은 얼마인가?
        Integer reduceMin = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::min);
        System.out.println("reduceMin = " + reduceMin);

        //책 답안
        //Comparator 인자를 받는 min , max 사용
        Optional<Transaction> comparatorMin = transactions.stream()
                .min(comparing(Transaction::getValue));
        comparatorMin.ifPresent(transaction -> System.out.println("transaction.getValue() = " + transaction.getValue()));


    }

}
