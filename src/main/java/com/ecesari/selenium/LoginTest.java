package com.ecesari.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;


@GraphWalker(value = "random(edge_coverage(100))")
public class LoginTest extends ExecutionContext implements Login {

    @BeforeExecution
    public void setup() throws InterruptedException {
        browser = "chrome";
        open("https://eksisozluk.com/");
        Thread.sleep(1000);
    }


    @Override
    public void e_LostPassword() {
        var formList = $("#login-form-container ul li");
        var lostPasswordElement = formList.$$("a").stream().filter(x -> x.text().equals("şifremi unuttum")).findFirst().get();
        lostPasswordElement.click();
    }

    @Override
    public void v_LoggedOut() {
        var loginLink = $("#top-login-link");
        loginLink.exists();
    }

    @Override
    public void e_LoginFailed() {
        var userNameField = $("#username");
        userNameField.setValue("email@email.com");
        var password = $("#password");
        password.setValue("password").pressEnter();
    }

    @Override
    public void e_LogOut() {
        var logOutButtonExists = $("#options-dropdown .dropdown-menu .separated a").exists();
        while (logOutButtonExists) {
            $("#options-dropdown a").click();
            $("#options-dropdown .dropdown-menu .separated a").click();
            logOutButtonExists = $("#options-dropdown .dropdown-menu .separated a").exists();
        }

    }

    @Override
    public void v_FailedLogin() {
        var errorField = $(".field-validation-error");
        errorField.exists();
        errorField.text().equals("hatalı kullanıcı ya da şifre, ama hangisi söylemem.");
    }

    @Override
    public void e_HomePage() {
        var item = $("#logo");
        item.click();
    }

    @Override
    public void e_Register() {
//        var formList = $("#login-form-container ul");
        var registerButton = $(By.linkText("kayıt ol"));
//        var registerButton = $("href='/kayit'");
        registerButton.click();
    }

    @Override
    public void v_Register() {
        Selenide.title().equals("kullanıcı bilgileri  - kutsal bilgi kaynağı");
    }

    @Override
    public void e_BackToLogin() {
        back();
    }

    @Override
    public void v_ResetPassword() {
        Selenide.title().equals("şifre sıfırlama süreci - kutsal bilgi kaynağı");
    }

    @Override
    public void v_LoggedIn() {
        var userPageItem = $("#top-navigation ul .not-mobile");
        userPageItem.exists();
        userPageItem.getOwnText().contains("ben");
    }

    @Override
    public void e_GoToLogin() {
        $("#top-login-link").click();
    }

    @Override
    public void v_HomePage() {
        Selenide.title().equals("ekşi sözlük - kutsal bilgi kaynağı");
    }

    @Override
    public void e_SuccessfulLogin() {
        var userNameField = $("#username");
        userNameField.setValue("bvrpcohwkieujcnbit@bvhrs.com");
        var password = $("#password");

        password.setValue("qweASD1410").pressEnter();
    }

    @Override
    public void v_Login() {
        $("#content-body div").shouldHave(Condition.id("login-form-container"));
    }
}
