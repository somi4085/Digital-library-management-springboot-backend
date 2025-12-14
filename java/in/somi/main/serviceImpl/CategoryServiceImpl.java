package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.CategoryDTO;
import in.somi.main.dto.CreateCategoryRequestDTO;
import in.somi.main.entity.Category;
import in.somi.main.repository.CategoryRepository;
import in.somi.main.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public CategoryDTO createCategory(CreateCategoryRequestDTO dto) {
		Category category = new Category();
		category.setName(dto.getName());
		
		Category saved = repository.save(category);
		return mapToDO(saved);
 	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		return repository.findAll().stream().map(this::mapToDO).toList();
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {
		Category category  = repository.findById(id).orElseThrow(() -> new RuntimeException("category not found"));
		return mapToDO(category);
	}

	@Override
	public CategoryDTO updateCategory(Long id, CreateCategoryRequestDTO dto) {
		Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
		
		category.setName(dto.getName());
		
		Category updated = repository.save(category);
		return mapToDO(updated);
	}

	@Override
	public void deleteCategory(Long id) {
		 repository.deleteById(id);
	}
	
	private CategoryDTO mapToDO(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;
	}
}
