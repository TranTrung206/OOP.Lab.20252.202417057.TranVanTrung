package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");
    
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new AddBookToStoreScreen(store).setVisible(true);
            }
        });

        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCompactDiscToStoreScreen(store).setVisible(true);
            }
        });

        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ẩn màn hình chính Store đi và mở màn hình Add DVD
                dispose();
                new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
            }
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        
        center.setLayout(new GridLayout(0, 3, 20, 20));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store mockStore = new Store();

        mockStore.addMedia(new DigitalVideoDisc(1, "Harry Potter 1", "Adventure", 3.05f, "Director A", 120));
        mockStore.addMedia(new DigitalVideoDisc(4, "The Hunger Games", "Sci-Fi", 5.5f, "Director B", 140));
       
        mockStore.addMedia(new Book(2, "Harry Potter 2", "Adventure", 3.5f));
        mockStore.addMedia(new Book(5, "Catching Fire", "Sci-Fi", 4.9f));
        
        mockStore.addMedia(new CompactDisc(3, "Future Nostalgia", "Pop", 9.6f, "Director CD 1", 45, "Dua Lipa"));
        mockStore.addMedia(new CompactDisc(6, "Fetch the Bolt Cutters", "Rock", 10.39f, "Director CD 2", 50, "Fiona Apple"));

        new StoreManagerScreen(mockStore);
    }
}