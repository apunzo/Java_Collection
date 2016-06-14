/**
 * CS 201
 * @author Antonio Punzo
 * 4/28/2014
 * TicTacToe Final Project
 * 
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
/**
 * @author Antonio Punzo
 * Declares class TicTacToev2
 * implements ActionListener
 * 
 * 
 */
public class TicTacToev2 implements ActionListener 
{
	/**
	 * Creates a GUI game of Tic Tac Toe that can be either single player or multiplayer
	 * Determines and displays the winner of the game
	 * Allows the user to determine the type of game, if they want to play multiple games or if they wish to quit
	 * 
	 */
	
	
	public JFrame frame = new JFrame("Tony's Tic-Tac-Toe " );

	public JMenuBar mainMenu= new JMenuBar();
	public JMenuItem newGmMenu = new JMenuItem("New Game");
	
	public JMenuItem menuExt = new JMenuItem("Exit");
	

	 public JButton MultiPlyr = new JButton("MultiPlayer");
	 public JButton SinglePlyr = new JButton("Single Player");
	 public JButton quit = new JButton("Instruction Menu");
	
	 
	 public JButton rePlay = new JButton("Play Another Round");
	 public JButton board[] = new JButton[10];

	 public JPanel NewgmPanel = new JPanel();
	 public JPanel menuPanel = new JPanel();
	 public JPanel mainPanel = new JPanel();
	 public JPanel firstPanel = new JPanel();
	 public JPanel secondPanel = new JPanel();
	 public JPanel quitPanel = new JPanel();
	 public JPanel gameboardPanel = new JPanel();

	 public JLabel Instrc = new JLabel("<html><center>Welcome To Tony's Tic Tac Toe<br><br> Instructions:<br><br>Click New Game-To select Game Type <br><br>"
			+ "Choose Single Player for Player vs CPU<br><br> Choose MultiPlayer for Player vs Player<br><br>"
			+ "X Goes First<br><br> To Start a New Game Click New Game and Select Game Type<br><br> To Go again Click Play another Round after game is Complete<br><br>"
			+ "To Return to This Page Click New Game Then Instruction Menu</center><html>");
	
	
	 public JLabel whosTurn = new JLabel();
	 public JLabel gameStatus = new JLabel("", JLabel.CENTER);
	 public JTextArea gameMessage = new JTextArea();
	
	 final int winArray[][] = new int[][]
		{//Array has elements 1,2,3= win, Array has elements 1,4,7=win etc.
			 {1, 2, 3}, {1, 4, 7}, {1, 5, 9},
			 {4, 5, 6}, {2, 5, 8}, {3, 5, 7},
			 {7, 8, 9}, {3, 6, 9}
			 /*Horizontal Wins*/ /*Vertical Wins*/ /*Diagonal Wins*/
		};
	private final int X = 700, Y = 500;	//Sets original size of window
	public int turns = 1, winPlyr1 = 0, winPlyr2 = 0, wins1 = 1, wins2 = 1, wins3 = 1;
	public int option;
	
	public boolean gamePlay = false;
	public boolean win = false;
	public boolean CPU1 = false;
	
	public String message;
	public String Plyr1 = "Player 1", Plyr2 = "Player 2",CPU="CPU";

	/**
	 * Method TicTacToev2()
	 * Sets up GUI Properties
	 * Layouts, Font size, Screen position
	 * Adds Buttons and Panels to JFrames
	 * Add action listener to buttons
	 * Sets up the array for game board
	 */
	public TicTacToev2() 
		{ //Setting game properties,layout and styles
			//Setting window properties:
			frame.setSize(X, Y);
			frame.setLocation(400, 150);	//Sets Location where window will open on screen
			frame.setResizable(true);
			frame.setLayout(new BorderLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Sets up Panel Layouts
			menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			firstPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	
			newGmMenu.setFont(new Font("Arial",1,20));
			menuExt.setFont(new Font("Arial",1,20));
			Instrc.setFont(new Font("Arial",1,18));
	
			quitPanel.setLayout(new GridLayout(1, 2, 2, 2));
			quitPanel.add(rePlay);
			quitPanel.add(quit);

			//Adds menu items to menu bar
			mainMenu.add(newGmMenu);
			mainMenu.add(menuExt);

			//Adds buttons to Newgm Panel
			NewgmPanel.setLayout(new GridLayout(4, 1, 2, 10));
			NewgmPanel.add(quit);
			NewgmPanel.add(MultiPlyr);
			NewgmPanel.add(SinglePlyr);
	

			//sets Button properties
			rePlay.setEnabled(false);
			quit.setEnabled(false);

			//Sets JOption message properties
	
			gameMessage.setEditable(false);

			//Adds Action Listener to all the Buttons and Menu Items
			newGmMenu.addActionListener(this);
			menuExt.addActionListener(this);
	
	
			MultiPlyr.addActionListener(this);
			SinglePlyr.addActionListener(this);
			quit.addActionListener(this);

	
			rePlay.addActionListener(this);

			//Sets up game board
			gameboardPanel.setLayout(new GridLayout(3, 3, 2, 2));
			gameboardPanel.setBackground(Color.black);
	
			for(int array=1; array<=9; array++)
			{
				board[array] = new JButton();
	
				board[array].addActionListener(this);
				gameboardPanel.add(board[array]);
			}

			//Add elements to menu panel and main panel
			menuPanel.add(mainMenu);
			mainPanel.add(Instrc);
	
	
			//Adds to window and sets JFrame to be visible
			frame.add(menuPanel, BorderLayout.NORTH);
			frame.add(mainPanel, BorderLayout.CENTER);
			frame.setVisible(true);
		}

	



	/**
	 *  Method showGame()
	 *	Clears the button menu
	 *	Adds all elements and Layout for game board
	 */
	public void showGame() 
	{ // Shows the Playing Field
	
		clearPanelSouth();
		mainPanel.setLayout(new BorderLayout());
		firstPanel.setLayout(new BorderLayout());
		secondPanel.setLayout(new BorderLayout());
		firstPanel.add(gameboardPanel);
		secondPanel.add(whosTurn, BorderLayout.WEST);
		secondPanel.add(gameStatus, BorderLayout.CENTER);
		secondPanel.add(quitPanel, BorderLayout.EAST);
		mainPanel.add(firstPanel, BorderLayout.CENTER);
		mainPanel.add(secondPanel, BorderLayout.SOUTH);
		gameboardPanel.requestFocus();
		gamePlay  = true;
		checkTurn();
		checkWinStatus();
	}
	
	/**
	 * Method newGame()
	 *  Creates new game board
	 * sets the board array text to empty
	 */
	public void newGame()
	{ // Sets all the game required variables to default
	// and then shows the playing field.
	
	
		for(int array=1; array<10; array++) 
		{//adds 9 elements to array i. makes index 0-8
			board[array].setText("");
			board[array].setFont(new Font("Arial",1,60));
		
			board[array].setBackground(Color.WHITE);
			board[array].setEnabled(true);
		}
		turns = 1;
		win = false;
		showGame();
	
	}
		
	/**
	 * Method goBack
	 * Clears the game and takes user back to Instruction page
	 */
	public void goBack() 
	{
		gamePlay = false;
		clearPanelSouth();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(Instrc);
	
	}
	
	/**
	 * Method checkWin()
	 * Checks for the possible array combinations that equal a win (vertical win, diagonal win, horizontal win)
	 * Checks that the array index has something placed in it.
	 * Next checks if the items next to each other are the same (x==y)
	 * 1.If items are the same (x==y) does the array index for x and y match any of the first two array indexs for a winning array
	 * Next checks if the next item is the same as one before it (z==y)
	 * 2.If items are the same (z==y) does the array index for z and y match any of the last two array indexs for a winning array
	 * If both 1 and 2 then  win=true
	 * Method checks who's turn it was when win=true became true and displays message of who won
	 */
	public void checkWin()
	{ 
		for(int array=0; array<8; array++)
		{//checks values at index 0-8
			if(
					!board[ winArray[array][0]].getText().equals("") &&
					board[ winArray[array][0]].getText().equals(board[ winArray[array][1]].getText()) &&
					
					board[ winArray[array][1]].getText().equals(board[ winArray[array][2]].getText())) 
			{
	
				win = true;
				wins1 =  winArray[array][0];
				wins2 =  winArray[array][1];
				wins3 =  winArray[array][2];
	
				break;
			}
		}
	
		if(win || (!win && turns>9))	
		{
			if(win)	
			{
				if(board[wins1].getText().equals("X"))	
				{
					message = Plyr1 + " has won";
					winPlyr1++;
				}
				else	
				{
					message = Plyr2 + " has won";
					winPlyr2++;
				}
			}	
			else if(!win && turns>9)
				message = "The game was a draw!";
			showMessage(message);
			for(int array=1; array<=9; array++)	
			{
				board[array].setEnabled(false);
			}
		rePlay.setEnabled(true);
		checkWinStatus();
		} 
		else
		checkTurn();
	}
	
	/**
	 * Method AI()
	 * Uses method RandomMove() to place an O in a random place on the board
	 * Increments O's turn count
	 * Uses method checkWin() to determine when a winning array combination has been entered
	 */
	public void AI()	
	{
		turns++;
		RandomMove();
		checkWin();
	}
	/**
	 * Method RandomMove()
	 * Creates random number between 1 and 9
	 * Checks board array and puts an O at a random array index if X has been placed
	 * Sets the Font for O and the background color for when an array index gets a value of O
	 * Sets the array index where O was placed as fasle so it is no longer clickable
	 */
	public void RandomMove()
	{
		Random randomNumbers = new Random();
		int n = 1 + randomNumbers.nextInt(9);
		if(board[n].getText().equals("O") || board[n].getText().equals("X") )
		{
			RandomMove();
			
		} 
		else 
		{
			board[n].setText("O");
			board[n].setFont(new Font("Arial",1,60));
			board[n].setBackground(Color.CYAN);
			board[n].setEnabled(false);
			
		}
	}
	
	/**
	 * Method checkTurn()
	 * Keeps track of who's turn it is and displays info on bottom panel
	 */
	public void checkTurn() 
	{
		String whoTurn;
		if(!(turns % 2 == 0)) 
		{
			whoTurn = Plyr1 + " [X]";
		} 
		else
		{
			whoTurn = Plyr2 + " [O]";
		}
		whosTurn.setText("Turn: " + whoTurn);
	}
	
	/**
	 * Methods checkWinStatus()
	 * Responsible for displaying Total wins of Players
	 * 
	 */
	public void checkWinStatus()
	{
		gameStatus.setText(Plyr1 + ": " + winPlyr1 + " | " + Plyr2 + ": " + winPlyr2);
	}
	
	/**
	 * Method setDefaultLayout
	 * Responsible for the different JPanel's overall layout
	 * 
	 */
	public void setDefaultLayout() 
	{
		mainPanel.setLayout(new GridLayout(2, 1, 2, 5));
		firstPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	/**
	 * Method displayMessage
	 *  responsible for displaying JOption Panes
	 * Displays option window confirming exit
	 * @param message ask user if they want to exit
	 * @param title exit
	 * @param r Options available are Yes or No
	 * @return int indicating option selected
	 */
	public int displayMessage(String message, String title, int r) 
	{
	return JOptionPane.showConfirmDialog(null, message, title, r);
	}
	
	/**
	 * Method showMessage
	 * Displays a message of who won the game
	 * @param message "Player 1 won", "Player 2 won", "The game was a tie"
	 */
	public void showMessage(String message) 
	{
	JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Method clearPanelSouth()
	 * Removes all Panels so that the default layout can be loaded when a new game is started
	 */
	public void clearPanelSouth()
	{ //Removes all the possible panels
	//that pnlMain, pnlTop, pnlBottom
	//could have.
		mainPanel.remove(Instrc);
	
	
		mainPanel.remove(firstPanel);
		mainPanel.remove(secondPanel);
		firstPanel.remove(NewgmPanel);
		firstPanel.remove(gameMessage);
		firstPanel.remove(gameboardPanel);
		secondPanel.remove( whosTurn);
		secondPanel.remove(quitPanel);
	}
	
	/**
	 * Actions for Button Click Methods
	 * Determines what is done if buttons NewGame, Exit, Single Player or MultiPlayer is clicked
	 * Also determines what to do when buttons in the game board array are clicked
	 */
	
	public void actionPerformed(ActionEvent e) 
	{
		Object s = e.getSource();
		for(int array=1; array<=9; array++) 
			{
				if(s == board[array] && turns < 10) 
				{
			
					if(!(turns % 2 == 0))
						board[array].setText("X");
					else
						board[array].setText("O");
						board[array].setEnabled(false);
						board[array].setBackground(Color.CYAN);
						gameboardPanel.requestFocus();
						turns++;
						checkWin();
						if(CPU1 && win == false)
							AI();
			
				}
			}
	
	
		if(s == newGmMenu ) 
			{
				clearPanelSouth();
				setDefaultLayout();

				if(s == newGmMenu) 
				{//NewGame
					firstPanel.add(NewgmPanel);
				}
				mainPanel.add(firstPanel);
				mainPanel.add(secondPanel);
			}
		
	
		else if(s == MultiPlyr || s == SinglePlyr) 
		{
			if(gamePlay)	
			{
				gamePlay = false;
			}
			if(!gamePlay) 
			{
				if(s == MultiPlyr) 
				{// Multiplayer Game
					CPU1=false;
					quit.setEnabled(true);
					newGame();
				}
			else 
			{//Single Player Game
				CPU1=true;	
				quit.setEnabled(true);
				newGame();
			}
	
			} 
		}
	
		else if(s == menuExt) 
		{
		 option = displayMessage("Are you sure you want to exit?", "Exit Game", JOptionPane.YES_NO_OPTION);
		 	if( option == JOptionPane.YES_OPTION)
		 		System.exit(0);
		}
		else if(s == rePlay)
		{
			newGame();
			rePlay.setEnabled(false);
		}
		else if(s == quit)
		{
			goBack();
		}
	mainPanel.setVisible(false);
	mainPanel.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		TicTacToev2 myTicTacToev2 = new TicTacToev2();// //Create a TicTacToe object and assign it to myTicTacToe
		
		}
}

