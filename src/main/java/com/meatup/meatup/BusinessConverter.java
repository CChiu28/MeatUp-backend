package com.meatup.meatup;

import com.meatup.meatup.dto.Categories;
import org.modelmapper.AbstractConverter;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessConverter extends AbstractConverter<List<Categories>,List<String>> {

    @Override
    protected List<String> convert(List<Categories> categories) {
        return categories.stream().map(Categories::getTitle).collect(Collectors.toList());
    }
}
