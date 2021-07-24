package puzzle;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import code.OnDrag;
import code.PButton;
import code.SplashScreen;
import graphics.ToggleButton;

public class PuzzleGame extends JFrame {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleGame frame = new PuzzleGame();
					
//					SplashScreen splashScreen = new SplashScreen(frame, "Welcome to My Application");
//					splashScreen.setBackgound(Color.blue);
//					splashScreen.setProcessForeground(Color.white);
//					splashScreen.setFont(new Font("Century", Font.PLAIN, 32));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel boardPanel = null;
	private JLabel box[];
	private ImageIcon icon[];
	private JPanel board;
	private JLabel lblTotalMoves;
	private JLabel fullImg;
	private Timer timer;
	private String fullImgPath;
	private ActionButton actionButton;
	private JButton uploadBtn;
	
	public PuzzleGame() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("src\\Images\\autism_48px.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 600, 580);
		contentPane = new JPanel();
		contentPane.setInheritsPopupMenu(true);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		setLocationByPlatform(false);
		contentPane.setLayout(null);

		// set Drag event
		new OnDrag(contentPane, PuzzleGame.this);

		//variables
		JLabel exitOp = new JLabel("X");
		exitOp.setForeground(Color.WHITE);
		exitOp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PuzzleGame.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitOp.setForeground(new Color(255, 6, 7));
			}

			@Override
			public void mouseExited(MouseEvent event) {
				exitOp.setForeground(Color.white);
			}
		});
		exitOp.setFont(new Font("Consolas", Font.BOLD, 22));
		exitOp.setBounds(574, 11, 16, 22);
		contentPane.add(exitOp);

		JPanel puzzle = new JPanel();
		puzzle.setBounds(68, 111, 428, 422);
		puzzle.setBackground(new Color(0, 0, 0, 0));
		puzzle.setLayout(null);

		PButton puzzle1 = new PButton("Puzzle 1");
		
		puzzle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list1/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "src\\puzzle\\Photo\\list1\\full.jpg";
			}
		});

		puzzle1.setBounds(137, 25, 200, 42);
		puzzle1.setStartColor(Color.magenta);
		puzzle1.setEndColor(Color.blue);
		puzzle.add(puzzle1);

		PButton puzzle2 = new PButton("Puzzle 2");
		puzzle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list2/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "\\src\\puzzle\\Photo\\list2\\full.jpg";
			}

		});
		puzzle2.setBounds(137, 78, 200, 42);
		puzzle2.setStartColor(Color.magenta);
		puzzle2.setEndColor(Color.blue);
		puzzle.add(puzzle2);

		PButton puzzle3 = new PButton("Puzzle 3");
		puzzle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list3/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "src\\puzzle\\Photo\\list3\\full.jpg";
			}
		});
		puzzle3.setBounds(137, 136, 200, 42);
		puzzle3.setStartColor(Color.magenta);
		puzzle3.setEndColor(Color.blue);
		puzzle.add(puzzle3);

		PButton puzzle4 = new PButton("Puzzle 4");
		puzzle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list4/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "src\\puzzle\\Photo\\list4\\full.jpg";
			}
		});
		puzzle4.setBounds(137, 192, 200, 42);
		puzzle4.setStartColor(Color.magenta);
		puzzle4.setEndColor(Color.blue);
		puzzle.add(puzzle4);

		PButton puzzle5 = new PButton("Puzzle 5");
		puzzle5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list5/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "src\\puzzle\\Photo\\list5\\full.jpg";
			}
		});
		puzzle5.setBounds(137, 245, 200, 42);
		puzzle5.setStartColor(Color.magenta);
		puzzle5.setEndColor(Color.blue);
		puzzle.add(puzzle5);

		PButton puzzle6 = new PButton("Puzzle 6");
		puzzle6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				// Refresh image
				actionButton.refresh();
				for (int i = 0; i < icon.length; i++) {
					icon[i] = new ImageIcon(
							"src/puzzle/Photo/list6/" + (1 + i) + ".jpg");
					box[i].setIcon(icon[i]);
				}
				fullImgPath = "src\\puzzle\\Photo\\list6\\full.jpg";
			}
		});
		puzzle6.setBounds(137, 302, 200, 42);
		puzzle6.setStartColor(Color.magenta);
		puzzle6.setEndColor(Color.blue);
		puzzle.add(puzzle6);

		contentPane.add(puzzle);
		
		PButton puzzle7 = new PButton("New Puzzle");
		puzzle7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzle.setVisible(false);
				boardPanel.setVisible(true);
				for(int i = 0 ; i < 9; i++) {
					box[i].setVisible(false);
				}
				
				uploadBtn = new JButton("Upload Your Image");
				uploadBtn.setBounds(85, 135, 130, 30);
				uploadBtn.setBackground(Color.white);
				uploadBtn.setFocusable(true);
				board.add(uploadBtn);
				uploadBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
						/*FileFilter filter = new FileFilter() {
							@Override
							public boolean accept(File pathname) {
								return pathname.getPath().endsWith(".png") || pathname.getPath().endsWith(".jpg") || pathname.getPath().endsWith(".bmp") ;
							}
							@Override
							public String getDescription() {
								return null;
							}
						};  */
						
						FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("JPG & GIF  Images", "jpg", "png", "gif");
						fileChooser.setFileFilter(fileFilter);
						
						fileChooser.showDialog(PuzzleGame.this, "Select Your Image");
						File file = fileChooser.getSelectedFile();
						
						BufferedImage img = null;
						try {
							img = ImageIO.read(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						BufferedImage bimg = resizeImage(img, 400, 400, BufferedImage.TYPE_INT_ARGB);
						bImage = cropImage(bimg, 0, 0, 300, 300, "");
						BufferedImage cropImg;
						
						JLabel label1 = new JLabel(new ImageIcon(bImage));
						label1.setBounds(0, 0, 300, 300);
						int []locX = { 0, 100, 200, 0, 100, 200, 0, 100, 200 }, locY = { 0, 0, 0, 100, 100, 100, 200, 200, 200 };

						for (int i = 0; i < 9; i++) {
							cropImg = cropImage(bImage, (int)locX[i], locY[i], 100, 100, (i + 1)+"");							
							box[i].setIcon(new ImageIcon(cropImg));
						}
						
						// 
						for(int i = 0 ; i < 8; i++) {
							box[i].setVisible(true);
						}

						
						fullImgPath = "";
						System.out.println("Upload button "+file.getPath());
						
						uploadBtn.setVisible(false);
						board.repaint();
						board.revalidate();
					}
				});
			}
		});
		puzzle7.setBounds(137, 355, 200, 42);
		puzzle7.setStartColor(Color.magenta);
		puzzle7.setEndColor(Color.blue);
		puzzle.add(puzzle7);

		Font font = new Font("century", Font.PLAIN, 18);
		puzzle1.setFont(font);
		puzzle2.setFont(font);
		puzzle3.setFont(font);
		puzzle4.setFont(font);
		puzzle5.setFont(font);
		puzzle6.setFont(font);
		puzzle7.setFont(font);
		
//		// Board
//		ToggleButton toggleButton = new ToggleButton() {
//
//			@Override
//			public void onFunction() {
//				super.onFunction();
//				g2d.setColor(new Color(255, 0, 0));
//			}
//
//			@Override
//			public void offFunction() {
//				super.offFunction();
//				g2d.setColor(new Color(255, 0, 0, 0));
//			}
//		};
		
	
		boardPanel = new JPanel();
		boardPanel.setVisible(false);
		boardPanel.setAutoscrolls(true);
		boardPanel.setLayout(null);
		boardPanel.setBackground(new Color(255, 255, 255));
		boardPanel.setBounds(40, 111, 495, 379);
		contentPane.add(boardPanel);
		boardPanel.validate();
		
//		toggleButton.setLocation(340, 10);
//		toggleButton.setOn(boardPanel);
		
		board = new JPanel();
		board.setBounds(110, 43, 301, 301);
		boardPanel.add(board);
		board.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		board.setLayout(null);

		JLabel lblRefresh = new JLabel("");
		lblRefresh.setToolTipText("Refresh");
		lblRefresh.setBackground(new Color(255, 255, 255));
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRefresh.setIcon(
						new ImageIcon("src\\Image\\refresh_24px.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				lblRefresh.setIcon(
						new ImageIcon("src\\Images\\refreshblue.png"));
			}
		});
		lblRefresh.setIcon(new ImageIcon("src\\Images\\refreshblue.png"));
		lblRefresh.setBounds(248, 354, 30, 25);
		boardPanel.add(lblRefresh);

		// board
		box = new JLabel[9];
		icon = new ImageIcon[9];
		int []locX = { 0, 100, 200, 0, 100, 200, 0, 100, 200 }, locY = { 0, 0, 0, 100, 100, 100, 200, 200, 200 };

		for (int i = 0; i < icon.length; i++) {
			box[i] = new JLabel();
			// add label name for ActionButton class
			box[i].setName("b" + i);
			box[i].setSize(100, 100);
			box[i].setBorder(new MatteBorder(1, 1, 1, 1, Color.blue));
			box[i].setLocation(locX[i], locY[i]);
		}

		for (int i = 0; i < box.length; i++)
			board.add(box[i]);
		
		// Last image
		box[8].setVisible(false);

		// board End
		JLabel backButton = new JLabel();
		backButton.setIconTextGap(0);
		backButton.setToolTipText("Back buton");
		backButton.setBackground(new Color(255, 255, 255));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				actionButton.refresh();
				
				puzzle.setVisible(true);
				boardPanel.setVisible(false);
				
				if(uploadBtn != null) {
					// crop image game
					for(int i = 0 ; i < 8; i++) {
						box[i].setVisible(true);
					}
					board.remove(uploadBtn);
					board.repaint();
					board.revalidate();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(
						new ImageIcon("src\\Images\\backRedimg.png"));
			}

			@Override
			public void mouseExited(MouseEvent event) {
				backButton
						.setIcon(new ImageIcon("src\\Images\\backImg.png"));
			}
		});

		backButton.setIcon(new ImageIcon("src\\Images\\backImg.png"));
		backButton.setBounds(0, 164, 48, 48);
		boardPanel.add(backButton);

		lblTotalMoves = new JLabel("Total Moves : 0");
		lblTotalMoves.setBackground(Color.WHITE);
		lblTotalMoves.setForeground(Color.BLUE);
		lblTotalMoves.setFont(new Font("Consolas", Font.BOLD, 18));
		lblTotalMoves.setBounds(110, 22, 175, 25);
		boardPanel.add(lblTotalMoves);

		//
		JLabel lblPhotoPuzzleGame = new JLabel("PHOTO PUZZLE GAME");
		lblPhotoPuzzleGame.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
		lblPhotoPuzzleGame.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPhotoPuzzleGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoPuzzleGame.setForeground(Color.BLUE);
		lblPhotoPuzzleGame.setFont(new Font("Consolas", Font.BOLD, 32));
		lblPhotoPuzzleGame.setBounds(25, 11, 495, 62);
		contentPane.add(lblPhotoPuzzleGame);

		JLabel lblDevelopedBy = new JLabel("Developed By : Om prakash kumar");
		lblDevelopedBy.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedBy.setForeground(Color.BLUE);
		lblDevelopedBy.setFont(new Font("Consolas", Font.BOLD, 19));
		lblDevelopedBy.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLUE));
		lblDevelopedBy.setBounds(68, 533, 467, 62);
		contentPane.add(lblDevelopedBy);


		JLabel winLabel = new JLabel("");
		winLabel.setBounds(141, 489, 310, 30);
		contentPane.add(winLabel);
		winLabel.setBackground(Color.WHITE);
		winLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		winLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winLabel.setForeground(Color.RED);
		winLabel.setFont(new Font("Consolas", Font.BOLD, 19));

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		backgroundImg.setIcon(new ImageIcon("src\\Images\\puzzle1.jpg"));
		backgroundImg.setBounds(0, 0, 600, 580);
		contentPane.add(backgroundImg);

		// ADD ACTION ON buttons
		actionButton = new ActionButton();
		actionButton.addButton(box);
		actionButton.addRefreshButton(lblRefresh);
		actionButton.addMoveLabel(lblTotalMoves);

		JLabel lblView = new JLabel("");
		lblView.setToolTipText("show full image");
		lblView.setIcon(new ImageIcon("src\\Images\\hide_24px.png"));
		
		
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < box.length - 1; i++) {
					 box[i].setVisible(true);
				}
				 fullImg.setVisible(false);
				 timer.stop();
			}
		};
		
		lblView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    timer = new Timer(3000, action);

			    try {
			    	if(!fullImgPath.equals(""))
			    		bufferedImage = ImageIO.read(new File(fullImgPath));
			    	else
			    		bufferedImage = bImage;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			    
//			    fullImg = new JLabel(new ImageIcon(fullImgPath));
			    fullImg = new JLabel(new ImageIcon(bufferedImage));
			    
				fullImg.setBounds(0, 0, 300, 300);
				board.add(fullImg);
				fullImg.setVisible(true);

				for (int i = 0; i < box.length - 1; i++) {
					box[i].setVisible(false);
				}
			
				timer.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblView.setIcon(new ImageIcon("src\\Images\\hide_24red.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblView.setIcon(new ImageIcon("src\\Images\\hide_24px.png"));
			}
			
		});
		
		lblView.setBounds(288, 355, 46, 24);
		boardPanel.add(lblView);
		actionButton.addWinLabel(winLabel);

		contentPane.validate();
		this.validate();
	}
	
	private BufferedImage bufferedImage, bImage;
	Graphics2D g2d;
	
	private BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int w, int h, String str) {
		BufferedImage reImag = bufferedImage.getSubimage(x, y, w, h);
		g2d = reImag.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Century", Font.BOLD, 20));
		g2d.setColor(Color.red);
		g2d.drawString(str, 48, 48);
//		g2d.dispose();
		return reImag;
	}
		
	private BufferedImage resizeImage(BufferedImage bImg, int  w, int h, int type) {
		BufferedImage reImag = new BufferedImage(w, h, type);
		Graphics2D g2d = reImag.createGraphics();
		g2d.drawImage(bImg, 0, 0, w, h, null);
		g2d.dispose();
		return reImag;
	}
}
