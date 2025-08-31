package fr.koumare.ecommerce.controller;

import fr.koumare.ecommerce.models.Product;
import fr.koumare.ecommerce.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/home")
    public String homePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("listProduct",products);
        return "dynamic/home";
    }
    @GetMapping("/products/delete/{id}")
    public  String deleteProduct(@PathVariable Long id) {
         productService.deleteProduct(id);
         return "redirect:/home";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "dynamic/forms";
    }

    @PostMapping("/home")
    public String saveProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/home";
    }

    @GetMapping("products/{id}")
    public String showUpdateProduct(@PathVariable Long id, Model model) {
        Product existProd = productService.getProductById(id);
        if(existProd!=null) {
            model.addAttribute("product", existProd);
            return "dynamic/forms";
        }
        else{
            return "redirect:/home";
        }

    }
}
