package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("colors", colorService.findAll());
		return "admin-color";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("color", colorService.findOne(id));
		return show(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		colorService.delete(id);
		return "redirect:/admin/color";
	}
	
	@PostMapping
	public String save(@ModelAttribute("category") Color color, SessionStatus status){
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color";
	}
	
}
