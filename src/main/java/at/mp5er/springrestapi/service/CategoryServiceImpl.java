package at.mp5er.springrestapi.service;

import at.mp5er.springrestapi.api.v1.mapper.CategoryMapper;
import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(mapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return mapper.categoryToCategoryDTO(repository.findByName(name));
    }
}
