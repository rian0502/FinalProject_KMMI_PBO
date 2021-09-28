package finalprojectpbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * @author Miftah
 */
public abstract class Nasabah {
    protected IntegerProperty id;
    protected StringProperty nama;
    protected StringProperty alamat;
    private IntegerProperty sizeRekening;
    protected ArrayList <Rekening> rekening;

    public Nasabah(int id, String nama, String alamat, int sizeRekening, ArrayList<Rekening> rekening) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.sizeRekening = new SimpleIntegerProperty(sizeRekening);
        this.rekening = rekening;
    }
    public Nasabah(int id, String nama, String alamat, int sizeRekening, Rekening rekenings) {
        this.rekening = new ArrayList<>();
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.sizeRekening = new SimpleIntegerProperty(sizeRekening);
        this.rekening.add(rekenings);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public int getSizeRekening() {
        return sizeRekening.get();
    }

    public IntegerProperty sizeRekeningProperty() {
        return sizeRekening;
    }

    public void setSizeRekening(int sizeRekening) {
        this.sizeRekening.set(sizeRekening);
    }

    public ArrayList<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }

    abstract public void print();
}
