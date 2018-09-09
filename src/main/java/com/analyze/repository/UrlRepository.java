package com.analyze.repository;

import com.analyze.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hod on 05.09.18.
 */
//@RepositoryRestResource(collectionResourceRel = "urls", path = "urls")
public interface UrlRepository extends JpaRepository<Url, Long> {
}
