package Testes;
import Caracteristicas.Casa;
import Caracteristicas.Sala;
import Caracteristicas.SalaDAO;
import Personagens.Aluno;
import Personagens.Diretor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amanda Rost
 */
public class TestaSalaDAO {

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

        Diretor d1 = new Diretor("Karen", c2, "karen@gmail.com");
        Diretor d2 = new Diretor("Marcio", c1, "marcio@gmail.com");
        Diretor d3 = new Diretor("Karen", c3, "janaina@gmail.com");

        Aluno aluno1 = new Aluno("Amanda", "senha1", "dfefrijf@gmail.com", c4);
        Aluno aluno2 = new Aluno("Pietra", "senha2", "djfrijfieg@gmail.com", c1);
        Aluno aluno3 = new Aluno("Karen", "senha3", "KHTHJRIHRITHR@gmail.com", c2);
        Aluno aluno4 = new Aluno("Caio", "senha3", "KHTHJRIHRIgjy@gmail.com", c3);
        Aluno aluno5 = new Aluno("Anna", "senha3", "KHTHJRIHRI@gmail.com", c1);

        Sala s1 = new Sala(d1, d2, 1234);
        Sala s2 = new Sala(d3, d2, 1235);
        Sala s3 = new Sala(d1, d3, 1236);
        Sala s4 = new Sala(d1, d2, 1234);

        s1.addAluno(aluno1);
        s1.addAluno(aluno2);
        s1.addAluno(aluno3);
        s1.addAluno(aluno4);

        c1.setPontTotal(100);
        c2.setPontTotal(200);
        c3.setPontTotal(250);
        c4.setPontTotal(100);
        try {
            //System.out.println("\n ======= Erro 1 ========== ");
            //s1.placar(); //Exception
            //System.out.println("\n ======= Erro 2 ========== ");
            //s1.toString(); //Exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        s1.OrdenaPlacar(c1, c2, c3, c4);
        System.out.println(s1.toString());
        SalaDAO dados = new SalaDAO();

        boolean b = dados.inserir(s1);
        testaRetorno(b, "inserir");
        b = dados.inserir(s4);
        testaRetorno(b, "inserir");
        b = dados.inserir(s2);
        testaRetorno(b, "inserir");
        b = dados.inserir(s3);
        testaRetorno(b, "inserir");
        b = dados.inserir(s1);
        testaRetorno(b, "inserir");
        //----------------------------------------
        Sala p = (Sala) dados.pesquisar(1234);
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }
        //----------------------------------------
        b = dados.excluir(1234);
        testaRetorno(b, "excluir");
        b = dados.excluir(1234);
        testaRetorno(b, "excluir");
        //------------------------------
        s2.addAluno(aluno1);
        s2.addAluno(aluno2);
        s2.addAluno(aluno3);
        s2.addAluno(aluno4);
        s2.addAluno(aluno5);
        s2.OrdenaPlacar(c1, c2, c3, c4);

        b = dados.editar(s2);
        testaRetorno(b, "editar");

        p = (Sala) dados.pesquisar(s2.getCodigo());
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }

        s2.removeAluno(aluno5);

        b = dados.editar(s2);
        testaRetorno(b, "editar");

        p = (Sala) dados.pesquisar(s2.getCodigo());
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }

        p = (Sala) dados.pesquisar(s1.getCodigo());
        if (p != null) {
            System.out.println("Achou " + p);
        } else {
            System.out.println("Nao achou !");
        }
    }
}
