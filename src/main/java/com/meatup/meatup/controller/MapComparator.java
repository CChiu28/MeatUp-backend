package com.meatup.meatup.controller;

import com.meatup.meatup.model.Content;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.Map;

@AllArgsConstructor
public class MapComparator implements Comparator<Map<String,Object>> {
    private String key;

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        Long firstValue = (Long) o1.get(key);
        Long secondValue = (Long) o2.get(key);
        return firstValue>secondValue ? 1 : -1;
    }
}
