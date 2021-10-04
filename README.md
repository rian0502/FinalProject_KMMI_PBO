# FinalProject_KMMI_PBO

Tugas KMMI PBO tentang kelas Diagram

Anggota:
Muhammad Febrian Hasibuan 2017051033
Alif Akbar Kartadinata 2017051049
Miftahul Huda Guntara 2015061038

Pembagian Tugas:
- Miftahul: Menginisialisasi dan mengembangkan class yang digunakan dalam project
- Febrian : Membuat dan menghubungkan program dengan database SQLite
- Alif : Mendesain dan membuat GUI menggunakan JafaFX dan Scene Builder


        classDiagram

        Nasabah <|-- Individu
        Nasabah <|-- Perusahaan
        Nasabah "1"--o"*" Rekening : has
        Nasabah o-- NasabahDataModel : Data Modeling
        NasabahDataModel <-- NasabahController : Data Control
        NasabahDataModel --> DBHelper : DB Connection
        NasabahController <.. NasabahForm : Form Control
        class Nasabah{
          <<abstract>>
          #IntegerProperty ID
          #StringProperty name
          #StringProperty alamat
          #IntegerProperty numRekening
          #ArrayList<Rekening> rekening
          +IntegerProperty nextID()
          + abstract print()
        }

        class Individu{
          -LongProperty nik
          -LongProperty npwp
          +Long getNik()
          +Long getNpwp()
          +print()
        }
        class Perusahaan{
          -StringProperty nib
          +String getNib()
          +print()
        }
        class Rekening{
          -IntegerProperty noRekening;
          -DoubleProperty saldo
          +tambahSaldo(double jumlah)
          +tartikTunai(double jumlah)
          +double getSaldo()
        }

        class NasabahDataModel{
            Connection conn
            addNasabah()
            addRekening()
            getIndividu()
            getPerusahaan()
            nextNasabahID()
            nextNoRekening()
        }

        class NasabahController{
            initialize()
            handleButtonAddRekening()
            handleButtonAddAccountHolder()
            loadDataIndividua()
            loadDataPerusahaan()
            loadDataRekening()
            handleClearForm()
        }
        class DBHelper{
            - String DBURL
            getConnection()
            createTable();
        }
    
   
![image](https://user-images.githubusercontent.com/83405871/135701398-0b2290c6-a4d0-4753-b37d-81b9f0d05eaa.png)

        erDiagram
                Nasbaah ||..|| INDIVIDU : is
                Nasbaah ||--|| PERUSAHAAN : is
                Nasbaah ||--|{ REKENING : "has"
                Nasbaah {
                    int id_nasabah
                    string nama
                    string alamat
                }
                INDIVIDU{
                    int id_nasabah
                    long nik
                    long npwp
                }
                PERUSAHAAN{
                    int id_nasabah
                    string nib
                }
                REKENING{
                    int noRekening
                    double saldo
                    int id_nasabah
                }
![image](https://user-images.githubusercontent.com/83405871/135813012-40b04538-7177-43be-a688-df444272a2d2.png)
