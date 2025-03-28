package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLModel {
    private Document document;
    
    public XMLModel() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return document;
    }

    public void addElement(Element parent, String tagName, String value, String attributeName, String attributeValue) {
        Element newElement = document.createElement(tagName);
        if (value != null && !value.isEmpty()) {
            newElement.appendChild(document.createTextNode(value));
        }
        if (attributeName != null && !attributeName.isEmpty()) {
            newElement.setAttribute(attributeName, attributeValue);
        }
        parent.appendChild(newElement);
    }

    public void updateElement(Element element, String newValue, String attributeName, String newAttributeValue) {
        if (newValue != null && !newValue.isEmpty()) {
            element.setTextContent(newValue);
        }
        if (attributeName != null && !attributeName.isEmpty()) {
            element.setAttribute(attributeName, newAttributeValue);
        }
    }

    public void deleteElement(Element element) {
        if (element != null && element.getParentNode() != null) {
            element.getParentNode().removeChild(element);
        }
    }
    public void saveToFile(String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}