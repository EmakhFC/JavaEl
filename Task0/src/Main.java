public class Main {

    public static void main(String[] args) {
        System.out.println("№ 1: ");

        System.out.println("Hello world!");

        System.out.println(" ");

        System.out.println("№ 2: ");

        int testVar = 21;
        System.out.println(testVar);

        System.out.println(" ");

        System.out.println("№ 3: ");

        int testVar1 = 10;
        System.out.println("Начальное значение: "+testVar1);
        testVar1++;
        System.out.println("Начальное значение +1: "+testVar1);
        testVar1 = testVar1 + 1;
        System.out.println("Начальное значение +1: "+testVar1);
        ++testVar1;
        System.out.println("Начальное значение +1: "+testVar1);

        System.out.println(" ");

        System.out.println("№ 4: ");

        int a = 2;
        int b = 4;
        System.out.println("\nA = "+a);
        System.out.println("B = "+b);

        int buffer = a;
        a = b;
        b = buffer;
        System.out.println("A = "+a);
        System.out.println("B = "+b);

        a=a+b-(b=a);
        System.out.println("A = "+a);
        System.out.println("B = "+b);

        a += b;
        b = a - b;
        a -= b;
        System.out.println("A = "+a);
        System.out.println("B = "+b);

        System.out.println(" ");

        System.out.println("№ 5: ");

        double side1 = 12;
        double side2 = 5;
        System.out.println(HypotenuseCalculator(side1, side2));

        System.out.println(" ");

        System.out.println("№ 6: ");

        int value = 2002;
        String valueStr = String.valueOf(value);
        System.out.println(valueStr.charAt(valueStr.length()-1));

        System.out.println(" ");


        System.out.println("№ 7: ");

        int mainValue = -200248;
        if (mainValue > 0)
            System.out.println(mainValue % 100 / 10);
        else
            System.out.println("Значение отрицательное");

        System.out.println(" ");

        System.out.println("№ 8: ");

        int value8 = 37;
        System.out.println(value8 / 10);

        System.out.println(" ");


        System.out.println("№ 9: ");

        System.out.println(unit9(30));

        System.out.println(" ");


        System.out.println("№ 10: ");

        System.out.println(arithmeticMean(2, 3));
        System.out.println(arithmeticMean(6, 8));
        System.out.println(arithmeticMean(6, 4));

        System.out.println(" ");

        System.out.println("№ 11: ");

        System.out.println(geometricMean(4, 8));
        System.out.println(geometricMean(5, 3));
        System.out.println(geometricMean(12, 9));

        System.out.println(" ");

        System.out.println("№ 12: ");
        double result = pointerCalc(4.123, 1.132, 20.2353, 2.20230);
        System.out.println("\nРасстояние между двумя точками: " + result);

    }
    
      public static double pointerCalc(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double geometricMean(int value1, int value2) {
        return Math.sqrt(value1 * value2);
    }

    public static double arithmeticMean(int value1, int value2) {
        return (value1 + value2) / 2;
    }

    public static int unit9(int unit9){
        return unit9 - 21;
    }

    public static double HypotenuseCalculator(double cathetus1, double cathetus2) {
        return Math.sqrt(Math.pow(cathetus1, 2.0) + Math.pow(cathetus2, 2.0));
    }
}