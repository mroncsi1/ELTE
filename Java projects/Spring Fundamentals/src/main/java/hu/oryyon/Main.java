package hu.oryyon;

import hu.oryyon.configuration.AppConfig;
import hu.oryyon.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
        System.out.println(service);

        CustomerService service2 = applicationContext.getBean("customerService", CustomerService.class);
        System.out.println(service2);

        System.out.println(service.findAll());
    }
}
