package karyawan;

import java.util.List;
import java.util.Scanner;

public class Keluarga{
	private int id;
	private int idkaryawan;
	private String namaKaryawan;
	private String nama;
	private String flagPosisi;
	
	List<Keluarga> listKeluarga;
	
	LogicDatabase logicDatabase = new LogicDatabase();

	public Keluarga() {

	}
	
	public Keluarga(int id) {
		this.id = id;
	}

	public Keluarga(String nama, String flagPosisi) {
		this.nama = nama;
		this.flagPosisi = flagPosisi;
	}
	
	public Keluarga(int idKaryawan, String nama, String flagPosisi) {
		this.idkaryawan = idKaryawan;
		this.nama = nama;
		this.flagPosisi = flagPosisi;
	}

	public Keluarga(int id, int idKaryawan, String nama, String flagPosisi) {
		this.id = id;
		this.idkaryawan = idKaryawan;
		this.nama = nama;
		this.flagPosisi = flagPosisi;
	}
	
	public Keluarga(int id, int idKaryawan, String namaKaryawan, String nama, String flagPosisi) {
		this.id = id;
		this.idkaryawan = idKaryawan;
		this.setNamaKaryawan(namaKaryawan);
		this.nama = nama;
		this.flagPosisi = flagPosisi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkaryawan() {
		return idkaryawan;
	}

	public void setIdkaryawan(int idkaryawan) {
		this.idkaryawan = idkaryawan;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getFlagPosisi() {
		return flagPosisi;
	}

	public void setFlagPosisi(String flagPosisi) {
		this.flagPosisi = flagPosisi;
	}
	
	public void showData() {
		listKeluarga = logicDatabase.showDataKeluarga();
		
		System.out.println("****** DATA ANGGOTA KELUARGA ******\n");
		
		for (Keluarga keluarga : listKeluarga) {
			System.out.println("ID Karyawan   : " + keluarga.getIdkaryawan());
			System.out.println("Nama Karyawan : " + keluarga.getNamaKaryawan());
			System.out.println("ANGGOTA KELUARGA");
			System.out.println("ID            : " + keluarga.getId());
			System.out.println("Nama          : " + keluarga.getNama());
			System.out.println("Posisi        : " + keluarga.getFlagPosisi());
			System.out.println("___________________________________");
			System.out.println();
		}
	}
	
	public void insertData() {
		Scanner scan = new Scanner(System.in);

		System.out.println("****** INPUT DATA KELUARGA ******");
		System.out.print("ID Karyawan : ");
		int inputIdkaryawan = scan.nextInt();
		System.out.print("Nama        : ");
		String inputNamaKeluarga = scan.next();
		System.out.print("Flag Posisi : ");
		String inputFlagPosisi = scan.next();

		scan.close();

		Keluarga keluargaBaru = new Keluarga(inputIdkaryawan, inputNamaKeluarga, inputFlagPosisi);
		logicDatabase.insertData(keluargaBaru);
	}
	
	public void updateData() {
		Scanner scan = new Scanner(System.in);

		System.out.println("****** EDIT DATA ANGGOTA KELUARGA ******");
		System.out.print("ID Keluarga : ");
		int inputIdKeluarga = scan.nextInt();
		System.out.print("ID Karyawan : ");
		int inputIdKaryawan = scan.nextInt();
		System.out.print("Nama : ");
		String inputNama = scan.next();
		System.out.print("Flag Posisi : ");
		String inputPosisi = scan.next();

		scan.close();

		Keluarga keluargaUpdated = new Keluarga(inputIdKeluarga, inputIdKaryawan, inputNama, inputPosisi);
		logicDatabase.updateData(keluargaUpdated);
	}
	
	public void deleteData() {
		Scanner scan = new Scanner(System.in);

		System.out.println("***** HAPUS DATA ANGGOTA KELUARGA *****");
		System.out.print("ID Keluarga: ");
		int inputId = scan.nextInt();
		
		scan.close();
		
		Keluarga keluargaDeleted = new Keluarga(inputId);
		logicDatabase.deleteData(keluargaDeleted);
	}
}
