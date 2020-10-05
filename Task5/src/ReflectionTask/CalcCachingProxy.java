package ReflectionTask;

import java.util.HashMap;

public class CalcCachingProxy implements Calculator {

    private Calculator calculator = new CalculatorImpl();

    private HashMap<Integer, Integer> cachedValues=new HashMap<>();

    public void clearCache() {
        calculator = null;
    }

    public void printCache(){
        System.out.println(cachedValues);
    }

    @Override
    public int calc(int number) {
        if(cachedValues.containsKey(number)){
            return cachedValues.get(number);
        } else{
            int result = calculator.calc(number);
            cachedValues.put(number,result);
            return result;
        }
    }
}
