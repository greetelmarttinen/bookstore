package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    // injektoidaan repository
    @Autowired
    private CategoryRepository categoryRepository;

    // testi: uuden categoryn lisääminen
    @Test
    public void createNewCategory() {
        Category category = new Category("Fiction");

        categoryRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();

    }

    // testi: categoryn haku
    @Test
    public void findByCategoryName() {
        Category category = new Category("Fiction");
        categoryRepository.save(category);

        List<Category> foundCategory = categoryRepository.findByName("Fiction");
        assertThat(foundCategory).hasSize(1);
        assertThat(foundCategory.get(0).getName()).isEqualTo("Fiction");

    }

    // testi: poista category
    @Test
    public void deleteCategory() {
        Category category = new Category("Fiction");
        categoryRepository.save(category);

        categoryRepository.delete(category);

        List<Category> foundCategory = categoryRepository.findByName("Fiction");

        assertThat(foundCategory).isEmpty();

    }

}
