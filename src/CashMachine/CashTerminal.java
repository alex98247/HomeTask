package CashMachine;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CashTerminal {

    public List<List<Pair<Integer, Integer>>> Exchange(int banknote, int index, int[] array) {

        List<List<Pair<Integer, Integer>>> list = new LinkedList<>();

        for (int i = banknote / array[index]; i >= 0; i--) {

            if (banknote - i * array[index] == 0) {
                List<Pair<Integer, Integer>> list1 = new LinkedList<>();
                list1.add(new Pair<>(array[index], i));
                list.add(list1);
                continue;

            }

            if (index + 1 < array.length) {

                List<List<Pair<Integer, Integer>>> exchange = Exchange(banknote - i * array[index], index + 1, array);
                if (exchange.size() != 0) {
                    for (List<Pair<Integer, Integer>> l : exchange) {
                        l.add(new Pair<>(array[index], i));
                    }
                    list.addAll(exchange);
                }
            }

        }

        return list;

    }

    public boolean Validator(int[] coins){
        return Arrays.stream(coins).allMatch(x-> x>0);
    }

    public void Start(){

        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {
            System.out.println("Введите купюру:");
            int banknote = Integer.parseInt(br.readLine());

            System.out.println("Введите размен:");
            String[] inputCoins = br.readLine().split(" ");
            int[] coinsExchange = Arrays.stream(inputCoins).mapToInt(x -> Integer.parseInt(x)).toArray();

            if(!Validator(coinsExchange) || ! Validator(new int []{banknote})){
                System.out.println("Купюры меьше 0:");
                return;
            }

            List<List<Pair<Integer, Integer>>> exchangedBanknote = Exchange(banknote, 0, coinsExchange);

            exchangedBanknote.forEach(x->{
                x.forEach(y->System.out.print(Repeat(y.getKey().toString() + " ", y.getValue())));
                System.out.println();
            });
            System.out.println("Количество комбинаций: " + exchangedBanknote.size());
        }
        catch(Exception ex){

            System.out.println("Скорее всего вы ввели неверные купюры");
        }
    }
    private String Repeat(String string, int count){
        return new String(new char[count]).replace("\0", string);
    }
}
