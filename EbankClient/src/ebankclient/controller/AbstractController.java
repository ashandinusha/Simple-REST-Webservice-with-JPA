/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankclient.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

/**
 *
 * @author DELL
 * @param <T>
 * @param <I>
 */
public interface AbstractController<T, I> extends Serializable {
    public void add(T entity)throws MalformedURLException,IOException,RuntimeException;
    public void update(T entity)throws MalformedURLException,IOException,RuntimeException;
    public void delete(T entity)throws MalformedURLException,IOException,RuntimeException;
    public T get(T entity)throws MalformedURLException,IOException,RuntimeException;
    public List<T> getAll()throws MalformedURLException,IOException,RuntimeException;
    
}
