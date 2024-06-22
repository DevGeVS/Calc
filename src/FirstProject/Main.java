package FirstProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));


    }
    public static String calc(String input) throws Exception {
        String oper;
        int number1;
        int number2;
        String resultat;
        boolean isRim;
        String[] operands = input.split("[+\\-*/]");
        oper = operaciy(input);
        if (oper == null || operands.length != 2) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        if (Rimskie.isRoman(operands[0]) && Rimskie.isRoman(operands[1])) {
            number1 = Rimskie.convertToArabian(operands[0]);
            number2 = Rimskie.convertToArabian(operands[1]);
            isRim = true;
        }
        else if (!Rimskie.isRoman(operands[0]) && !Rimskie.isRoman(operands[1])) {
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRim = false;
        }
        else if (Rimskie.tezRim(operands) == true && Rimskie.tezNum(operands)==true){
            throw new Exception("вы используюте одновременно разные системы счисления");
        }
        else {
            throw new Exception("не коректно введены цифры в римской системе счислений");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("числа от 1 до 10 включительно");
        }
        int arabian = run(number1, number2, oper);
        if (isRim) {
            if (arabian <= 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            resultat = Rimskie.convertToRoman(arabian);
        } else {
            resultat = String.valueOf(arabian);
        }
        return resultat;
    }

    static int run(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }
    static String operaciy(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }
    class Rimskie {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            } return -1;
        }
        public static boolean isRoman(String a) {
            for (int i = 0; i < romanArray.length; i++) {
                if (a.equals(romanArray[i])) {
                    return true;
                }
            } return false;
        }
        public static String convertToRoman(int arabian) {
            return romanArray[arabian];
        }
        public static boolean tezRim(String[]s){

            for (int i = 0; i <s.length ; i++) {
                if(Character.isLetter(s[i].charAt(0))){

                    return true;
                }
            }
            return false;
        }
        public static boolean tezNum(String[]s){

            for (int i = 0; i <s.length ; i++) {
                if(Character.isDigit(s[i].charAt(0))){

                    return true;
                }
            }
            return false;
        }
    }

}
