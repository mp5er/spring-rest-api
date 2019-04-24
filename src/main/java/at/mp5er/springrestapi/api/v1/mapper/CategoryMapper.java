package at.mp5er.springrestapi.api.v1.mapper;

import at.mp5er.springrestapi.api.v1.model.CategoryDTO;
import at.mp5er.springrestapi.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    CategoryDTO categoryToCategoryDTO(Category category);
}
