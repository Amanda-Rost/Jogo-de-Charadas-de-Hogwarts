package Caracteristicas;

import Personagens.Aluno;
import Personagens.Diretor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Sala implements Comparable {

    private final Integer cod;
    private final Diretor d1;
    private final Diretor d2;
    private HashMap<String, Aluno> listAlunos;
    private HashMap<String, Aluno> equipeGrif;
    private HashMap<String, Aluno> equipeSons;
    private HashMap<String, Aluno> equipeLufa;
    private HashMap<String, Aluno> equipeCorv;
    private ArrayList<Casa> casas = new ArrayList<Casa>();

    public Sala(Diretor d1, Diretor d2, Integer cod) {
        Objects.requireNonNull(d1, "Deve ter dois diretores");
        Objects.requireNonNull(d2, "Deve ter dois diretores");
        this.cod = cod;
        this.d1 = d1;
        this.d2 = d2;
        this.listAlunos = new HashMap<String, Aluno>();
        this.equipeGrif = new HashMap<String, Aluno>();
        this.equipeSons = new HashMap<String, Aluno>();
        this.equipeLufa = new HashMap<String, Aluno>();
        this.equipeCorv = new HashMap<String, Aluno>();
        this.casas = new ArrayList<Casa>();
    }

    public Integer getCodigo() {
        return this.cod;
    }

    public Diretor getDiretor1() {
        return this.d1;
    }

    public Diretor getDiretor2() {
        return this.d2;
    }

    public String getEquipeGrif() {
        String resp = "";

        Collection list = this.equipeGrif.values();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            resp = resp + it.next() + "\n";
        }
        return resp;
    }

    public String getEquipeSons() {
        String resp = "";

        Collection list = this.equipeSons.values();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            resp = resp + it.next() + "\n";
        }
        return resp;
    }

    public String getEquipeLufa() {
        String resp = "";

        Collection list = this.equipeLufa.values();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            resp = resp + it.next() + "\n";
        }
        return resp;
    }

    public String getEquipeCorv() {
        String resp = "";

        Collection list = this.equipeCorv.values();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            resp = resp + it.next() + "\n";
        }
        return resp;
    }

    public boolean addAluno(Aluno a) {
        Objects.requireNonNull(a, "Não pode ser nulo");
        if (this.listAlunos.containsKey(a.getEmail())) {
            return false;
        } else {
            this.listAlunos.put(a.getEmail(), a);
            if (a.getCasa().getNome().equalsIgnoreCase("grifinoria")) {
                if (this.equipeGrif.containsKey(a.getEmail())) {
                    return false;
                } else {
                    this.equipeGrif.put(a.getEmail(), a);
                    return true;
                }
            } else if (a.getCasa().getNome().equalsIgnoreCase("sonserina")) {
                if (this.equipeSons.containsKey(a.getEmail())) {
                    return false;
                } else {
                    this.equipeSons.put(a.getEmail(), a);
                    return true;
                }
            } else if (a.getCasa().getNome().equalsIgnoreCase("lufa-lufa")) {
                if (this.equipeLufa.containsKey(a.getEmail())) {
                    return false;
                } else {
                    this.equipeLufa.put(a.getEmail(), a);
                    return true;
                }
            } else {
                if (this.equipeCorv.containsKey(a.getEmail())) {
                    return false;
                } else {
                    this.equipeCorv.put(a.getEmail(), a);
                    return true;
                }
            }
        }
    }

    public boolean removeAluno(Aluno a) {
        Objects.requireNonNull(a, "Não pode ser nulo");
        if (this.listAlunos.containsKey(a.getEmail())) {
            this.listAlunos.remove(a.getEmail(), a);
            if (a.getCasa().getNome().equalsIgnoreCase("grifinoria")) {
                if (this.equipeGrif.containsKey(a.getEmail())) {
                    this.equipeGrif.remove(a.getEmail(), a);
                    return true;

                } else {
                    return false;
                }
            } else if (a.getCasa().getNome().equalsIgnoreCase("sonserina")) {
                if (this.equipeSons.containsKey(a.getEmail())) {

                    this.equipeSons.remove(a.getEmail(), a);
                    return true;
                } else {
                    return false;
                }
            } else if (a.getCasa().getNome().equalsIgnoreCase("lufa-lufa")) {
                if (this.equipeLufa.containsKey(a.getEmail())) {
                    this.equipeLufa.remove(a.getEmail(), a);
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.equipeCorv.containsKey(a.getEmail())) {
                    this.equipeCorv.put(a.getEmail(), a);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

//Eh obrigatorio ordenar o placar antes de imprimir o placar
    public void OrdenaPlacar(Casa c1, Casa c2, Casa c3, Casa c4) {
        Objects.requireNonNull(c1, "A casa nao pode ser nulo");
        Objects.requireNonNull(c2, "A casa nao pode ser nulo");
        Objects.requireNonNull(c3, "A casa nao pode ser nulo");
        Objects.requireNonNull(c4, "A casa nao pode ser nulo");

        this.casas.add(c1);
        this.casas.add(c2);
        this.casas.add(c3);
        this.casas.add(c4);

        this.casas.sort(new OrdenaPorPontos());

    }

    public String placar() {
        int ind = 0;
        do {
            if (this.casas.size() == 0) {
                throw new IllegalArgumentException("Deve ordenar o placar antes de tentar imprimi-lo");
            }
            ind++;
        } while (ind < 4);
        int cont = 0;
        String resp = "";
        do {
            resp = resp + (cont + 1) + " - Lugar:" + this.casas.get(cont) + "\n";
            cont++;
        } while (cont <= 3);

        return resp;
    }

    @Override
    public String toString() {
        if (this.listAlunos.isEmpty()) {
            return "Sala/" + this.getCodigo()+ "\n" + "1 - Diretor: " + this.getDiretor1().getNome() + "\n2 - Diretor: "
                    + this.getDiretor2().getNome() + "\nNao ha nenhum aluno inserido, por tanto ainda nao ha um placar.";
        } else if (this.listAlunos.size() >= 4 && this.casas.size() == 0) {
            throw new IllegalArgumentException("Deve ordenar o placar primeiro");
        } else {
            return "Sala/" + this.getCodigo()+ "\n" + "1 - Diretor: " + this.getDiretor1().getNome() + "\n2 - Diretor: "
                    + this.getDiretor2().getNome() + "\nGrifinoria: \n" + this.getEquipeGrif() + "\nSonserina:\n"
                    + this.getEquipeSons() + "\nLufa-Lufa:\n" + this.getEquipeLufa() + "\nCorvinal:\n"
                    + this.getEquipeCorv() + "\nPlacar: \n" + this.placar();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cod);
        hash = 41 * hash + Objects.hashCode(this.d1);
        hash = 41 * hash + Objects.hashCode(this.d2);
        hash = 41 * hash + Objects.hashCode(this.listAlunos);
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.d1, other.d1)) {
            return false;
        }
        if (!Objects.equals(this.d2, other.d2)) {
            return false;
        }
        if (!Objects.equals(this.listAlunos, other.listAlunos)) {
            return false;
        }
        return true;
    }

// Aqui estamos comparando as casas dos diretores para definir a ordem das salas
    @Override
    public int compareTo(Object obj) {
        Objects.requireNonNull(obj, "Dados não podem ser nulos");
        if (obj instanceof Sala) {
            Sala s = (Sala) obj;
            int compareCasa = this.getDiretor1().getCasa().compareTo(s.getDiretor1().getCasa());
            if (compareCasa != 0) {
                return compareCasa;
            } else {
                return this.getDiretor2().getCasa().compareTo(s.getDiretor2().getCasa());
            }
        } else {
            throw new IllegalArgumentException("Deve ser uma sala para ser comparado");
        }

    }

}
