package com.excel.excel_data_extractor.service;

import com.excel.excel_data_extractor.model.Person;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ExcelService {

    public List<Person> extract(MultipartFile file) {
        List<Person> personList = new ArrayList<>();

        try {
            Workbook workbook = new XSSFWorkbookFactory().create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    Person person = new Person();

                    Cell nomeCell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (nomeCell != null) {
                        person.setNome(nomeCell.getStringCellValue());
                    }

                    Cell idadeCell = row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (idadeCell != null && idadeCell.getCellType() == CellType.NUMERIC) {
                        person.setIdade((int) idadeCell.getNumericCellValue());
                    }

                    personList.add(person);
                }
            }
        } catch (Exception e) {
            log.error("Error extracting excel file: {}", e.getMessage());
        }
        return personList;
    }
}
//    private String validateCell(Cell cell) {
//        return switch (cell.getCellType()){
//            case NUMERIC -> String.valueOf(BigDecimal.valueOf(cell.getNumericCellValue()));
//            case STRING -> cell.getStringCellValue();
//            case BLANK -> "";
//            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
//            default -> "[UNKNOW]";
//        };
//    }

