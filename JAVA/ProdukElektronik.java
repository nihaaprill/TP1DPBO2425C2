public class ProdukElektronik {
    // Atribut produk dibuat private agar hanya bisa diakses melalui constructor atau getter/setter
    private String id;
    private String nama;
    private String merk;
    private int harga;
    private int stok;

    // Constructor untuk inisialisasi data produk
    public ProdukElektronik(String id, String nama, String merk, int harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getMerk() { return merk; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }

    // Setter
    public void setNama(String nama) { this.nama = nama; }
    public void setMerk(String merk) { this.merk = merk; }
    public void setHarga(int harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }
}
