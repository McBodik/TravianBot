package com.mcbodik.travbot.actions;

import com.sun.webkit.dom.HTMLAnchorElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLLIElement;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class ActionsHelper {

    private static final String VILLAGE_BOX_ID = "sidebarBoxVillagelist";

    public static String getActiveVillage(Document document) {
        HTMLDivElement villageListBox = (HTMLDivElement) document.getElementById(VILLAGE_BOX_ID);
        HTMLDivElement villagesList = (HTMLDivElement) villageListBox.getChildNodes().item(3).getChildNodes().item(3);

        int lengthOfVillagesList = villagesList.getChildNodes().item(1).getChildNodes().getLength();

        Node li;

        for (int i = 0; i < lengthOfVillagesList; i++) {
            li = villagesList.getChildNodes().item(1).getChildNodes().item(i);
            if (li instanceof HTMLLIElement) {
                if (li.getAttributes().item(0).getTextContent().contains("active")) {
                    return li.getChildNodes().item(1).getChildNodes().item(3).getTextContent();
                }
            }
        }

        return null;
    }
}
