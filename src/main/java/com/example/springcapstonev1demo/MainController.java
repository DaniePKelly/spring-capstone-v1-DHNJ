package com.example.springcapstonev1demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1")   //versioning the API
public class MainController {
    public static final String VERSION_1 = "/v1";
    public static final String CUSTOMER = "/customers";
    public static final String HOME = "/homes";
    public static final String AUTO = "/auto";

    @Autowired  //wires the customerRepository
    private CustomerRepository customerRepository;
    @Autowired  //wires the homeRepository
    private HomeRepository homeRepository;
    @Autowired
    private AutoRepository autoRepository;

    @GetMapping(CUSTOMER + "/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerWithId(@PathVariable Integer id){
        return customerRepository.findById(id);
    }

    @GetMapping(path = CUSTOMER)
    public @ResponseBody
    Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //TODO add @ApiResponse paramenters
    @PostMapping(path = CUSTOMER)
    public @ResponseBody
    String addNewCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam LocalDate dateOfBirth){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setDateOfBirth(dateOfBirth);
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(CUSTOMER + "/{id}" + HOME)
    public @ResponseBody
    Iterable<Home> getHomesByCustomerWithId(@PathVariable Integer id){
        return customerRepository.findById(id).get().getHomes();
    }

 @GetMapping(path = CUSTOMER + HOME)
    public @ResponseBody
    Iterable<Home> getAllHomes(){
        return homeRepository.findAll();
    }

    @PostMapping(path = CUSTOMER + "/{id}" + HOME)
    public @ResponseBody
    String addNewHome(@PathVariable Integer id,
                      @RequestParam String description, @RequestParam int value, @RequestParam LocalDate dateBuilt){
        Home home = new Home();
        home.setDescription(description);
        home.setValue(value);
        home.setDateBuilt(dateBuilt);
        //TODO pass these in too
        home.setHeatingType(Home.HeatingType.OIL_HEATING);
        home.setLocation(Home.Location.RURAL);

        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            home.setCustomer(customer.get());
            homeRepository.save(home);

            //TODO confirm you don't have to add the home to the customer
            //customer.get().getHomes().add(home);

            return "Saved";
        } else {
            return "No customer found";
        }

    }

    @GetMapping(CUSTOMER + "/{id}" + AUTO)
    public @ResponseBody
    Iterable<Auto> getAutosByCustomerWithId(@PathVariable Integer id){
        return customerRepository.findById(id).get().getAutos();
    }

    @GetMapping(path = CUSTOMER + AUTO)
    public @ResponseBody
    Iterable<Auto> getAllAutos(){
        return autoRepository.findAll();
    }

    @PostMapping(path = CUSTOMER + "/{id}" + AUTO)
    public @ResponseBody
    String addNewAuto(@PathVariable Integer id,
                      @RequestParam String model, @RequestParam String make, @RequestParam int autoYear,
                      @RequestParam int numberOfAccidents){
        Auto auto = new Auto();
        auto.setModel(model);
        auto.setMake(make);
        auto.setAutoYear(autoYear);
        auto.setNumberOfAccidents(numberOfAccidents);


        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            auto.setCustomer(customer.get());
            autoRepository.save(auto);
            customer.get().getAutos().add(auto);

            return "Saved";
        } else {
            return "No customer found";
        }

    }


}
