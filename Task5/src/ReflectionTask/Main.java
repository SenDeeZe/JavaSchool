package ReflectionTask;

public class Main {

    public static void main(String[] args) {
        Reflector.printClassAndSuperMethods(ReflectionChecker.class);
        System.out.println();

        System.out.println("Getters");
        Reflector.printGetters(ReflectionChecker.class);
        System.out.println();

        System.out.println("Week checker:");
        Reflector.weekDaysChecker();
        System.out.println();

        System.out.println("Cache proxy task:");
        Calculator calculator= new PerformanceProxy(new CalcCachingProxy());
        System.out.println(calculator.calc(15));
        System.out.println(calculator.calc(15));
        System.out.println();

        System.out.println("BeanTest");
        TestBeanUtils testBeanUtil1=new TestBeanUtils("1","2",3);
        TestBeanUtils testBeanUtil2 = new TestBeanUtils();
        BeanUtils.assign(testBeanUtil2,testBeanUtil1);
        System.out.println(testBeanUtil2);
    }
}
