package addressbook;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Updated for Lab 4
 *
 * @author Sarah Abdallah
 * @version 2022-01-26
 */


@RepositoryRestResource(collectionResourceRel = "buddy", path="buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo,Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findByPhoneNumber(String number);
    BuddyInfo findById(long id);
    //BuddyInfo save(BuddyInfo buddy);
}
