package at.mp5er.springrestapi.api.v1.mapper;

import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    private static final String HOHO = "hoho";
    private static final long ID = 2L;
    private CategoryMapper sut = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        // given
        Category category = new Category();
        category.setName(HOHO);
        category.setId(ID);

        // when
        CategoryDTO categoryDTO = sut.categoryToCategoryDTO(category);

        // then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(HOHO, categoryDTO.getName());
    }
}