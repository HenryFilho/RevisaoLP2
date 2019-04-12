package doghost;

public class DogHost {

    private String nome;
    private int maximoRacao;
    private Dog[] dogs;
    private int indiceDogs;

    public DogHost(String nome, int maximoDogs, int maximoRacao) {
        this.nome = nome;
        this.dogs = new Dog[maximoDogs];
        this.maximoRacao = maximoRacao;
        this.indiceDogs = 0;
    }

    public boolean adicionaDog(Dog d) {

        boolean result = false;

        if (d.getConsumoRacao() + totalRacao() < maximoRacao && indiceDogs < dogs.length) {
            dogs[indiceDogs] = d;
            indiceDogs++;
            result = true;
        }

        return result;
    }

    public String listaDogs() {

        String result = nome + ":\n";

        for (int i = 0; i < dogs.length; i++) {
            result += dogs[i].toString();
        }

        return result;
    }

    public double consultaValorHospedagem(Dog toto, int dias) {
        if (!contains(toto))
            throw new IllegalArgumentException("Dog não cadastrado.");

        return consumoDiario(toto) * dias;
    }

    private boolean contains(Dog toto) {
        boolean result = false;
        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i].equals(toto)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int totalRacao() {
        int result = 0;
        for (int i = 0; i < dogs.length; i++) {
            result += dogs[i].getConsumoRacao();
        }
        return result;
    }

    public double totalValorDiario() {
        double result = 0;
        for (int i = 0; i < dogs.length; i++) {
            result += consumoDiario(dogs[i]);
        }
        return result;
    }

    private double consumoDiario(Dog dog) {
        return dog.getConsumoRacao() * 0.4;
    }
}
