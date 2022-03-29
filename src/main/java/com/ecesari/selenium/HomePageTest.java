package com.ecesari.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;


@GraphWalker(value = "random(edge_coverage(100))")
public class HomePageTest extends ExecutionContext implements HomePage {

    @BeforeExecution
    public void setup() throws InterruptedException {
        browser = "chrome";
        open("https://eksisozluk.com/");
        Thread.sleep(1000);
    }

    @Override
    public void v_Channels() {
        System.out.println("You are at channels");
    }

    @Override
    public void e_HomePage() {
        var item = $("#logo");
        item.click();
        assert (Selenide.title() == "ekşi sözlük - kutsal bilgi kaynağı");
    }

    @Override
    public void e_ChooseDictionary() {
        var element = $(".topic-list li a");
        element.click();
        var text = element.getOwnText().trim();
        $("#content-body #topic #title").shouldHave(text(text));

    }

    @Override
    public void e_SearchEntries() {
        var textToTest = "qwerty";
        $("#search-textbox").setValue(textToTest).pressEnter();
        $("#content-body #topic #title").shouldHave(text(textToTest));
    }

    @Override
    public void e_LogOut() {
//        $$("#options-dropdown .dropdown-menu li").stream().filter(x->x.text().equals("terk")).findFirst().get().click();
        back();

    }

    @Override
    public void v_Dictionary() {
        System.out.println("You are at dictionary");

    }

    @Override
    public void v_Search() {
        System.out.println("You are at search");

    }

    @Override
    public void v_HomePage() {
        System.out.println("You are at homepage");

    }

    @Override
    public void e_Login() {
        $("#top-login-link").click();
        $("#content-body div").shouldHave(Condition.id("login-form-container"));

    }

    @Override
    public void e_ChooseChannel() {
        var item = $("#quick-index-nav li a");
        var text = item.getText();
        item.click();
        $("#partial-index div h2").shouldHave(text(text));
    }

    @Override
    public void v_Login() {
        System.out.println("You are at login");

    }
}
