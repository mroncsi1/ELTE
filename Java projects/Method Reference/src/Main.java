import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {

        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();

            addNumbers(numbers, Main::addPositiveNumbers);
            System.out.println(numbers);

            addNumbers(numbers, Main::addNegativeNumbers);
            System.out.println(numbers);

            System.out.println(function(4, 5, (a, b) -> a > b ? a : b));
        }

        private static void addNumbers(List<Integer> numbers, Consumer<List<Integer>> function) {
            function.accept(numbers);
        }

        private static void addPositiveNumbers(List<Integer> numbers) {
            Random r = new Random();
            numbers.clear();
            for (int i = 0; i < 10; ++i) numbers.add(r.nextInt(100));
        }

        private static void addNegativeNumbers(List<Integer> numbers) {
            Random r = new Random();
            numbers.clear();
            for (int i = 0; i < 10; ++i) numbers.add(r.nextInt(100) - 100);
        }

        private static int function(int a, int b, BiFunction<Integer, Integer, Integer> function) {
            return function.apply(a, b);
        }
    }

