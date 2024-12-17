package Testes;
import Caracteristicas.Charada;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PEDRO
 */
public class TestaCharada {
    public static void testaRetorno(boolean b, String operacao) {
        if (b) { // testa se b == true
            System.out.println("Certoou!");
        } else {
            System.out.println("Voce falhau na operacao " + operacao);
        }
    }
    public static void main(String args[]){
         Charada c = new Charada();
        c.insereCharadas("O que veio primeiro? A fenix ou a chama", "Um circulo nao tem principio, um circulo nao tem comeco?");
        c.insereCharadas("Qual seria um nome melhor do que rei da selva para um leao?", "Emperoar");
        c.insereCharadas("Do que voce pode encher o barril para ele ficar mais leve?", "Buracos");
        c.insereCharadas("Por que o aluno relapso nao conhece as leis?", "Porque nao estuda direito");
       
        int cont = 0;
        
        do {
            System.out.println(c.falaCharada());
            cont++;
        } while (cont < 4);

       
        boolean b = c.charadasConfere("Gas helio"); // resp errada
        testaRetorno(b, "confere se acertou"); 
        
        b = c.charadasConfere("Buracos"); // resp certo
        testaRetorno(b, "confere se acertou"); 
        
        c.removeCharadas("Qual seria um nome melhor do que rei da selva para um leao?");
        c.reiniciafalaCharada();
        int cont2 = 0;
        
        do {
            System.out.println(c.falaCharada());
            cont2++;
        } while (cont2 < 3);
        
        c.editaResp("O que veio primeiro? A fenix ou a chama", "chama");
        
         b = c.charadasConfere("chama");
        testaRetorno(b, "confere se acertou"); 
        
        System.out.println(c.toString());
        
        do {
            System.out.println(c.falaResp());
            cont2 --;
        } while (cont2 > 0);
        
        c.reiniciafalaResp();
        int cont3 = 0;
        do {
            System.out.println(c.falaResp());
            cont3++;
        } while (cont3 < 3);
        
        c.insereRespErrada("Fenix");
        c.insereRespErrada("Imperador");
        c.insereRespErrada("ar");
        c.insereRespErrada("burro");
        c.insereRespErrada("gas");
        c.insereRespErrada("incapaz");
       // c.insereRespErrada("ciclo");
        System.out.println(c.imprimeRespErrada());
        System.out.println(c.imprimeRespErrada());
        c.removeRespErradas("burro");
    }
    
}
