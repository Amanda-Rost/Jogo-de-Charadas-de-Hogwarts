package Personagens;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import Caracteristicas.DAO;

/**
 *
 * @author Amanda Rost e Pietra Machado
 */
public class AlunoDAO implements DAO {

    private HashMap<String, Aluno> list;

    public AlunoDAO() {
        this.list = new HashMap<String, Aluno>();
    }

    @Override
    public boolean inserir(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um aluno");
        if (obj instanceof Aluno) {
            Aluno al = (Aluno) obj;
            if (this.list.containsKey(al.getEmail())) {
                return false;
            } else {
                this.list.put(al.getEmail(), al);
                return true;
            }
        }
        return false;
    }

    @Override // pelo email
    public boolean excluir(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um email");
        if (obj instanceof String) {
            String email = (String) obj;
            if (this.list.containsKey(email)) {
                this.list.remove(email);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean editar(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um aluno");
        if (obj instanceof Aluno) {
            Aluno al = (Aluno) obj;
            if (this.list.containsKey(al.getEmail())) {
                excluir(al.getEmail());
                return inserir(al);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // pelo email
    public Object pesquisar(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um email");
        if (obj instanceof String) {
            String email = (String) obj;
            if (this.list.containsKey(email)) {
                return this.list.get(email);
            } else {
                return "Esse aluno já está foi removido ou ainda não foi inserido!";
            }
        } else {
            return "Nao ha um aluno com esse email";
        }

    }

}
