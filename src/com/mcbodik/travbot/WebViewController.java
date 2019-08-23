package com.mcbodik.travbot;

import com.mcbodik.travbot.actions.Action;
import com.mcbodik.travbot.actions.ActionsRunner;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import com.mcbodik.travbot.settings.Settings;

import java.util.LinkedList;
import java.util.Queue;

public class WebViewController {
    private Action currentAction = Action.LOGIN;
    private Queue<Action> actionsQueue = new LinkedList<>();

    private ActionsRunner actionsRunner = new ActionsRunner();

    @FXML
    private WebView webView;

    @FXML
    private void initialize() {
        initActions();

        WebEngine engine = webView.getEngine();
        engine.load(Settings.getInstance().getUrl());

        Worker<Void> loadWorker = engine.getLoadWorker();
        loadWorker.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (actionsQueue.size() > 0) {
                switch (actionsQueue.peek()) {
                    case LOGIN:
                        actionsRunner.login(engine.getDocument());
                        actionsQueue.poll();
                        break;
                }
            }
        });
    }

    private void initActions() {
        actionsQueue.add(Action.LOGIN);
    }

}
