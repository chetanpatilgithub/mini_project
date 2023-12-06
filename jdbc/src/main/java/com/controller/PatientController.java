package com.controller;

import java.sql.SQLException;

import com.service.PatientService;

public class PatientController {

	static PatientService ps = new PatientService();

	public static void getPatient() {
		try {
			ps.getpatient();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
