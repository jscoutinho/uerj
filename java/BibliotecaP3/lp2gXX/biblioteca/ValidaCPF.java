package lp2gXX.biblioteca;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ValidaCPF {

    public static boolean isCPF(String _CPF) {
        if (_CPF == null) {
            return false;
        }

        String regexCPFString = "^\\d{11}$|^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

        if (!Pattern.matches(regexCPFString, _CPF)) {
            return false;
        }

        String CPF = _CPF.replaceAll("[\\.\\-]", "");

        if (CPF.chars().distinct().count() == 1) {
            return false;
        }

        if (CPF.length() != 11) {
            return false;
        }

        try {
            int sm = 0, peso = 10;
            for (int i = 0; i < 9; i++) {
                int num = CPF.charAt(i) - '0';
                sm += num * peso--;
            }

            int r = 11 - (sm % 11);
            char dig10 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            sm = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                int num = CPF.charAt(i) - '0';
                sm += num * peso--;
            }

            r = 11 - (sm % 11);
            char dig11 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            return dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10);

        } catch (InputMismatchException e) {
            return false;
        }
    }

    public static String imprimeCPF(String CPF) {
        if (CPF == null || CPF.length() != 11)
            return CPF;
        return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
    }

    public static long toLong(String _CPF) {
        if (_CPF == null)
            throw new IllegalArgumentException("CPF nao pode ser nulo");
        String CPF = _CPF.replaceAll("[\\.\\-]", "");
        return Long.parseLong(CPF);
    }
}
