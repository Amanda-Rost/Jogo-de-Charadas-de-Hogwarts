package Caracteristicas;

import Personagens.Diretor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class SalaDAO implements DAO {

    private TreeSet<Sala> list;

    public SalaDAO() {
        this.list = new TreeSet<Sala>();
    }

    @Override
    public boolean inserir(Object obj) {
        Objects.requireNonNull(obj, "Dados não podem ser nulos");
        if (obj instanceof Sala) {
            Sala sala = (Sala) obj;
            boolean tem = this.list.contains(sala);
            if (tem) {
                return false;
            } else {
                return this.list.add(sala);
            }
        }
        return false;
    }

    @Override // exclui pelo codigo
    public boolean excluir(Object obj) {
        Objects.requireNonNull(obj, "Os dados não podem nulo");
        if (obj instanceof Integer) {
            Integer cod = (Integer) obj;
            Sala s = (Sala) pesquisar(cod);
            if (s != null) {
                boolean tem = list.remove(s);
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
        if (obj instanceof Sala) {
            Sala sala = (Sala) obj;
            Sala antiga = (Sala) pesquisar(sala.getCodigo());
            if (antiga != null) {
                boolean b = excluir(antiga.getCodigo());
                if (b) {
                    return inserir(sala);
                }
            }
        }
        return false;
    }

    @Override
    public Object pesquisar(Object o) {

        Objects.requireNonNull(o, "Deve ter um cogido");
        if (o instanceof Integer) {
            Integer cod = (Integer) o;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Sala s = (Sala) it.next();
                if (s.getCodigo().equals(cod)) {
                    return s;
                }
            }
        }
        return null;

    }
}
