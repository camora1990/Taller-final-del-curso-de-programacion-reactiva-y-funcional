package com.sofka.agendamiento.service;

import com.sofka.agendamiento.collections.Date;
import com.sofka.agendamiento.dto.UpdateDateDto;
import com.sofka.agendamiento.repository.DateRespository;
import com.sofka.agendamiento.service.interfaces.IDateService;
import com.sofka.agendamiento.utilities.MyResponseUtility;
import com.sofka.agendamiento.utilities.type_enum.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DateService implements IDateService {

    private final ModelMapper modelMapper;
    private final DateRespository dateRespository;


    @Autowired
    public DateService(DateRespository dateRespository, ModelMapper modelMapper, MyResponseUtility myResponseUtility) {
        this.dateRespository = dateRespository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Flux<Date> getAllDate() {

        return dateRespository.findAll();
    }

    @Override
    public Mono<ResponseEntity<MyResponseUtility>> getDateById(String id) {
        return dateRespository.findById(id).map(date ->
                new ResponseEntity<>(new MyResponseUtility(false, "Date", date), HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(new MyResponseUtility(true, "Date not Found"), HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Mono<ResponseEntity<MyResponseUtility>> createDate(Date date) {
        date.setState(State.ACTIVE.toString());
        return dateRespository.save(date).map(newDate->
                new ResponseEntity<>(
                        new MyResponseUtility(false,"Date created",newDate)
                        ,HttpStatus.CREATED));
    }

    @Override
    public Mono<ResponseEntity<MyResponseUtility>> deleteDate(String id) {
        return dateRespository.findById(id)
                .flatMap(deleteDate -> {
                    deleteDate.setState(State.INACTIVE.toString());
                    return dateRespository.save(deleteDate).then(Mono.just(deleteDate));
                }).map(date->new ResponseEntity<>(new MyResponseUtility(false,"Date delete",date),HttpStatus.OK)).defaultIfEmpty(
                        new ResponseEntity<>(new MyResponseUtility(true, "Date not Found"),HttpStatus.NOT_FOUND)
                );
    }

    @Override
    public Mono<ResponseEntity<MyResponseUtility>> updateDate(String id, Date date) {
        return dateRespository.findById(id)
                .flatMap(d -> {
                    modelMapper.map(date, d);
                    return dateRespository.save(d);
                }).map(dateUpdate ->
                        new ResponseEntity<>(
                                new MyResponseUtility(false, "date updated", dateUpdate), HttpStatus.OK
                        )
                ).defaultIfEmpty(
                        new ResponseEntity<>(new MyResponseUtility(true, "Date not Found"), HttpStatus.NOT_FOUND)
                );
    }
}
