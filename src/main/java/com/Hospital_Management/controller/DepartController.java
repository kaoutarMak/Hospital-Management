package com.Hospital_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Hospital_Management.entities.Departement;
import com.Hospital_Management.metier.DepartService;

@Controller
public class DepartController {

	@Autowired
	private DepartService departService;

	@RequestMapping("/listDepart")
	public String listDepart(Model model) {
		List<Departement> listdepart = departService.listDepart();
		model.addAttribute("listdepart", listdepart);
		return "admin/listDepart";
	}
	
	@RequestMapping("/newDepart")
	public String newDepart(Model model) {
		Departement departement = new Departement();
		model.addAttribute("departement", departement);
		return "admin/new_Depart";

	}

	@RequestMapping(value = "/saveDepart", method = RequestMethod.POST)
	public String saveDepart(@ModelAttribute("departement") Departement departement) {			
		
		departService.saveDepart(departement);
		
		return "redirect:/listDepart";
	}

	

	@RequestMapping("/edit/{id_dep}")
	public ModelAndView editDep(@PathVariable(name = "id_dep") Long id) {
		
		ModelAndView mav = new ModelAndView("admin/edit_depart");
		Departement departement = departService.get(id);
	
		mav.addObject("departement", departement);
		
		
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deletDepart(@PathVariable(name = "id") Long id) {
		departService.delete(id);
		return "redirect:/listDepart";
	}

}
