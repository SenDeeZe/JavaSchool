package ReflectionTask;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PerformanceProxy implements Calculator {
    private Calculator calculator;
    private boolean isMetric;

    public PerformanceProxy(Calculator calculator) {
        this.calculator = calculator;
        Method method = null;
        try {
            method = Calculator.class.getMethod("calc", int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation annotation = method.getAnnotation(Metric.class);
        isMetric=annotation!=null;
    }

    @Override
    public int calc(int number) {
        if (isMetric) {
            long startTime = System.nanoTime();
            int result = calculator.calc(number);
            System.out.println("Время работы метода: "+(System.nanoTime() - startTime) / 1000000000.0 + " (в наносек)");
            return result;
        } else {
            return calculator.calc(number);
        }
    }
}
