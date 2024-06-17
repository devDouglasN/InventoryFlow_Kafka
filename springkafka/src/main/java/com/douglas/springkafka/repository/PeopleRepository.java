package com.douglas.springkafka.repository;

import com.douglas.springkafka.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, String> {
}
