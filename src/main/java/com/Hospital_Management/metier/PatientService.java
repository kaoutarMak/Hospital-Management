package com.Hospital_Management.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Hospital_Management.controller.dto.PatientRegistrationModel;
import com.Hospital_Management.entities.Patient;

public interface PatientService {
    void create(PatientRegistrationModel registrationModel);

    //void save(EditPatientModel editPatientModel);

   // PatientViewModel getById(long id);

    Patient getByUserId(long userId);

	Page<Patient> getAll(Pageable pageable);

	void save(Patient editPatientModel);

   // EditPatientModel getEditModelByUserId(long userId);

    //PatientBasicViewModel getBasicById(long id);

   // List<PatientBasicViewModel> getPatientsByDoctorId(long doctorId);

   // Page<PatientViewModel> getPatientsByDoctorId(Pageable pageable, long doctorId);

   // Page<PatientViewModel> getAll(Pageable pageable);
}
