package com.utility;

import com.ui.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName) {

        File xlsxFile = new File(System.getProperty("user.dir") + "/testData/"+fileName);
        XSSFWorkbook workbook = null;
        XSSFSheet sheet;
        Iterator<Row> rowIterator;
        List<User> userList= null;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User userData;
        try {
            workbook = new XSSFWorkbook(xlsxFile);
            sheet = workbook.getSheet("LoginTestData");
            rowIterator = sheet.iterator();
            userList = new ArrayList<>();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                userData = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(userData);
                workbook.close();
            }
            return userList.iterator();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
