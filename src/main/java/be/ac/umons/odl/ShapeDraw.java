package be.ac.umons.odl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShapeDraw {
	private JPanel mainPanel;
	private JPanel drawingArea;
	private JPanel controls;
	private JRadioButton rectBtn;
	private JRadioButton squareBtn;
	private JRadioButton ellipsisBtn;
	private JRadioButton circleBtn;
	private JTextPane messageZone;

	public ShapeDraw() {
		$$$setupUI$$$();
		drawingArea.addMouseListener(new MouseAdapter() {
			private Point start;

			@Override
			public void mousePressed(MouseEvent e) {
				messageZone.setText("Mouse pressed: (" + e.getX() + ", " + e.getY() + ")");
				start = new Point(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				messageZone.setText(messageZone.getText() + "\nMouse released: (" + e.getX() + ", " + e.getY() + ")");
				Point end = new Point(e.getX(), e.getY());
				if (rectBtn.isSelected()) {
					((DrawingPanel) drawingArea).addDrawable(new Rectangle(start, end));
				} else if (squareBtn.isSelected()) {
					((DrawingPanel) drawingArea).addDrawable(new Square(start, Math.min(end.getX() - start.getX(), end.getY() - start.getY())));
				}
				else if(ellipsisBtn.isSelected()){
					((DrawingPanel) drawingArea).addDrawable (new Ellipsis(start,Math.abs(end.getX() - start.getX()), Math.abs(end.getY() - start.getY())));

				}
				else if(circleBtn.isSelected()){
					((DrawingPanel) drawingArea).addDrawable(new Circle(start,Math.abs(end.getX() - start.getX())));
				}
				drawingArea.repaint();
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("ShapeDraw");
		frame.setContentPane(new ShapeDraw().mainPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void createUIComponents() {
		drawingArea = new DrawingPanel();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		createUIComponents();
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		drawingArea.setBackground(new Color(-1));
		drawingArea.setMaximumSize(new Dimension(800, 600));
		drawingArea.setMinimumSize(new Dimension(800, 600));
		drawingArea.setPreferredSize(new Dimension(800, 600));
		mainPanel.add(drawingArea);
		controls = new JPanel();
		controls.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		controls.setMaximumSize(new Dimension(200, 600));
		controls.setMinimumSize(new Dimension(200, 600));
		controls.setPreferredSize(new Dimension(200, 600));
		mainPanel.add(controls);
		rectBtn = new JRadioButton();
		rectBtn.setMaximumSize(new Dimension(200, 52));
		rectBtn.setMinimumSize(new Dimension(200, 52));
		rectBtn.setPreferredSize(new Dimension(200, 52));
		rectBtn.setSelected(true);
		rectBtn.setText("Rectangle");
		controls.add(rectBtn);
		squareBtn = new JRadioButton();
		squareBtn.setMaximumSize(new Dimension(200, 52));
		squareBtn.setMinimumSize(new Dimension(200, 52));
		squareBtn.setPreferredSize(new Dimension(200, 52));
		squareBtn.setText("Square");
		controls.add(squareBtn);
		ellipsisBtn = new JRadioButton();
		ellipsisBtn.setMaximumSize(new Dimension(200, 52));
		ellipsisBtn.setMinimumSize(new Dimension(200, 52));
		ellipsisBtn.setOpaque(true);
		ellipsisBtn.setPreferredSize(new Dimension(200, 52));
		ellipsisBtn.setText("Ellipsis");
		controls.add(ellipsisBtn);
		circleBtn = new JRadioButton();
		circleBtn.setMaximumSize(new Dimension(200, 52));
		circleBtn.setMinimumSize(new Dimension(200, 52));
		circleBtn.setPreferredSize(new Dimension(200, 52));
		circleBtn.setText("Circle");
		controls.add(circleBtn);
		messageZone = new JTextPane();
		messageZone.setEditable(false);
		messageZone.setEnabled(true);
		messageZone.setMaximumSize(new Dimension(200, 200));
		messageZone.setMinimumSize(new Dimension(200, 200));
		messageZone.setPreferredSize(new Dimension(200, 200));
		controls.add(messageZone);
		ButtonGroup buttonGroup;
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rectBtn);
		buttonGroup.add(squareBtn);
		buttonGroup.add(ellipsisBtn);
		buttonGroup.add(circleBtn);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}
}
