package com.musinsa.assignment.urlshortener.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByPathAndSslYn(String path , Boolean sslYn);

}
