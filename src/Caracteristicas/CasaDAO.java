/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracteristicas;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 *
 * @author Amanda Rost e Pietra Machado
 */
public class CasaDAO implements DAO {

    private TreeSet<Casa> list;

    public CasaDAO() {
        this.list = new TreeSet<Casa>();
    }

    @Override
    public boolean inserir(Object obj) {
        Objects.requireNonNull(obj, "Dados não podem ser nulos");
        if (obj instanceof Casa) {
            Casa c = (Casa) obj;
            boolean tem = this.list.contains(c);
            if (tem == true) {
                return false;
            } else {
                return this.list.add(c);
            }
        }
        return false;
    }
// pelo nome

    @Override
    public boolean excluir(Object obj) {
        Objects.requireNonNull(obj, "Os dados não podem nulo");
        if (obj instanceof String) {
            String nome = (String) obj;
            Casa c = (Casa) pesquisar(nome);
            if (c != null) {
                boolean tem = list.remove(c);
                if (tem == true) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean editar(Object obj) {
        Objects.requireNonNull(obj, "Dados não podem ser nulos");
        if (obj instanceof Casa) {
            Casa c = (Casa) obj;
            Casa antiga = (Casa) pesquisar(c.getNome());
            boolean b = excluir(antiga.getNome());
            if (b) {
                return inserir(c);
            }
        }
        return false;
    }

    @Override // pesquisar por nome
    public Object pesquisar(Object obj) {
        Objects.requireNonNull(obj, "O nome não poder nulo");
        if (obj instanceof String) {
            String nome = (String) obj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Casa c = (Casa) it.next();
                if (c.getNome().equalsIgnoreCase(nome)) {
                    return c;
                }
            }
        }
        return null;
    }

}
