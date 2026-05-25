package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(cost);
        this.add(Box.createVerticalGlue());

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Window ancestor = SwingUtilities.getWindowAncestor(MediaStore.this);
                    JDialog dialog = new JDialog((Frame) ancestor, "Playing Media", true);
                    dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
                    
                    JLabel msgLabel = new JLabel("<html><center>Playing: " + media.getTitle() 
                                                + "<br>Cost: " + media.getCost() + "$</center></html>");
                    msgLabel.setFont(new Font(msgLabel.getFont().getName(), Font.PLAIN, 16));
                    dialog.add(msgLabel);
                    
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(ancestor);
                    dialog.setVisible(true);
                }
            });
            
            this.add(playButton);
            this.add(Box.createVerticalGlue());
        }

        this.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
    }
}