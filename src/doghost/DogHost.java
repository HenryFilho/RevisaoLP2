package doghost;

/**
 * Classe que representa o anfitriao que se propôs a hospedar os cachorros.
 */
public class DogHost {
  
    /**
     * Nome do anfitriao.
     */
    private String nome;

    /**
     * Maximo de racao que o anfitriao se disponibiliza a comprar.
     */
    private int maximoRacao;

    /**
     * Array que armazena os doguinhos hospedados.
     */
    private Dog[] dogs;

    /**
     * Contados que armazena o indice do ultimo dog.
     */
    private int indiceDogs;

    /**
     * Construtor unico do anfitriao.
     *
     * @param nome        Nome do anfitriao.
     * @param maximoDogs  Maximo de doguinhos que o anfitriao se disponibiliza para cuidar.
     * @param maximoRacao Maximo de racao que o anfitriao se disponibiliza a comprar.
     */
    public DogHost(String nome, int maximoDogs, int maximoRacao) {
        this.nome = nome;
        this.dogs = new Dog[maximoDogs];
        this.maximoRacao = maximoRacao;
        this.indiceDogs = 0;
    }

    /**
     * Metodo responsavel pela hospedagem de um doguinho.
     *
     * @param dog Doguinho a ser adicionado.
     * @return true ou false dependendo do resultado da hospedagem. (Considerando o maximo de Racao e
     * o maximo de dogs.)
     */
    public boolean adicionaDog(Dog dog) {

        boolean result = false;

        if (dog.getConsumoRacao() + this.totalRacao() < this.maximoRacao && this.indiceDogs < this.dogs.length) {
            this.dogs[this.indiceDogs] = dog;
            this.indiceDogs++;
            result = true;
        }

        return result;
    }

    /**
     * Metodo responsavel por listar todos os dogs hospedados pelo anfitriao pela ordem de cadastro.
     *
     * @return o nome do anfitriao seguido do .toString() de cada um dos doguinhos, separados por uma
     * quebra de linha.
     */
    public String listaDogs() {

        String result = this.nome + ":" + System.lineSeparator();

        for (int i = 0; i < this.indiceDogs; i++) {
            result += this.dogs[i].toString() + System.lineSeparator();
        }

        return result.trim();
    }

    /**
     * Consulta o valor da hospedagem de um doguinho por uma determinada quantia de tempo. Lança uma
     * excecao caso ele nao esteja cadastrado.
     *
     * @param toto Dog a ser avaliado.
     * @param dias Quantos dias ele estara hospedado.
     * @return valor (em reais) do custo da hospedagem.
     */
    public double consultaValorHospedagem(Dog toto, int dias) {
        if (!contains(toto))
            throw new IllegalArgumentException("Dog não cadastrado.");

        return this.consumoDiario(toto) * dias;
    }

    /**
     * Metodo auxiliar que checa se um determinado doguinho esta cadastrado.
     *
     * @param toto Dog desejado.
     * @return valor booleano dependendo do cadastro do doguinho desejado.
     */
    private boolean contains(Dog toto) {
        boolean result = false;
        for (int i = 0; i < this.indiceDogs; i++) {
            if (this.dogs[i].equals(toto)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Total de racao consumida diariamente pelos dogs hospedados.
     *
     * @return Consumo diario de racao.
     */
    public int totalRacao() {
        int result = 0;
        for (int i = 0; i < this.indiceDogs; i++) {
            result += this.dogs[i].getConsumoRacao();
        }
        return result;
    }

    /**
     * Gasto total diario com racao.
     *
     * @return Valor (em reais) gasto.
     */
    public double totalValorDiario() {
        double result = 0;
        for (int i = 0; i < this.indiceDogs; i++) {
            result += this.consumoDiario(dogs[i]);
        }
        return result;
    }

    /**
     * Metodo auxiliar que retorna o consumo de um determinado dog.
     *
     * @param dog Doguinho desejado.
     * @return Consumo (em reais).
     */
    private double consumoDiario(Dog dog) {
        return dog.getConsumoRacao() * 0.4;
    }

    public String getNome() {
        return this.nome;
    }

    public int getMaximoRacao() {
        return this.maximoRacao;
    }

    public Dog[] getDogs() {
        return this.dogs;
    }

    public int getIndiceDogs() {
        return this.indiceDogs;
    }
}