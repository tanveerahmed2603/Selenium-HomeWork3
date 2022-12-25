package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class SeleniumHomeWork3 {
    @Test
    public void homeWork3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));// for loading page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        Random randomGenerator= new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.get("https://qa.taltektc.com/");

        // Verifying if Logo is present or not
        WebElement logoElement = driver.findElement(By.xpath("//div[1][@id='wrapper']/div[1]/div/img[@class='img-responsive sidebar-logo']"));
        if(logoElement.isDisplayed() == true){
            System.out.println("Logo present");
        }else{
            System.out.println("Logo not Present");
        }


        //Creating New User
        driver.findElement(By.partialLinkText("Create")).click();

        //Fetching Sign up page Text
        WebElement element= driver.findElement(By.xpath("//form[@id='signup-form']/legend"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Sign Up");

        //Verifying Sign up page TEXT exist
        WebElement element2= driver.findElement(By.xpath("//form[@id='signup-form']/h4"));
        System.out.println(element2.getText());
        Assert.assertEquals(element2.getText(), "It's free and always will be.");

        //Filling out the form with New USER Info
        driver.findElement(By.xpath("//form[@id='signup-form']/div[3]/div[1]/input[@name='firstName']")).sendKeys("Angela");
        driver.findElement(By.xpath("//form[@id='signup-form']/div[3]/div[2]/input[@name='lastName']")).sendKeys("mehri");
        WebElement emailElement = driver.findElement(By.xpath("//form[@id='signup-form']/input[1][@name='email']"));
        emailElement.sendKeys("username"+ randomInt + "@gmail.com");
        driver.findElement(By.xpath("//form[@id='signup-form']/input[2][@name='password']")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[placeholder='Confirm Password']")).sendKeys("12345");
        WebElement el = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[1]/select[@name='month']"));
        Select select = new Select(el);
        select.selectByVisibleText("Feb");

        WebElement el1 = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[2]/select[@name='day']"));
        Select sel = new Select(el1);
        sel.selectByIndex(9);

        WebElement el2 = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[3]/select[@name='year']"));
        Select sel2 = new Select(el2);
        sel2.selectByValue("1993");

        driver.findElement(By.xpath("//form[@id='signup-form']/label[3]/input[@id='male']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/label[4]/input[@id='female']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/div[5]/input[@id='defaultCheck1']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/button[@type='submit']")).click();

        //Verifying New user has been created with SUCCESS Message and NEW USER ID
        String webElement =driver.findElement(By.xpath("//form[@id='signup-form']/div[1]/div[@class='alert alert-success']")).getText();
        System.out.println(webElement);

        //Validating New USER CREATED WITH TEXT AND ID
        if(webElement.contains("Thank you for sign up, here your id - ")){
            System.out.println("You have successfully created new account");
        }else{
            System.out.printf("ERROR!!! NEW ACCOUNT DIDN'T CREATE !!!!" );
        }
        driver.findElement(By.xpath("//div[@id='page-content-wrapper']/nav/div/ul/li[2]/a[@class='nav-link']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//form[@id='login_form']/input[1][@class='ttc_email']")).sendKeys("angelamehri@gmail.com");
        driver.findElement(By.xpath("//form[@id='login_form']/input[2][@class='ttc_password']")).sendKeys("12345");
        driver.findElement(By.xpath("//form[@id='login_form']/input[3][@class='my-login']")).click();


//        driver.close();
    }
}