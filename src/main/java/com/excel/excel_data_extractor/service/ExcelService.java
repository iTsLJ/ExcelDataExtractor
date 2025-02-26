package com.excel.excel_data_extractor.service;

import com.excel.excel_data_extractor.model.Pessoa;
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

    public List<Pessoa> extract(MultipartFile file) {
        List<Pessoa> pessoaList = new ArrayList<>();

        try {
            Workbook workbook = new XSSFWorkbookFactory().create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    Pessoa pessoa = new Pessoa();

                    Cell nomeCell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (nomeCell != null) {
                        pessoa.setNome(nomeCell.getStringCellValue());
                    }

                    Cell idadeCell = row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (idadeCell != null && idadeCell.getCellType() == CellType.NUMERIC) {
                        pessoa.setIdade((int) idadeCell.getNumericCellValue());
                    }

                    pessoaList.add(pessoa);
                }
            }
        } catch (Exception e) {
            log.error("Erro ao extrar o arquivo excel(xlsx): {}", e.getMessage());
        }
        return pessoaList;
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

