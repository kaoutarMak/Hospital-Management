package com.Hospital_Management.metier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital_Management.DAO.DoctorRepository;
import com.Hospital_Management.controller.dto.DoctorRegistrationModel;
import com.Hospital_Management.controller.dto.UserRegistrationModel;
import com.Hospital_Management.entities.Departement;
import com.Hospital_Management.entities.Doctor;
import com.Hospital_Management.entities.User;
import com.Hospital_Management.entities.WeekSchedule;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	private DoctorRepository doctorRepository;

	private ModelMapper modelMapper;

	private UserService userService;
	@Autowired
	private DepartService depservice;
	@Autowired
	private WeekScheduleService weekScheduleService;

	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper, UserService userService,
			WeekScheduleService weekScheduleService) {
		this.doctorRepository = doctorRepository;
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.weekScheduleService = weekScheduleService;

	}

	@Override
	public void create(DoctorRegistrationModel registrationModel) {
		User user = this.createDoctorUser(registrationModel);
		Departement departement = depservice.get(registrationModel.getDepartement());
		WeekSchedule weekSchedule = this.weekScheduleService.createDefault();

		Doctor doctor = this.modelMapper.map(registrationModel, Doctor.class);
		doctor.setUser(user);
		doctor.setDepartement(departement);
		doctor.setWeekSchedule(weekSchedule);
//doctor.setPicture(registrationModel.getPicture());
		this.doctorRepository.saveAndFlush(doctor);
	}

	@Override
	public void save(Doctor doctor) {
		Doctor currentDoctor = this.doctorRepository.findById(doctor.getId_doc()).get();
		

		doctor.setWeekSchedule(currentDoctor.getWeekSchedule());

		doctor.setUser(currentDoctor.getUser());
		doctor.setPicture(currentDoctor.getPicture());
		this.doctorRepository.saveAndFlush(doctor);
	}

	

	@Override
	public Doctor getById(long id) {
		return this.doctorRepository.getOne(id);
	}


	@Override
	public Doctor getByUserId(long userId) {
		return this.doctorRepository.findOneByUserId(userId);
	}

	

	@Override
	public Page<Doctor> getAll(Pageable pageable) {
		Page<Doctor> doctors = this.doctorRepository.findAll(pageable);
		List<Doctor> doctorViewModels = new ArrayList<>();
		for (Doctor doctor : doctors) {
			Doctor doctorViewModel = this.modelMapper.map(doctor, Doctor.class);
			doctorViewModels.add(doctorViewModel);
		}

		return (Page<Doctor>) new PageImpl(doctorViewModels, pageable, doctors.getTotalElements());
	}

	private User createDoctorUser(DoctorRegistrationModel registrationModel) {
		UserRegistrationModel userRegistrationModel = this.modelMapper.map(registrationModel,
				UserRegistrationModel.class);
		String DEFAULT_DOCTOR_ROLE = "ROLE_DOCTOR";
		userRegistrationModel.setAdditionalRole(DEFAULT_DOCTOR_ROLE);
		return this.userService.register(userRegistrationModel);
	}

	@Override
	public List<Doctor> listDoctors() {
		return doctorRepository.findAll();
	}
	@Override
	public void delete(Long id) {
		doctorRepository.deleteById(id);
	}
}