package com.Hospital_Management.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.Hospital_Management.controller.dto.DoctorRegistrationModel;
import com.Hospital_Management.entities.Departement;
import com.Hospital_Management.entities.Doctor;
import com.Hospital_Management.entities.User;
import com.Hospital_Management.entities.WeekSchedule;
import com.Hospital_Management.metier.DepartService;
import com.Hospital_Management.metier.DoctorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Controller
public class DoctorController {
	private DoctorService doctorService;

	@Value("${dir.images}")
	private String imageDir;
	@Autowired
	private DepartService depservice;
	private DoctorService docservice;

	@Autowired
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;

	}

	@GetMapping("/doctors/{id}")
	public String getDoctor(@PathVariable long id, Model model) {
		Doctor doctor = this.doctorService.getById(id);

		model.addAttribute("doctor", doctor);
		List<Doctor> listdoctors = docservice.listDoctors();

		model.addAttribute("listdoctors", listdoctors);
		return "doctor/doctor";
	}

	@GetMapping({ "/doctors" })
	public String getDoctors(Model model, @PageableDefault(size = 8) Pageable pageable) {
		Page<Doctor> doctors = this.doctorService.getAll(pageable);
		model.addAttribute("doctors", doctors);

		return "doctor/doctors";
	}

	@RequestMapping("/listDoctors")
	public String listDoctors(Model model, @PageableDefault(size = 8) Pageable pageable) { 
		//List<Doctor> listdoctors = docservice.listDoctors();
		Page<Doctor> listdoctors = this.doctorService.getAll(pageable);
		model.addAttribute("listdoctors", listdoctors);

		return "admin/listDoctors";
	}

	@GetMapping("/register-doctor")
	public String getDoctorRegister(@ModelAttribute DoctorRegistrationModel doctorRegistrationModel, Model model) {
		List<Departement> departements = depservice.listDepart();
		WeekSchedule weekschedule = new WeekSchedule();
		model.addAttribute("departments", departements);
		model.addAttribute("weekschedule", weekschedule);
		return "doctor/register";
	}

	/*
	 * @GetMapping("/admin-register-doctor") public String
	 * getDoctorRegisterAd(@ModelAttribute DoctorRegistrationModel
	 * doctorRegistrationModel, Model model) {
	 * 
	 * List<Departement> departements = depservice.listDepart(); WeekSchedule
	 * weekschedule = new WeekSchedule(); model.addAttribute("departments",
	 * departements); model.addAttribute("weekschedule", weekschedule); return
	 * "admin/register-doctor"; }
	 */

	/*
	 * @PostMapping("/admin-register-doctor") public String
	 * registerDoctorad(@Valid @ModelAttribute DoctorRegistrationModel
	 * doctorRegistrationModel, BindingResult bindingResult, Model
	 * model, @RequestParam(name = "photo") MultipartFile file) {
	 * 
	 * if (!(file.isEmpty())) {
	 * doctorRegistrationModel.setPicture(file.getOriginalFilename()); }
	 * 
	 * if (!(file.isEmpty())) { try {
	 * doctorRegistrationModel.setPicture(file.getOriginalFilename()); File f = new
	 * File(imageDir + doctorRegistrationModel.getL_namedoc()); file.transferTo(f);
	 * 
	 * } catch (Exception e) { e.fillInStackTrace(); }
	 * 
	 * } this.doctorService.create(doctorRegistrationModel);
	 * 
	 * return "redirect:/listDoctors"; }
	 */

	@PostMapping("/register-doctor")
	public String registerDoctor(@Valid @ModelAttribute DoctorRegistrationModel doctorRegistrationModel,
			BindingResult bindingResult, Model model, @RequestParam(name = "photo") MultipartFile file) {

		if (!(file.isEmpty())) {
			doctorRegistrationModel.setPicture(file.getOriginalFilename());
		}

		if (!(file.isEmpty())) {
			try {
				doctorRegistrationModel.setPicture(file.getOriginalFilename());
				File f = new File(imageDir + doctorRegistrationModel.getL_namedoc());
				file.transferTo(f);

			} catch (Exception e) {
				e.fillInStackTrace();
			}

		}
		this.doctorService.create(doctorRegistrationModel);

		return "redirect:/";
	}

	@RequestMapping(value = "/getPicturedoc", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPicture(String name) throws Exception, IOException {
		File fi = new File(imageDir + name);
		return IOUtils.toByteArray(new FileInputStream(fi));

	}

	@GetMapping("/admin-register-doctor")
	public String getDoctorRegisterAd(@ModelAttribute DoctorRegistrationModel doctorRegistrationModel, Model model) {

		List<Departement> departements = depservice.listDepart();
		WeekSchedule weekschedule = new WeekSchedule();
		model.addAttribute("departments", departements);
		model.addAttribute("weekschedule", weekschedule);
		return "admin/register-doctor";
	}

	@PostMapping("/admin-register-doctor")
	public String registerDoctorad(@Valid @ModelAttribute DoctorRegistrationModel doctorRegistrationModel,
			BindingResult bindingResult, Model model, @RequestParam(name = "photo") MultipartFile file) {

		if (!(file.isEmpty())) {
			doctorRegistrationModel.setPicture(file.getOriginalFilename());
		}

		if (!(file.isEmpty())) {
			try {
				doctorRegistrationModel.setPicture(file.getOriginalFilename());
				File f = new File(imageDir + doctorRegistrationModel.getL_namedoc());
				file.transferTo(f);

			} catch (Exception e) {
				e.fillInStackTrace();
			}

		}
		this.doctorService.create(doctorRegistrationModel);

		return "redirect:/listDoctors";
	}

	@GetMapping("/doctor/edit")
	public String getEditDoctor(Model model, Authentication principal) {
		List<Departement> departements = depservice.listDepart();
		model.addAttribute("departements", departements);

		long userId = ((User) principal.getPrincipal()).getId();
		Doctor editDoctorModel = this.doctorService.getByUserId(userId);

		model.addAttribute("editDoctorModel", editDoctorModel);

		return "doctor/edit";
	}

	@PostMapping("/doctor/edit")
	public String editDoctor(@Valid @ModelAttribute Doctor editDoctorModel, BindingResult bindingResult,
			Authentication principal, Model model) {
		if (bindingResult.hasErrors()) {

			return "doctor/edit";
		}

		long userId = ((User) principal.getPrincipal()).getId();
		Doctor editDoctorModelId = this.doctorService.getByUserId(userId);
		editDoctorModel.setId_doc(editDoctorModelId.getId_doc());

		this.doctorService.save(editDoctorModel);

		return "redirect:/";
	}

	@GetMapping("/admin-edit")
	public String getEditDoctorad(Model model, Authentication principal) {
		long userId = ((User) principal.getPrincipal()).getId();
		Doctor editDoctorModell = this.doctorService.getByUserId(userId);

		List<Departement> departements = depservice.listDepart();
		model.addAttribute("departements", departements);

		model.addAttribute("editDoctorModell", editDoctorModell);

		return "admin/edit";
	}

	@PostMapping("/admin-edit")
	public String editDoctorad(@Valid @ModelAttribute Doctor editDoctorModell, BindingResult bindingResult,
			Authentication principal, Model model) {

		long userId = ((User) principal.getPrincipal()).getId();
		Doctor editDoctorModelId = this.doctorService.getByUserId(userId);
		editDoctorModell.setId_doc(editDoctorModelId.getId_doc());

		this.doctorService.save(editDoctorModell);

		return "redirect:/";
	}

	@RequestMapping("/deletedoc/{id_doc}")
	public String deletDoc(@PathVariable(name = "id_doc") Long id) {
		docservice.delete(id);
		System.out.println("--------------------" + id);
		return "redirect:/listDoctors";
	}
	/*
	 * @PostMapping("/doctor/edit-picture")
	 * 
	 * @ResponseBody public String addPictures(MultipartHttpServletRequest request,
	 * Authentication principal) { Iterator<String> itr = request.getFileNames();
	 * String imageFolderPath = "C:/dabs_mm_pics/doctor_pic/";
	 * 
	 * MultipartFile picture = request.getFile(itr.next());
	 * 
	 * if (picture.isEmpty()) { return "Error"; }
	 * 
	 * this.validateEventPicture(picture);
	 * 
	 * //Generating unique random name for the picture so it wouldn't override other
	 * with the same name. UUID uniquePicName = UUID.randomUUID(); String
	 * imageFormat = FilenameUtils.getExtension(picture.getOriginalFilename());
	 * String pictureName = uniquePicName + "." + imageFormat; String filePath =
	 * imageFolderPath + pictureName; File dest = new File(filePath);
	 * 
	 * try { picture.transferTo(dest); } catch (IOException e) {
	 * e.printStackTrace(); }
	 */
	/*
	 * long userId = ((User) principal.getPrincipal()).getId(); long doctorId =
	 * this.doctorService.getByUserId(userId).getId();
	 */

	/*
	 * EditDoctorPictureModel editDoctorPictureModel = new EditDoctorPictureModel();
	 * editDoctorPictureModel.setId(doctorId);
	 * editDoctorPictureModel.setPicturePath(pictureName);
	 */

	/*
	 * this.doctorService.savePicture(editDoctorPictureModel);
	 * 
	 * return "Success"; } }
	 */
}