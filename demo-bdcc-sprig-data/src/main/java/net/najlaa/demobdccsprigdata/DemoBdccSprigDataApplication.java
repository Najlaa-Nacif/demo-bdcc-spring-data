package net.najlaa.demobdccsprigdata;

import net.najlaa.demobdccsprigdata.entities.Product;
import net.najlaa.demobdccsprigdata.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class DemoBdccSprigDataApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoBdccSprigDataApplication.class, args);
    }

    @Bean
    CommandLineRunner star(ProductRepository productRepository) {
        return args -> {
            Product p1 = new Product();
            p1.setName("Computer");
            p1.setPrice(3400);
            p1.setQuantity(2);/* constructeur sans paramaiter */
            Product p2 = new Product(null, "Printer", 1200, 13);//constructeur avec parametre
            Product p3 = Product.builder()
                    .name("smart phone")
                    .price(1300)
                    .quantity(4)
                    .build();
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);

            List<Product> products = productRepository.findAll();
            products.forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
