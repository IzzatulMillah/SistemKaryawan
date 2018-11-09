package karyawan;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://192.168.23.220:3306/database_karyawan" 
			+ "?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Jakarta";
	final String USER = "sofco";
	final String PASS = "s3234";

	private Connection connection;
	
	public Koneksi() {
		buatKoneksi();
	}
	
	public static void main(String[] args) {
		Koneksi koneksi = new Koneksi();
		koneksi.getConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void buatKoneksi() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Koneksi ke database gagal.");
		}
	}
}
