package au.com.healthhack.controller;

import au.com.healthhack.model.Tags;
import au.com.healthhack.repository.TagsDao;
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
public class TagsController {

    private final Logger log = LoggerFactory.getLogger(TagsController.class);
    @Autowired
    TagsDao tagsDao;

    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public ResponseEntity<Tags> add(@RequestBody Tags tags) {
        Tags saved = null;
        try {
            saved = tagsDao.save(tags);
        } catch (Exception ex) {
            log.error("Error creating the Tags: " + ex.toString());
            return new ResponseEntity<Tags>(HttpStatus.BAD_REQUEST);
        }
        log.info("Tags successfully created! (id = " + tags.getId() + ")");
        return new ResponseEntity<Tags>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            tagsDao.delete(tagsDao.findOne(id));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting the Tags:" + ex.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Tags successfully deleted!", HttpStatus.OK);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Tags> getById(@PathVariable Long id) {
        Tags found = null;
        try {
            found = tagsDao.findOne(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Tags>> getAll() {
        Iterable<Tags> found;
        try {
            found = tagsDao.findAll();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
