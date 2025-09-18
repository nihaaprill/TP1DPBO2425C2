<?php
class ProdukElektronik {
    public $id;
    public $nama;
    public $merk;
    public $harga;
    public $stok;
    public $gambar;

    public function __construct($id, $nama, $merk, $harga, $stok, $gambar) {
        $this->id = $id;
        $this->nama = $nama;
        $this->merk = $merk;
        $this->harga = $harga;
        $this->stok = $stok;
        $this->gambar = $gambar;
    }
}
?>
