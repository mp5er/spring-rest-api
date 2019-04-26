package at.mp5er.springrestapi.bootstrap;

import at.mp5er.springrestapi.domain.Category;
import at.mp5er.springrestapi.domain.Customer;
import at.mp5er.springrestapi.repository.CategoryRepository;
import at.mp5er.springrestapi.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        loadCategories();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer frank = new Customer();
        frank.setId(1L);
        frank.setFirstname("Frank");
        frank.setLastname("Unit");

        Customer sam = new Customer();
        frank.setId(2L);
        sam.setFirstname("Sam");
        sam.setLastname("Axe");

        customerRepository.save(frank);
        customerRepository.save(sam);

        log.info("Customers loaded: " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        log.info("Categories loaded: " + categoryRepository.count());
    }
}
