package com.javaOOPProject.client;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

    public static String createXML(Client client){
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(Client.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(client, writer);
            System.out.println(writer.toString());
            return writer.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            return writer.toString();
        }
    }

    public static String createResponse(Client client) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("client");
            doc.appendChild(rootElement);

            // firstname elements
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(client.getUsername()));
            rootElement.appendChild(username);

            // lastname elements
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(client.getPassword()));
            rootElement.appendChild(password);

            // nickname elements
            Element permissionForCrypt = doc.createElement("permissionForCrypt");
            permissionForCrypt.appendChild(doc.createTextNode("true"));
            rootElement.appendChild(permissionForCrypt);

            // write the content into xml String
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            System.out.println(writer.getBuffer().toString());

            return writer.getBuffer().toString();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
