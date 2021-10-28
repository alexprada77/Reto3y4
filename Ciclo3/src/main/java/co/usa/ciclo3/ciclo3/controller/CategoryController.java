package co.usa.ciclo3.ciclo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) 
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/all")
	public List<Category> getCategorys() {
		return categoryService.getAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category insertCategory(@RequestBody Category category) {
		try {
			System.out.println("Insertando category");
			return categoryService.saveCategory(category);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
		return categoryService.getCategory(categoryId);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category updateCategory(@RequestBody Category category) {
		try {
			return categoryService.updateCategory(category);
		} catch (Exception e) {
			return null;
		}
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteCategory(@PathVariable("id") int categoryId) {
		return categoryService.deleteCategory(categoryId);
		
	}

}
