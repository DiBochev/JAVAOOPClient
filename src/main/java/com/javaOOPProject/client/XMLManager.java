package com.javaOOPProject.client;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author fgg12
 */
public class XMLManager {

    public static String createXML(Client client) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("client");
            doc.appendChild(rootElement);

            // username element
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(client.getUsername()));
            rootElement.appendChild(username);

            // password element
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(client.getPassword()));
            rootElement.appendChild(password);

            // permissionForCrypt element
            Element permissionForCrypt = doc.createElement("permissionForCrypt");
            permissionForCrypt.appendChild(doc.createTextNode(""));
            rootElement.appendChild(permissionForCrypt);
            
            // card element
            if (client.getCardNumbers() != null) {
                for (int i = 0; i < client.getCardNumbers().size() - 1; i++) {
                    Element card = doc.createElement("card");
                    card.appendChild(doc.createTextNode(client.getCardNumbers().get(i).toString()));
                    rootElement.appendChild(card);
                }
            }else{
                Element card = doc.createElement("card");
                    card.appendChild(doc.createTextNode(""));
                    rootElement.appendChild(card);
            }
            
            // write the content into xml String
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
//            System.out.println(writer.getBuffer().toString());

            return writer.getBuffer().toString();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
