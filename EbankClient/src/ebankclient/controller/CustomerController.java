/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankclient.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ebankclient.model.Customer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CustomerController implements AbstractController<Customer, Integer> {

    private final String URL = "customer";
    private final ServiceConnector serviceConnector = new ServiceConnector();
    private final Gson gson = new Gson();

    @Override
    public void add(Customer entity) throws MalformedURLException, IOException, RuntimeException {
        String data = gson.toJson(entity);
        String path = "/add";
        serviceConnector.sentRequest(URL + path, data, "POST");
    }

    @Override
    public void update(Customer entity) throws MalformedURLException, IOException, RuntimeException {
        String data = gson.toJson(entity);
        String path = "/update";
        serviceConnector.sentRequest(URL + path, data, "PUT");
    }

    @Override
    public void delete(Customer customer) throws MalformedURLException, IOException, RuntimeException {
        String path = "/delete";        
        serviceConnector.sentRequest(URL + path, gson.toJson(customer) , "PUT");
    }

    @Override
    public Customer get(Customer customer) throws MalformedURLException, IOException, RuntimeException {
        String path = "/search";
        String data = serviceConnector.getResponse(URL + path,"PUT",gson.toJson(customer));        
        customer = gson.fromJson(data, customer.getClass());
        return customer;
    }

    @Override
    public List<Customer> getAll() throws MalformedURLException, IOException, RuntimeException {
        String path = "/getAll";
        String data = serviceConnector.getResponse(URL + path,"GET","");
        List<Customer> customers = new ArrayList<>();
        Type founderListType = new TypeToken<ArrayList<Customer>>() {
        }.getType();

        customers = gson.fromJson(data, founderListType);
        return customers;
    }
    
     

}
