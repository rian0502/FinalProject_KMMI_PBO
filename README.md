# FinalProject_KMMI_PBO

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
          #IntegerProperty numAccounts
          +IntegerProperty nextID()
      }
    
    class Individual{
        -IntegerProperty nik
        -IntegerProperty npwp
      }
    class Perusahaan{
      -StringProperty nib
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
