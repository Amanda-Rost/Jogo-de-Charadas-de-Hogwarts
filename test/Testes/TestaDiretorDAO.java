package Testes;
import Caracteristicas.Casa;
import Personagens.Aluno;
import Personagens.Diretor;
import Personagens.DiretorDAO;


public class TestaDiretorDAO {
    public static void testaRetorno(boolean b, String operacao) {
        if (b) { // testa se b == true
            System.out.println("Operação realizada com sucesso !");
        } else {
            System.out.println("Falha na operação de " + operacao);
        }
    }
    public static void main (String [] args) {
		Casa c1 = new Casa("Sonserina");
		Casa c2 = new Casa("Grifinoria");
		Casa c3 = new Casa("Lufa-Lufa");
		Casa c4 = new Casa("Corvinal");
		
		Diretor d1 = new Diretor("Josias",c1,"josias@gmail.com");
		Diretor d2 = new Diretor("Debora", c3,"debora@gmail.com");
		Diretor d3 = new Diretor("Karen", c2,"karen@gmail.com");
		Diretor d4 = new Diretor("Marlon",c4,"marlon@gmail.com");
                
                DiretorDAO d = new DiretorDAO();
                
                System.out.println("Testa inserir:");
        boolean b = d.inserir(d1);
        testaRetorno(b, "inserir");
        b = d.inserir(d2);
        testaRetorno(b, "inserir");
        b = d.inserir(d2);
        testaRetorno(b, "inserir");
        b = d.inserir(d3);
        testaRetorno(b, "inserir");
        b = d.inserir(d4);
        testaRetorno(b, "inserir");

        System.out.println("\nTesta pesquisar:");

        String s = d2.getEmail();
        Diretor dr = (Diretor) d.pesquisar(s);
        System.out.println(dr);
        System.out.println(d.pesquisar(4));// false

        System.out.println("\nTesta editar:");

        Diretor d5 = new Diretor("Aline", c3, "aline@gmail.com");
        b = d.editar(d5);
        testaRetorno(b, "editar");
        d2.setNome("Minerva");
        b = d.editar(d2);
        testaRetorno(b, "editar");

        System.out.println(d.pesquisar(d2.getEmail()));

        System.out.println("\nTesta excluir:");
        b =d.excluir(d3.getEmail());
        testaRetorno(b, "excluir");
        b = d.excluir(d3.getEmail());
        testaRetorno(b, "excluir");
                
                
		
	}
}
