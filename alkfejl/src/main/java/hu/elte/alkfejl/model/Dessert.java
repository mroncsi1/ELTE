package hu.elte.alkfejl.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Dessert")
@Table(name = "DESSERT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dessert implements ModelInterface {

    @Id
    @Column(name = "DESSERT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "PRICE", nullable = false)
    @Getter @Setter private Integer price;

}