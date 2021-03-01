import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class task5 {
    public static void main(String[] args) {
        // Задача 41
        int[] arr = encrypt("Hello");
        for (int i = 0; i < arr.length - 1; i ++)
            System.out.print(arr[i] + ", ");
        System.out.println(arr[arr.length - 1]);
        int[] arr2 = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println(decrypt(arr2));
        // Задача 42
        System.out.println(canMove("Пешка", "A2", "A4"));
        System.out.println(canMove("Конь", "A1", "C2"));
        System.out.println(canMove("Слон", "A1", "H1"));
        System.out.println(canMove("Ладья", "A1", "H8"));
        System.out.println(canMove("Ферзь", "A1", "C8"));
        System.out.println(canMove("Король", "A1", "B2"));
        // Задача 43
        System.out.println(canComplete("bbutl", "beautiful"));
        // Задача 44
        int[] array = {36};
        System.out.println(sumDigProd(array));
        // Задача 45
        String[] arr1 = {"hoops", "chuff", "bot", "bottom"};
        String[] arr3 = sameVowelGroup(arr1);
        for (int i = 0; i < arr3.length; i++)
            System.out.print(arr3[i] + " ");
        System.out.println();
        // Задача 46
        System.out.println(validateCard(1234567890123456L));
        // Задача 47
        System.out.println(numToEng(909));
        System.out.println(numToRu(126));
        // Задача 48
        System.out.println(getSha256Hash("Fluffy@home"));
        // Задача 49
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        // Задача 50
        System.out.println(hexLattice(61));
    }

    // Задача 41
    public static int[] encrypt(String a) {
        int[] arr = new int[a.length()];
        arr[0] = a.charAt(0);
        for (int i = 1; i < a.length(); i++)
            arr[i] = a.charAt(i) - a.charAt(i - 1);
        return arr;
    }
    public static String decrypt(int[] arr) {
        String out = "";
        out += ((char)arr[0]);
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            m += arr[i];
            out += ((char) m);
        }
        return out;
    }

    // Задача 42
    public static boolean canMove(String a, String b, String c) {
        int a1 = c.charAt(1) - b.charAt(1), a2 = c.charAt(0) - b.charAt(0);
        boolean b1 = (b.charAt(0) == c.charAt(0)) || (b.charAt(1) == c.charAt(1));
        boolean b2 = (Math.abs(a2)) == (Math.abs(a1));
        switch (a) {
            case "Пешка":
                if (b.charAt(0) == c.charAt(0)) {
                    if (a1 == 1)
                        return true;
                    else if ((a1 == 2) && (b.charAt(1) == '2'))
                            return true;
                    else
                        return false;
                }
                else
                    return false;
            case "Конь":
                if ((Math.abs(a2) == 1) && (Math.abs(a1) == 2))
                    return true;
                else if ((Math.abs(a1) == 1) && (Math.abs(a2) == 2))
                    return true;
                else
                    return false;
            case "Слон":
                if (b1)
                    return true;
                else
                    return false;
            case "Ладья":
                if (b2)
                    return true;
                else
                    return false;
            case "Ферзь":
                if (b1 || b2)
                    return true;
                else
                    return false;
            case "Король":
                if (Math.abs(a1) <= 1 && Math.abs(a2) <= 1)
                    return true;
                else
                    return false;
        }
        return false;
    }

    // Задача 43
    public static boolean canComplete(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(j))
                j++;
        }
        if (j == a.length())
            return true;
        else
            return false;
    }

    // Задача 44
    public static int sumDigProd(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        while (sum > 9) {
            String a = Integer.toString(sum);
            sum = 1;
            for (int i = 0; i < a.length(); i ++) {
                sum *= Character.getNumericValue(a.charAt(i));
            }
        }
        return sum;
    }

    // Задача 45
    public static String[] sameVowelGroup(String[] arr) {
        String[] array = new String[arr.length];
        boolean equal = false;
        for (int i = 0; i < array.length; i++)
            array[i] = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                switch (arr[i].charAt(j)) {
                    case 'a':
                    case 'u':
                    case 'e':
                    case 'o':
                    case 'y':
                    case 'i':
                        for (int k = 0; k < array[i].length(); k++) {
                            if (array[i].charAt(k) == arr[i].charAt(j))
                                equal = true;
                        }
                        if (equal == false)
                            array[i] += arr[i].charAt(j);
                        equal = false;
                        break;
                }
            }
        }
        String out = "";
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            if (array[i].equals(array[0]))
                out += arr[i] + " ";
        }
        String delimeter = " ";
        String[] output = out.split(delimeter);
        return output;
    }

    // Задача 46
    public static boolean validateCard(long a) {
        String b = String.valueOf(a);
        if ((b.length() >= 14) && b.length() <= 19) {
            String c = "";
            String e = "";
            int d = 0, sum = 0;
            char control = b.charAt(b.length() - 1);
            b = b.substring(0, (b.length() - 1));
            for (int i = b.length() - 1; i >= 0; i--)
                c += b.charAt(i);
            for (int i = 0; i < c.length(); i++) {
                if ((i + 1) % 2 == 1) {
                    d = Character.getNumericValue(c.charAt(i));
                    d *= 2;
                    if (d > 9)
                        d = (d / 10) + (d % 10);
                    b += String.valueOf(d);
                    sum += d;
                } else {
                    b += c.charAt(i);
                    sum += Character.getNumericValue(c.charAt(i));
                }
            }
            if (10 - (sum % 10) == Character.getNumericValue(control))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    // Задача 47
    public static String numToEng(int a) {
        String out = "";
        switch (a / 100) {
            case 1:
                out += "one hundred ";
                break;
            case 2:
                out += "two hundred ";
                break;
            case 3:
                out += "three hundred ";
                break;
            case 4:
                out += "four hundred ";
                break;
            case 5:
                out += "five hundred ";
                break;
            case 6:
                out += "six hundred ";
                break;
            case 7:
                out += "seven hundred ";
                break;
            case 8:
                out += "eight hundred ";
                break;
            case 9:
                out += "nine hundred ";
                break;
            case 0:
                out += "";
                break;
        }
        switch (a / 10 - (a/100 * 10)) {
            case 1:
                switch (a % 100) {
                    case 10:
                        out += "ten";
                        return out;
                    case 11:
                        out += "eleven";
                        return out;
                    case 12:
                        out += "twelve";
                        return out;
                    case 13:
                        out += "thirteen";
                        return out;
                    case 14:
                        out += "fourteen";
                        return out;
                    case 15:
                        out += "fifteen";
                        return out;
                    case 16:
                        out += "sixteen";
                        return out;
                    case 17:
                        out += "seventeen";
                        return out;
                    case 18:
                        out += "eighteen";
                        return out;
                    case 19:
                        out += "nineteen";
                        return out;
                }
                break;
            case 2:
                out += "twenty ";
                break;
            case 3:
                out += "thirty ";
                break;
            case 4:
                out += "forty ";
                break;
            case 5:
                out += "fifty ";
                break;
            case 6:
                out += "sixty ";
                break;
            case 7:
                out += "seventy ";
                break;
            case 8:
                out += "eighty ";
                break;
            case 9:
                out += "ninety ";
                break;
            case 0:
                out += "";
                if (a % 10 != 0)
                    out += "and ";
                break;
        }
        switch (a % 10) {
            case 1:
                out += "one";
                break;
            case 2:
                out += "two";
                break;
            case 3:
                out += "three";
                break;
            case 4:
                out += "four";
                break;
            case 5:
                out += "five";
                break;
            case 6:
                out += "six";
                break;
            case 7:
                out += "seven";
                break;
            case 8:
                out += "eight";
                break;
            case 9:
                out += "nine";
                break;
            case 0:
                out += "";
                if (a == 0)
                    return "zero";
                break;
        }
        return out;
    }
    public static String numToRu(int a) {
        String out = "";
        switch (a / 100) {
            case 1:
                out += "сто ";
                break;
            case 2:
                out += "двести ";
                break;
            case 3:
                out += "триста ";
                break;
            case 4:
                out += "четыреста ";
                break;
            case 5:
                out += "пятьсот ";
                break;
            case 6:
                out += "шестьсот ";
                break;
            case 7:
                out += "семьсот ";
                break;
            case 8:
                out += "восемьсот ";
                break;
            case 9:
                out += "девятьсот ";
                break;
            case 0:
                out += "";
                break;
        }
        switch (a / 10 - (a/100 * 10)) {
            case 1:
                switch (a % 100) {
                    case 10:
                        out += "десять";
                        return out;
                    case 11:
                        out += "одиннадцать";
                        return out;
                    case 12:
                        out += "двенадцать";
                        return out;
                    case 13:
                        out += "тринадцать";
                        return out;
                    case 14:
                        out += "четырнадцать";
                        return out;
                    case 15:
                        out += "пятнадцать";
                        return out;
                    case 16:
                        out += "шестнадцать";
                        return out;
                    case 17:
                        out += "семнадцать";
                        return out;
                    case 18:
                        out += "восемнадцать";
                        return out;
                    case 19:
                        out += "девятнадцать";
                        return out;
                }
                break;
            case 2:
                out += "двадцать ";
                break;
            case 3:
                out += "тридцать ";
                break;
            case 4:
                out += "сорок ";
                break;
            case 5:
                out += "пятьдесят ";
                break;
            case 6:
                out += "шестьдесят ";
                break;
            case 7:
                out += "семьдесят ";
                break;
            case 8:
                out += "восемьдесят ";
                break;
            case 9:
                out += "девяносто ";
                break;
            case 0:
                out += "";
                break;
        }
        switch (a % 10) {
            case 1:
                out += "один";
                break;
            case 2:
                out += "два";
                break;
            case 3:
                out += "три";
                break;
            case 4:
                out += "четыре";
                break;
            case 5:
                out += "пять";
                break;
            case 6:
                out += "шесть";
                break;
            case 7:
                out += "семь";
                break;
            case 8:
                out += "восемь";
                break;
            case 9:
                out += "девять";
                break;
            case 0:
                out += "";
                if (a == 0)
                    return "ноль";
                break;
        }
        return out;
    }

    // Задача 48
    public static String getSha256Hash(String a) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(a.getBytes(StandardCharsets.UTF_8));

        //bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
        }
        catch (Exception ex) {}
        return "";
    }

    // Задача 49
    public static String correctTitle(String a) {
        String out = "";
        String delimeter = " ";
        String word;
        String[] str = a.split(delimeter);
        for (int i = 0; i < str.length; i++) {
            word = str[i].toLowerCase();
            switch (word) {
                case "and":
                case "the":
                case "of":
                case "in":
                    out += word + " ";
                    break;
                default:
                    out += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
                    break;
            }
        }
        return out;
    }

    // Задача 50
    public static String hexLattice(int a) {
        int b = 1, i = 1, length = 0, q = 0;
        while (a > b) {
            b += (6 * i);
            i++;
        }
        if (a == b) {
            String out = "";
            length = i * 2 - 1;
            for (int j = 0; j < length/2; j++) {
                for (int k = 0; k < (length - i - q); k++)
                    out += " ";
                for (int k = 0; k <= (length/2 + q); k++)
                    out += "o ";
                q++;
                out += "\n";
            }
            for (int j = 0; j < length; j++)
                out += "o ";
            out += "\n";
            q = i - 2;
            for (int j = length/2 + 1; j < length; j++) {
                for (int k = 0; k < (length - i - q); k++)
                    out += " ";
                for (int k = 0; k <= (length/2 + q); k++)
                    out += "o ";
                q--;
                out += "\n";
            }
            return out;
        }
        else
            return "Invalid";
    }
}
