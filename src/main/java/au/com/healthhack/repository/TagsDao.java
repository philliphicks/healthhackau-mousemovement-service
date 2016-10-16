package au.com.healthhack.repository;

import au.com.healthhack.model.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Phil on 10/15/2016.
 */
@Transactional
public interface TagsDao extends CrudRepository<Tags, Long> {
}
