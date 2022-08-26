package com.sofka.agendamiento.utilities;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Bean
    public ModelMapper getMapper(){
        var modelMapper = new ModelMapper();
        var configuration = modelMapper.getConfiguration();
        configuration.setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}
