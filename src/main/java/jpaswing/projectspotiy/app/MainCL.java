package jpaswing.projectspotiy.app;

import jpaswing.projectspotiy.utilities.JsonConverter;
import jpaswing.projectspotiy.service.TokenRequest;
import jpaswing.projectspotiy.ui.mainUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.awt.*;


public class MainCL implements CommandLineRunner {
    private TokenRequest tokenRequest;
    private JsonConverter jsonConverter;
    @Autowired
    public MainCL(TokenRequest tokenRequest, JsonConverter jsonConverter) {
        this.tokenRequest = tokenRequest;
        this.jsonConverter = jsonConverter;
    }
    @Override
    public void run(String... args) throws Exception {
        EventQueue.invokeLater(()  ->  new mainUI(tokenRequest,jsonConverter).setVisible(true));
    }
}
