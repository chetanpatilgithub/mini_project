package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Dao.PatientDao;
import com.entity.Patient;

public class PatientService {
	
	PatientDao pd = new PatientDao(); 
	
	public void getpatient()throws SQLException {
		ArrayList<Patient> list = pd.fetchPatient();
		list.forEach(p -> System.out.println(p));
	}
	
	
	
}
