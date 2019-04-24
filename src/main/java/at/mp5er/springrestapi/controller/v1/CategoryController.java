package at.mp5er.springrestapi.controller.v1;

import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.api.v1.model.CategoryListDTO;
import at.mp5er.springrestapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAll() {
        List<CategoryDTO> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(
                new CategoryListDTO(allCategories), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getByName(@PathVariable String name) {
        CategoryDTO category =  categoryService.getCategoryByName(name);
        return new ResponseEntity<>(
                category, HttpStatus.OK);
    }
}
