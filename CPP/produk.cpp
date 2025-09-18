#include <iostream>
using namespace std;

class ProdukElektronik {
public:
    string id, nama, merk;
    int harga, stok;

    ProdukElektronik(string i, string n, string m, int h, int s) {
        id = i; nama = n; merk = m; harga = h; stok = s;
    }

    void tampilkan() {
        cout << "ID: " << id << ", Nama: " << nama << ", Merk: " << merk
             << ", Harga: " << harga << ", Stok: " << stok << endl;
    }
};
