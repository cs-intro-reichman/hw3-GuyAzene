// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
    public static void main(String args[]) {
//         Tests some of the operations
	    System.out.println(plus(-2,-3));   // 2 + 3
	    System.out.println(minus(-7,-2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
        System.out.println(times(3, 4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
        System.out.println(pow(-3, 5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3
   		System.out.println(div(-5,-5));    // 5 / 5
   		System.out.println(div(-25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6
        System.out.println(pow(6, 2));      // 3^5

        System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        if (x2 >= 0) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        } else {
            for (int i = x2; i < 0; i++) {
                x1--;
            }
        }
        return x1;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        if (x2 >= 0) {
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        } else {
            for (int i = x2; i < 0; i++) {
                x1++;
            }
        }
        return x1;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int a = 0;
        int absx1 = x1 < 0 ? minus(0, x1) : x1;
        int absx2 = x2 < 0 ? minus(0, x2) : x2;
        for (int i = 0; i < absx2; i++) {
            a = plus(a, absx1);
        }
        return ((x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0)) ? minus(0, a) : a;
    }


    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int result = 1;
        int absa = x < 0 ? minus(0, x) : x;
        int absn = n < 0 ? minus(0, n) : n;
        boolean isPowEven = (mod(n, 2) == 0);

        for (int i = 0; i < absn; i++) {
            result = times(result, absa);
        }
        if (isPowEven && (x < 0)) {return result;}
        else if ((!isPowEven && (x < 0))) {return minus(0, result);}
        else return result;
    }

    // Returns the integer part of x1 / x2
    public static int div(int x1, int x2) {
        if (x2 == 0) {
            return 0;
        }

        int result = 0;
        int absx1 = x1 < 0 ? minus(0, x1) : x1;
        int absx2 = x2 < 0 ? minus(0, x2) : x2;

        while (absx1 >= absx2) {
            absx1 = minus(absx1, absx2);
            result = plus(result, 1);
        }

        return ((x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0)) ? minus(0, result) : result;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        x2 = x2 < 0 ? minus(0, x2) : x2;
        int absX1 = x1 < 0 ? minus(0, x1) : x1;

        while (absX1 >= x2) {
            absX1 = minus(absX1, x2);
        }
        return x1 < 0 ? minus(x2, absX1) : absX1;
    }

    // Returns the integer part of sqrt(x)
    public static int sqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;
        int root = 0;

        while (pow(root, 2) <= x) {
            root++;
        }

        return minus(root, 1);
    }
}