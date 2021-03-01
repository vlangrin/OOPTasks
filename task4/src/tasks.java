public class tasks {
    public static void main(String[] args) {
        // Задача 31
        System.out.println(esse(10, 7, "hello my name is Bessie and this is my essay"));
        // Задача 32
        String[] arr = split("() () ()");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        // Задача 33
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        // Задача 34
        double[] arr2 = {16, 18, 30, 1.8};
        System.out.println(overTime(arr2));
        // Задача 35
        System.out.println(BMI("48 kilos", "1.61 meters"));
        // Задача 36
        System.out.println(bugger(999));
        // Задача 37
        System.out.println(toStarShorthand("abbccc"));
        // Задача 38
        System.out.println(doesRhyme("Sam I am!", "Green eggs and jam."));
        // Задача 39
        System.out.println(trouble(12333, 3345));
        // Задача 40
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));

    }

    // Задача 31
    public static String esse(int a, int b, String c) {
        String[] arr = new String[a];
        String out = "";
        String delimeter = " ";
        int line = 0;
        arr = c.split(delimeter);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() <= b - line) {
                out += arr[i] + " ";
                line += arr[i].length();
            }
            else {
                out += "\n" + arr[i] + " ";
                line = arr[i].length();
            }
        }
        return out;
    }

    // Задача 32
    public static String[] split(String a) {
        int left = 0, right = 0, k = 0;
        String[] out = new String[8];
        String delimeter = " ";
        out = a.split(delimeter);
        return out;
    }

    // Задача 33
    public static String toCamelCase(String a) {
        String out = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '_') {
                i++;
                String b = Character.toString(a.charAt(i));
                out += b.toUpperCase();
            }
            else
                out += a.charAt(i);
        }
        return out;
    }
    public static String toSnakeCase(String a) {
        String out = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                String b = Character.toString(a.charAt(i));
                out += "_" + b.toLowerCase();
            }
            else
                out += a.charAt(i);
        }
        return out;
    }

    // Задача 34
    public static String overTime(double[] arr) {
        double start = arr[0], finish = arr[1], stavka = arr[2], mnozh = arr[3], res = 0;
        if (finish > 17)
            res = (finish - 17) * stavka * mnozh + (17 - start) * stavka;
        else
            res = (finish - start) * stavka;
        return "$" + String.format("%.2f", res);
    }

    // Задача 35
    public static String BMI(String a, String b) {
        double BMI = 0;
        String weight = "", height = "";
        String weight2 = "", height2 = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= '0' && a.charAt(i) <= '9' || a.charAt(i) == '.')
                weight += a.charAt(i);
            else if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z')
                weight2 += a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) >= '0' && b.charAt(i) <= '9' || b.charAt(i) == '.')
                height += b.charAt(i);
            else if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z')
                height2 += b.charAt(i);
        }
        double weight3 = Double.parseDouble(weight), height3 = Double.parseDouble(height);
        if (weight2.equals("pounds"))
            weight3 *= 0.453592;
        if (height2.equals("inches"))
            height3 *= 0.0254;
        BMI = weight3/(height3 * height3);
        if (BMI >= 25)
            return String.format("%.1f", BMI) + " Overweight";
        else if (BMI < 18.5)
            return String.format("%.1f", BMI) + " Underweight";
        else
            return String.format("%.1f", BMI) + " Normal weight";
    }

    // Задача 36
    public static int bugger(int a) {
        int count = 0;
        String num = Integer.toString(a);
        while (num.length() > 1) {
            int mn = 1;
            for (int i = 0; i < num.length(); i++) {
                mn *= Character.getNumericValue(num.charAt(i));
            }
            num = Integer.toString(mn);
            count++;
        }
        return count;
    }

    // Задача 37
    public static String toStarShorthand(String a) {
        int count = 1;
        String out = "";
        if (a.length() == 0)
            return "";
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i + 1) == a.charAt(i))
                count++;
            else {
                if (count > 1)
                    out += a.charAt(i) + "*" + count;
                else
                    out += a.charAt(i);
                count = 1;
            }
        }
        if (count > 1)
            out += a.charAt(a.length() - 1) + "*" + count;
        else
            out += a.charAt(a.length() - 1);
        count = 1;
        return out;
    }

    // Задача 38
    public static boolean doesRhyme(String a, String b) {
        String c = "", d = "";
        int i = 0;
        char e = a.charAt(a.length() - i - 1);
        do {
            switch (e) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    c += e;
                    break;
            }
            i++;
            e = a.charAt(a.length() - i - 1);
        }
        while (e != ' ');
        i = 0;
        e = b.charAt(b.length() - i - 1);
        do {
            switch (e) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    d += e;
                    break;
            }
            i++;
            e = b.charAt(b.length() - i - 1);
        }
        while (e != ' ');

        if (c.equals(d))
            return true;
        else
            return false;
    }

    // Задача 39
    public static boolean trouble(long a, long b) {
        int[] mas1 = new int[10];
        int[] mas2 = new int[10];
        int i = 0;
        while (a > 9) {
            mas1[(int)(a % 10)]++;
            a = a/10;
        }
        mas1[(int)a]++;
        while (b > 9) {
            mas2[(int)(b % 10)]++;
            b = b/10;
        }
        mas2[(int)b]++;
        for (i = 0; i < mas1.length; i++) {
            if (mas1[i] == 3)
                if (mas2[i] == 2)
                    return true;
        }
        return false;
    }

    // Задача 40
    public static int countUniqueBooks(String a, char b) {
        String book = "";
        boolean opened = false;
        int count = 0, j = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b && opened == false)
                opened = true;
            else if (a.charAt(i) != b && opened == true) {
                for (j = 0; j < book.length(); j++) {
                    if (a.charAt(i) == book.charAt(j))
                        break;
                }
                if (j == book.length())
                    book += a.charAt(i);
            }
            else if (a.charAt(i) == b && opened == true) {
                opened = false;
                count += book.length();
                book = "";
            }
        }
        return count;
    }
}
