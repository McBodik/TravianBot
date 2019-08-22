package com.mcbodik.travbot;

import com.sun.webkit.dom.HTMLButtonElementImpl;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLInputElement;
import com.mcbodik.travbot.settings.Settings;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class WebViewController {
    private Action action = Action.LOGIN;

    @FXML
    private WebView webView;

    @FXML
    private void initialize() {
        WebEngine engine = webView.getEngine();
        engine.load(Settings.getInstance().getUrl());



        Worker<Void> loadWorker = engine.getLoadWorker();
        loadWorker.stateProperty().addListener((observable, oldValue, newValue) -> {
            switch (action) {
                case LOGIN:
                    login(engine.getDocument());
                    break;
            }
        });
    }

    private void login(Document doc) {
        try {
            ((HTMLInputElement) XPathFactory.newInstance().newXPath().evaluate(
                    "//*[@name='name']",
                    doc,
                    XPathConstants.NODE))
                    .setValue(Settings.getInstance().getLogin());

            ((HTMLInputElement) XPathFactory.newInstance().newXPath().evaluate(
                    "//*[@name='password']",
                    doc,
                    XPathConstants.NODE))
                    .setValue(Settings.getInstance().getPassword());
            ((HTMLButtonElementImpl) doc.getElementById("s1")).click();
            System.out.println("");
        } catch (Exception e) {
        }
        action = null;
    }

    enum Action {
        LOGIN;
    }
}
