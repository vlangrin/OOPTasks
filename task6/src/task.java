import java.util.ArrayList;

public class task {
    public static void main(String[] args) {
        // Задача 51
        System.out.println(bell(6));
        // Задача 52
        System.out.println(translateWord("flag"));
        System.out.println(translateSentence("I like to eat honey waffles."));
        // Задача 53
        System.out.println(validColor("rgb(0,4,0)"));
        // Задача 54
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2&b=4&a=5"));
        String[] arr = {"b"};
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2&b=4&a=5", arr));
        // Задача 55
        String[] arr2 = getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit");
        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
        // Задача 56
        System.out.println(ulan(31));
        // Задача 57
        System.out.println(longestNonrepeatingSubstring("abcda"));
        // Задача 58
        System.out.println(convertToRoman(999));
        // Задача 59
        System.out.println(formula("13 + 12 = 100 / 4 = 5 * 4 + 5 = 25"));
        // Задача 60
        System.out.println(palindromedescendant(23336014));
    }

    // Задача 51
    public static int bell(int a) {
        if (a == 0) return 1;
        else
        {
            int sum = 0;
            for (int k = 0; k < a; k++) {
                sum += C(a-1, k) * bell(a - k - 1);
            }
            return sum;
        }
    }
    private static int C(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    private static int factorial(int a) {
        int sum = 1;
        for (int i = 1; i <= a; i++)
            sum *= i;
        return sum;
    }

    // Задача 52
    public static String translateWord(String a) {
        String c = a;
        if (a == "")
            return "";
        switch (a.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                return a + "yay";
            default:
                for (int i = 0; i < c.length(); i++) {
                    switch (c.charAt(0)) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                        case 'y':
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                        case 'Y':
                            return c + "ay";
                        default:
                            c = c.substring(1) + c.charAt(0);
                    }
                }
                break;
        }
        return c + "ay";
    }
    public static String translateSentence(String a) {
        String out = "";
        String del = " ";
        String[] b = a.split(del);
        for (int i = 0; i < b.length - 1; i ++)
            out += translateWord(b[i]) + " ";
        String c = b[b.length - 1];
        if (c.charAt(c.length() - 1) == '.') {
            c = c.substring(0, c.length() - 2);
            out += translateWord(c) + '.';
        }
        return out;
    }

    // Задача 53
    public static boolean validColor(String a) {
        String word = "", word2 = "";
        int i = 0;
        while (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                word += a.charAt(i);
                i++;
        }
        if (!word.equals("rgb") && !word.equals("rgba"))
            return false;
        for (i = word.length(); i < a.length(); i++)
            word2 += a.charAt(i);
        if (word2.charAt(0) != '(' || word2.charAt(word2.length() - 1) != ')')
            return false;
        word2 = word2.substring(1, word2.length() - 1);
        String del = ",";
        String[] rgb = word2.split(del);
        for (i = 0; i < 3; i ++) {
            if (!rgb[i].equals("")) {
                if (Double.parseDouble(rgb[i]) > 255 || Double.parseDouble(rgb[i]) < 0)
                    return false;
            }
            else
                return false;
        }
        return true;
    }

    // Задача 54
    public static String stripUrlParams(String a) {
        String out = "";
        int i = 0, q = 0;
        while (a.charAt(i) != '=')
            i++;
        q = i - 1;
        String str = a.substring(i-1);
        String del = "&";
        String[] st = str.split(del);
        for (i = 0; i < st.length; i++) {
            for (int j = i + 1; j < st.length; j++) {
                if (st[i] != "" && st[j] != "")
                    if (st[i].charAt(0) == st[j].charAt(0)) {
                        st[i] = st[j];
                        st[j] = "";
                    }
            }
        }
        out += a.substring(0, q);
        for (i = 0; i < st.length - 1; i++)
            out += st[i] + "&";
        while (out.charAt(out.length() - 1) == '&')
            out = out.substring(0, out.length() - 1);
        return out;
    }
    public static String stripUrlParams(String a, String[] b) {
        String out = "";
        int i = 0, q = 0;
        while (a.charAt(i) != '=')
            i++;
        q = i - 1;
        String str = a.substring(i-1);
        String del = "&";
        String[] st = str.split(del);
        for (i = 0; i < st.length; i++) {
            for (int j = i + 1; j < st.length; j++) {
                if (st[i] != "" && st[j] != "")
                    if (st[i].charAt(0) == st[j].charAt(0)) {
                        st[i] = st[j];
                        st[j] = "";
                    }
            }
        }
        out += a.substring(0, q);

        for (i = 0; i < st.length; i++) {
            for (int j = 0; j < b.length; j++)
                if (!st[i].equals(""))
                    if (st[i].charAt(0) == b[j].charAt(0))
                        st[i] = "";
        }

        for (i = 0; i < st.length - 1; i++)
            out += st[i] + "&";
        while (out.charAt(out.length() - 1) == '&')
            out = out.substring(0, out.length() - 1);
        return out;
    }

    // Задача 55
    public static String[] getHashTags(String a) {
        String del = " ";
        String[] out = {"", "", ""};
        String[] str = a.split(del);
        for (int i = 0; i < str.length; i++)
            if (str[i].charAt(str[i].length() - 1) == ',')
                str[i] = str[i].substring(0, str[i].length() - 1);
        for (int i = 0; i < str.length; i++) {
            for (int j = out.length - 1; j >= 0; j--) {
                if (str[i].length() > out[j].length()) {
                    out[j] = str[i];
                    break;
                }
            }
            out = sort(out);
        }
        for (int i = 0; i < out.length; i++)
            if (!out[i].equals(""))
                out[i] = "#" + out[i].toLowerCase();
        return out;
    }
    public static String[] sort(String[] out) {
        for (int i = 0; i < out.length; i++)
            for (int j = 1; j < out.length; j++)
                if (out[j].length() > out[j - 1].length()) {
                    String a = out[j - 1];
                    out[j - 1] = out[j];
                    out[j] = a;
                }
        return out;
    }

    // Задача 56
    public static int ulan(int a) {
        ArrayList<Integer> mas = new ArrayList<>();
        int count = 0;
        mas.add(1);
        mas.add(2);
        int num = 3, len = 2, g = 2;
        while (g < a) {
            for (int j = 0; j < mas.size(); j++) {
                for (int k = j + 1; k < mas.size(); k++) {
                    if (mas.get(j) + mas.get(k) == num)
                        count++;
                }
            }
            if (count == 1) {
                mas.add(num);
                g++;
            }
            num++;
            len++;
            count = 0;
        }
        return mas.get(g - 1);
    }

    // Задача 57
    public static String longestNonrepeatingSubstring(String a) {
        String str = "", longest = "";
        str += a.charAt(0);
        for (int i = 1; i < a.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == a.charAt(i)) {
                    if (str.length() > longest.length())
                        longest = str;
                    str = "";
                }
            }
            str += a.charAt(i);
        }
        if (longest.equals(""))
            longest = str;
        return longest;
    }

    // Задача 58
    public static String convertToRoman(int a) {
        String out = "";
        // M - 1000, D - 500, C - 100, L - 50, X - 10, V - 5, I - 1
            while (a >= 1000) {
                out += "M";
                a -= 1000;
            }
            while (a >= 900) {
                out += "CM";
                a -= 900;
            }
            while (a >= 500) {
                out += "D";
                a -= 500;
            }
            while (a >= 400) {
                out += "CD";
                a -= 400;
            }
            while (a >= 100) {
                out += "C";
                a -= 100;
            }
            while (a >= 90) {
                out += "XC";
                a -= 90;
            }
            while (a >= 50) {
                out += "L";
                a -= 50;
            }
            while (a >= 40) {
                out += "XL";
                a -= 40;
            }
            while (a >= 10) {
                out += "X";
                a -= 10;
            }
            while (a >= 9) {
                out += "IX";
                a -= 9;
            }
            while (a >= 5) {
                out += "V";
                a -= 5;
            }
            while (a >= 4) {
                out += "IV";
                a -= 4;
            }
            while (a >= 1) {
                out += "I";
                a -= 1;
            }
        return out;
    }

    // Задача 59
    public static boolean formula(String a) {
        String del = "=";
        int r = 0;
        String[] ur = a.split(del);
        int[] val = new int[ur.length];
        char act = ' ';
        for (int i = 0; i < ur.length; i++) {
            String del2 = " ";
            String[] ch_ur = ur[i].split(del2);
            for (int j = 0; j < ch_ur.length; j++) {
                if (ch_ur[j].equals("+")) {
                    r += Integer.parseInt(ch_ur[j + 1]);
                    j++;
                }
                else if (ch_ur[j].equals("-")) {
                    r -= Integer.parseInt(ch_ur[j + 1]);
                    j++;
                }
                else if (ch_ur[j].equals("*")) {
                    r *= Integer.parseInt(ch_ur[j + 1]);
                    j++;
                }
                else if (ch_ur[j].equals("/")) {
                    r /= Integer.parseInt(ch_ur[j + 1]);
                    j++;
                }
                else
                    if (!ch_ur[j].equals(""))
                        r = Integer.parseInt(ch_ur[j]);
            }
            val[i] = r;
        }
        for (int i = 0; i < val.length - 1; i++)
            if (val[i] != val[i + 1])
                return false;
        return true;
    }

    // Задача 60
    public static boolean palindromedescendant(int a) {
        String b = String.valueOf(a);
        String c = "";
        if (isPalindrome(b))
            return true;
        while (b.length() > 2) {
            c = "";
            for (int i = 0; i < b.length(); i++) {
                c += Integer.toString(
                        Character.getNumericValue(b.charAt(i) + Character.getNumericValue(b.charAt(i + 1))
                        ));
                i++;
            }
            if (isPalindrome(c))
                return true;
            b = c;
        }
        if (b.length() == 2) {
            b = Integer.toString(Character.getNumericValue(b.charAt(0)) + Character.getNumericValue(b.charAt(1)));
            if (isPalindrome(b))
                return true;
            else
                return false;
        }
            return false;
    }
    public static boolean isPalindrome(String a) {
        String b = "";
        for (int i = a.length() - 1; i >= 0; i--)
            b += a.charAt(i);
        return (a.equals(b));
    }
}