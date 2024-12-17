package Testes;
import Caracteristicas.Casa;
import Caracteristicas.CasaDAO;

public class TestaCasaDAO {

    public static void testaRetorno(boolean b, String operacao) {
        if (b) { // testa se b == true
            System.out.println("Operacao realizada com sucesso !");
        } else {
            System.out.println("Falha na operacao de " + operacao);
        }
    }

    public static void main(String[] args) {
        Casa c1 = new Casa("Sonserina");
        Casa c2 = new Casa("Grifinoria");
        Casa c3 = new Casa("Lufa-Lufa");
        Casa c4 = new Casa("Corvinal");

        c1.addPontos(150);
        System.out.println(c1.toString());
        c1.addPontos(50);
        System.out.println(c1.toString());
        c3.addPontos(50);
        System.out.println(c3.toString());

        c4.addPontos(300);
        System.out.println(c4.toString());
        c4.addPontos(-50);
        System.out.println(c4.toString());
        System.out.println(c2.toString());

        CasaDAO dados = new CasaDAO();
        boolean b = dados.inserir(c1);
        testaRetorno(b, "inserir");
        b = dados.inserir(c1);
        testaRetorno(b, "inserir");
        b = dados.inserir(c2);
        testaRetorno(b, "inserir");
        b = dados.inserir(c3);
        testaRetorno(b, "inserir");
        b = dados.inserir(c4);
        testaRetorno(b, "inserir");
        //----------------------------------------
        Casa p = (Casa) dados.pesquisar("Lufa-Lufa");
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Não achou !");
        }
        //----------------------------------------
        b = dados.excluir("Sonserina");
        testaRetorno(b, "excluir");
        b = dados.excluir("Sonserina");
        testaRetorno(b, "excluir");
        //------------------------------
        c2.setPontTotal(50);
        b = dados.editar(c2);
        testaRetorno(b, "editar");
        System.out.println(c2.toString());
        c2.addPontos(150);
        b = dados.editar(c2);
        testaRetorno(b, "editar");

        p = (Casa) dados.pesquisar(c2.getNome());
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }

        p = (Casa) dados.pesquisar(c1.getNome());
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }

    }
}
