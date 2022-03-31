package com.ecesari.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.oracle.truffle.js.builtins.ConsoleBuiltins;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;


@GraphWalker(value = "random(edge_coverage(100))")
public class DictionaryTest extends ExecutionContext implements Dictionary {

    private String username = "";

    @Override
    public void e_SortByPopular() {
        var sortLink = $("#topic .sub-title-container .sub-title-menu .nice-mode-toggler a");
        sortLink.click();
    }

    @Override
    public void v_Dictionary() {
        var dictionaryTitle = $("#topic #title");
        dictionaryTitle.exists();
    }

    @Override
    public void e_GoToUser() {
        var user = $("#entry-author .entry-author");
        username = user.getOwnText();
        $("#entry-author .entry-author").click();
        user.click();
    }

    @Override
    public void v_User() {
        var userTitle = $("#user-profile-title a");
        userTitle.getOwnText().contains(username);
    }

    @Override
    public void v_SharePrompt() {
        var sharePrompt = $(".entry-share ul");
        sharePrompt.has(cssClass("open"));

    }

    @Override
    public void e_SortByDate() {
        var sortLink = $("#topic .sub-title-container .sub-title-menu .nice-mode-toggler a");
        sortLink.click();
    }

    @Override
    public void e_GetEntry() {
        var entryLink = $(".entry-date");
        entryLink.click();
    }

    @Override
    public void e_OpenShare() {
        var entryShareLinkButton = $(".entry-share a");
        entryShareLinkButton.click();
    }

    @Override
    public void v_SortedByPopular() {
        var sortLabel = $("#topic .sub-title-container .sub-title-menu .nice-mode-toggler a");
        sortLabel.has(cssClass("nice-on"));
    }

    @Override
    public void v_Entry() {
        var entries = $$("#entry-item-list li");
        var entryCount = entries.stream().count();
        assert(entryCount == 1);
    }

    @Override
    public void e_Back() {
        back();
    }

    @Override
    public void e_Backv() {
        back();
    }

    @Override
    public void e_CloseShare() {
        var entryShareLinkButton = $(".entry-share a");
        entryShareLinkButton.click();
    }
}
