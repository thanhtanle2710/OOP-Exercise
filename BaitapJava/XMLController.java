package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.XMLModel;
import view.XMLView;

public class XMLController implements ActionListener {
    private XMLModel model;
    private XMLView view;

    public XMLController(XMLModel model, XMLView view) {
        this.model = model;
        this.view = view;
        initializeView();
        setupListeners();
    }

    private void initializeView() {
        view.updateTable(model.getDocument());
        view.setVisible(true);
    }

    private void setupListeners() {
        view.getAddButton().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getSaveButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        if (src.equals("Add")) {
            String selectedPath = view.getSelectedPath();
            if (selectedPath == null) {
                view.showMessage("Please select a parent node in the table!");
                return;
            }

            String tagName = view.getTagName();
            String value = view.getValue();
            String attrName = view.getAttrName();
            String attrValue = view.getAttrValue();

            if (tagName.isEmpty()) {
                view.showMessage("Tag name cannot be empty!");
                return;
            }

            Element parent = findElementFromPath(selectedPath);
            if (parent != null) {
                model.addElement(parent, tagName, value, attrName, attrValue);
                view.updateTable(model.getDocument());
            } else {
                view.showMessage("Invalid parent node!");
            }
        }
        else if (src.equals("Update")) {
            String selectedPath = view.getSelectedPath();
            if (selectedPath == null) {
                view.showMessage("Please select a node to update!");
                return;
            }

            String value = view.getValue();
            String attrName = view.getAttrName();
            String attrValue = view.getAttrValue();

            Element element = findElementFromPath(selectedPath);
            if (element != null) {
                model.updateElement(element, value, attrName, attrValue);
                view.updateTable(model.getDocument());
            } else {
                view.showMessage("Invalid node for update!");
            }
        }
        else if (src.equals("Delete")) {
            String selectedPath = view.getSelectedPath();
            if (selectedPath == null) {
                view.showMessage("Please select a node to delete!");
                return;
            }

            Element element = findElementFromPath(selectedPath);
            if (element != null) {
                model.deleteElement(element);
                view.updateTable(model.getDocument());
            } else {
                view.showMessage("Invalid node for delete!");
            }
        }
        else if (src.equals("Save to File")) {
            model.saveToFile("output.xml");
            view.showMessage("Saved to output.xml");
            try {
                String content = new String(Files.readAllBytes(Paths.get("output.xml")));
                System.out.println("Nội dung file XML (output.xml):");
                System.out.println(content);
            } catch (Exception ex) {
                System.out.println("Lỗi khi đọc file XML: " + ex.getMessage());
            }
        }
    }

    private Element findElementFromPath(String path) {
        if (path == null || path.isEmpty()) return null;

        String[] parts = path.split("/");
        Node current = model.getDocument().getDocumentElement();

        // Nếu path chỉ có root, trả về ngay root
        if (parts.length == 1 && parts[0].equals(current.getNodeName())) {
            return (Element) current;
        }

        // Duyệt qua các phần của path để tìm node
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].isEmpty()) continue;
            String tagName = parts[i];
            NodeList children = ((Element) current).getElementsByTagName(tagName);
            if (children == null || children.getLength() == 0) {
                return null;
            }
            // Lấy node đầu tiên (có thể cải tiến để xử lý nhiều node cùng tên)
            current = children.item(0);
        }
        return (Element) current;
    }
}