package com.meatup.meatup.configuration;

import com.meatup.meatup.BusinessConverter;
import com.meatup.meatup.dto.Businesses;
import com.meatup.meatup.dto.BusinessesDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Businesses, BusinessesDTO> typeMap = modelMapper.createTypeMap(Businesses.class,BusinessesDTO.class);
        typeMap.addMappings(mapping -> mapping.using(new BusinessConverter())
                .map(Businesses::getCategories,BusinessesDTO::setCategories));
        return modelMapper;
    }
}
