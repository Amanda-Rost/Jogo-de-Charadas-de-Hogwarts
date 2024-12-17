package Caracteristicas;

import java.util.Objects;

public class Casa implements Comparable {

    private final String nome;
    private Integer pontTotal;

    public Casa(String nome) {
        Objects.requireNonNull(nome, "Deve ter um nome!");
        if (nome.equalsIgnoreCase("corvinal") || nome.equalsIgnoreCase("lufa-lufa")
                || nome.equalsIgnoreCase("sonserina") || nome.equalsIgnoreCase("grifinoria")) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Não existe essa casa");
        }
        this.pontTotal = 0;
    }

    public Integer getPontTotal() {
        return pontTotal;
    }

    public void setPontTotal(Integer pontTotal) {
        this.pontTotal = pontTotal;
    }

    public String getNome() {
        return nome;
    }

    public void addPontos(int pontos) {
        if (pontos < 0 && pontos > this.pontTotal) {
            this.pontTotal = 0;
        }
        this.pontTotal += pontos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Casa other = (Casa) obj;
        return this.nome.equalsIgnoreCase(other.nome);
    }

    @Override
    public String toString() {
        return "\nTotal de pontos: " + this.pontTotal;
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o, "Dados nao podem ser nulos");
        if (o instanceof Casa) {
            Casa c = (Casa) o;
            return this.nome.compareToIgnoreCase(c.getNome());
        } else {
            throw new IllegalArgumentException("Deve ser uma casa para ser comparado");
        }
    }
}
