package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct( Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	   @RequestMapping(value = "/updateProduct", method = {RequestMethod.PUT, RequestMethod.GET})
	   public String update(Product product){
	       service.save(product);
	       return "redirect:/";
	   }
	
	//for popup modal id
	   @GetMapping("/getIdProduct")
	   @ResponseBody
	   public Product getId(long id){
	       Product product = service.getId(id);
	       return product;
	   }
	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
//		ModelAndView mav = new ModelAndView("edit_product");
//		
//		Product product = service.get(id);
//		mav.addObject("product", product);
//		
//		return mav;
//	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
