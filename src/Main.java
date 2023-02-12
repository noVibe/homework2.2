import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        class Human {
            String name;

            public Human(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name;
            }
        }

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate1.test(1));

        Predicate<Integer> predicate2 = x -> x > 0;

        System.out.println(predicate2.test(-2));

        Human man = new Human("Dude");
        Human woman = new Human("Girl");

        Consumer<Human> consumer1 = new Consumer<Human>() {
            @Override
            public void accept(Human human) {
                System.out.println("hi " + human);
            }
        };
        consumer1.accept(man);

        Consumer<Human> consumer2 = x -> System.out.println("hi " + x);
        consumer2.accept(woman);

        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        Function<Double, Long> function2 = x -> Math.round(x);

        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier1.get());

        Supplier<Integer> supplier2 = () -> (int) (Math.random() * 100);

        System.out.println(supplier2.get());

        Predicate<Human> condition = h -> h.name.contains("a");
        Function<Human, String> ifTrue = Object::toString;
        Function<Human, String> ifFalse = s -> "False";

        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(man));


        Supplier<Human> supHuman = () -> new Human(Character.getName(supplier2.get()));

        Human dan = new Human("Dan");
        Consumer<Human> cons = h -> System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(h));
        cons.accept(supHuman.get());
        cons.accept(dan);

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }


}




