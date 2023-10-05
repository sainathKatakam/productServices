package dev.sainath.productService;

/*import dev.sainath.productService.inheritanceDemo.singleTable.Mentor;
import dev.sainath.productService.inheritanceDemo.singleTable.Student;*/


import dev.sainath.productService.inheritanceDemo.jointable.Mentor;
import dev.sainath.productService.inheritanceDemo.jointable.MentorRepositoryJT;
import dev.sainath.productService.inheritanceDemo.jointable.Student;
import dev.sainath.productService.inheritanceDemo.jointable.StudentRepositoryJT;
import dev.sainath.productService.inheritanceDemo.tableperclass.MentorRepositoryTC;
import dev.sainath.productService.inheritanceDemo.tableperclass.StudentRepositoryTC;
import dev.sainath.productService.inheritanceDemo.tableperclass.UserRepositoryTC;
import dev.sainath.productService.models.Category;
import dev.sainath.productService.models.Price;
import dev.sainath.productService.models.Product;
import dev.sainath.productService.repositories.CategoryRepository;
import dev.sainath.productService.repositories.PriceRepository;
import dev.sainath.productService.repositories.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@Data
public class ProductServiceApplication {
/*	@Autowired
	private MentorRepositoryTC mentorRepositoryTc;
	@Autowired
	private StudentRepositoryTC studentRepositoryTC;
	@Autowired
	UserRepositoryTC userRepositoryTC;

	@Autowired
	MentorRepositoryJT mentorRepositoryJT;
	@Autowired
	StudentRepositoryJT studentRepositoryJT;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	PriceRepository priceRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {

		Mentor mentor = new Mentor();
		mentor.setName("Naman");
		mentor.setEmail("Naman@gmail.com");
		mentor.setAverageRating(4.56);
		//mentorRepositoryTc.save(mentor);

		Student s = new Student();
		s.setName("sainath");
		s.setAttendance(70);
		s.setPsp(1.24);
		//studentRepositoryTC.save(s);


	*//*	List<User> users = userRepository.findAll();
		for(User u : users){
			System.out.println(u.toString());
		}
		*//*
		mentorRepositoryJT.save(mentor);
		studentRepositoryJT.save(s);

		Category category = new Category();
		category.setName("Electronics");
		//Category savedCategory = categoryRepository.save(category);

		Price price = new Price();
		price.setCurrency("INR");
		price.setPrice(12000.00);

		//Price savedPrice = priceRepository.save(price);
		Product product = new Product();
		product.setTitle("IPhone");
		product.setDescritpion("Latest Iphone 15series");
		product.setImage("APPLE_img");

		product.setPrice(price);
		product.setCategory(category);

		Product savedProdcut =productRepository.save(product);

		List<Category> dbCategory = categoryRepository.findAll();
		for(Category c: dbCategory){
			System.out.println("Category Name :"+c.getName());
			for(Product p : c.getProducts()){
				System.out.println(p.getTitle());
			}
			System.out.println("--------");
		}
		//productRepository.deleteById(UUID.fromString("f4d613e2-c37c-47d7-9b52-c6d23ed767b5"));

	}*/
}
