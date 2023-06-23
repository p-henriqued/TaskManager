package TaskManager.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UI extends JFrame implements ActionListener {
    private JPanel text_checkBoxPanel;
    private JButton addButton, removeButton;
    private JMenuBar menuBar;
    private JMenuItem itemSave, itemClean;
    private JMenu menuFile;
    private ArrayList<JTextField> textFields;
    private JCheckBox checkBox;

    public UI(){
        super("Gerenciador de Tarefas");
        text_checkBoxPanel = new JPanel();
        text_checkBoxPanel.setLayout(new GridLayout(0, 1));

        //menu bar settings
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 0));
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuFile);
        itemSave = new JMenuItem("save");
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSave.addActionListener(this);
        itemClean = new JMenuItem("clean");
        itemClean.setMnemonic(KeyEvent.VK_C);
        menuFile.add(itemSave);
        menuFile.add(itemClean);
        menuPanel.add(menuBar);

        //to add fields in the window
        for(int i=0; i<8; i++){
            addTextField_checkBox();
        }

        //Buttons settings
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);

        //Windows settings
        Container container = getContentPane();
        container.add(menuPanel, BorderLayout.PAGE_START);
        container.add(text_checkBoxPanel, BorderLayout.CENTER);
        container.add(buttonsPanel, BorderLayout.SOUTH);
        setSize(800, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemSave){
            //
        }else if(e.getSource() == addButton){
            addTextField_checkBox();
        }else if(e.getSource() == removeButton){
            removeTextField_checkBox();
        }
    }

    ////Method to add text field and checkBox.
    private void addTextField_checkBox(){
        JPanel interaction_field = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkBox = new JCheckBox();
        textFields = new ArrayList<>();
        textFields.add(new JTextField(60));
        interaction_field.add(checkBox);
        textFields.forEach(textField -> interaction_field.add(textField));
        text_checkBoxPanel.add(interaction_field);
        revalidate();
        repaint();
    }
    //Method to remove the last text field and checkBox
    private void removeTextField_checkBox() {
        Integer component_count = text_checkBoxPanel.getComponentCount();
        if(component_count > 1){
            text_checkBoxPanel.remove(component_count - 1);
            revalidate();
            repaint();
        }
    }


}
