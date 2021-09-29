package finalprojectpbo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Miftah
 */
public class Rekening {
    private IntegerProperty noRekening;
    private DoubleProperty saldo;
    
    public Rekening(int noRekening, double saldo){
        this.noRekening = new SimpleIntegerProperty(noRekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }

    public int getNoRekening() {
        return noRekening.get();
    }

    public IntegerProperty noRekeningProperty() {
        return noRekening;
    }

    public void setNoRekening(int noRekening) {
        this.noRekening.set(noRekening);
    }

    public double getSaldo() {
        return saldo.get();
    }

    public DoubleProperty saldoProperty() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo.set(saldo);
    }

    public void tambahSaldo(double jumlah){
        setSaldo(this.saldo.get()+jumlah);
    }
    
    public void tarikTunai(double jumlah){
        setSaldo(this.saldo.get()-jumlah);

    }
}
