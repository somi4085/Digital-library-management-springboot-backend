package in.somi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.CategoryDTO;
import in.somi.main.dto.CreateCategoryRequestDTO;
import in.somi.main.service.CategoryService;

@RestController
@RequestMapping("/controller")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping
	public CategoryDTO createCategory(@RequestBody CreateCategoryRequestDTO dto) {
		return service.createCategory(dto);
	}
	
	@GetMapping
	public List<CategoryDTO> getAllcategory() {
		return service.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return service.getCategoryById(id);
	}
	
	@PutMapping("/{id}")
	public CategoryDTO updateCategory(@RequestBody CreateCategoryRequestDTO dto, @PathVariable Long id) {
		return service.updateCategory(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByid(@PathVariable Long id) {
		 service.deleteCategory(id);
	}
}
