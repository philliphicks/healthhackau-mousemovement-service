package au.com.healthhack.controller;

import au.com.healthhack.model.Snippet;
import au.com.healthhack.repository.SnippetDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Phil on 10/15/2016.
 */
@RestController
@RequestMapping("api")
public class SnippetController {

    private final Logger log = LoggerFactory.getLogger(SnippetController.class);
    @Autowired
    SnippetDao snippetDao;

    @RequestMapping(value = "/snippet", method = RequestMethod.POST)
    public ResponseEntity<Snippet> add(@RequestBody Snippet snippet) {
        Snippet saved = null;
        try {
            saved = snippetDao.save(snippet);
        } catch (Exception ex) {
            log.error("Error creating the Snippet: " + ex.toString());
            return new ResponseEntity<Snippet>(HttpStatus.BAD_REQUEST);
        }
        log.info("Snippet successfully created! (id = " + snippet.getId() + ")");
        return new ResponseEntity<Snippet>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/snippet/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            snippetDao.delete(snippetDao.findOne(id));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting the Snippet:" + ex.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Snippet successfully deleted!", HttpStatus.OK);
    }

    @RequestMapping(value = "/snippet/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Snippet> getById(@PathVariable Long id) {
        Snippet found = null;
        try {
            found = snippetDao.findOne(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/snippets", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Snippet>> getAll() {
        Iterable<Snippet> found;
        try {
            found = snippetDao.findAll();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}