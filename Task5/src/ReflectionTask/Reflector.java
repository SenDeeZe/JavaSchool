package ReflectionTask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflector {

    public static void printClassAndSuperMethods(Class<?> myClass) {
        Class<?> superClass = myClass.getSuperclass();
        if(superClass != null)
            printClassAndSuperMethods(superClass);

        System.out.print("\n");
        System.out.println("Class:" + myClass.getName());

        Class<?>[] interfaces =  myClass.getInterfaces();
        for (Class<?> eachInterface : interfaces)
            System.out.println("Interface:"+ eachInterface.getName());

        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println("Method:"+ method.getName());
    }

    public static void printGetters(Class<?> myclass) {
        System.out.println("Class " + myclass.getName());
        Method[] methods = myclass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if(method.getName().contains("get") && Modifier.isPublic(modifiers)) {
                System.out.println("Getter:"+method.getName());
            }
        }
    }

    public static void weekDaysChecker(){
        WeekDays week = new WeekDays();
        Field[] fields = WeekDays.class.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if(field.getType().equals(String.class) && Modifier.isFinal(modifiers)) {
                try {
                    if(field.getName().compareTo((String) field.get(week)) != 0)
                        System.out.println("Неверное значение поля:"+field.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
