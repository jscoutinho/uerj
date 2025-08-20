package trabalhos.P2;
import java.util.*;

public class MinhaListaOrdenavel {

    private ArrayList<PessoaIMC> lista = new ArrayList<>();

    
    public static final int NOME_AZ = 1;
    public static final int NOME_ZA = 2;
    public static final int PESO_CRESCENTE = 3;
    public static final int PESO_DECRESCENTE = 4;
    public static final int IMC_CRESCENTE = 5;
    public static final int IMC_DECRESCENTE = 6;
    public static final int ALTURA_CRESCENTE = 7;
    public static final int ALTURA_DECRESCENTE = 8;
    public static final int IDADE_CRESCENTE = 9;
    public static final int IDADE_DECRESCENTE = 10;
    public static final int CPF_AZ = 11;
    public static final int CPF_ZA = 12;
    public static final int GENERO = 13;

    
    public void add(PessoaIMC p) {
        lista.add(p);
    }

    
    public PessoaIMC get(int index) {
        return lista.get(index);
    }

    
    public ArrayList<PessoaIMC> ordena(int criterio) {
        switch (criterio) {
            case NOME_AZ:
                Collections.sort(lista, nomeComparator);
                break;
            case NOME_ZA:
                Collections.sort(lista, Collections.reverseOrder(nomeComparator));
                break;
            case PESO_CRESCENTE:
                Collections.sort(lista, pesoComparator);
                break;
            case PESO_DECRESCENTE:
                Collections.sort(lista, Collections.reverseOrder(pesoComparator));
                break;
            case IMC_CRESCENTE:
                Collections.sort(lista, imcComparator);
                break;
            case IMC_DECRESCENTE:
                Collections.sort(lista, Collections.reverseOrder(imcComparator));
                break;
            case ALTURA_CRESCENTE:
                Collections.sort(lista, alturaComparator);
                break;
            case ALTURA_DECRESCENTE:
                Collections.sort(lista, Collections.reverseOrder(alturaComparator));
                break;
            case IDADE_CRESCENTE:
                Collections.sort(lista, idadeComparator);
                break;
            case IDADE_DECRESCENTE:
                Collections.sort(lista, Collections.reverseOrder(idadeComparator));
                break;
            case CPF_AZ:
                Collections.sort(lista, cpfComparator);
                break;
            case CPF_ZA:
                Collections.sort(lista, Collections.reverseOrder(cpfComparator));
                break;
            case GENERO:
                Collections.sort(lista, generoComparator);
                break;
            default:
                System.out.println("Critério inválido.");
        }
        return lista;
    }

    

    private Comparator<PessoaIMC> nomeComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return p1.getNome().compareToIgnoreCase(p2.getNome());
        }
    };

    private Comparator<PessoaIMC> pesoComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Float.compare(p1.getPeso(), p2.getPeso());
        }
    };

    private Comparator<PessoaIMC> alturaComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Float.compare(p1.getAltura(), p2.getAltura());
        }
    };

    private Comparator<PessoaIMC> imcComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Float.compare(p1.calculaIMC(), p2.calculaIMC());
        }
    };

    private Comparator<PessoaIMC> idadeComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Integer.compare(p1.getIdade(), p2.getIdade());
        }
    };

    private Comparator<PessoaIMC> cpfComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return p1.getCpf().compareTo(p2.getCpf());
        }
    };

    private Comparator<PessoaIMC> generoComparator = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            if (p1 instanceof Mulher && p2 instanceof Homem) return -1;
            if (p1 instanceof Homem && p2 instanceof Mulher) return 1;
            return 0;
        }
    };
}
