import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static ArrayList<ProdukElektronik> produkList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void tambahData() {
        System.out.print("Masukkan ID: ");
        String id = sc.nextLine();

        // Cek duplikasi ID
        for (ProdukElektronik p : produkList) {
            if (p.getId().equals(id)) {
                System.out.println("ID sudah ada, stok akan ditambahkan.");
                System.out.print("Tambahkan stok: ");
                int tambahan = Integer.parseInt(sc.nextLine());
                p.setStok(p.getStok() + tambahan);
                return;
            }
        }

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Merk: ");
        String merk = sc.nextLine();
        System.out.print("Masukkan Harga: ");
        int harga = Integer.parseInt(sc.nextLine());
        System.out.print("Masukkan Stok: ");
        int stok = Integer.parseInt(sc.nextLine());

        produkList.add(new ProdukElektronik(id, nama, merk, harga, stok));
        System.out.println("Data berhasil ditambahkan!\n");
    }

    static void tampilkanData() {
        if (produkList.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }

        System.out.println("+-----+-------------------+------------+-----------+------+\n"
                         + "| ID  | Nama              | Merk       | Harga     | Stok |\n"
                         + "+-----+-------------------+------------+-----------+------+");

        for (ProdukElektronik p : produkList) {
            System.out.printf("| %-3s | %-17s | %-10s | %-9d | %-4d |\n",
                    p.getId(), p.getNama(), p.getMerk(), p.getHarga(), p.getStok());
        }

        System.out.println("+-----+-------------------+------------+-----------+------+\n");
    }

    static void updateData() {
        System.out.print("Masukkan ID untuk update: ");
        String id = sc.nextLine();
        boolean found = false;

        for (ProdukElektronik p : produkList) {
            if (p.getId().equals(id)) {
                System.out.print("Nama baru: "); p.setNama(sc.nextLine());
                System.out.print("Merk baru: "); p.setMerk(sc.nextLine());
                System.out.print("Harga baru: "); p.setHarga(Integer.parseInt(sc.nextLine()));
                System.out.print("Stok baru: "); p.setStok(Integer.parseInt(sc.nextLine()));
                System.out.println("Data berhasil diupdate!");
                found = true;
            }
        }

        if (!found) System.out.println("Data tidak ditemukan.");
    }

    static void hapusData() {
        System.out.print("Masukkan ID untuk hapus: ");
        String id = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < produkList.size(); i++) {
            if (produkList.get(i).getId().equals(id)) {
                produkList.remove(i);
                System.out.println("Data berhasil dihapus!");
                found = true;
            }
        }

        if (!found) System.out.println("Data tidak ditemukan.");
    }

    static void cariData() {
        System.out.print("Masukkan ID untuk cari: ");
        String id = sc.nextLine();
        boolean found = false;

        for (ProdukElektronik p : produkList) {
            if (p.getId().equals(id)) {
                System.out.println("+-----+-------------------+------------+-----------+------+\n"
                                 + "| ID  | Nama              | Merk       | Harga     | Stok |\n"
                                 + "+-----+-------------------+------------+-----------+------+");
                System.out.printf("| %-3s | %-17s | %-10s | %-9d | %-4d |\n",
                        p.getId(), p.getNama(), p.getMerk(), p.getHarga(), p.getStok());
                System.out.println("+-----+-------------------+------------+-----------+------+\n");
                found = true;
            }
        }

        if (!found) System.out.println("Data tidak ditemukan.");
    }

    public static void main(String[] args) {
        int pilihan = 0;

        while (pilihan != 6) {
            System.out.println("\n=== MENU TOKO ELEKTRONIK ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Cari Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = Integer.parseInt(sc.nextLine());

            if (pilihan == 1) tambahData();
            else if (pilihan == 2) tampilkanData();
            else if (pilihan == 3) updateData();
            else if (pilihan == 4) hapusData();
            else if (pilihan == 5) cariData();
            else if (pilihan == 6) System.out.println("Keluar...");
            else System.out.println("Pilihan salah!");
        }
    }
}
