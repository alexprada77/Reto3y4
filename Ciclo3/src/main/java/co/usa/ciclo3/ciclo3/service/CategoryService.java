package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	public Optional<Category> getCategory(int id){
		return categoryRepository.findById(id);
	}
	
	public Category updateCategory(Category category) {
		if(category.getId()!=null) {
			Optional<Category> cat= getCategory(category.getId());
			if(cat.isPresent()) {
				if(category.getName()!=null) {
					cat.get().setName(category.getName());
				}
				if(category.getDescription()!=null) {
					cat.get().setDescription(category.getDescription());
				}
				return saveCategory(cat.get());
			}
		}
		return category;
	}
	
	public boolean deleteCategory(int id) {
		Optional<Category> cat= getCategory(id);
		if(cat.isPresent()) {
			categoryRepository.delete(cat.get());
			return true;
		}
		return false;
	}


}
