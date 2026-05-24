package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class StoreScreen extends JFrame {
    private Store store;

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AIMS - Store Management System");
        setSize(1024, 768);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenu menuOptions = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menuOptions.add(smUpdateStore);
        menuOptions.add(new JMenuItem("View Cart"));
        menuOptions.add(new JMenuItem("Manage Store"));
        menuBar.add(menuOptions);

        JMenu menuHelp = new JMenu("Help");
        JMenuItem itemAbout = new JMenuItem("About Developer");
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StoreScreen.this,
                    "AIMS - Store Management System v1.0\n\n" +
                    "Developer: Trần Văn Trung\n" +
                    "Student ID: 202417057\n" +
                    "Class: HEDSPI - HUST",
                    "About Developer",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuHelp.add(itemAbout);
        menuBar.add(menuHelp);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS STORE MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.CYAN);

        JButton btnViewCart = new JButton("View Cart");
        btnViewCart.setPreferredSize(new Dimension(120, 40));
        btnViewCart.setMaximumSize(new Dimension(120, 40));

        header.add(Box.createHorizontalStrut(20));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnViewCart);
        header.add(Box.createHorizontalStrut(20));

        header.setBackground(Color.DARK_GRAY);
        header.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 15, 15)); 
        center.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            StoreItem cell = new StoreItem(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }
    public static void main(String[] args) {
        Store mockStore = new Store();
        
        for (int i = 1; i <= 7; i++) {
            mockStore.addMedia(new DigitalVideoDisc(
                i, 
                "Digital DVD Vol." + i, 
                "Sci-Fi / Animation", 
                15.50f * i, 
                "Director Studio " + i, 
                135
            ));
        }

        new StoreScreen(mockStore);
    }
}