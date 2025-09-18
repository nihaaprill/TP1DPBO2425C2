<?php

include __DIR__ . "/produk.php";
session_start();

if (isset($_GET['clear'])) {
    session_unset();   // hapus semua data di session
    session_destroy(); // hancurkan session
    session_start();   // mulai session baru kosong
}

if (!isset($_SESSION['produk'])) {
    $_SESSION['produk'] = [];
}

if (isset($_POST['tambah'])) {
    $id = $_POST['id'];
    $nama = $_POST['nama'];
    $merk = $_POST['merk'];
    $harga = $_POST['harga'];
    $stok = $_POST['stok'];
    $gambar = $_POST['gambar'];
    $_SESSION['produk'][] = new ProdukElektronik($id, $nama, $merk, $harga, $stok, $gambar);
}

if (isset($_GET['hapus'])) {
    $id = $_GET['hapus'];
    foreach ($_SESSION['produk'] as $key => $p) {
        if ($p->id == $id) {
            unset($_SESSION['produk'][$key]);
        }
    }
    $_SESSION['produk'] = array_values($_SESSION['produk']); // reset index array
}



$cari = null;
if (isset($_POST['cari'])) {
    $id = $_POST['id_cari'];
    foreach ($_SESSION['produk'] as $p) {
        if ($p->id == $id) {
            $cari = $p;
        }
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Toko Elektronik</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f4f6;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #2563eb;
            border-bottom: 2px solid #2563eb;
            padding-bottom: 5px;
        }
        form {
            background: #fff;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        input, button {
            margin: 5px 0;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            background: #2563eb;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background: #1d4ed8;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #2563eb;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9fafb;
        }
        .highlight {
            background: #dbeafe;
            padding: 10px;
            border-radius: 5px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h2>Tambah Produk</h2>
<form method="post">
    ID: <input type="text" name="id" required><br>
    Nama: <input type="text" name="nama" required><br>
    Merk: <input type="text" name="merk" required><br>
    Harga: <input type="number" name="harga" required><br>
    Stok: <input type="number" name="stok" required><br>
    Gambar (path lokal): <input type="text" name="gambar" required><br>
    <button type="submit" name="tambah">Tambah</button>
</form>

<h2>Daftar Produk</h2>
<table>
<tr><th>ID</th><th>Nama</th><th>Merk</th><th>Harga</th><th>Stok</th><th>Gambar</th><th>Aksi</th></tr>
<?php foreach ($_SESSION['produk'] as $p): ?>
<tr>
    <td><?= $p->id ?></td>
    <td><?= $p->nama ?></td>
    <td><?= $p->merk ?></td>
    <td><?= $p->harga ?></td>
    <td><?= $p->stok ?></td>
    <td><img src="<?= $p->gambar ?>" width="60"></td>
    <td><a href="?hapus=<?= $p->id ?>" style="color:red;">Hapus</a></td>
</tr>
<?php endforeach; ?>
</table>

<h2>Cari Produk</h2>
<form method="post">
    ID: <input type="text" name="id_cari" required>
    <button type="submit" name="cari">Cari</button>
</form>
<?php if ($cari): ?>
<div class="highlight">
    <strong>Data ditemukan:</strong><br>
    <?= $cari->id ?> - <?= $cari->nama ?> (<?= $cari->merk ?>) | Harga: <?= $cari->harga ?> | Stok: <?= $cari->stok ?>
</div>
<?php endif; ?>
</body>
</html>
