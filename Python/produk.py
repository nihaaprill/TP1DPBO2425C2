class ProdukElektronik:
    def __init__(self, id, nama, merk, harga, stok):
        self.id = id
        self.nama = nama
        self.merk = merk
        self.harga = harga
        self.stok = stok

    def tampilkan(self):
        print(f"ID: {self.id}, Nama: {self.nama}, Merk: {self.merk}, Harga: {self.harga}, Stok: {self.stok}")
