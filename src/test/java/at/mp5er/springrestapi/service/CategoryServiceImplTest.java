package at.mp5er.springrestapi.service;

import at.mp5er.springrestapi.api.v1.mapper.CategoryMapper;
import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.domain.Category;
import at.mp5er.springrestapi.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    private static final Long ID = 1L;
    private static final String NAME = "cat1";

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @Before
    public void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
    }

    @Test
    public void getAllCategories() {
        // given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        // when
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        // then
        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCategoryByName() {
        // given
        Category category = new Category();
        category.setId(1L);
        category.setName(NAME);
        when(categoryRepository.findByName(NAME)).thenReturn(category);

        // when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        // then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }

}