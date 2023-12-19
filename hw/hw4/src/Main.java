import FDS.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        System.out.println("PART 1");
        final long startTime = System.nanoTime();
        int res_part1 = 0;
        res_part1 += test_zero("test_isEmpty",ArrayList::isEmpty,Part1.isEmpty.compose(Main::AL2FL));
        res_part1 += test_zero("test_size",ArrayList::size,Part1.size.compose(Main::AL2FL));
        res_part1 += test_zero("test_min",
                a -> {if (a.isEmpty()) return null;
                else {
                    Integer res = a.get(0);
                    for (int i = 1; i < a.size(); i++) res = Math.min(res, a.get(i));
                    return res;
                }},
                Part1.min.compose(Main::AL2FL));
        res_part1 += test_one("test_push_back",
                a -> x -> {
                    ArrayList<Integer> b = new ArrayList<>(a);
                    b.add(x);
                    return b;
                },
                a -> x -> FL2AL(Part1.push_back.apply(AL2FL(a)).apply(x)),
                t -> new Random().nextInt(1000)
        );
        res_part1 += test_zero("test_pop_back",
                a -> {
                    ArrayList<Integer> b = new ArrayList<>(a);
                    if (!b.isEmpty()) b.remove(b.size()-1);
                    return b;
                },
                a -> FL2AL(Part1.pop_back.apply(AL2FL(a))));
        res_part1 += test_zero("test_reverse",
                a -> {
                    ArrayList<Integer> b = new ArrayList<>(a);
                    Collections.reverse(b);
                    return b;
                },
                a -> FL2AL(Part1.reverse.apply(AL2FL(a))));
        res_part1 += test_one("test_concat",
                a1 -> a2 -> {
                    ArrayList<Integer> res = new ArrayList<>(a1);
                    res.addAll(a2);
                    return res;
                },
                a1 -> a2 -> FL2AL(Part1.concat.apply(AL2FL(a1)).apply(AL2FL(a2))),
                Main::rALu);
        res_part1 += test_one("test_contains",
                a -> a::contains,
                a -> n -> Part1.contains.apply(AL2FL(a)).apply(n),
                t -> new Random().nextInt(1000)
                );
        res_part1 += test_insert(Part1.insert);
        res_part1 += test_zero("test_sort",
                a -> {
                    ArrayList<Integer> b = new ArrayList<>(a);
                    Collections.sort(b);
                    return b;
                },
                a -> FL2AL(Part1.sort.apply(AL2FL(a))));
        System.out.println("UPPER BOUND PART1: " + res_part1 + "/10");
        final long endTime = System.nanoTime();
        System.out.println(ANSI_CYAN + "Total time: " +
                new DecimalFormat("#0.0000").format((endTime - startTime)/1e9) + " s" + ANSI_RESET);
    }

    private final static int PAD = 25;
    private static <O> int test_zero(
            String name,
            Function<ArrayList<Integer>,O> correct,
            Function<ArrayList<Integer>,O> candidate) {
        final int T = 2000;
        for (int t = 1; t <= 2000; t++) {
            System.out.print(String.format("\r%1$-"+PAD+"s", name+":")+t +"/"+T);
            if (t % 100 == 0) System.out.flush();
            ArrayList<Integer> arg = rALu(t);
            O corr = correct.apply(arg);
            O your = candidate.apply(arg);
            if ((corr == null && your != null) || (corr != null && !corr.equals(your))) {
                System.out.println(String.format("\r%1$-"+PAD+"s", name+":")+FAIL + "       ");
                System.out.println("args: " + arg);
                System.out.println("corr: " + corr);
                System.out.println("your: " + your);
                return 0;
            }
        }
        System.out.println(String.format("\r%1$-"+PAD+"s", name+":")+OK + "       ");
        return 1;
    }

    private static <I, II> int test_one(
            String name,
            Function<ArrayList<Integer>, Function<I, II>> correct,
            Function<ArrayList<Integer>, Function<I, II>> candidate,
            Function<Integer, I> G
    ) {
        final int T = 2000;
        for (int t = 1; t <= T; t++) {
            System.out.print(String.format("\r%1$-"+PAD+"s", name+":")+t +"/"+T);
            if (t % 100 == 0) System.out.flush();
            ArrayList<Integer> arg1 = rALu(t);
            I arg2 = G.apply(t);
            II corr = correct.apply(arg1).apply(arg2);
            II your = candidate.apply(arg1).apply(arg2);
            if ((corr == null && your != null) || (corr != null && !corr.equals(your))) {
                System.out.println(String.format("\r%1$-"+PAD+"s", name+":")+FAIL + "       ");
                System.out.println("args: " + arg1 + " " + arg2);
                System.out.println("corr: " + corr);
                System.out.println("your: " + your);
                return 0;
            }
        }
        System.out.println(String.format("\r%1$-"+PAD+"s", name+":")+OK + "       ");
        return 1;
    }

    private static int test_insert(Function<FL, Function<Integer, FL>> insert) {
        Random r = new Random();
        final int T = 2000;
        for (int t = 1; t <= T; t++) {
            System.out.print(String.format("\r%1$-"+PAD+"s", "test_insert"+":")+t +"/"+T);
            if (t % 100 == 0) System.out.flush();
            ArrayList<Integer> B = rAL(r.nextInt(t));
            Collections.sort(B);
            FL A = AL2FL(B);
            Integer n = r.nextInt(1000);
            ArrayList<Integer> Bres = new ArrayList<>(B);
            Bres.add(n); Collections.sort(Bres);
            FL Ares = insert.apply(A).apply(n);
            if (!FL2AL(Ares).equals(Bres)) {
                System.out.println(String.format("\r%1$-"+PAD+"s", "test_insert"+":")+FAIL + "       ");
                System.out.println("args: " + B + " " + n);
                System.out.println("Ares: " + FL2AL(Ares));
                System.out.println("Bres: " + Bres);
                return 0;
            }
        }
        System.out.println(String.format("\r%1$-"+PAD+"s", "test_insert"+":")+OK + "       ");
        return 1;
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private static final String OK = ANSI_GREEN + "OK" + ANSI_RESET;
    private static final String FAIL = ANSI_RED + "FAIL" + ANSI_RESET;

    private static ArrayList<Integer> FL2AL(final FL l) {
        ArrayList<Integer> res = new ArrayList<>();
        FL q = l;
        while (q != null) {res.add(q.head()); q = q.tail();}
        return res;
    }

    private static FL AL2FL(final ArrayList<Integer> a) {
        FL res = null;
        for (int i = a.size()-1; i>= 0; i--) res = new FL(a.get(i), res);
        return res;
    }

    private static ArrayList<Integer> rAL(Integer length) {
        final Integer u = 1000;
        ArrayList<Integer> res = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            res.add(r.nextInt(u));
        }
        return res;
    }

    private static ArrayList<Integer> rALu(Integer t) {
        Random r = new Random();
        return rAL(r.nextInt(t));
    }
}
