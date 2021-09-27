package finalprojectpbo;

import java.util.ArrayList;

/**
 * @author Miftah
 */
public class Individu extends Nasabah {
    private long nik;
    private long npwp;
    
    public Individu(long nik, long npwp, String nama, String alamat, ArrayList<Rekening> rekening){
        super(nama,alamat,rekening);
        this.nik = nik;
        this.npwp = npwp;
    }
    
    public long getNik(){
        return nik;
    }
    
    public void setNik(long nik){
        this.nik = nik;
    }
    
    public long getNpwp(){
        return npwp;
    }
    
    public void setNpwp(long npwp){
        this.npwp = npwp;
    }
    
    @Override
    public void print(){
        
    }
}
