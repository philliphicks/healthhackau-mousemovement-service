package au.com.healthhack.controller;

import au.com.healthhack.model.Video;
import au.com.healthhack.repository.VideoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class VideoController {

    private final Logger log = LoggerFactory.getLogger(VideoController.class);
    @Autowired
    VideoDao videoDao;
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(value = "/video", method = RequestMethod.POST)
    public ResponseEntity<Video> add(@RequestBody Video video) {
        Video saved = null;
        try {
            saved = videoDao.save(video);
        } catch (Exception ex) {
            log.error("Error creating the Video: " + ex.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("Video successfully created! (id = " + video.getId() + ")");
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/video/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            videoDao.delete(videoDao.findOne(id));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting the Video:" + ex.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Video successfully deleted!", HttpStatus.OK);
    }

    @RequestMapping(value = "/video/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Video> getById(@PathVariable Long id) {
        Video found = null;
        try {
            found = videoDao.findOne(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            //VideoDTO dto = mapper.convertValue(found, VideoDTO.class);
            return new ResponseEntity<>(found, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Video>> getAll() {
        Iterable<Video> found;
        try {
            found = videoDao.findAll();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
