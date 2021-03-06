package doghost;

import java.util.Objects;

/**
 * Classe que representa os dogs que podem ser hospedados pelos doghosts.
 */
public class Dog {

    /**
     * Nome do dog em questao.
     */
    private String nome;

    /**
     * Nome do tutor/dono do dog.
     */
    private String tutor;

    /**
     * Quanto de racao o dog consome diariamente.
     */
    private int consumoRacao;

    /**
     * Restricao que pode tornar a racao mais cara.
     * (i.e. obesos, alergicos, celiacos, veganos, etc).
     */
    private String restricao;

    /**
     * Construtor de um dog que nao possui restricoes quanto a alimentacao.
     *
     * @param nome         Nome do dog.
     * @param tutor        Nome do tutor/dono do dog.
     * @param consumoRacao Quanto de racao o dog consome diariamente.
     */
    public Dog(String nome, String tutor, int consumoRacao) {
        validarEntradas(nome, tutor, consumoRacao);

        this.nome = nome;
        this.tutor = tutor;
        this.consumoRacao = consumoRacao;
    }

    /**
     * Construtor de um dog que possui restricoes quanto a sua alimentacao.
     *
     * @param nome         Nome do dog.
     * @param tutor        Nome do tutor/dono do dog.
     * @param consumoRacao Quanto de racao o dog consome diariamente.
     * @param restricao    Restricao quanto a alimentacao do dog.
     *                     (i.e. obesos, alergicos, celiacos, veganos, etc)
     */
    public Dog(String nome, String tutor, int consumoRacao, String restricao) {
        validarEntradas(nome, tutor, consumoRacao);

        this.nome = nome;
        this.tutor = tutor;
        this.consumoRacao = consumoRacao;
        this.restricao = restricao;
        this.consumoRacao *= 2;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTutor() {
        return this.tutor;
    }


    /**
     * Getter do consumo total de racao.
     *
     * @return Retorna o atributo {@code consumoRacao}
     */
    public int getConsumoRacao() {
        return this.consumoRacao;
    }

    @Override
    public String toString() {
        return "Dog [name=" + this.nome + ", tutor=" + this.tutor + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return this.nome.equals(dog.nome) && this.tutor.equals(dog.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.tutor);
    }

    /**
     * Metodo auxiliar para validar as entradas dos construtores.
     *
     * @param nome         Nome do dog.
     * @param tutor        Nome do tutor/dono do dog.
     * @param consumoRacao Quanto de racao o dog consome diariamente.
     */
    private void validarEntradas(String nome, String tutor, int consumoRacao) {
        if (nome == null)
            throw new NullPointerException("Nome nulo!");
        if (nome.trim().equals(""))
            throw new IllegalArgumentException("Nome vazio!");
        if (tutor == null)
            throw new NullPointerException("Nome de tutor nulo!");
        if (tutor.trim().equals(""))
            throw new IllegalArgumentException("Nome de tutor vazio!");
        if (consumoRacao <= 0)
            throw new IllegalArgumentException("Consumo invalido!");
    }

}
