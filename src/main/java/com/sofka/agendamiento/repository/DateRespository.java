package com.sofka.agendamiento.repository;

import com.sofka.agendamiento.collections.Date;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRespository extends ReactiveMongoRepository<Date, String> {
}
