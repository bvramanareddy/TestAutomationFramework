package com.ui.loginDataProviders;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson=  new Gson();
        File testDataFile = new File(System.getProperty("user.dir")+"/testData/logindata.json");
        FileReader fileReader =  new FileReader(testDataFile);
        TestData testData= gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn =  new ArrayList<>();

        for (User user: testData.getData()){
            dataToReturn.add(new Object[] {user});
        }
        return dataToReturn.iterator();

    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CSVReaderUtility.readCSVFile("logindata.csv");
    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }
}
