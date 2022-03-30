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

    private String channelText = "";
    private String dictionaryText = "";
    private String searchCollectionText = "";

    @BeforeExecution
    public void setup() throws InterruptedException {
        browser = "chrome";
        open("https://eksisozluk.com/");
        Thread.sleep(1000);
    }

    @Override
    public void v_Channels() {
        $("#partial-index div h2").shouldHave(text(channelText));
    }

    @Override
    public void e_HomePage() {
        var item = $("#logo");
        item.click();
    }

    @Override
    public void e_ChooseDictionary() {
        var element = $$(".topic-list li a").stream().skip(1).findFirst().get();
        var text = element.getOwnText();
        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        $$(".topic-list li a").stream().skip(1).findFirst().get().click();
        dictionaryText = text;

    }

    @Override
    public void e_SearchEntries() {
        var textToTest = "qwerty";
        $("#search-textbox").setValue(textToTest).pressEnter();
        searchCollectionText = textToTest;
    }

//    @Override
//    public void e_LogOut() {
//        back();
//
//    }

    @Override
    public void v_Dictionary() {
        $("#content-body #topic #title").shouldHave(text(dictionaryText));
    }

    @Override
    public void v_Search() {
        $("#content-body #topic #title").shouldHave(text(searchCollectionText));
    }

    @Override
    public void v_HomePage() {
        assert (Selenide.title() == "ekşi sözlük - kutsal bilgi kaynağı");
    }

    @Override
    public void e_Login() {
        $("#top-login-link").click();
    }

    @Override
    public void e_ChooseChannel() {
        var item = $("#quick-index-nav li a");
        var text = item.getText();
        item.click();
        channelText = text;
    }

    @Override
    public void v_Login() {
        $("#content-body div").shouldHave(Condition.id("login-form-container"));
    }
}
