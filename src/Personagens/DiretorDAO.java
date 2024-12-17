package Personagens;

import java.util.HashMap;
import java.util.Objects;
import Caracteristicas.DAO;

/**
 *
 * @author Amanda Rost e Pietra Machado
 */
public class DiretorDAO implements DAO {

    private HashMap<String, Diretor> list;

    public DiretorDAO() {
        this.list = new HashMap<String, Diretor>();
    }

    @Override
    public boolean inserir(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um diretor");
        if (obj instanceof Diretor) {
            Diretor di = (Diretor) obj;
            if (this.list.containsKey(di.getEmail())) {
                return false;
            } else {
                this.list.put(di.getEmail(), di);
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
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean editar(Object obj) {
        Objects.requireNonNull(obj, "Deve ter um diretor");
        if (obj instanceof Diretor) {
            Diretor di = (Diretor) obj;
            if (this.list.containsKey(di.getEmail())) {
                excluir(di.getEmail());
                return inserir(di);
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
                return "Esse diretor já está foi removido ou ainda não foi inserido!";
            }
        } else {
            return "Nao ha um aluno com esse email";
        }

    }

}
