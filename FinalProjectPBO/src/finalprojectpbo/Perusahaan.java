package finalprojectpbo;

import java.util.ArrayList;

/**
 * @author Miftah
 */
public class Perusahaan extends Nasabah{
    private String nib;
    
    public Perusahaan(String nib, String nama, String alamat, ArrayList<Rekening> rekening){
        super(nama, alamat, rekening);
        this.nib = nib;
    }
    
    @Override
    public void print(){
        
    }
}
