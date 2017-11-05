package hu.elte.alkfejl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Pizza")
@Table(name = "PIZZAS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pizza implements ModelInterface {

    @Id
    @Column(name = "PIZZA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "SIZE", nullable = false)
    @Getter @Setter private Integer size;

    @Column(name = "PRICE", nullable = false)
    @Getter @Setter private Integer price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "PIZZA_TOPPING", joinColumns = {
            @JoinColumn(name = "TOPPING_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "PIZZA_ID",
                    nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private List<Topping> toppings;
}