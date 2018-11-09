package karyawan;

import java.util.List;
import java.util.Scanner;

public class Karyawan {
	private int id;
	private String nama;
	private String alamat;
	private String divisi;
	private String noHp;
	private String email;

	LogicDatabase logicDatabase = new LogicDatabase();
	List<Karyawan> karyawans;
	
	Scanner scan = new Scanner(System.in);

	public Karyawan() {

	}
	
	public Karyawan(int id) {
		this.id = id;
	}
	
	public Karyawan(int id, String nama) {
		this.id = id;
		this.nama = nama;
	}

	public Karyawan(String nama, String alamat, String divisi, String noHp, String email) {
		this.nama = nama;
		this.alamat = alamat;
		this.divisi = divisi;
		this.noHp = noHp;
		this.email = email;
	}

	public Karyawan(int id, String nama, String alamat, String divisi, String noHp, String email) {
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.divisi = divisi;
		this.noHp = noHp;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getDivisi() {
		return divisi;
	}

	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void showData() {
		karyawans = logicDatabase.showDataKaryawan();
		
		System.out.println("\n===== DATA KARYAWAN =====");
		
		for (Karyawan karyawan : karyawans) {
			System.out.println("ID     : " + karyawan.getId());
			System.out.println("Nama   : " + karyawan.getNama());
			System.out.println("Alamat : " + karyawan.getAlamat());
			System.out.println("Divisi : " + karyawan.getDivisi());
			System.out.println("No. HP : " + karyawan.getNoHp());
			System.out.println("E-mail : " + karyawan.getEmail());
			System.out.println();
		}
	}

	public void insertData() {
		System.out.println("===== INPUT DATA KARYAWAN =====");
		System.out.print("Nama : ");
		String inputNama = scan.next();
		System.out.print("Alamat : ");
		String inputAlamat = scan.next();
		System.out.print("Divisi : ");
		String inputDivisi = scan.next();
		System.out.print("No. Hp : ");
		String inputNoHp = scan.next();
		System.out.print("E-mail : ");
		String inputEmail = scan.next();

		scan.close();

		Karyawan karyawanBaru = new Karyawan(inputNama, inputAlamat, inputDivisi, inputNoHp, inputEmail);
		logicDatabase.insertData(karyawanBaru);
	}

	public void updateData() {
		System.out.println("===== EDIT DATA KARYAWAN =====");
		System.out.print("ID : ");
		int inputId = scan.nextInt();
		System.out.print("Nama : ");
		String inputNama = scan.next();
		System.out.print("Alamat : ");
		String inputAlamat = scan.next();
		System.out.print("Divisi : ");
		String inputDivisi = scan.next();
		System.out.print("No. Hp : ");
		String inputNoHp = scan.next();
		System.out.print("E-mail : ");
		String inputEmail = scan.next();

		scan.close();

		Karyawan karyawanUpdated = new Karyawan(inputId, inputNama, inputAlamat, inputDivisi, inputNoHp, inputEmail);
		logicDatabase.updateData(karyawanUpdated);
	}

	public void deleteData() {
		System.out.println("===== HAPUS DATA KARYAWAN =====");
		System.out.print("ID : ");
		int inputId = scan.nextInt();
		
		scan.close();
		
		Karyawan karyawanDeleted = new Karyawan(inputId);
		logicDatabase.deleteData(karyawanDeleted);
	}
}
