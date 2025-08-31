
package fr.koumare.ecommerce.services;

import fr.koumare.ecommerce.models.Categorie;

public interface CategorieService {

    public Categorie getCategorieById(Long id);
    public Iterable<Categorie> getAllCategories();
    public Categorie addCategorie(Categorie categorie);
    public void  deleteCategorie(Long id);
}

