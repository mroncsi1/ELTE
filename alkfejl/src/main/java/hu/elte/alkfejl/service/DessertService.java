package hu.elte.alkfejl.service;


import hu.elte.alkfejl.model.Dessert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class DessertService extends AbstractService<Dessert> {
}