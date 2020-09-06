public class TempConverter {

    public static double CtoF(double t){
        double result = 9.0/5*t+32;
        return result;
    }

    public static double CtoK(double t){
        double result = t+273.15;
        return result;
    }

    public static void main(String[] args) {
        double cTemp = 30;
        System.out.println("Tempreture in Celsius: " + cTemp);
        System.out.println("Tempreture in Fahrenheit: " + CtoF(cTemp));
        System.out.println("Tempreture in Kelvins: " + CtoK(cTemp));
    }
}
