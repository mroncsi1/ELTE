package hu.oryyon.repository;

import hu.oryyon.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
@Scope("singleton") // default
public class CustomerRepositoryImpl implements CustomerRepository {

    @Value("${firstname}")
    private String firstname;

    @Value("${lastname}")
    private String lastname;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();

        customer.setFirstname(firstname);
        customer.setLastname(lastname);

        customers.add(customer);

        return customers;
    }
}
