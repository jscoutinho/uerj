import java.util.*;

class ValidaCPF {
    public static boolean isCPF(String cpf) {
        if (cpf == null) return false;

        // Remove todos os caracteres não numéricos
        String num = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos
        if (num.length() != 11) return false;

        // Verifica se todos os dígitos são iguais
        if (num.matches("(\\d)\\1{10}")) return false;

        // Calcula os dígitos verificadores
        try {
            int d1 = 0, d2 = 0;
            for (int i = 1; i <= 9; i++) {
                int dig = Integer.parseInt(num.substring(i - 1, i));
                d1 += dig * (11 - i);
                d2 += dig * (12 - i);
            }
            int resto1 = d1 % 11;
            resto1 = resto1 < 2 ? 0 : 11 - resto1;
            d2 += resto1 * 2;
            int resto2 = d2 % 11;
            resto2 = resto2 < 2 ? 0 : 11 - resto2;

            return resto1 == Integer.parseInt(num.substring(9, 10)) &&
                   resto2 == Integer.parseInt(num.substring(10));
        } catch (Exception e) {
            return false;
        }
    }

    public static long toLong(String cpf) {
        String num = cpf.replaceAll("[^0-9]", "");
        return Long.parseLong(num);
    }
}

class ValidaData {
    public static boolean isDia(String diaStr) {
        try {
            int dia = Integer.parseInt(diaStr);
            return dia >= 1 && dia <= 31;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isMes(String mesStr) {
        try {
            int mes = converteMes(mesStr);
            return mes >= 1 && mes <= 12;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isAno(String anoStr) {
        try {
            int ano = Integer.parseInt(anoStr);
            int atual = Calendar.getInstance().get(Calendar.YEAR);
            return ano >= (atual - 120) && ano <= atual;
        } catch (Exception e) {
            return false;
        }
    }

    public static int converteMes(String mesStr) {
        mesStr = mesStr.trim().toLowerCase();
        switch (mesStr) {
            case "1": case "01": case "janeiro": return 1;
            case "2": case "02": case "fevereiro": return 2;
            case "3": case "03": case "marco": return 3;
            case "4": case "04": case "abril": return 4;
            case "5": case "05": case "maio": return 5;
            case "6": case "06": case "junho": return 6;
            case "7": case "07": case "julho": return 7;
            case "8": case "08": case "agosto": return 8;
            case "9": case "09": case "setembro": return 9;
            case "10": case "outubro": return 10;
            case "11": case "novembro": return 11;
            case "12": case "dezembro": return 12;
            default: throw new IllegalArgumentException("Mês inválido: " + mesStr);
        }
    }

    public static boolean isDataValida(int dia, int mes, int ano) {
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setLenient(false);
            gc.set(ano, mes - 1, dia);
            gc.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDataValida(String diaStr, String mesStr, String anoStr) {
        try {
            int dia = Integer.parseInt(diaStr);
            int mes = converteMes(mesStr);
            int ano = Integer.parseInt(anoStr);
            return isDataValida(dia, mes, ano);
        } catch (Exception e) {
            return false;
        }
    }
}

