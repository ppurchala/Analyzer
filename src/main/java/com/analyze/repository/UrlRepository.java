package com.analyze.repository;

import com.analyze.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hod on 05.09.18.
 */
//@RepositoryRestResource(collectionResourceRel = "urls", path = "urls")
public interface UrlRepository extends JpaRepository<Url, Long> {
}
