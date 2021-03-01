public class tasks {
    public static void main(String[] args) {
        // 11 задача
        System.out.println(repeat("mouse", 3));
        // 12 задача
        int[] arr = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(arr));
        // 13 задача
        int[] arr2 = {1, 3, 4, 8};
        System.out.println(isAvgWhole(arr2));
        // 14 задача
        int[] arr3 = {1, 2, 3};
        int[] arr4 = new int[arr3.length];
        arr4 = cumulativeSum(arr3);
        for (int i = 0; i < arr4.length; i++)
            System.out.print(arr4[i] + " ");
        System.out.println("");
        // 15 задача
        // getDecimalPlaces
        System.out.println(getDecimalPlaces(3.141592));
        // 16 задача
        System.out.println(Fibonacci(12));
        // 17 задача
        System.out.println(isValid("11692"));
        // 18 задача
        System.out.println(isStrangePair("bush", "hub"));
        // 19 задача
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        // 20 задача
        System.out.println(boxSeq(5));
    }

    // 11 задача
    public static String repeat(String a, int b) {
        String out = "";
        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b; j++)
                out += a.charAt(i);
        return out;
    }

    // 12 задача
    public static int differenceMaxMin(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        return max - min;
    }

    // 13 задача
    public static boolean isAvgWhole(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        if (sum % arr.length == 0)
            return true;
        else
            return false;
    }

    // 14 задача
    public static int[] cumulativeSum(int[] arr) {
        int sum = 0;
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            array[i] = sum;
        }
        return array;
    }

    // 15 задача
    public static int getDecimalPlaces(double a) {
        String num = Double.toString(a);
        int count = 0;
        boolean point = false;
        for (int i = 0; i < num.length(); i++) {
            if (!point) {
                if (num.charAt(i) == '.')
                    point = true;
            }
            else
                count++;
        }
        return count;
    }

    // 16 задача
    public static int Fibonacci(int a) {
        if (a > 2) {
            int[] fib = new int[a];
            fib[0] = 1;
            fib[1] = 2;
            for (int i = 2; i < a; i++)
                fib[i] = fib[i - 1] + fib[i - 2];
            return fib[a - 1];
        }
        else
            return a;
    }

    // 17 задача
    public static boolean isValid(String a) {
        if (a.length() == 5) {
            for (int i = 0; i < 5; i++) {
                if (a.charAt(i) < '0' | a.charAt(i) > '9')
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    // 18 задача
    public static boolean isStrangePair(String a, String b) {
        if (a == "" | b == "")
            return true;
        else if ((a.charAt(a.length() - 1) == b.charAt(0)) && (a.charAt(0) == b.charAt(b.length() - 1)))
            return true;
        else
            return false;
    }

    // 19 задача
    public static boolean isPrefix(String a, String b) {
        for (int i = 0; i < b.length() - 1; i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
    public static boolean isSuffix(String a, String b) {
        for (int i = 0; i < b.length() - 1; i++) {
            if (a.charAt(a.length() - 1 - i) != b.charAt(b.length() - 1 - i))
                return false;
        }
        return true;
    }

    // 20 задача
    public static int boxSeq(int a) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            if (i % 2 == 1)
                sum += 3;
            else
                sum -= 1;
        }
        return sum;
    }
}