package com.Hospital_Management.metier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital_Management.DAO.PatientRepository;
import com.Hospital_Management.controller.dto.PatientRegistrationModel;
import com.Hospital_Management.controller.dto.UserRegistrationModel;
import com.Hospital_Management.entities.Doctor;
import com.Hospital_Management.entities.Patient;
import com.Hospital_Management.entities.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	private PatientRepository patientRepository;

	private ModelMapper modelMapper;

	private UserService userService;

	private DoctorService doctorService;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper, UserService userService,
			DoctorService doctorService) {
		this.patientRepository = patientRepository;
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.doctorService = doctorService;
	}

	@Override
	public void create(PatientRegistrationModel registrationModel) {
		UserRegistrationModel userRegistrationModel = this.modelMapper.map(registrationModel,
				UserRegistrationModel.class);
		String DEFAULT_PATIENT_ROLE = "ROLE_PATIENT";
		userRegistrationModel.setAdditionalRole(DEFAULT_PATIENT_ROLE);
		User user = this.userService.register(userRegistrationModel);

		Patient patient = this.modelMapper.map(registrationModel, Patient.class);
		// patient.setInsured(registrationModel.getIsInsured() == null);
		patient.setUser(user);
		patient.setF_name(registrationModel.getFirstName());
		patient.setL_name(registrationModel.getLastName());
		// patient.setDoctor(doctor);

		this.patientRepository.saveAndFlush(patient);
	}

	@Override
	public void save(Patient editPatientModel) {
		Patient currentPatient = this.patientRepository.findById(editPatientModel.getId_patient()).get();
		Patient patient = this.modelMapper.map(editPatientModel, Patient.class);

		
		patient.setUser(currentPatient.getUser());
		//patient.setEmail(currentPatient.getEmail());
		

		this.patientRepository.saveAndFlush(patient);
	}

	/*
	 * @Override public PatientViewModel getById(long id) { Patient patient =
	 * this.patientRepository.findById(id).get();
	 * 
	 * return this.modelMapper.map(patient, PatientViewModel.class); }
	 */

	@Override
	public Patient getByUserId(long userId) {
		return this.patientRepository.findOneByUserId(userId);
	}

	/*
	 * @Override public EditPatientModel getEditModelByUserId(long userId) { Patient
	 * patient = this.patientRepository.findOneByUserId(userId);
	 * 
	 * return this.modelMapper.map(patient, EditPatientModel.class); }
	 * 
	 * @Override public PatientBasicViewModel getBasicById(long id) { Patient
	 * patient = this.patientRepository.getOne(id);
	 * 
	 * return this.modelMapper.map(patient, PatientBasicViewModel.class); }
	 */

	/*
	 * @Override public List<PatientBasicViewModel> getPatientsByDoctorId(long
	 * doctorId) { List<Patient> patients =
	 * this.patientRepository.findAllByDoctorId(doctorId);
	 * List<PatientBasicViewModel> patientBasicViewModels = new ArrayList<>(); for
	 * (Patient patient : patients) { PatientBasicViewModel patientBasicViewModel =
	 * this.modelMapper.map(patient, PatientBasicViewModel.class);
	 * patientBasicViewModels.add(patientBasicViewModel); }
	 * 
	 * return patientBasicViewModels; }
	 * 
	 * @Override public Page<PatientViewModel> getPatientsByDoctorId(Pageable
	 * pageable, long doctorId) { Page<Patient> patients =
	 * this.patientRepository.findAllByDoctorIdOrderByDateOfBirthDesc(doctorId,
	 * pageable); List<PatientViewModel> patientViewModels = new ArrayList<>(); for
	 * (Patient patient : patients) { PatientViewModel patientViewModel =
	 * this.modelMapper.map(patient, PatientViewModel.class);
	 * patientViewModels.add(patientViewModel); }
	 * 
	 * return (Page<PatientViewModel>) new PageImpl(patientViewModels, pageable,
	 * patients.getTotalElements()); }
	 * 
	 */
	@Override
	public Page<Patient> getAll(Pageable pageable) {
		Page<Patient> patients = this.patientRepository.findAll(pageable);
		List<Patient> patientViewModels = new ArrayList<>();
		for (Patient patient : patients) {
			Patient patientViewModel = this.modelMapper.map(patient, Patient.class);
			patientViewModels.add(patientViewModel);
		}

		return (Page<Patient>) new PageImpl(patientViewModels, pageable, patients.getTotalElements());
	}

}
