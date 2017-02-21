/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.proxy.client;

import com.mycompany.rest.proxy.model.Book;

/**
 *
 * @author Edgar
 */
public class Application {

    public static void main(String[] args) throws Exception {

        BookRepositoryImplResteasyProxy proxy = new BookRepositoryImplResteasyProxy();

        //Lista todos los libros
        System.out.println("********Lista todos los libros*********");
        System.out.println(proxy.getAllBooks());

        //Crea uno nuevo
        System.out.println("********Crea uno nuevo*********");
        Book book = new Book();
        book.setName("Cien años de soledad");
        book.setAuthor("Gabriel García Márquez");
        Book newBook = proxy.createBook(book);

        //Obtiene nuevo registro
        System.out.println("********Obtiene nuevo registro*********");
        System.out.println(proxy.getBook(newBook.getId()));

        //Actualiza libro nuevo
        System.out.println("********Actualiza libro nuevo*********");
        newBook.setName("Del amor y otros demonios");
        Book newBook2 = proxy.updateBook(newBook);

        //Obtiene updated
        System.out.println("********Obtiene updated*********");
        System.out.println(proxy.getBook(newBook2.getId()));
        
        
        //Lista todos los libros
        System.out.println("********Lista todos los libros*********");
        System.out.println(proxy.getAllBooks());
        
        //Elimina libro
        System.out.println("********Elimina libro "+ newBook2.getId() + "*********");
        proxy.deleteBook(newBook2.getId());

        //Lista todos los libros
        System.out.println("********Lista todos los libros*********");
        System.out.println(proxy.getAllBooks());

    }
}
