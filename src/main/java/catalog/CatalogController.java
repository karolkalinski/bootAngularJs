package catalog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CatalogController {


    private Catalog catalog = new Catalog();

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String post(String title, String authorName) {
        catalog.books.add(String.format("title: %s, uthorName: %s", title, authorName));
        return String.format("Added book %s, %s", title, authorName);
    }

/*
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/books", method = RequestMethod.GET)
    public List<String> get(String id) {
        return catalog.books;
    }
*/

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<String> get(String id) {
        return catalog.books;
    }

    class Catalog {
        List<String> books = Collections.synchronizedList(new ArrayList<>());

    }

}