public class tasks {
    public static void main(String[] args) {
        // 1 задача
        System.out.println(remainder(24, 9));
        // 2 задача
        System.out.println(triArea(10, 4));
        // 3 задача
        System.out.println(animals(7, 2, 9));
        // 4 задача
        System.out.println(profitableGamble(3,25,23));
        // 5 задача
        System.out.println(operation(24, 6, 4));
        // 6 задача
        System.out.println(ctoa('Q'));
        // 7 задача
        System.out.println(addUpTo(174));
        // 8 задача
        System.out.println(nextEdge(8,10));
        // 9 задача
        double[] arr = {1, 5, 9};
        System.out.println(sumOfCubes(arr));
        // 10 задача
        System.out.println(abcmath(42, 5, 10));

    }
    // 1 задача
    public static int remainder(int a, int b) {
        return a%b;
    }

    // 2 задача
    public static double triArea(int a, int b) {
        return a*b*0.5;
    }

    // 3 задача
    public static int animals(int a, int b, int c) {
        return a*2+b*4+c*4;
    }

    // 4 задача
    public static boolean profitableGamble(double prob, double prize, double pay) {
        if (prob * prize > pay)
            return true;
        else
            return false;
    }

    // 5 задача
    public static String operation(double N, double a, double b) {
        if (a + b == N)
            return "Сложить";
        else if (a - b == N)
            return "Вычесть";
        else if (a * b == N)
            return "Умножить";
        else if (a / b == N)
            return "Разделить";
        else
            return "None";
    }

    // 6 задача
    public static int ctoa(char a) {
        return a;
    }

    // 7 задача
    public static int addUpTo(int a) {
        int sum = 0;
        for (int i = 0; i <= a; i++)
            sum += i;
        return sum;
    }

    // 8 задача
    public static int nextEdge(int a, int b) {
        return a + b - 1; // Так как третья сторона не должна превышать сумму двух других
    }

    // 9 задача
    public static double sumOfCubes(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += Math.pow(arr[i], 3);
        return sum;
    }

    // 10 задача
    public static boolean abcmath(int A, int B, int C) {
        for (int i = 0; i < B; i ++)
            A += A;
        if (A % C == 0)
            return true;
        else
            return false;
    }
}