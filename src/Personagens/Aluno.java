/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.Objects;

import Caracteristicas.Casa;

/**
 *
 * @author Amanda Rost e Pietra Machado
 */
public class Aluno {

    private String nome;
    private final String email;
    private String senha;
    private final Casa casa;

    public Aluno(String nome, String senha, String email, Casa casa) {
        setNome(nome);
        setSenha(senha);
        Objects.requireNonNull(casa, "Deve ter uma casa!");
        Objects.requireNonNull(email, "Deve ter um email!");
        this.nome = nome;
        this.casa = casa;
        this.senha = senha;
        this.email = email;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        Objects.requireNonNull(senha, "Deve haver uma senha");
        this.senha = senha;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.email);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome + "/" + this.email + this.casa;
    }

}
