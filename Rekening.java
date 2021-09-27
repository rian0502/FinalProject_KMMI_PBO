package finalprojectpbo;
/**
 * @author Miftah
 */
public class Rekening {
    private int noRekening;
    private double saldo;
    
    public Rekening(int noRekening, double saldo){
        this.noRekening = noRekening;
        this.saldo = saldo;
    }
    
    public int getNoRekening(){
        return noRekening;
    }
    
    public void getNoRekening(int noRekening){
        this.noRekening = noRekening;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void tambahSaldo(double jumlah){
        if(jumlah > 0)
            this.saldo += jumlah;
    }
    
    public void tarikTunai(double jumlah){
        if (jumlah > 0 && this.saldo > jumlah)
            this.saldo -= jumlah;
    }
}
