package au.com.healthhack.repository;

import au.com.healthhack.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Phil on 10/15/2016.
 */
@Transactional
public interface VideoDao extends CrudRepository<Video, Long> {
}
