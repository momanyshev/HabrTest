package com.example.habrtest;

import com.example.habrtest.tests.MainPageTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentsManager {
    @Attachment(value = "Schreenshot", type = "image/png")
    public static byte[] schreenshot(){
        return((TakesScreenshot) MainPageTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
