package fr.koumare.ecommerce.controller;

import fr.koumare.ecommerce.models.Categorie;
import fr.koumare.ecommerce.services.CategorieService;
import fr.koumare.ecommerce.services.impl.CategorieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CategorieController {

    public final CategorieServiceImpl categorieService;

    @GetMapping("/homeCategorie")
    public String homeCategorie(Model model) {
        List<Categorie> categorie = categorieService.getAllCategories();
        model.addAttribute("categories", categorie);
        return "dynamic/categorie/home";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategorie(@PathVariable Long id){
        categorieService.deleteCategorie(id);
        return "redirect:/homeCategorie";
    }

    @GetMapping("/categories/{id}")
    public String updateCategorie(@PathVariable Long id, Model model){

        Categorie existCategorie = categorieService.getCategorieById(id);
        if(existCategorie != null){
            model.addAttribute("categorie", existCategorie);
            return "dynamic/categorie/forms";
        }
        else{
            return "redirect:/homeCategorie";
        }

    }

    @GetMapping("/addCatgorie")
    public String addCategorie(Model model){
        model.addAttribute("categorie", new Categorie());
        return "dynamic/categorie/forms";
    }

    @PostMapping("/homeCategorie")
    public String SaveCategorie(Categorie categorie){
        categorieService.addCategorie(categorie);
        return "redirect:/homeCategorie";
    }
}
