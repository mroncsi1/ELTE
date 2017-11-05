package hu.elte.alkfejl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topping")
@Table(name = "TOPPINGS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topping implements ModelInterface, Serializable {

    @Id
    @Column(name = "TOPPING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "PRICE", nullable = false)
    @Getter @Setter private Integer price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "PIZZA_TOPPING", joinColumns = {
            @JoinColumn(name = "PIZZA_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "TOPPING_ID",
                    nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private List<Pizza> pizzas;
}