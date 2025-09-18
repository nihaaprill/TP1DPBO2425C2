from produk import ProdukElektronik

produk_list = []

def tambah_data():
    id = input("Masukkan ID: ")
    nama = input("Masukkan Nama: ")
    merk = input("Masukkan Merk: ")
    harga = int(input("Masukkan Harga: "))
    stok = int(input("Masukkan Stok: "))
    produk_list.append(ProdukElektronik(id, nama, merk, harga, stok))
    print("Data berhasil ditambahkan!\n")

def tampilkan_data():
    if not produk_list:
        print("Belum ada data.\n")
    else:
        # header tabel
        print(f"{'ID'.ljust(10)}{'Nama'.ljust(15)}{'Merk'.ljust(15)}{'Harga'.ljust(12)}{'Stok'.ljust(8)}")
        print("-" * 60)
        # isi tabel
        for p in produk_list:
            print(f"{p.id.ljust(10)}{p.nama.ljust(15)}{p.merk.ljust(15)}{str(p.harga).ljust(12)}{str(p.stok).ljust(8)}")
        print()

def update_data():
    id = input("Masukkan ID untuk update: ")
    for p in produk_list:
        if p.id == id:  
            p.nama = input("Nama baru: ")
            p.merk = input("Merk baru: ")
            p.harga = int(input("Harga baru: "))
            p.stok = int(input("Stok baru: "))
            print("Data berhasil diupdate!\n")
            return
    print("Data tidak ditemukan.\n")

def hapus_data():
    id = input("Masukkan ID untuk hapus: ")
    for p in produk_list:
        if p.id == id:
            produk_list.remove(p)
            print("Data berhasil dihapus!\n")
            return
    print("Data tidak ditemukan.\n")

def cari_data():
    id = input("Masukkan ID untuk cari: ")
    for p in produk_list:
        if p.id == id:
            p.tampilkan()
            return
    print("Data tidak ditemukan.\n")

while True:
    print("=== MENU TOKO ELEKTRONIK ===")
    print("1. Tambah Data\n2. Tampilkan Data\n3. Update Data\n4. Hapus Data\n5. Cari Data\n6. Keluar")
    pilihan = input("Pilih menu: ")
    if pilihan == "1": tambah_data()
    elif pilihan == "2": tampilkan_data()
    elif pilihan == "3": update_data()
    elif pilihan == "4": hapus_data()
    elif pilihan == "5": cari_data()
    elif pilihan == "6": break
    else: print("Pilihan salah!\n")
