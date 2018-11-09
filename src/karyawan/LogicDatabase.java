package karyawan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LogicDatabase {
	Koneksi koneksi = new Koneksi();
	Connection connection = koneksi.getConnection();

	public List<Karyawan> showDataKaryawan() {
		List<Karyawan> karyawanList = new ArrayList<>();

		Statement statement;
		ResultSet resultSet;

		int id;
		String nama;
		String alamat;
		String divisi;
		String noHp;
		String email;
		
		String sql = "SELECT * FROM karyawan";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while(resultSet.next()){
				id = resultSet.getInt("id");
				nama = resultSet.getString("nama");
				alamat = resultSet.getString("alamat");
				divisi = resultSet.getString("divisi");
				noHp = resultSet.getString("no_hp");
				email = resultSet.getString("email");
				karyawanList.add(new Karyawan(id, nama, alamat, divisi, noHp, email));
			}

			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return karyawanList;
	}

	public void insertData(Karyawan karyawan) {
		PreparedStatement pStatement;

		String sql = "INSERT INTO karyawan(" + 
				"nama, alamat, " +
				"divisi, no_hp, " +
				"email)" + 
				" VALUES ('" + 
				karyawan.getNama() + "','" + karyawan.getAlamat() + "','" + 
				karyawan.getDivisi() + "','" + karyawan.getNoHp() + "','" + 
				karyawan.getEmail() + "')";

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("Input Data Karyawan berhasil.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void updateData(Karyawan karyawanUpdated) {
		PreparedStatement pStatement;

		String sql = "UPDATE karyawan SET " +
				"nama = '" + karyawanUpdated.getNama() + "', alamat = '" + karyawanUpdated.getAlamat() +
				"', divisi = '" + karyawanUpdated.getDivisi() + "', no_hp = '" + karyawanUpdated.getNoHp() +
				"', email = '" + karyawanUpdated.getEmail() + 
				"' WHERE id = " + karyawanUpdated.getId();

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("update berhasil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void deleteData(Karyawan karyawan) {
		PreparedStatement pStatement;
		String sql = "DELETE FROM karyawan WHERE id = '" + karyawan.getId() + "'";

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("hapus data berhasil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public List<Keluarga> showDataKeluarga() {
		Statement statement;
		ResultSet resultSet;

		int id;
		int idKaryawan;
		String nama;
		String flagPosisi;
		String namaKaryawan;
		
		List<Keluarga> listKeluarga = new ArrayList<>();
		
		String sql = "SELECT karyawan.nama, keluarga.id, " +
					 "keluarga.id_karyawan, keluarga.nama_anggota_keluarga, " +
					 "keluarga.flag_posisi_keluarga " +
					 "FROM keluarga " +
					 "INNER JOIN karyawan " + "ON karyawan.id = keluarga.id_karyawan";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while(resultSet.next()){
				id = resultSet.getInt("keluarga.id");
				idKaryawan = resultSet.getInt("keluarga.id_karyawan");
				nama = resultSet.getString("keluarga.nama_anggota_keluarga");
				flagPosisi = resultSet.getString("keluarga.flag_posisi_keluarga");
				namaKaryawan = resultSet.getString("karyawan.nama");
				
				listKeluarga.add(new Keluarga(id, idKaryawan, namaKaryawan, nama, flagPosisi));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return listKeluarga;
	}

	public void insertData(Keluarga keluarga) {
		PreparedStatement pStatement;

		String sql = "INSERT INTO keluarga(" + 
				"id_karyawan, nama_anggota_keluarga, " +
				"flag_posisi_keluarga)" + 
				" VALUES ('" + 
				keluarga.getIdkaryawan() + "','" + keluarga.getNama() + "','" + 
				keluarga.getFlagPosisi() + "')";

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("input data anggota keluarga berhasil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void updateData(Keluarga keluargaUpdated) {
		PreparedStatement pStatement;

		String sql = "UPDATE keluarga SET " +
					 "id_karyawan = '" + keluargaUpdated.getIdkaryawan() + 
					 "', nama_anggota_keluarga = '" + keluargaUpdated.getNama() +
					 "', flag_posisi_keluarga = '" + keluargaUpdated.getFlagPosisi() + 
					 "' WHERE id =" + keluargaUpdated.getId();

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("update data anggota keluarga berhasil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void deleteData(Keluarga keluarga) {
		PreparedStatement pStatement;
		String sql = "DELETE FROM keluarga WHERE id = '" + keluarga.getId() + "'";

		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.execute();

			System.out.println("hapus data anggota keluarga berhasil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
