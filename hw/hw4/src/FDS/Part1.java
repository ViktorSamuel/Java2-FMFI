package FDS;

import java.util.function.Function;

public interface Part1 {
    Function<FL, Boolean> isEmpty = fl ->
            fl == null;
    Function<FL, Integer> size = fl ->
            fl == null ? 0 : 1 + Part1.size.apply(fl.tail());
    Function<FL, FL> reverse = fl ->
            fl == null ? null : Part1.push_back.apply(Part1.reverse.apply(fl.tail())).apply(fl.head());
    Function<FL, Function<Integer, FL>> push_back = fl -> n ->
            fl == null ? new FL(n, null) : new FL(fl.head(), Part1.push_back.apply(fl.tail()).apply(n));
    Function<FL, FL> pop_back = fl ->
            fl == null || fl.tail() == null ? null : new FL(fl.head(), Part1.pop_back.apply(fl.tail()));
    Function<FL, Function<FL, FL>> concat = fl1 -> fl2 ->
            fl1 == null ? fl2 : new FL(fl1.head(), Part1.concat.apply(fl1.tail()).apply(fl2));
    Function<FL, Function<Integer, Boolean>> contains = fl -> n ->
            fl != null && (fl.head().equals(n) || Part1.contains.apply(fl.tail()).apply(n));
    Function<FL, Integer> min = fl ->
            fl == null ? null : fl.tail() == null ? fl.head() : Math.min(fl.head(), Part1.min.apply(fl.tail()));
    Function<FL, Function<Integer, FL>> insert = fl -> n ->
            fl == null || n < fl.head() ? new FL(n, fl) : new FL(fl.head(), Part1.insert.apply(fl.tail()).apply(n));
    Function<FL, FL> sort = fl ->
            fl == null ? null : Part1.insert.apply(Part1.sort.apply(fl.tail())).apply(fl.head());
}