
package fr.koumare.ecommerce.services;

import fr.koumare.ecommerce.models.Categorie;

import java.util.List;

public interface CategorieService {

    public Categorie getCategorieById(Long id);
    public List<Categorie> getAllCategories();
    public Categorie addCategorie(Categorie categorie);
    public void  deleteCategorie(Long id);
    public Categorie updateCategorie(Categorie categorie);
}

