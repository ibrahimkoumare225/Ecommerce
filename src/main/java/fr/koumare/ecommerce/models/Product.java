package fr.koumare.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Product  {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long product_id;
    private String name;
    private Double price;
    @ManyToOne
    private Categorie categorie;

}
