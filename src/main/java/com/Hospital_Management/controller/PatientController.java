package com.Hospital_Management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Hospital_Management.controller.dto.PatientRegistrationModel;
import com.Hospital_Management.entities.Doctor;
import com.Hospital_Management.entities.Patient;
import com.Hospital_Management.entities.User;
import com.Hospital_Management.metier.DoctorService;
import com.Hospital_Management.metier.PatientService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class PatientController {
    private PatientService patientService;

    private DoctorService doctorService;

    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

	/*
	 * @GetMapping("/patient/{id}") public String getPatient(@PathVariable long id,
	 * Model model) { PatientViewModel patientViewModel =
	 * this.patientService.getById(id);
	 * 
	 * model.addAttribute("patientViewModel", patientViewModel);
	 * 
	 * return "patient/patient"; }
	 */

    //admin
    @GetMapping("/patients")
    public String getPatients(Model model, @PageableDefault(size = 8) Pageable pageable) {
        Page<Patient> patients = this.patientService.getAll(pageable);
        model.addAttribute("patients", patients);

        return "admin/listPatients";
    }

	/*
	 * @GetMapping("/doctor/patients") public String getDoctorPatients(Model
	 * model, @PageableDefault(size = 8) Pageable pageable, Authentication
	 * principal) { long userId = ((User) principal.getPrincipal()).getId(); Doctor
	 * doctor = this.doctorService.getByUserId(userId);
	 * 
	 * Page<PatientViewModel> patients =
	 * this.patientService.getPatientsByDoctorId(pageable, doctor.getId());
	 * model.addAttribute("patients", patients);
	 * 
	 * return "patient/patients"; }
	 */

    @GetMapping("/register-patient")
    public String getPatientRegister(@ModelAttribute PatientRegistrationModel patientRegistrationModel, Model model) {
       // List<DoctorSelectViewModel> doctors = this.doctorService.getAllSelect();
       // model.addAttribute("doctors", doctors);

        return "patient/register";
    }

    @PostMapping("/register-patient")
    public String registerPatient(@Valid @ModelAttribute PatientRegistrationModel patientRegistrationModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
           // List<DoctorSelectViewModel> doctors = this.doctorService.getAllSelect();
          //  model.addAttribute("doctors", doctors);

            return "patient/register";
        }

        this.patientService.create(patientRegistrationModel);

        return "redirect:/";
    }

    @GetMapping("/admin-register-patient")
    public String getPatientRegisterad(@ModelAttribute PatientRegistrationModel patientRegistrationModel, Model model) {
       // List<DoctorSelectViewModel> doctors = this.doctorService.getAllSelect();
       // model.addAttribute("doctors", doctors);

        return "admin/register-patient";
    }

    @PostMapping("/admin-register-patient")
    public String registerPatientad(@Valid @ModelAttribute PatientRegistrationModel patientRegistrationModel, BindingResult bindingResult, Model model) {
      
        this.patientService.create(patientRegistrationModel);

        return "redirect:/patients";
    }

    @GetMapping("/patient/edit")
    public String getEditPatient(Model model, Authentication principal) {
        long userId = ((User) principal.getPrincipal()).getId();

        Patient editPatientModel = this.patientService.getByUserId(userId);

        model.addAttribute("editPatientModel", editPatientModel);

        return "patient/edit";
    }

    @PostMapping("/patient/edit")
    public String editPatient(@Valid @ModelAttribute Patient editPatientModel, BindingResult bindingResult, Authentication principal) {
        if(bindingResult.hasErrors()){
            return "patient/edit";
        }

        long userId = ((User) principal.getPrincipal()).getId();
        Patient editPatientModelId = this.patientService.getByUserId(userId);
        editPatientModel.setId_patient(editPatientModelId.getId_patient());

        this.patientService.save(editPatientModel);

        return "redirect:/";
    }
    
    @GetMapping("/admin/pati-edit")
    public String getEditPatientad(Model model, Authentication principal) {
        long userId = ((User) principal.getPrincipal()).getId();

        Patient editPatientModel = this.patientService.getByUserId(userId);

        model.addAttribute("editPatientModel", editPatientModel);

        return "admin/editpa";
    }

    @PostMapping("/admin/pati-edit")
    public String editPatientad(@Valid @ModelAttribute Patient editPatientModel, BindingResult bindingResult, Authentication principal) {
        if(bindingResult.hasErrors()){
            return "patient/edit";
        }

        long userId = ((User) principal.getPrincipal()).getId();
        Patient editPatientModelId = this.patientService.getByUserId(userId);
        editPatientModel.setId_patient(editPatientModelId.getId_patient());

        this.patientService.save(editPatientModel);

        return "redirect:/";
    }
    
}
