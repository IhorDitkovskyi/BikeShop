package ua.com.shop.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.entity.Cart;
import ua.com.shop.entity.Commodity;
import ua.com.shop.service.CommodityService;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

	@Autowired
	private CommodityService commodityService;

	@ModelAttribute("cart")
	public Cart getCart() {
		return new Cart();
	}

	@GetMapping
	public String show(Model model, @ModelAttribute("cart") Cart cart) {
		if (cart.getCommodities() == null) {
			return "user-cart";
		} else {
			double totalPrice = 0;
			for (Commodity com : cart.getCommodities()) {
				totalPrice = totalPrice + com.getPrice();
			}
			model.addAttribute("tprice", totalPrice);
			
			List<Commodity> list = new ArrayList<>();
 			for (Commodity commod : cart.getCommodities()) {
				if(!list.contains(commod))
					list.add(commod);
			}
			model.addAttribute("comm", list);
		}
		return "user-cart";
	}

	@PostMapping("/delete/{id}")
	public String deleteFromCart(Model model, @PathVariable int id,
			@ModelAttribute("cart") Cart cart) {
		cart.getCommodities().remove(commodityService.findOne(id));
		return "redirect:/cart";
	}
}
