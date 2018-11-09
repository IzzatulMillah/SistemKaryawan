package karyawan;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int pilihanUser;
		
		while(true) {
			pilihanUser = showMenu();
			detailMenu(pilihanUser);
		}
	}
	
	public static int showMenu() {
		int pilihan;
		Scanner scan = new Scanner(System.in);

		System.out.println("*** SISTEM INFORMASI KARYAWAN ***\n");
		System.out.println("1. Tampilkan Data Karyawan");
		System.out.println("2. Menambah Data Karyawan");
		System.out.println("3. Mengubah Data Karyawan");
		System.out.println("4. Menghapus Data Karyawan");
		System.out.println("5. Tampilkan Data Anggota Keluarga");
		System.out.println("6. Menambah Data Anggota Keluarga");
		System.out.println("7. Mengubah Data Anggota Keluarga");
		System.out.println("8. Menghapus Data Anggota Keluarga");
		System.out.print("--> Masukkan pilihan : ");
		
		pilihan = scan.nextInt();
		return pilihan;
	}
	
	public static void detailMenu(int pilihan) {
		Karyawan karyawan = new Karyawan();
		Keluarga keluarga = new Keluarga();
		
		switch (pilihan) {
		case 1:
			karyawan.showData();
			break;
		case 2:
			karyawan.insertData();;
			break;
		case 3:
			karyawan.updateData();;
			break;
		case 4:
			karyawan.deleteData();
			break;
		case 5:
			keluarga.showData();
			break;
		case 6:
			keluarga.insertData();
			break;
		case 7:
			keluarga.updateData();
			break;
		case 8:
			keluarga.deleteData();
			break;
		default:
			break;
		}
	}
}
