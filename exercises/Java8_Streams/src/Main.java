import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static void part1() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        System.out.println(stream);

        List<Integer> list = stream.collect(Collectors.toList());
        System.out.println(list);

        ArrayList<Integer> array = new ArrayList<>(list);
        System.out.println(array);

        stream = array.stream();
        long count = stream.count();
        System.out.println("Count: " + count);
    }

    private static void part2() {
        IntStream S = IntStream.range(1, 16);
        System.out.println(S.map(x -> 2*x)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        System.out.println(S.map(x -> x*x)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        System.out.println(S.mapToDouble(Math::sqrt)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        System.out.println(S.filter(x -> x > 2)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        System.out.println(S.filter(x -> x % 2 == 0)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        System.out.println(S.filter(x -> x % 3 == 0)
                            .filter(x -> x % 2 == 1)
                            .boxed()
                            .collect(Collectors.toList())
        );

        S = IntStream.range(1, 16);
        S.forEach(n -> {
            for (int i = 0; i < n; i++) System.out.print("*");
            System.out.println();
        });

        S = IntStream.range(1, 16);
        System.out.println("Sucet: " + S.sum());

        S = IntStream.range(1, 16);
        System.out.println("Max: " + S.reduce(Math::max).orElse(Integer.MIN_VALUE));

        S = IntStream.range(1, 16);
        System.out.println("Max: " + S.reduce(Integer.MIN_VALUE, Math::max));

        S = IntStream.range(1, 16);
        int inc = 4;
        System.out.println(S.map(x -> x + inc)
                            .boxed()
                            .collect(Collectors.toList())
        );
    }

    private static void part3() {
        System.out.println(IntStream
                            .range(2, 1000)
                            .filter(n -> IntStream.range(2,(int)Math.sqrt(n) + 1).allMatch(k -> n % k != 0))
                            .boxed()
                            .collect(Collectors.toList())
        );

        System.out.println(IntStream
                .iterate(2, n -> n+1)
                .filter(n -> IntStream.range(2, (int)Math.sqrt(n) + 1).allMatch(k -> n % k != 0))
                .limit(200)
                .boxed()
                .collect(Collectors.toList())
        );

        System.out.println(IntStream
                .iterate(2, n -> n+1)
                .filter(n -> IntStream
                        .iterate(n, k -> k % 2 == 0 ? k / 2 : 3 * k + 1)
                        .limit(100)
                        .noneMatch(k -> k == 1)
                )
                .limit(200)
                .boxed()
                .collect(Collectors.toList())
        );

    }

    public static void main(String[] args) {
	    part1();
	    part2();
	    part3();
    }
}
