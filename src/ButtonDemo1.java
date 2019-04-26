import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/** An instance has two buttons, exactly one of which is always enabled. Click the enabled one and
 * the other one becomes enabled. */
public class ButtonDemo1 extends JFrame {

	/** Class invariant: exactly one of eastB and westB is enabled */
	private JButton westB= new JButton("west");
	private JButton eastB= new JButton("east");

	/** Show the GUI */
	public static void main(String[] pars) {
		ButtonDemo1 gui= new ButtonDemo1();
	}

	/** Constructor: a frame with two buttons */
	public ButtonDemo1() {
		super("ButtonDemo1");

		add(westB, BorderLayout.WEST);
		add(eastB, BorderLayout.EAST);
		westB.setEnabled(true);
		eastB.setEnabled(false);

		ActionListener al= e -> {
			boolean b= westB.isEnabled();
			eastB.setEnabled(b);
			westB.setEnabled(!b);
		};

		westB.addActionListener(al);
		eastB.addActionListener(al);
		westB.setFont(new Font("Arial", Font.PLAIN, 22));
		eastB.setFont(new Font("Arial", Font.PLAIN, 22));

		pack();
		setVisible(true);
	}

}