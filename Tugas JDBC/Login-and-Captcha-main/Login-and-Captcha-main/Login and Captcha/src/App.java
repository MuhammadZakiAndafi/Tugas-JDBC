import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class App {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/zealous_mart";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //polymorphisme
        DataCustomer Zaki = new Customer();

        Login Andafi = new Login();
        Andafi.login();

        //inputkan data
        Zaki.inputDataPelanggan();
        
        //mencetak struk
        Zaki.Struk();

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO customer (kode_barang, no_faktur, nama_customer, no_hp, alamat) VALUE ('%s','%s', '%s', '%s', '%s' )";
            sql = String.format(sql, Zaki.getKodeBarang(), Zaki.getFaktur(), Zaki.getNama(), Zaki.getNoHP(), Zaki.getAlamat());
            stmt.execute(sql);

            while (!conn.isClosed()) {
               showMenu();
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
        e.printStackTrace();
        }

        scanner.close();

    }

    static Scanner scanner = new Scanner(System.in); 
    
    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Show Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            Integer pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        String sql = "SELECT * FROM customer";

        try {
            rs = stmt.executeQuery(sql);
            
            System.out.println("+--------------------------------+");
            System.out.println("|     Z E A L O U S  M A R T     |");
            System.out.println("+--------------------------------+");

            while (rs.next()) {
                String no_faktur = rs.getString("no_faktur");
                String nama_customer = rs.getString("nama_customer");
                String no_hp = rs.getString("no_hp");
                String alamat = rs.getString("alamat");
                String kode_barang = rs.getString("kode_barang");
                
                System.out.println(String.format("%s. %s -- %s -- (%s)", kode_barang, no_faktur, nama_customer, alamat, no_hp));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updateData() {
        try {
            
            // ambil input dari user
            System.out.print("Kode Barang yang mau diedit : ");
            String kode_barang = scanner.nextLine();            
            System.out.print("No Faktur : ");
            String no_faktur = scanner.nextLine();
            System.out.print("Nama Customer : ");
            String nama_customer = scanner.nextLine().trim();
            System.out.print("Alamat : ");
            String alamat = scanner.nextLine().trim();

            // query update
            String sql = "UPDATE customer SET nama_customer='%s', no_faktur='%s', alamat='%s' WHERE kode_barang='%s'";
            sql = String.format(sql, nama_customer, no_faktur, alamat, kode_barang);

            // update data Data
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteData() {
        try {
            
            // ambil input dari user
            System.out.print("Kode Barang yang mau dihapus : ");
            String kode_barang = (scanner.nextLine());
            
            // buat query hapus
            String sql = String.format("DELETE FROM customer WHERE kode_barang='%s'", kode_barang);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}