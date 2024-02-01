public class Main {
    public static void main(String[] args) {
        Strategy defaultStrategy = DefaultStrategy.getInstance();
        Strategy taylorStrategy = TaylorStrategy.getInstance();

        Fun exp = new Exp(defaultStrategy);
        Fun recip = new Recip();
        Fun sin = new Sin(taylorStrategy);

        System.out.println("Exp(0) " + exp.eval(0.0));
        System.out.println("Recip(2) " + recip.eval(2.0));
        System.out.println("Sin(1) " + sin.eval(1.0));

        Fun prod = new Prod(exp, recip, sin);
        System.out.println("Prod(Exp, Recip, Sin)(1) " + prod.eval(0.0));

        Fun compose = new Compose(exp, recip, sin);
        System.out.println("Compose(Exp, Recip, Sin)(1) " + compose.eval(0.0));

        Fun max = new Max(exp, recip, sin);
        System.out.println("Max(Exp, Recip, Sin)(1) " + max.eval(0.0));

        Fun lowPass = new LowPassDecorator(sin, exp);
        System.out.println("LowPass(Sin, Exp)(8) " + lowPass.eval(8.0));

        Fun timeShift = new TimeShiftDecorator(sin, 2.0);
        System.out.println("TimeShift(Sin, 2)(1) " + timeShift.eval(1.0));
    }
}
