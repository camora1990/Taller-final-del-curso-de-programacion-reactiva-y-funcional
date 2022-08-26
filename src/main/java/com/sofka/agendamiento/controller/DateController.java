package com.sofka.agendamiento.controller;

import com.sofka.agendamiento.collections.Date;
import com.sofka.agendamiento.dto.CreateDateDto;
import com.sofka.agendamiento.dto.UpdateDateDto;
import com.sofka.agendamiento.service.DateService;
import com.sofka.agendamiento.utilities.MyResponseUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/agendamiento")
public class DateController {
    private final DateService dateService;

    private final MyResponseUtility myResponseUtility;

    private final ModelMapper mapper;
    @Autowired
    public DateController(DateService dateService, MyResponseUtility myResponseUtility, ModelMapper mapper) {
        this.dateService = dateService;
        this.myResponseUtility = myResponseUtility;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public Flux<Date> getAllDate(){
        return dateService.getAllDate();
    }

    @GetMapping( value = "/{id}")
    public Mono<ResponseEntity<MyResponseUtility>> getById(@PathVariable(name = "id") String id){
        return dateService.getDateById(id);
    }


    @PostMapping(value = "/")
    public Mono<ResponseEntity<MyResponseUtility>> creaDate( @RequestBody @Valid CreateDateDto date){

        return dateService.createDate(mapper.map(date,Date.class));
    }

    @PutMapping( value = "/{id}")
    public Mono<ResponseEntity<MyResponseUtility>> updateDate(@RequestBody @Valid UpdateDateDto date, @PathVariable(name = "id") String id){
        return dateService.updateDate(id,mapper.map(date,Date.class));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<MyResponseUtility>> deleteDate(@PathVariable(name = "id") String id){
        return dateService.deleteDate(id);
    }
}
