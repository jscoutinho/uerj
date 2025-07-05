

import java.time.LocalDate;

public class ValidaData {
    public boolean isDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAno(int ano) {
        LocalDate hoje = LocalDate.now();
        if (ano > -120 && ano <= hoje.getYear()) {
            return true;
        } else {
            return false;
        }
    }

    public enum Mes {
        JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), JUNHO(6),
        JULHO(7), AGOSTO(8), SETEMBRO(9), OUTUBRO(10), NOVEMBRO(11), DEZEMBRO(12);

        private final int numero;

        Mes(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }
    }

    public static boolean isMes(String mes) {

        try {
            int numero = Integer.parseInt(mes);
            return numero >= 1 && numero <= 12;
        } catch (NumberFormatException e) {
        }

        mes = mes.toUpperCase();
        for (Mes m : Mes.values()) {
            if (m.name().equalsIgnoreCase(mes)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMes(int Mes) {
        if (Mes >= 1 && Mes <= 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDataValida(int dia, int mes, int ano) {
        if (isAno(ano) && isMes(mes)) {

            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                return dia >= 1 && dia <= 31;
            } else if (mes == 2) {
                return dia >= 1 && dia <= 28;
            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                return dia >= 1 && dia <= 30;
            }
        }
        return false;

    }

    public static boolean isDataValida(String sDia, String nMes, String sAno) {

        int mes = 0;
        int dia = Integer.parseInt(sDia);
        int ano = Integer.parseInt(sAno);

        try {
            int numero = Integer.parseInt(nMes);
            if (numero >= 1 && numero <= 12) {
                mes = numero;
            }
        } catch (NumberFormatException e) {
        }

        nMes = nMes.toUpperCase();
        for (Mes m : Mes.values()) {
            if (m.name().equalsIgnoreCase(nMes)) {
                mes = m.getNumero();
            }
        }

        if (isAno(ano) && isMes(mes)) {

            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                return dia >= 1 && dia <= 31;
            } else if (mes == 2) {
                return dia >= 1 && dia <= 28;
            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                return dia >= 1 && dia <= 30;
            }

        }
        return false;

    }

    public int mesParaNumero(String nomeMes) throws IllegalArgumentException {
    if (nomeMes == null) {
        throw new IllegalArgumentException("O mês não pode ser nulo.");
    }

    nomeMes = nomeMes.trim().toUpperCase();

    nomeMes = nomeMes
        .replace("Ç", "C")
        .replace("Á", "A").replace("À", "A").replace("Â", "A").replace("Ã", "A")
        .replace("É", "E").replace("È", "E").replace("Ê", "E")
        .replace("Í", "I")
        .replace("Ó", "O").replace("Ô", "O").replace("Õ", "O")
        .replace("Ú", "U");

    try {
        return Mes.valueOf(nomeMes).getNumero();
    } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Nome de mês inválido: " + nomeMes);
    }
}


}
