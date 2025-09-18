#include <iostream>
#include <vector>
#include <limits>   // untuk numeric_limits
#include <iomanip>  // untuk setw
#include "produk.cpp"
using namespace std;

vector<ProdukElektronik> produk_list;

void tambah_data() {
    string id, nama, merk; 
    int harga, stok;

    cin.ignore(numeric_limits<streamsize>::max(), '\n'); // bersihkan newline sisa input menu

    cout << "Masukkan ID: ";
    getline(cin, id);

    cout << "Masukkan Nama: ";
    getline(cin, nama);

    cout << "Masukkan Merk: ";
    getline(cin, merk);

    cout << "Masukkan Harga: ";
    cin >> harga;

    cout << "Masukkan Stok: ";
    cin >> stok;
    cin.ignore(numeric_limits<streamsize>::max(), '\n'); // buang newline setelah angka

    produk_list.push_back(ProdukElektronik(id, nama, merk, harga, stok));
    cout << "Data berhasil ditambahkan!\n";
}

void tampilkan_data() {
    if (produk_list.empty()) {
        cout << "Belum ada data.\n";
    } else {
        cout << left << setw(10) << "ID"
             << setw(20) << "Nama"
             << setw(15) << "Merk"
             << setw(12) << "Harga"
             << setw(8)  << "Stok" << endl;
        cout << string(65, '-') << endl;
        for (auto &p : produk_list) p.tampilkan();
    }
}

void update_data() {
    string id;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout << "Masukkan ID untuk update: "; getline(cin, id);
    for (auto &p : produk_list) {
        if (p.id == id) {
            cout << "Nama baru: "; getline(cin, p.nama);
            cout << "Merk baru: "; getline(cin, p.merk);
            cout << "Harga baru: "; cin >> p.harga;
            cout << "Stok baru: "; cin >> p.stok;
            cout << "Data berhasil diupdate!\n";
            return;
        }
    }
    cout << "Data tidak ditemukan.\n";
}

void hapus_data() {
    string id;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout << "Masukkan ID untuk hapus: "; getline(cin, id);
    for (auto it = produk_list.begin(); it != produk_list.end(); ++it) {
        if (it->id == id) {
            produk_list.erase(it);
            cout << "Data berhasil dihapus!\n";
            return;
        }
    }
    cout << "Data tidak ditemukan.\n";
}

void cari_data() {
    string id;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout << "Masukkan ID untuk cari: "; getline(cin, id);
    for (auto &p : produk_list) {
        if (p.id == id) {
            p.tampilkan();
            return;
        }
    }
    cout << "Data tidak ditemukan.\n";
}

int main() {
    int pilihan;
    do {
        cout << "\n=== MENU TOKO ELEKTRONIK ===\n";
        cout << "1. Tambah Data\n2. Tampilkan Data\n3. Update Data\n4. Hapus Data\n5. Cari Data\n6. Keluar\n";
        cout << "Pilih menu: "; cin >> pilihan;

        if (pilihan == 1) {
            tambah_data();
        } else if (pilihan == 2) {
            tampilkan_data();
        } else if (pilihan == 3) {
            update_data();
        } else if (pilihan == 4) {
            hapus_data();
        } else if (pilihan == 5) {
            cari_data();
        } else if (pilihan == 6) {
            cout << "Keluar...\n";
        } else {
            cout << "Pilihan salah!\n";
        }

    } while(pilihan != 6);
    return 0;
}
