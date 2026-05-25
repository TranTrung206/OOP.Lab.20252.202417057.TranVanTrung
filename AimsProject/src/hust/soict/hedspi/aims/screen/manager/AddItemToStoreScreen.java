package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel formPanel; 
    public AddItemToStoreScreen(Store store, String titleHeader) {
        this.store = store;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createMenuBar());
        northPanel.add(createHeader(titleHeader));
        cp.add(northPanel, BorderLayout.NORTH);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        addFormFields(); 

        JButton btnAdd = new JButton("Add Item");
        
        JPanel centerContainer = new JPanel(new BorderLayout());
        centerContainer.add(formPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnAdd);
        centerContainer.add(buttonPanel, BorderLayout.SOUTH);

        cp.add(centerContainer, BorderLayout.CENTER);

        setTitle("Add Item To Store");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new StoreManagerScreen(store); 
            }
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader(String titleHeader) {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel(titleHeader);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    protected JTextField addTextField(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 14));
        JTextField textField = new JTextField();
        formPanel.add(label);
        formPanel.add(textField);
        return textField;
    }

    protected abstract void addFormFields();
}