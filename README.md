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
        Nasabah <|-- Individual
        Nasabah <|-- Perusahaan
        Nasabah "1"--o"*" Account : has
        Nasabah o-- NasabahDataModel : Data Modeling
        NasabahDataModel <-- AccountHolderController : Data Control
        NasabahDataModel --> DBHelper : DB Connection
        AccountHolderController <.. AccountHolderForm : Form Control      

    class Nasabah{
      <<abstract>>
      #IntegerProperty ID
      #StringProperty nama
      #StringProperty alamat
      #IntegerProperty sizeAccount
      +IntegerProperty nextID()
      +print(void)
    }
    
    class Individual{
      -LongProperty nik
      -LongProperty npwp
      +setNik(void)
      +setNpwp(void)
      +getNik()
      +getNpwp()
      +print():
    }
    class Perusahaan{
      -StringProperty nib
      +setNib()
      +getNib()
      +print():
    }
    class Account{
      -IntegerProperty accNumber;
      -DoubleProperty balance
      +deposite(double amt)
      +withdraw(double amt)
      +double getBalance()
    }

    class NasabahDataModel{
        Connection conn
        addAccountHolder()
        addAccount()
        getIndividuals()
        getPerusahaans()
        nextAccountHolderID()
        nextAccountNumber()
    }

    class AccountHolderController{
        initialize()
        handleButtonAddAccount()
        handleButtonAddAccountHolder()
        loadDataIndividual()
        loadDataPerusahaan()
        loadDataAccount()
        handleClearForm()
    }
    class DBHelper{
        - String USERNAME
        - String PASSWORD
        - String DB
        getConnection()
        getConnection(String driver)
        createTable();
    }
