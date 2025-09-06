
package fr.koumare.ecommerce.services.impl;

import fr.koumare.ecommerce.models.Categorie;
import fr.koumare.ecommerce.repository.CategorieRepository;
import fr.koumare.ecommerce.services.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    @Override
    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void  deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        Categorie existingcategorie = categorieRepository.findById(categorie.getId()).orElseThrow(()-> new IllegalArgumentException("Categorie not found"));

        if(categorie.getDescription()!=null){
            existingcategorie.setId(categorie.getId());
        }
        return categorieRepository.save(categorie);
    }
}

