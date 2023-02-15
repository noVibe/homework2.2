import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "AA", "BB", "C", "XXX");
        Comparator<String> comparator = Comparator.comparing(String::length);
        BiConsumer<String, String> consumer = (x, y) -> System.out.println(x + "\n" + y);

        findMinMax(stream, comparator, consumer);
        findMinMax(Stream.empty(), comparator, consumer);

        double res = Stream.generate(new Random()::nextInt).limit(20).filter(x -> x % 2 ==0).peek(System.out::println).count();
        System.out.println((int)res + " even numbers");
    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> consumer) {
        Deque<? extends T> q = stream.sorted(order).collect(Collectors.toCollection(LinkedList::new));
        consumer.accept(q.peekFirst(), q.peekLast());
    }
}




