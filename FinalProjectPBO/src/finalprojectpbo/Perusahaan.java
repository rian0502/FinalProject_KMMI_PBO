package finalprojectpbo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * @author Miftah
 */
public class Perusahaan extends Nasabah{
    private StringProperty nib;

    public Perusahaan(int id, String nama, String alamat, ArrayList<Rekening> rekening, String nib) {
        super(id, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }

    public Perusahaan(int id, String nama, String alamat, Rekening rekenings, String nib) {
        super(id, nama, alamat, rekenings);
        this.nib = new SimpleStringProperty(nib);
    }

    public String getNib() {
        return nib.get();
    }

    public StringProperty nibProperty() {
        return nib;
    }

    public void setNib(String nib) {
        this.nib.set(nib);
    }

    @Override
    public void print(){
        System.out.println("Nib  : " + getNib());
        System.out.println("Nama Perusahan : "+getNama());
        System.out.println("Alamat Perusahaan : "+getAlamat());
        System.out.println("Rekening : ");
        for (Rekening rek : rekening){
            System.out.println(rek);
        }
    }
}
