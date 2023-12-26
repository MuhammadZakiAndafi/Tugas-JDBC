import java.util.Scanner;

public class Customer extends DataCustomer{

    //method untuk mengisi data pelanggan
    public void inputDataPelanggan(){
        Scanner scanStr = new Scanner(System.in);
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Masukkan no faktur \t= ");
        faktur = scanStr.next();
        System.out.print("Masukkan nama pelanggan = ");
        nama = scanStr.next();
        System.out.print("Masukkan no HP \t\t= ");
        noHP = scanStr.next();
        System.out.print("Masukkan alamat \t= ");
        alamat = scanStr.next();
        System.out.print("Masukkan nama barang \t= ");
        namaBarang = scanStr.next();
        System.out.print("Masukkan kode barang \t= ");
        kodeBarang = scanStr.next();

        System.out.print("Masukkan harga barang \t= ");
        //exception handling
        try {
            hargaBarang = scanIn.nextInt();
            if (hargaBarang < 500){
                throw new IllegalArgumentException ("harga barang tidak valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Inputkan kembali harga barang \t=");
            hargaBarang = scanIn.nextInt();
        }

        System.out.print("Masukkan jumlah barang \t= ");
        jmlBarang = scanIn.nextInt();
    }

    //method untuk mencetak struk
    @Override
    public void Struk() {
        Integer totalBayar = hargaBarang*jmlBarang;
        this.totalBayar = totalBayar;
        System.out.println("\n\n\n");
        System.out.println("~~~~~~~~~~~~~ ZEALOUS MART ~~~~~~~~~~~~~");
        System.out.println(hari.format(date));
        System.out.println(jam.format(date));
        System.out.println("No Faktur \t: \n" + faktur);
        System.out.println("~~~~~~~~~~~~ DATA PELANGGAN ~~~~~~~~~~~~");
        System.out.println("Nama Pelanggan \t: " + nama);
        System.out.println("No HP \t\t: " + noHP);
        System.out.println("Alamat \t\t\n: " + alamat);
        System.out.println("~~~~~~~~ DATA PEMBELIAN BARANG ~~~~~~~~~");
        System.out.println("Nama Barang \t: " + namaBarang);
        System.out.println("Kode Barang \t: " + kodeBarang);
        System.out.println("Harga \t\t: " + hargaBarang);
        System.out.println("Jumlah \t\t: " + jmlBarang);
        System.out.println("Total Bayar \t: " + this.totalBayar);
        System.out.println("========================================");
        System.out.println("Kasir \t\t: Muhammad Zaki Andafi\n");
        
        //method string
        System.out.println("Ini Method String");
        System.out.println("toUperrcase\t: " + nama.toUpperCase() );
        System.out.println("toLowercase\t: " + nama.toLowerCase() );
        System.out.println("toUperrcase\t: " + namaBarang.toUpperCase() );
        System.out.println("toLowercase\t: " + namaBarang.toLowerCase() );
        System.out.println("length\t\t: " + namaBarang.length() );
        System.out.println("length\t\t: " + nama.length() );
        System.out.println("compareto\t:" + nama.compareTo(alamat));

    }
    

}
