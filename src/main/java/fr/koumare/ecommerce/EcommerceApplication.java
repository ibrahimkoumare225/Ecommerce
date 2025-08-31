package fr.koumare.ecommerce;



import fr.koumare.ecommerce.models.Categorie;
import fr.koumare.ecommerce.models.Product;
import fr.koumare.ecommerce.services.impl.CategorieServiceImpl;
import fr.koumare.ecommerce.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor

@SpringBootApplication
public class EcommerceApplication  implements CommandLineRunner {


    private final ProductServiceImpl productService;
    private final CategorieServiceImpl categorieService;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Categorie c1 = new Categorie(null,"HighTech",null);
        Categorie c2 = new Categorie(null,"ElectroMenager",null);
        Categorie c3 = new Categorie(null,"Sanitaire",null);
        categorieService.addCategorie(c1);
        categorieService.addCategorie(c2);
        categorieService.addCategorie(c3);

        Product p1 = new Product(null, "hp",1500.0,c1);
        Product p2 = new Product(null, "samsung",700.0,c2);
        Product p3 = new Product(null, "ikea",500.0,c3);
        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
    }
}
