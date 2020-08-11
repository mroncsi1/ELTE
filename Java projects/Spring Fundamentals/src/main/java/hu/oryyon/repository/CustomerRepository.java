package hu.oryyon.repository;

import hu.oryyon.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

}
