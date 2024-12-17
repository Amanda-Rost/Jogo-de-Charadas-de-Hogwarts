/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caracteristicas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @authoras: Amanda e Pietra
 */
public class Charada {
// os Iterator foram declarados fora dos metados pq é necessario manter a posicao do Iterador entre as chamadas de metados
    private HashMap<String, String> respsEpergs;
    private ArrayList<String> respErradas;
    private Iterator numPerg;
    private Iterator contResp;

    public Charada() {
        this.respsEpergs = new HashMap<String, String>();
        this.respErradas = new ArrayList<String>();
        this.numPerg = null;
        this.contResp = null;
    }

    public void reiniciafalaCharada() {
        Collection list = this.respsEpergs.keySet();
        this.numPerg = list.iterator();

    }

    public String getrespsEpergs(){
          Collection list = this.respsEpergs.keySet();
            Iterator it = list.iterator();
            String resp ="";
           do{
               resp = resp + it.next() +"\n";
           }while(it.hasNext());
            return resp; 
    }
    public void reiniciafalaResp() {
        Collection list = this.respsEpergs.values();
        this.contResp = list.iterator();

    }

    public void insereRespErrada(String resp) {
        int v1 = this.respErradas.size(), v2 = this.respsEpergs.size() * 2;

        boolean verd = (this.respErradas.size()) > (this.respsEpergs.size() * 2);
        if (verd == true) {
            throw new IllegalArgumentException("Ja tem respostas erradas o suficiente");
        } else {
            Objects.requireNonNull(resp, "Deve ter uma resposta errada");
            this.respErradas.add(resp);
        }
    }

    public void removeRespErradas(String resp) {
        Objects.requireNonNull(resp, "Deve ter uma resposta errada que deseja remover");
        if (this.respErradas.contains(resp)) {
            this.respErradas.remove(resp);
        } else {
            throw new IllegalArgumentException("Essa resposta errada ja foi removida ou ainda nao foi inserida");
        }
    }

    public String imprimeRespErrada() {
        int pos = (int) (Math.random() * this.respErradas.size());
        return this.respErradas.get(pos);
    }

    public String falaCharada() {

        if (this.numPerg == null) {
            Collection list = this.respsEpergs.keySet();
            this.numPerg = list.iterator();
            return numPerg.next() + "\n";
        } else {
            return numPerg.next() + "\n";
        }
    }

    public String falaResp() {
        if (this.contResp == null) {
            Collection list2 = this.respsEpergs.values();
            this.contResp = list2.iterator();
            return contResp.next() + "\n";
        } else {
            return contResp.next() + "\n";
        }

    }

    public Iterator getCont() {
        return this.contResp;
    }

    public Iterator getNumPerg() {
        return this.numPerg;
    }

    public void insereCharadas(String perg, String resp) {
        Objects.requireNonNull(perg, "Tem que ter uma pergunta");
        Objects.requireNonNull(resp, "Tem que ter uma resposta");
        if (this.respsEpergs.containsKey(perg)) {
            throw new IllegalArgumentException("Essa charada já foi inserida");
        } else {
            this.respsEpergs.put(perg, resp);
        }
    }

    public void removeCharadas(String perg) {
        Objects.requireNonNull(perg, "Tem que ter uma pergunta");
        if (this.respsEpergs.containsKey(perg)) {
            this.respsEpergs.remove(perg);
        } else {
            throw new IllegalArgumentException("Essa charada já foi removida ou ainda nao foi inserida");
        }

    }

    public void editaResp(String perg, String resp) {
        Objects.requireNonNull(perg, "Tem que ter uma pergunta");
        Objects.requireNonNull(resp, "Tem que ter uma resposta");

        if (this.respsEpergs.containsKey(perg)) {
            this.respsEpergs.put(perg, resp);
        } else {
            throw new IllegalArgumentException("Essa charada já foi removida ou ainda nao foi inserida");
        }
    }

    public boolean charadasConfere(String resp) {
        Objects.requireNonNull(resp, "Tem que ter uma resposta");
        if (this.respsEpergs.containsValue(resp)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.respsEpergs);
        hash = 53 * hash + Objects.hashCode(this.numPerg);
        hash = 53 * hash + Objects.hashCode(this.contResp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Charada other = (Charada) obj;
        return Objects.equals(this.respsEpergs, other.respsEpergs);
    }

    @Override
    public String toString() {
        String charadas = "";
        for (Map.Entry<String, String> linha : this.respsEpergs.entrySet()) {
            String perg = linha.getKey();
            String resp = linha.getValue();
            charadas = charadas + "Pergunta :" + perg + "\nRespostas: " + resp + "\n";
        }
        return "Charadas:\n" + charadas;
    }

}
