package com.mcbodik.travbot.actions;

import com.mcbodik.travbot.settings.Settings;
import com.sun.webkit.dom.HTMLButtonElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLInputElement;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class ActionsRunner {

    public void login(Document doc) {
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
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}
