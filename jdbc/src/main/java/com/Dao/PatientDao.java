package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Patient;

public class PatientDao {

	public ArrayList<Patient> fetchPatient() throws SQLException {
		String query = "Select * from Student";
		ArrayList<Patient> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String userName = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/db1";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
			pst = con.prepareStatement(query);
			rst = pst.executeQuery();
			while (rst.next()) {
				Integer pId = rst.getInt("patientId");
				String pName = rst.getString("patientName");
				String pAddress = rst.getString("patientAddress");
				String pPhone = rst.getString("patientPhone");
				double pBill = rst.getDouble("patientBill");

				
				Patient s1 = new Patient(pId, pName, pAddress, pPhone, pBill);
				list.add(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rst.close();
			pst.close();
			con.close();
		}
		return list;

	}

}
