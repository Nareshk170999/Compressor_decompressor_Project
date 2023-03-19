package GUI;

import compressor_decompressor_acciojob.compressor;
import compressor_decompressor_acciojob.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JLabel label;
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

      label=new JLabel();

        JPanel panel = new JPanel();
        JLabel bottomLabel = new JLabel("2023 © All rights reserved.");
        bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomLabel.setBounds(1, 195, 500, 20);


        this.add(bottomLabel);

        compressButton = new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);




        decompressButton = new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);
        this.add(compressButton);
        this.add(decompressButton);

        this.setSize(500, 300);
        this.getContentPane().setBackground(Color.WHITE );
        this.setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(file);// This prints the file path to the console.
                try {
                    compressor.method(file);


                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    decompressor.method(file);
                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
}
