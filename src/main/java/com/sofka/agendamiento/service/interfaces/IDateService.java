package com.sofka.agendamiento.service.interfaces;

import com.sofka.agendamiento.collections.Date;
import com.sofka.agendamiento.utilities.MyResponseUtility;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDateService {
    Flux<Date> getAllDate();
    Mono<ResponseEntity<MyResponseUtility>> getDateById(String io);
    Mono<ResponseEntity<MyResponseUtility>> createDate(Date date);
    Mono<ResponseEntity<MyResponseUtility>> deleteDate(String id);
    Mono<ResponseEntity<MyResponseUtility>> updateDate(String id, Date date);

}
