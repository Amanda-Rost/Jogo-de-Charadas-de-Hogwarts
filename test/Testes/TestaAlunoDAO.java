package Testes;
import Caracteristicas.Casa;
import Personagens.Aluno;
import Personagens.AlunoDAO;

public class TestaAlunoDAO {

    public static void testaRetorno(boolean b, String operacao) {
        if (b) { // testa se b == true
            System.out.println("Operação realizada com sucesso !");
        } else {
            System.out.println("Falha na operação de " + operacao);
        }
    }

    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        Casa c1 = new Casa("Sonserina");
        Casa c2 = new Casa("Grifinoria");
        Casa c3 = new Casa("Lufa-Lufa");
        Casa c4 = new Casa("Corvinal");

        Aluno aluno1 = new Aluno("Amanda", "senha1", "dfefrijf@gmail.com", c1);
        Aluno aluno2 = new Aluno("Pietra", "senha2", "djfrijfieg@gmail.com", c2);
        Aluno aluno3 = new Aluno("Karen", "senha3", "KHTHJRIHRITHR@gmail.com", c3);
        Aluno aluno4 = new Aluno("Caio", "senha3", "KHTHJRIHRIgjy@gmail.com", c4);

        System.out.println("Testa inserir:");
        boolean b = alunoDAO.inserir(aluno1);
        testaRetorno(b, "inserir");
        b = alunoDAO.inserir(aluno2);
        testaRetorno(b, "inserir");
        b = alunoDAO.inserir(aluno2);
        testaRetorno(b, "inserir");
        b = alunoDAO.inserir(aluno3);
        testaRetorno(b, "inserir");
        b = alunoDAO.inserir(aluno4);
        testaRetorno(b, "inserir");

        System.out.println("\nTesta pesquisar:");

        System.out.println(alunoDAO.pesquisar(aluno2.getEmail()));
        System.out.println(alunoDAO.pesquisar(4));// false

        System.out.println("\nTesta editar:");

        Aluno aluno5 = new Aluno("Harry", "senha4", "feirugt@gmail.com", c2);
        b = alunoDAO.editar(aluno5);
        testaRetorno(b, "editar");
        aluno2.setNome("Hermione");
        b = alunoDAO.editar(aluno2);
        testaRetorno(b, "editar");

        System.out.println(alunoDAO.pesquisar(aluno2.getEmail()));

        System.out.println("\nTesta excluir:");
        b = alunoDAO.excluir(aluno3.getEmail());
        testaRetorno(b, "excluir");
        b = alunoDAO.excluir(aluno3.getEmail());
        testaRetorno(b, "excluir");
        
    }
}
