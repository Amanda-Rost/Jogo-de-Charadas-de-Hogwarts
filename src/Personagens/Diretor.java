/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.ArrayList;
import java.util.Objects;

import Caracteristicas.Casa;
import Caracteristicas.Sala;

/**
 *
 * @author Amanda Rost e Pietra Machado
 */
public class Diretor {

    private String nome;
    private ArrayList listSala;
    private final String email;
    private final Casa casa;

    public Diretor(String nome, Casa casa, String email) {
        setNome(nome);
        Objects.requireNonNull(casa, "Deve ter uma casa");
        Objects.requireNonNull(email, "Deve ter um email");
        this.nome = nome;
        this.casa = casa;
        this.listSala = new ArrayList();
        this.email = email;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "Deve haver um nome");
        this.nome = nome;
    }

    public String getListSala() {
        String resp = "";
        int cont = 0;
        do {
            resp = resp + this.listSala.get(cont).toString() + "\n";
            cont++;
        } while (cont < this.listSala.size() - 1);
        return this.listSala.toString();
    }

    public void criaSala(Sala sala) {
        this.listSala.add(sala);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.email);
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
        final Diretor other = (Diretor) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (this.nome + "/" + this.email + this.casa)
                + "\n" + this.getListSala();
    }

}
