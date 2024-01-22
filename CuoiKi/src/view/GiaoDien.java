package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GiaoDien extends JFrame {
	private Card2 card;

	public GiaoDien() {
		setTitle("Quản lí câu lạc bộ bóng đá");
		JLabel lb_MU = new JLabel("MANCHESTER UNITED");
		;
		lb_MU.setForeground(Color.WHITE);
		// nut trang chu (chuyen qua class Card1)
		JButton bt_Trangchu = new JButton("Trang chủ");
		bt_Trangchu.setIcon(new ImageIcon(GiaoDien.class.getResource("icons8-home-21.png")));
		bt_Trangchu.setBackground(Color.BLACK);
		bt_Trangchu.setForeground(Color.WHITE);
		// nut trandau (chuyen qua class Card2)
		JButton bt_Trandau = new JButton("Trận Đấu");
		bt_Trandau.setIcon(	new ImageIcon(GiaoDien.class.getResource("icons8-battle-21.png")));
		bt_Trandau.setBackground(Color.BLACK);
		bt_Trandau.setForeground(Color.WHITE);
		// nut tim kiem(chuyen qua class TimKiem)
		JButton bt_timkiem = new JButton("Tìm Kiếm");
		bt_timkiem.setIcon(	new ImageIcon(GiaoDien.class.getResource("icons8-search-21.png")));
		bt_timkiem.setBackground(Color.BLACK);
		bt_timkiem.setForeground(Color.WHITE);
		// nút menu (chuyen qua class Card3)
		JMenuBar menubar = new JMenuBar();
		JMenu mnQL = new JMenu("Quản lí");
		mnQL.setIcon(new ImageIcon(GiaoDien.class.getResource("icons8-manage-21.png")));
		menubar.add(mnQL);
		menubar.setBackground(Color.BLACK);
		mnQL.setForeground(Color.WHITE);
		JMenuItem mnql1 = new JMenuItem("Quản lí nhân viên");
		mnql1.setBackground(Color.decode("#363636"));
		mnql1.setForeground(Color.WHITE);
		JMenuItem mnql2 = new JMenuItem("Quản lí cầu thủ");
		mnql2.setBackground(Color.decode("#363636"));
		mnql2.setForeground(Color.WHITE);
		mnQL.add(mnql1);
		mnQL.add(mnql2);

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(2, 0));
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new GridLayout(2, 0));
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		JPanel pnHeader = new JPanel();
		pnHeader.setBackground(Color.RED);
		JPanel pnsubHeader = new JPanel();
		pnsubHeader.setBackground(Color.black);
		pnsubHeader.setLayout(new GridLayout(0, 6));

		pnHeader.add(lb_MU);
		pnNorth.add(pnHeader);
		pnNorth.add(pnsubHeader);

		pnsubHeader.add(bt_Trangchu);
		pnsubHeader.add(bt_timkiem);
		pnsubHeader.add(bt_Trandau);
		pnsubHeader.add(menubar);
		
		// cardlayout chứa phần trang chủ
		CardLayout cardLayout = new CardLayout();
		JPanel cardPanel = new JPanel(cardLayout);

		Card1 cardOne = new Card1(); // Tạo instance của Card1
		cardPanel.add(cardOne, "Card1"); // Thêm Card1 vào cardPanel với tên "Card1"
		
		TimKiem timkiem = new TimKiem();
		cardPanel.add(timkiem,"TimKiem");
		Card2 cardTwo = new Card2(); // Tạo instance của Card2
		cardPanel.add(cardTwo, "Card2"); // Thêm Card2 vào cardPanel với tên "Card2"

		Card3 cardThree = new Card3(); // Tạo instance của Card3
		cardPanel.add(cardThree, "Card3"); // Thêm Card3 vào cardPanel với tên "Card3"

		Card4 cardFour = new Card4(); // Tạo instance của Card4
		cardPanel.add(cardFour, "Card4"); // Thêm Card4 vào cardPanel với tên "Card4"
		//các nút chuyển cardlayout
		bt_Trangchu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.show(cardPanel, "Card1"); // Chuyển đến Card1 khi nhấn button "Trang chủ"
			}
		});
		bt_timkiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.show(cardPanel, "TimKiem"); // Chuyển đến Card1 khi nhấn button "Trang chủ"
			}
		});

		bt_Trandau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.show(cardPanel, "Card2"); // Chuyển đến Card2 khi nhấn button "Trận Đấu"
			}
		});

		mnql1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.show(cardPanel, "Card3");
			}
		});

		mnql2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.show(cardPanel, "Card4");
			}
		});

		pnBorder.add(cardPanel, BorderLayout.CENTER); // Thêm cardPanel vào pnBorder ở vị trí mong muốn
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(pnBorder, BorderLayout.CENTER);
		pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiaoDien view = new GiaoDien();
		view.setLocationRelativeTo(null);
		view.setExtendedState(view.MAXIMIZED_BOTH);
		view.setVisible(true);
	}
}