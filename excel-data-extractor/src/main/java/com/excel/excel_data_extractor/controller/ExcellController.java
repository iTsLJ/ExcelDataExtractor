package com.excel.excel_data_extractor.controller;


import com.excel.excel_data_extractor.model.Person;
import com.excel.excel_data_extractor.service.ExcelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping
public class ExcellController {
    private final ExcelService excelService;

    public ExcellController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping(value = "/ExcelDataExtractor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<Person>> extract(@RequestParam MultipartFile file) {
        return ResponseEntity.ok(excelService.extract(file));
    }
}
