package lp2gXX.biblioteca;

import java.io.*;
import java.util.*;

public class Biblioteca {
    private Hashtable<Long, Usuario> usuarios;
    private Hashtable<Integer, Livro> livros;
    private int diasPermitidos = 7;
    private double multaPorDia = 2.0;

    public Biblioteca() {
        usuarios = new Hashtable<>();
        livros = new Hashtable<>();
    }

    public Biblioteca(String arqUsu, String arqLiv) throws Exception {
        leArqUsu(arqUsu);
        leArqLiv(arqLiv);
    }

    public void setPolitica(int dias, double multa) {
        this.diasPermitidos = dias;
        this.multaPorDia = multa;
    }

    public void cadastraUsuario(Usuario u) throws Exception {
        if (usuarios.containsKey(u.getCpf()))
            throw new Exception("Usuário já cadastrado.");
        usuarios.put(u.getCpf(), u);
    }

    public void cadastraLivro(Livro l) throws Exception {
        if (livros.containsKey(l.getCod()))
            throw new Exception("Livro já cadastrado.");
        livros.put(l.getCod(), l);
    }

    public void salvaArquivo(Hashtable<?, ?> tabela, String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(tabela);
        }
    }

    public void leArqUsu(String nomeArquivo) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            usuarios = (Hashtable<Long, Usuario>) in.readObject();
        }
    }

    public void leArqLiv(String nomeArquivo) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            livros = (Hashtable<Integer, Livro>) in.readObject();
        }
    }

    public void emprestaLivro(Usuario u, Livro l) throws Exception {
        if (temAtraso(u)) {
            throw new Exception("Usuário com devolução em atraso. Não é possível emprestar outro livro.");
        }
        l.empresta();
        GregorianCalendar hoje = new GregorianCalendar();
        u.addLivroHist(hoje, l.getCod());
        l.addUsuarioHist(hoje, null, u.getCpf());
    }

    public void devolveLivro(Usuario u, Livro l) throws Exception {
        l.devolve();
        GregorianCalendar hoje = new GregorianCalendar();
        u.devolverLivro(l.getCod(), hoje);
        l.registrarDevolucao(u.getCpf(), hoje);

        GregorianCalendar dataEmp = getDataEmprestimoUsuario(u, l.getCod());
        long dias = (hoje.getTimeInMillis() - dataEmp.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        if (dias > diasPermitidos) {
            double multa = (dias - diasPermitidos) * multaPorDia;
            System.out.printf("ATENÇÃO: Livro devolvido com atraso de %d dias. Multa: R$ %.2f\n",
                    (dias - diasPermitidos), multa);
        }
    }

    private GregorianCalendar getDataEmprestimoUsuario(Usuario u, int codLivro) {
        for (Emprest e : u.getHist()) {
            if (e.getCodLivro() == codLivro && e.getDataDev() != null) {
                return e.getDataEmp();
            }
        }
        return null;
    }

    public boolean temAtraso(Usuario u) {
        GregorianCalendar hoje = new GregorianCalendar();
        for (Emprest e : u.getHist()) {
            if (e.getDataDev() == null) {
                long dias = (hoje.getTimeInMillis() - e.getDataEmp().getTimeInMillis()) / (1000 * 60 * 60 * 24);
                if (dias > diasPermitidos)
                    return true;
            }
        }
        return false;
    }

    public String imprimeLivros() {
        TreeMap<Integer, Livro> ordenados = new TreeMap<>(livros);
        StringBuilder sb = new StringBuilder();
        for (Livro l : ordenados.values()) {
            sb.append(l).append("\n\n");
        }
        return sb.toString();
    }

    public String imprimeUsuarios() {
        TreeMap<Long, Usuario> ordenados = new TreeMap<>(usuarios);
        StringBuilder sb = new StringBuilder();
        for (Usuario u : ordenados.values()) {
            sb.append(u).append("\n\n");
        }
        return sb.toString();
    }

    public Livro getLivro(int cod) throws LivroNaoCadastradoEx {
        Livro l = livros.get(cod);
        if (l == null)
            throw new LivroNaoCadastradoEx();
        return l;
    }

    public Usuario getUsuario(long cpf) throws UsuarioNaoCadastradoEx {
        Usuario u = usuarios.get(cpf);
        if (u == null)
            throw new UsuarioNaoCadastradoEx();
        return u;
    }

    public Hashtable<Long, Usuario> getUsuarios() {
        return usuarios;
    }

    public Hashtable<Integer, Livro> getLivros() {
        return livros;
    }
}