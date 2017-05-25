package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.editor.BrandEditor;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.MaterialEditor;
import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Material;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.MaterialService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.CommodityValidator;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private ColorService colorService;
	 
	@Autowired
	private CategoryService categoryService;
	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	
	@ModelAttribute("commodity")
	public CommodityForm getForm(){
		return new CommodityForm();
	}
	
	@ModelAttribute("filter")
	public CommodityFilter getFilter(){
		return new CommodityFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter){
		model.addAttribute("page", commodityService.findAll(pageable, filter));
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("materials", materialService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "admin-commodity";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter){
		model.addAttribute("commodity", commodityService.findForm(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter){
		commodityService.delete(id);
		return "redirect:/admin/commodity"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("commodity") @Valid CommodityForm commodity, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		commodityService.save(commodity);
		status.setComplete();
		return "redirect:/admin/commodity"+getParams(pageable, filter);
	}
	
	private String getParams(Pageable pageable, CommodityFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer =new StringBuilder(page);
		if(!filter.getMax().isEmpty()){
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if(!filter.getMin().isEmpty()){
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if(!filter.getBrandId().isEmpty()){
			for (Integer id : filter.getBrandId()) {
				buffer.append("&brandId=");
				buffer.append(id);
			}
		}
		if(!filter.getMaterialId().isEmpty()){
			for (Integer id : filter.getMaterialId()) {
				buffer.append("&materialId=");
				buffer.append(id);
			}
		}
		if(!filter.getColorId().isEmpty()){
			for (Integer id : filter.getColorId()) {
				buffer.append("&colorId=");
				buffer.append(id);
			}
		}
		if(!filter.getCategoryId().isEmpty()){
			for (Integer id : filter.getCategoryId()) {
				buffer.append("&categoryId=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
	
}
