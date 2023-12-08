package annotation_example;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем словарь для преобразования римских цифр в арабские и обратно
        Map<Character, Integer> romanToArabic = new HashMap<>();
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);

        Map<Integer, String>  arabicToRoman = new HashMap<>();
        arabicToRoman.put(1, "I");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(100, "C");
        arabicToRoman.put(400, "CD");
        arabicToRoman.put(500, "D");
        arabicToRoman.put(900, "CM");
        arabicToRoman.put(1000, "M");

        // Ввод чисел и операции
        System.out.print("Введите первое число: ");
        String input1 = scanner.nextLine();
        System.out.print("Введите второе число: ");
        String input2 = scanner.nextLine();
        System.out.print("Введите операцию (+, -, *, /): ");
        char operation = scanner.nextLine().charAt(0);

        // Проверка типа введенных чисел
        boolean isInput1Roman = isRomanNumber(input1);
        boolean isInput2Roman = isRomanNumber(input2);

        // Если одно число римское, а другое арабское - генерируем исключение
        if (isInput1Roman && !isInput2Roman || !isInput1Roman && isInput2Roman) {
            throw new IllegalArgumentException("Одно число римское, а другое арабское. Некорректный ввод.");
        }

        // Выполнение операции
        int result;
        if (isInput1Roman) {
            int number1 = convertRomanToArabic(input1, romanToArabic);
            int number2 = convertRomanToArabic(input2, romanToArabic);
            result = performOperation(number1, number2, operation);
            System.out.println("Результат: " + convertArabicToRoman(result, arabicToRoman));
        } else {
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);
            result = performOperation(number1, number2, operation);
            System.out.println("Результат: " + result);
        }
    }

    // Проверка, является ли строка римским числом
    private static boolean isRomanNumber(String input) {
        String romanRegex = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return input.matches(romanRegex);
    }

    // Преобразование римского числа в арабское
    private static int convertRomanToArabic(String input, Map<Character, Integer> romanToArabic) {
        int result = 0;
        int prevValue = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            int currentValue = romanToArabic.get(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    // Преобразование арабского числа в римское
    private static String convertArabicToRoman(int number, Map<Integer, String> arabicToRoman) {
        StringBuilder romanNumber = new StringBuilder();
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int value : arabicValues) {
            while (number >= value) {
                romanNumber.append(arabicToRoman.get(value));
                number -= value;
            }
        }

        return romanNumber.toString();
    }

    // Выполнение операции над числами
    private static int performOperation(int number1, int number2, char operation) {
        return switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> throw new IllegalArgumentException("Некорректная операция. Допустимые операции: +, -, *, /");
        };
    }
}
