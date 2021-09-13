package lojinha;

public class Telefone {
    int ddd;
    long numero;

    //Este é um construtor padrão
    Telefone() {}
    
    //Este é um construtor completo
    Telefone(int ddd, long numero) {
        this.ddd = ddd;
        this.numero = numero;
    };

    //<- DDD ->
    public void setDDD(int ddd) {
        this.ddd = ddd;
    }
    public int getDDD() {
        return ddd;
    }

    //<- Numero ->
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public long getNumero() {
        return numero;
    }
}
