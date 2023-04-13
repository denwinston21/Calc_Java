import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате '1+1' арабскими или 'I+I' римскими числами и нажмите Enter: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        String oper;
        String result;
        boolean isRoman;
        int num1;
        int num2;
        String[] operands = expression.split("[+\\-*/]");
        oper = detectOperation(expression);
        if (oper == null) throw new Exception("Cтрока не является математической операцией");
        if (operands.length != 2) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        // Если оба числа римские
        if (convertNumToRoman.isRoman(operands[0]) && convertNumToRoman.isRoman(operands[1])) {
            // Конвертируем числа в арабский формат для вычесления
            num1 = convertNumToRoman.romanToNumber(operands[0]);
            num2 = convertNumToRoman.romanToNumber(operands[1]);
            isRoman = true;
        }
        // Если оба числа арабские
        else if (!convertNumToRoman.isRoman(operands[0]) && !convertNumToRoman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        // Если одно число римское, а другое арабское
        else {
            throw new Exception("Используются одновременно разные системы счисления!");
        }
        // Если число больше 10
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calculated(num1, num2, oper);
        if (isRoman) {
            // Если римское число получилось меньше или равно нулю
            if (arabian <= 0) {
                throw new Exception("В римской системе нет отрицательных чисел!");
            }
            //             // Конвертируем результат выражения из арабского в римский формат
            result = convertNumToRoman.convertToRoman(arabian);
        } else {
            // Конвертируем арабское число в тип String
            result = String.valueOf(arabian);
        }
        // Возвращаем результат выражения
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calculated(int num1, int num2, String oper) {

        if (oper.equals("+")) return num1 + num2;
        else if (oper.equals("-")) return num1 - num2;
        else if (oper.equals("*")) return num1 * num2;
        else return num1 / num2;
    }

}

class convertNumToRoman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int romanToNumber(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }

}
