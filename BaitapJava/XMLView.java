package view;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class XMLView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField tagNameField, valueField, attrNameField, attrValueField;
    private JButton addButton, updateButton, deleteButton, saveButton;
    private int selectedRow = -1; // Lưu chỉ số hàng được chọn trong JTable

    public XMLView() {
        setTitle("XML CRUD Application - JTable Version");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo JTable với các cột: Path, Tag Name, Value, Attributes
        String[] columnNames = {"Path", "Tag Name", "Value", "Attributes"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

        // Panel chứa các trường nhập liệu
        JPanel controlPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        controlPanel.add(new JLabel("Tag Name:"));
        tagNameField = new JTextField();
        controlPanel.add(tagNameField);

        controlPanel.add(new JLabel("Value:"));
        valueField = new JTextField();
        controlPanel.add(valueField);

        controlPanel.add(new JLabel("Attribute Name:"));
        attrNameField = new JTextField();
        controlPanel.add(attrNameField);

        controlPanel.add(new JLabel("Attribute Value:"));
        attrValueField = new JTextField();
        controlPanel.add(attrValueField);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        saveButton = new JButton("Save to File");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        controlPanel.add(new JLabel(""));
        controlPanel.add(buttonPanel);

        add(controlPanel, BorderLayout.SOUTH);

        // Lắng nghe sự kiện chọn hàng trong JTable
        table.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tagNameField.setText((String) tableModel.getValueAt(selectedRow, 1));
                valueField.setText((String) tableModel.getValueAt(selectedRow, 2));
                String attributes = (String) tableModel.getValueAt(selectedRow, 3);
                if (attributes != null && attributes.contains("=")) {
                    String[] attrParts = attributes.split("=");
                    if (attrParts.length == 2) {
                        attrNameField.setText(attrParts[0].trim());
                        attrValueField.setText(attrParts[1].replaceAll("[\"\\]]", "").trim());
                    }
                } else {
                    attrNameField.setText("");
                    attrValueField.setText("");
                }
            }
        });
    }

    // Cập nhật JTable từ Document
    public void updateTable(Document doc) {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<Object[]> rows = new ArrayList<>();
        buildTableRows(doc.getDocumentElement(), "", rows);
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
    }

    // Duyệt qua các node trong Document và tạo dữ liệu cho JTable
    private void buildTableRows(Node node, String parentPath, List<Object[]> rows) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            String tagName = element.getTagName();
            String path = parentPath.isEmpty() ? tagName : parentPath + "/" + tagName;
            String value = element.getChildNodes().getLength() == 1 && 
                           element.getFirstChild().getNodeType() == Node.TEXT_NODE 
                           ? element.getTextContent().trim() : "";
            StringBuilder attributes = new StringBuilder();
            NamedNodeMap attrMap = element.getAttributes();
            for (int i = 0; i < attrMap.getLength(); i++) {
                Node attr = attrMap.item(i);
                attributes.append(attr.getNodeName()).append("=\"").append(attr.getNodeValue()).append("\"");
                if (i < attrMap.getLength() - 1) attributes.append(", ");
            }

            rows.add(new Object[]{path, tagName, value, attributes.toString()});

            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                buildTableRows(children.item(i), path, rows);
            }
        }
    }

    // Các getter
    public JButton getAddButton() { return addButton; }
    public JButton getUpdateButton() { return updateButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getSaveButton() { return saveButton; }
    public String getTagName() { return tagNameField.getText(); }
    public String getValue() { return valueField.getText(); }
    public String getAttrName() { return attrNameField.getText(); }
    public String getAttrValue() { return attrValueField.getText(); }
    public String getSelectedPath() {
        if (selectedRow >= 0) {
            return (String) tableModel.getValueAt(selectedRow, 0);
        }
        return null;
    }
    public void showMessage(String message) { JOptionPane.showMessageDialog(this, message); }
}