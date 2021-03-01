public class task3 {
    public static void main(String[] args) {
        // Задача 21
        System.out.println(solutions(2,4,2));
        // Задача 22
        System.out.println(findZip("zip zip"));
        // Задача 23
        System.out.println(checkPerfect(28));
        // Задача 24
        System.out.println(flipEndChars("привет"));
        // Задача 25
        System.out.println(isValidHexCode("#A2AaFA"));
        // Задача 26
        int[] arr1 = {1, 3, 4, 4, 4};
        int[] arr2 = {2, 5, 7};
        System.out.println(same(arr1, arr2));
        // Задача 27
        System.out.println(isKaprekar(2728));
        // Задача 28
        System.out.println(longestZero("011000000101100000"));
        // Задача 29
        System.out.println(nextPrime(7999964));
        // Задача 30
        System.out.println(rightTriangle(145, 105, 100));
    }
    // Задача 21
    public static int solutions(int a, int b, int c) {
        double D = (Math.pow(b, 2)) - (4 * a * c);
        int k = 0;
        if (D == 0)
            return 1;
        else if (D > 0)
            return 2;
        else
            return 0;
    }

    // Задача 22
    public static int findZip(String a) {
        int zip = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'z')
                if (a.charAt(i + 1) == 'i')
                    if (a.charAt(i + 2) == 'p') {
                        if (zip == 1)
                            return i;
                        else
                            zip++;
                    }
        }
        return -1;
    }

    // Задача 23
    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i <= a/2; i++) {
            if (a % i == 0)
                sum += i;
        }
        if (sum == a)
            return true;
        else
            return false;
    }

    // Задача 24
    public static String flipEndChars(String a) {
        if (a.length() < 2)
            return "Несовместимо";
        else {
            if (a.charAt(0) == a.charAt(a.length() - 1))
                return "Два - это пара";
            else {
                String c = "";
                c += a.charAt(a.length() - 1);
                for (int j = 1; j < a.length() - 1; j++)
                    c += a.charAt(j);
                c += a.charAt(0);
                return c;
            }
        }
    }

    // Задача 25
    public static boolean isValidHexCode(String a) {
        if (a.charAt(0) == '#' && a.length() == 7) {
            for (int i = 1; i < 6; i++) {
                if (!((a.charAt(i) >= 'A') && (a.charAt(i)) <= 'F') && !((a.charAt(i) >= 'a') && (a.charAt(i)) <= 'f') && !((a.charAt(i) >= '0') && (a.charAt(i)) <= '9'))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    // Задача 26
    public static boolean same(int[] arr1, int[] arr2) {
        int[] mas1 = new int[10];
        int[] mas2 = new int[10];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arr1.length; i++)
            mas1[arr1[i]]++;
        for (int i = 0; i <= 9; i ++)
            if (mas1[i] > 0)
                count1++;
        for (int i = 0; i < arr2.length; i++)
            mas2[arr2[i]]++;
        for (int i = 0; i <= 9; i ++)
            if (mas2[i] > 0)
                count2++;
        if (count1 == count2)
            return true;
        else
            return false;
    }

    // Задача 27
    public static boolean isKaprekar(int a) {
        if (a > 3) {
            int b = a * a;
            String c = Integer.toString(b);
            String d = c.substring(0, c.length() / 2);
            String e = c.substring((c.length() / 2), c.length());
            if (Integer.parseInt(d) + Integer.parseInt(e) == a)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    // Задача 28
    public static String longestZero(String a) {
        int max = 0, current = 0;
        String zeroes = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0')
                current++;
            else {
                if (current > max)
                    max = current;
                current = 0;
            }
        }
        if (current > max)
            max = current;
        for (int j = 0; j < max; j++)
            zeroes += '0';
        return zeroes;
    }

    // Задача 29
    public static int nextPrime(int a) {
        int i = a;
        boolean isPrime = false;
        while (isPrime == false) {
            int j = 2;
            while ((i % j != 0) && (j < i)) {
                j++;
            }
            if (j == i)
                isPrime = true;
            else
                i++;
        }
        return i;
    }

    // Задача 30
    public static boolean rightTriangle(double a, double b, double c) {
        if ((Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) ||
                (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) ||
                (Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2)))
            return true;
        else
            return false;
    }
}