import java.util.Scanner;

abstract class abs_Resto {
    String nama, noTelp, keterangan;
    int jmlTamu, hargaMenu, hargaTema;
    
    abstract void jenis();
    abstract void paket();
    abstract void cetakNama(String nama);
    abstract void cetakTotal();
}

class jenis_Resto extends abs_Resto {
    @Override
    void jenis() {
        System.out.println("\nJenis Menu Paket Restoran");
        System.out.println("1. Menu Indonesia  ||| Rp. 30.000");
        System.out.println("2. Menu Seafood    ||| Rp. 45.000");
        System.out.println("3. Menu Western    ||| Rp. 60.000");
    }
    
    @Override
    void paket() {
        System.out.println("\nJenis Paket Tema Acara");
        System.out.println("1. Ulang Tahun/Arisan  ||| Rp. 3.500.000");
        System.out.println("2. Kegiatan Kantor     ||| Rp. 10.000.000");
        System.out.println("3. Pernikahan/Tunangan ||| Rp. 20.000.000");
    }
    
    @Override
    void cetakNama(String nama) {
        this.nama = nama;
        System.out.println("Nama Penyewa: " + nama);
    }
    
    @Override
    void cetakTotal() {
        int total = (hargaMenu * jmlTamu) + hargaTema;
        System.out.println("Total Biaya: Rp" + total);
    }
    
    void setDataPenyewa(String noTelp, int jmlTamu, int hargaMenu, int hargaTema, String keterangan) {
        this.noTelp = noTelp;
        this.jmlTamu = jmlTamu;
        this.hargaMenu = hargaMenu;
        this.hargaTema = hargaTema;
        this.keterangan = keterangan;
    }
}

public class main_Resto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        jenis_Resto penyewa = new jenis_Resto();
        
        System.out.println("--- Asia International Resto/Hall ---");
        System.out.print("Masukkan Nama Penyewa: ");
        String nama = input.nextLine();
        penyewa.cetakNama(nama);
        
        System.out.print("Masukkan No.Telp Penyewa: ");
        String noTelp = input.nextLine();
        
        penyewa.jenis();
        System.out.print("\nJenis Paket Restoran: ");
        int pilihanMenu = input.nextInt();
        
        penyewa.paket();
        System.out.print("\nJenis Paket Tema Acara: ");
        int pilihanTema = input.nextInt();
        
        System.out.print("Banyak Tamu Undangan: ");
        int jmlTamu = input.nextInt();
        input.nextLine(); // consume newline
        
        System.out.print("Masukkan Keterangan: ");
        String keterangan = input.nextLine();
        
        int hargaMenu = 0;
        int hargaTema = 0;
        
        switch (pilihanMenu) {
            case 1:
                hargaMenu = 30000;
                break;
            case 2:
                hargaMenu = 45000;
                break;
            case 3:
                hargaMenu = 60000;
                break;
        }
        
        switch (pilihanTema) {
            case 1:
                hargaTema = 3500000;
                break;
            case 2:
                hargaTema = 10000000;
                break;
            case 3:
                hargaTema = 20000000;
                break;
        }
        
        penyewa.setDataPenyewa(noTelp, jmlTamu, hargaMenu, hargaTema, keterangan);
        System.out.println("\n=========================================================");      
        System.out.println("\n*** Data Penyewa ***");
        System.out.println("Nama Penyewa: " + nama);
        System.out.println("No. Telp: " + noTelp);
        System.out.println("Jumlah Tamu: " + jmlTamu);
        System.out.println("\nKeterangan: " + keterangan);
        System.out.println("=========================================================");
        System.out.println("\nPaket Restoran yang Dipesan:");
        System.out.println("1. Jenis: " + (pilihanMenu == 1 ? "Menu Indonesia" : pilihanMenu == 2 ? "Menu Seafood" : "Menu Western"));
        System.out.println("2. Paket: " + (pilihanTema == 1 ? "Ulang Tahun/Arisan" : pilihanTema == 2 ? "Kegiatan Kantor" : "Pernikahan/Tunangan"));
        System.out.println("\n=========================================================");
        penyewa.cetakTotal();
        System.out.println("=========================================================");
        input.close();
    }
}
