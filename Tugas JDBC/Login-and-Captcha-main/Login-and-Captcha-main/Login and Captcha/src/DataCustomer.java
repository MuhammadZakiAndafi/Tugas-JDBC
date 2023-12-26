import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCustomer implements CetakStruk {
    String faktur;
    String nama;
    String noHP;
    String namaBarang;
    String kodeBarang;
    

    String alamat;
    int hargaBarang;
    Integer jmlBarang;
    Integer totalBayar;

    public String getKodeBarang() {
        return kodeBarang;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getFaktur() {
        return faktur;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHP() {
        return noHP;
    }

    @Override
    public void Struk() {
    }

    //date
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yyyy");
        SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

    //method untuk mengisi data pelanggan
    public void inputDataPelanggan() {
    }

    
}
