package finalprojectpbo;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.ArrayList;

/**
 * @author Miftah
 */
public class Individu extends Nasabah {
    private LongProperty nik;
    private LongProperty npwp;

    public Individu(int id, String nama, String alamat,ArrayList<Rekening> rekening, long nik, long npwp) {
        super(id, nama, alamat,rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public Individu(int id, String nama, String alamat, Rekening rekenings, long nik, long npwp) {
        super(id, nama, alamat, rekenings);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public long getNik() {
        return nik.get();
    }

    public LongProperty nikProperty() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik.set(nik);
    }

    public long getNpwp() {
        return npwp.get();
    }

    public LongProperty npwpProperty() {
        return npwp;
    }

    public void setNpwp(long npwp) {
        this.npwp.set(npwp);
    }

    @Override
    public void print(){
        System.out.println("NIK      : " + getNik());
        System.out.println("NPWP     : " + getNpwp());
        System.out.println("Nama     : "+getNama());
        System.out.println("Alamat   : "+getAlamat());
        System.out.println("Rekening : ");
        for (Rekening rek : rekening){
            System.out.println(rek);
        }
    }
}
