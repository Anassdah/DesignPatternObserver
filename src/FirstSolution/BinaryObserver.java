package FirstSolution;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class BinaryObserver extends JFrame implements Observer, ActionListener {
    private Subject subject;
    private JLabel label = new JLabel("State Binary Value : Undefined");
    private JPanel labelPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel emptyPanel = new JPanel();
    private JButton subscribe = new JButton("Subscribe-Me");
    private JButton unsubscribe = new JButton("Unsubscribe-Me");

    public BinaryObserver(Subject subject){
        super("Welcome to the Binary Observer!");
        this.subject = subject;
        this.setLayout(new FlowLayout());
        labelPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout());
        labelPanel.add(label);
        buttonPanel.add(subscribe);
        buttonPanel.add(unsubscribe);
        emptyPanel.setPreferredSize(new Dimension(300,150));
        subscribe.addActionListener(this);
        unsubscribe.addActionListener(this);
        this.add(labelPanel);
        this.add(emptyPanel);
        this.add(buttonPanel);
        this.subscribe.setEnabled(true);
        this.unsubscribe.setEnabled(false);
        this.setSize(300,300);
        this.setVisible(true);
    }

    @Override
    public void update() {
        this.getLabel().setText( "State Binary Value : "
                + Integer.toBinaryString( subject.getState() ) );
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == subscribe) {
            this.subject.subscribe(this);
            this.subscribe.setEnabled(false);
            this.unsubscribe.setEnabled(true);

        }

        else if (event.getSource() == unsubscribe) {
            this.subject.unsubscribe(this);
            this.getLabel().setText( "State Binary Value : Undefined");
            this.subscribe.setEnabled(true);
            this.unsubscribe.setEnabled(false);

        }
    }

}

