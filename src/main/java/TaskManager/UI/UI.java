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
    private JMenuItem itemSave;
    private JMenu menuFile;
    private ArrayList<JTextField> textFields;
    private JCheckBox checkBox;

    public UI(){
        super("Gerenciador de Tarefas");
        text_checkBoxPanel = new JPanel();
        text_checkBoxPanel.setLayout(new GridLayout(0, 1));

        //menu bar settings
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuFile);
        itemSave = new JMenuItem("save");
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSave.addActionListener(this);
        menuFile.add(itemSave);
        menuPanel.add(menuBar);


        addTextField_checkBox();

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
            //
        }else if(e.getSource() == removeButton){
            //
        }
    }

    ////Method to add text field and checkBox.
    public void addTextField_checkBox(){

    }
}
