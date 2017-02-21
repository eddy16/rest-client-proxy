/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.proxy.client;

import com.mycompany.rest.proxy.model.Book;
import java.util.List;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author Edgar
 */
public class BookRepositoryImplResteasyProxy {

    private static final String URI_BOOK = "http://localhost:8080/book";
    private final ResteasyClient client = new ResteasyClientBuilder().build();
    private final ResteasyWebTarget  target = client.target(URI_BOOK);
    private final SimpleResteasyProxyClient simpleClient= target.proxy(SimpleResteasyProxyClient.class);
    
    
    public List<Book> getAllBooks() throws Exception {     
        return simpleClient.getAllBooks();
    }

    public Book getBook(String id) throws Exception{
        return simpleClient.getBook(id);
    }

    public Book createBook(Book book) throws Exception {
        return  simpleClient.insertBook(book);       
    }

    public Book updateBook(Book book) throws Exception {
        return simpleClient.updateBook(book);
    }

    public void deleteBook(String id) {
        simpleClient.deleteBook(id);
    }

}
