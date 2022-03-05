package com.example.spring;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/**
 * Updated for Lab 5
 * Taken from Spring Tutorial (Accessing JPA Data)
 *
 * @author Sarah Abdallah
 * @version 2022-03-04
 */
@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path = "BuddyInfo")

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer>{
}
