package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyReteyAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_ATTEMPSTS =3;
    private static int current_attempt= 1;


    @Override
    public boolean retry(ITestResult result) {
        if (current_attempt<=MAX_NUMBER_OF_ATTEMPSTS){
            current_attempt++;
            return true;
        }
        return false;
    }
}
