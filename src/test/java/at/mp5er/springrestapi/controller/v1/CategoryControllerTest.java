package at.mp5er.springrestapi.controller.v1;

import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {


    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void getAllCategories() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1L);
        category1.setName("Jim");

        CategoryDTO category2 = new CategoryDTO();
        category2.setId(2L);
        category2.setName("Bob");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/v1/categories/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

    @Test
    public void getCategoryByName() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1L);
        category1.setName("Jim");

        when(categoryService.getCategoryByName(eq("Jim"))).thenReturn(category1);

        mockMvc.perform(get("/api/v1/categories/Jim")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Jim")));
    }

}