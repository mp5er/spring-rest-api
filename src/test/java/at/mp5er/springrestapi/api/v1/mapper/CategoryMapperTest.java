package at.mp5er.springrestapi.api.v1.mapper;

import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.domain.Category;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CategoryMapperTest {

    private static final String NAME = "hoho";
    private static final Long ID = 2L;
    private CategoryMapper sut = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        // given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        // when
        CategoryDTO categoryDTO = sut.categoryToCategoryDTO(category);

        // then
        assertThat(categoryDTO.getId(), is(ID));
        assertThat(categoryDTO.getName(), is(NAME));
    }
}