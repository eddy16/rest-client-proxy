/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.proxy.client;

import com.mycompany.rest.proxy.model.Book;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Edgar
 */
public interface SimpleResteasyProxyClient {

    @GET
    @Consumes("application/json")
    List<Book> getAllBooks();

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    Book getBook(@PathParam("id") String id);
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    Book insertBook(Book book);

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    Book updateBook(Book book);

    @DELETE
    @Path("/{id}")
    @Consumes
    void deleteBook(@PathParam("id") String id);
}
