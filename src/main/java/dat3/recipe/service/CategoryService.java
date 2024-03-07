package dat3.recipe.service;
import dat3.recipe.entity.Category;
import dat3.recipe.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
  CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<String> getAllCategories() {
    List<Category> categories =  categoryRepository.findAll();
    return categories.stream().map((c)->new String(c.getName())).toList();
  }

  public String addCategory(Category request) {
    categoryRepository.save(request);
    return "Category added";
  }
}
