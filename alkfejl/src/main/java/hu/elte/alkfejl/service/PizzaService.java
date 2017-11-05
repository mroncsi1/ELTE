package hu.elte.alkfejl.service;

import hu.elte.alkfejl.model.Pizza;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class PizzaService extends AbstractService<Pizza> {
}
