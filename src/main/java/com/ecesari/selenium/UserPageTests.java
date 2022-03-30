package com.ecesari.selenium;

import com.codeborne.selenide.Condition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

@GraphWalker(value = "random(edge_coverage(100))")
public class UserPageTests extends ExecutionContext implements UserPage {

    private String biographyText = "This is my biography. Woo Hoo!";
    private String note = "This is my note.";
    private String username = "kjhaskdjhaskjdhsakj";
    @Override
    public void e_UserPage() {
        $("#top-navigation .not-mobile a").click();
    }

    @Override
    public void e_CloseBiography() {
        var closeButton = $(".modal-close");
        closeButton.click();
    }

    @Override
    public void v_BiographyPrompt() {
        var modal = $("#set-biography");
        modal.exists();
    }

    @Override
    public void e_Entry() {
        var entryLink = $("#profile-stats-section-nav li a");
        entryLink.click();
    }

    @Override
    public void v_DeletedBiography() {
        var biography = $("#profile-biography");
        biography.exists();
    }

    @Override
    public void v_UpdatedBiography() {
        var biography = $("#profile-biography div");
        biography.getOwnText().equals(biographyText);
    }

    @Override
    public void v_Entries() {
        var link = $("#profile-stats-section-nav li");
        link.has(Condition.cssClass("active"));
    }

    @Override
    public void e_OpenBiography() {
        var profileLinks = $("#profile-dots a");
        profileLinks.click();
        var biographyLink = $("#edit-bilgraphy");
        biographyLink.click();
    }

    @Override
    public void v_UserPage() {
        var profileContainer = $("#profile-top-container");
        profileContainer.exists();
        var profileTitle = $("#user-profile-title");
        var link = profileTitle.$("a");
        link.getOwnText().contains(username);
    }

    @Override
    public void e_AddNote() {
        var noteTextArea = $("#user-note");
        noteTextArea.setValue(note);
        var submitButton = $("#user-note-form button");
        submitButton.click();
    }

    @Override
    public void e_UpdateBiography() {
        var biographyTextBox = $("#editbox");
        biographyTextBox.setValue(biographyText);
        var biographySaveButton = $("#save-biography");
        biographySaveButton.click();
    }

    @Override
    public void v_NoteSaved() {
        refresh();
        var userNote = $("#user-note");
        userNote.getValue().contains(note);
    }

    @Override
    public void e_DeleteBiography() {
        var button = $("#delete-biography");
        button.click();
    }
}
