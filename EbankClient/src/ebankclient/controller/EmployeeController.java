/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankclient.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ebankclient.model.Employee;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EmployeeController implements AbstractController<Employee, Integer> {

    private final String URL = "employee";
    private final ServiceConnector serviceConnector = new ServiceConnector();
    private final Gson gson = new Gson();

    @Override
    public void add(Employee entity) throws MalformedURLException, IOException, RuntimeException {
        String data = gson.toJson(entity);
        String path = "/add";
        serviceConnector.sentRequest(URL + path, data, "POST");
    }

    @Override
    public void update(Employee entity) throws MalformedURLException, IOException, RuntimeException {
        String data = gson.toJson(entity);
        String path = "/update";
        serviceConnector.sentRequest(URL + path, data, "PUT");
    }

    @Override
    public void delete(Employee entity) throws MalformedURLException, IOException, RuntimeException {
        String path = "/delete";
        serviceConnector.sentRequest(URL + path, gson.toJson(entity), "PUT");
    }

    @Override
    public Employee get(Employee entity) throws MalformedURLException, IOException, RuntimeException {
        String path = "/search";
        String data = serviceConnector.getResponse(URL + path, "PUT", gson.toJson(entity));
        entity = gson.fromJson(data, entity.getClass());
        return entity;
    }

    @Override
    public List<Employee> getAll() throws MalformedURLException, IOException, RuntimeException {
        String path = "/getAll";
        String data = serviceConnector.getResponse(URL + path, "GET", "");
        List<Employee> employees = new ArrayList<>();
        Type founderListType = new TypeToken<ArrayList<Employee>>() {
        }.getType();

        employees = gson.fromJson(data, founderListType);
        return employees;
    }

    public Employee login(Employee employee) throws MalformedURLException, IOException, RuntimeException {
        String path = "/login";
        String data = serviceConnector.getResponse(URL + path, "PUT", gson.toJson(employee));
        Employee e = new Employee();
        e = gson.fromJson(data, e.getClass());
        return e;
    }

}
