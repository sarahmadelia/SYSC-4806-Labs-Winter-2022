package pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pack.BuddyInfo;

/**
 * Updated for Lab 4
 *
 * @author Sarah Abdallah
 * @version 2022-01-26
 */


@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo,Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findByPhoneNumber(String number);
    BuddyInfo findById(long id);
}
