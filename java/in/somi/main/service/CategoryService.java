package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.CategoryDTO;
import in.somi.main.dto.CreateCategoryRequestDTO;

public interface CategoryService {
	CategoryDTO createCategory(CreateCategoryRequestDTO dto);
	
	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryById(Long id);
	
	CategoryDTO updateCategory(Long id, CreateCategoryRequestDTO dto);
	
	void deleteCategory(Long id);
}
