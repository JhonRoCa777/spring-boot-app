package com.example.spring_boot_server.infrastructure.config;

import com.example.spring_boot_server.domain.enums.DocumentTypeEnum;
import com.example.spring_boot_server.domain.enums.RoleEnum;
import com.example.spring_boot_server.infrastructure.adapters.ProductDAO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.spring_boot_server.infrastructure.models.ProductModel;
import com.example.spring_boot_server.infrastructure.models.UserModel;
import com.example.spring_boot_server.infrastructure.adapters.UserRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner seed(UserRepository userRepository, ProductDAO productDAO) {
        return args -> {
            if (userRepository.count() > 0) return;

            Faker faker = new Faker();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String myPass = encoder.encode("hola1234");

            UserModel jhonatan = new UserModel();
            jhonatan.setDocumentType(DocumentTypeEnum.CC);
            jhonatan.setDocument("1005772426");
            jhonatan.setNames("Jhonatan");
            jhonatan.setLastNames("Romero");
            jhonatan.setPassword(myPass);
            jhonatan.setRole(RoleEnum.ADMIN);

            UserModel stiven = new UserModel();
            stiven.setDocumentType(DocumentTypeEnum.CC);
            stiven.setDocument("1234567890");
            stiven.setNames("Stiven");
            stiven.setLastNames("Campuzano");
            stiven.setPassword(myPass);
            stiven.setRole(RoleEnum.USER);

            userRepository.saveAll(List.of(jhonatan, stiven));

            List<ProductModel> products = new ArrayList<>();

            for (UserModel user : List.of(jhonatan, stiven)) {
                for (int i = 0; i < 50; i++) {
                    ProductModel product = new ProductModel();
                    product.setName(faker.commerce().productName());
                    product.setAmount(faker.number().numberBetween(1, 100));
                    product.setPrice((float) faker.number().randomDouble(2, 1, 1000));
                    product.setCreatedById(user.getId());
                    products.add(product);
                }
            }
            productDAO.saveAll(products);
        };
    }
}