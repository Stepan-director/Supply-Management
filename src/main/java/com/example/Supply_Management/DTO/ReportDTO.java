package com.example.Supply_Management.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportDTO {

    private List<Map<String, Object>> data = new ArrayList<>();

  
    public void addRecord(String supplier, String product, double weight, double cost) {
        Map<String, Object> record = new HashMap<>();
        record.put("Поставщик", supplier);
        record.put("Продукт", product);
        record.put("Вес (кг)", weight);
        record.put("Стоимость (руб)", cost);
        data.add(record);
    }

    public List<Map<String, Object>> getData() {
        return data;
    }
}
