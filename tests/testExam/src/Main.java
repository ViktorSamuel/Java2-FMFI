public class Main {
    public static void main(String[] args) {
        Function sin = Sin.getInstance();
        Function sqrt = Sqrt.getInstance();
        Function recip = Recip.getInstance();

        System.out.println("Sin(0)" + sin.eval(0.0));
        System.out.println("Sqrt(9)" + sqrt.eval(9.0));
        System.out.println("Recip(10)" + recip.eval(10.0));

        System.out.println("Sin(0)" + sin.eval(0.0));
        System.out.println("Sqrt(9)" + sqrt.eval(-50.0));
        System.out.println("Recip(10)" + recip.eval(0.0));

        Function compose = new Compose(sin, sqrt, recip);

        System.out.println("Compose(Sin, Sqrt, Recip)(10)" + compose.eval(10.0));
        System.out.println("Compose(Sin, Sqrt, Recip)(0)" + compose.eval(0.0));
        System.out.println("Compose(Sin, Sqrt, Recip)(-50)" + compose.eval(-50.0));

        System.out.println(compose.getName());

        Function compose2 = new Compose(sin, sqrt, compose);
        System.out.println("Compose(Sin, Sqrt, Compose(Sin, Sqrt, Recip))(10)" + compose2.eval(10.0));
        System.out.println(compose2.getName());

        Function Average = new Average(sin, sqrt, compose);
        System.out.println("Average(Sin, Sqrt, Compose(Sin, Sqrt, Recip))(10)" + Average.eval(10.0));
        System.out.println(Average.getName());

        Function Average2 = new Average(sin, sqrt, recip);
        System.out.println();

        LogDecorator log = new LogDecorator(Average2);
        System.out.println(log.getName());
        LogDecorator log2 = new LogDecorator(log);
        log2.eval(10.0);
        System.out.println();

        SlowDecorator slow = new SlowDecorator(log2);
        slow.eval(10.0);
        SlowDecorator slow2 = new SlowDecorator(slow);
        slow2.eval(10.0);
        SlowDecorator slow3 = new SlowDecorator(slow2);
        slow3.eval(10.0);
        System.out.println();

        Function compose3 = new Compose();
        System.out.println(compose3.getName());
        System.out.println(compose3.eval(10.0));
        Function compose4 = new Compose(compose3 , sin);
        System.out.println(compose4.getName());
        System.out.println(compose4.eval(10.0));
    }
}
