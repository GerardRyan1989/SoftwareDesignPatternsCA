import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
//declaring class  and setting it so it can inherits from the JFrame class and implements the interface class actionlistener

@SuppressWarnings({"unchecked", "deprecation"})

public class MainMenuGUI extends JFrame implements ActionListener {// inheriting from JFrame Class and implenting the absract class/interface ActionListener
	private int gamenum =0;//declaring gamenum and assigning gamenum a default value of 0
	private static double balance =0;//declaring balance and assigning it a default valuue of 0
	private CardPlayer u1;//declaring u1 of Utype CardPlayer
	private ImageIcon blackjackBG = new ImageIcon("cards/background.jpg");//declaring ImageIcon and setting path to image
	private JLabel 	backgroundImage;//deeclaring JLabel
	private JMenuBar menuStrip; //Declaring JMenuBar to be added to gui further in Program
	private JMenu file;
	private JMenu play;
	private JMenu register;
	private JMenu info ;
	private JMenuItem newGame;
	private JMenuItem loadGame;
	private JMenuItem saveGame;
	private JMenuItem newUser;
	private JMenuItem exit;
	private JMenuItem rulesOfGame;//declaring JmenuItems to add to Jmenu
	private JPanel  backGround; //declaring Jpanel which is added togui furte in program
	private	ArrayList <CardPlayer> users = new ArrayList<CardPlayer>();//Declaring an arraylist of type user that will be used to save and load files
	private BlackJackGUI table;
		
	public MainMenuGUI(){
		super("Menu");
		setSize(800,600);
		setLocation(350,100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		newGame = new JMenuItem("Play Game");//instainating JmenuItem
		rulesOfGame = new JMenuItem("Rules of BlackJack");//instainating JmenuItem
		newGame.addActionListener(this);//adding actionlistener to new gaame
		rulesOfGame.addActionListener(this);//adding actionlistener to rules of game
		loadGame = new JMenuItem("Load CardPlayer Details");//instainating JmenuItem
		saveGame = new JMenuItem("Save CardPlayer Details");//instainating JmenuItem
		loadGame.addActionListener(this);//adding actionlistener load game
		saveGame.addActionListener(this);//adding actionlistener to save game
		register = new JMenu("Users");//Instaniating a Jmenu
		info = new JMenu("Information");//Instaniating a Jmenu
		file= new JMenu("File");//Instaniating a Jmenu
		play = new JMenu("Play");//Instaniating a Jmenu
		exit = new JMenuItem("Exit");//instainating JmenuItem
		newUser = new JMenuItem("Register New CardPlayer");//instainating JmenuItem
		newUser.addActionListener(this);//adding actionlistener to new CardPlayer
		info.add(rulesOfGame);
		register.add(newUser);
        register.add(loadGame);
		file.add(saveGame);
		file.add(exit);//adding JmenuItems to Jmenu
		exit.addActionListener(this);//adding an action listener for exit
		play.add(newGame);//adding Jmenu item to Jmenu
		menuStrip = new JMenuBar();//instaniating Jmenu Bar
		menuStrip.add(info);
		menuStrip.add(play);
		menuStrip.add(register);
		menuStrip.add(file);//adding jmenus to JmenuBar
		backgroundImage = new JLabel();//instaniating a Jlabel
		backgroundImage.setIcon(blackjackBG);//assigning JLabel a imageIconw
		backGround = new JPanel();//instaing Jpanel
		backGround.add(backgroundImage);//adding Jlabel with image to Jpanel
		setJMenuBar(menuStrip);//adding Jmenubar to gui
		add(backGround);//adding jPanel backgroud to gui
		setResizable(false);//disbling rezing by user
		setVisible(true);//setting gui to visible
		
	}
	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == newGame)
		{

			String [] options = {"BlackJack", "FortyFive"};
			String n = (String)JOptionPane.showInputDialog(null, "Please Choose which game you wish to play",
					"Game Choice", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			System.out.print("\n\n\n" + n + " VLAUE RETURNED \n\n");


			table = new BlackJackGUI(this , n);

			if(u1==null)
                {
                    JOptionPane.showMessageDialog(null,"Please either load a user or register a new user");
                }
			else	
				{
					table.setCardPlayer(u1);
					table.setVisible(true);
					this.setVisible(false);
					System.out.print(u1.getClass());
				}

		}//end of action performed new game, loads black jack Gui if a user is selected

		
		if(e.getSource() == newUser)
		{   
			int x = 1;
			boolean valid=false;
			String name  ="";
			int age =0;
			double balance =0;
		    u1 = new CardPlayer();
		   
		    
		  do{
			 
			 name =JOptionPane.showInputDialog("Please enter your name: ");
			 
			do{
				
			try{
				 	age = Integer.parseInt(JOptionPane.showInputDialog("please enter your Age: "));

				 	valid = true;
				 }catch(NumberFormatException a){

				 	JOptionPane.showMessageDialog(null,"please enter a whole number for your age please");
				 }
				if(age < 18){
				     valid = false;
				 	JOptionPane.showMessageDialog(null,"You must be over 18 to play this game");
				}
			}while(!valid);//try catch used to catch number format exceptions insisde a loop to ensuee user is  18 or older
			
			valid = false;
			
			 
			do{
			try{
				 	
				 	balance = Double.parseDouble(JOptionPane.showInputDialog("Please enter in euros how much you wish to play with:"));
				 	
				 	valid = true;
				 }catch(NumberFormatException a){
				 	JOptionPane.showMessageDialog(null,"please enter a number in the format of \"99.99\"");
				 }
			
			}while(!valid);//try catch inside loop to catch a number foramt exception when user enters balance
			
				 u1.setAge(age);
				 u1.setName(name); 
				 u1.setBalance(balance);//setting new users details
			 	 
				 x = JOptionPane.showConfirmDialog(null,"Name: " + u1.getName() +"\nAge: " + u1.getAge() + "\nDeposit: " + u1.getBalance() +
				 											"\n\nAre these details correct","Details",JOptionPane.YES_NO_OPTION);
		
			}while(x == 1);//end of confirming user details confirm dialog used tii ensure details are correct
			
		 users.add(u1);
		 try{
		    
		    		save();//save  implented to save user details as they register
		     }
            catch (IOException f){
                 f.printStackTrace();
            }//io exception try catch
		}//end of actionperformed New CardPlayer
		if(e.getSource() == rulesOfGame){
			
			JOptionPane.showMessageDialog(null,"***Rules of BlackJack***\n\n1: Each person Starts with 2 cards.\n2:Hit-- CardPlayer takes another PlayingCard\n3:Stick--CardPlayer takes no more cards and sticks with current hand\n4:"
				 + "Deal--  A new game of BlackJack is started\n5:Stake-- The amount of money the user wish to bet on each game(odds are Even) \n6: The maximum cards a player can have at any one time  is 5." +
					"\n6: The winner is decided by hich hand has a greater value and/or if a hand is greater than 21 it results in a loss"+
						" \n7: If the user has the same value as the dealer e.g. both the dealer and the user have  21, it will result in a split pot i.e both parties share the winnings");
		}//end of action performed rules of game, Message dialog explaining rules of black jack

		if(e.getSource() == exit)	
		{
			int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","exit confimation",JOptionPane.YES_NO_OPTION);
			if(x == 0)
			{
				System.exit(0);	
			}//this confirm dialog usd to ask user if they wish to exit
			
		}//end of ActionPerformed exit
		
		if(e.getSource() == saveGame)
		{
			
		try{

				if(u1 == null) {
					JOptionPane.showMessageDialog(null,"Cannot save an empty file");
				}
				else{
					u1.setBalance(balance);
					addUser();
					save();
					JOptionPane.showMessageDialog(null, "Save Successful");

				}//if else to ensure no empty files  are being saved
            }
            catch (IOException f){
                 f.printStackTrace();
            }//try catch used to tryensure theres no io exception
		}//end of actionPerformed saveGame
			
		if(e.getSource() == loadGame)
		{
			String output ="";
			boolean valid = false;
            int i;
			open();
		
			for( i =0; i < users.size(); i++){
				output += i +": " + users.get(i).toString() + "\n";
			}//inside the for loop we add to a String the CardPlayer values of each eleement
			  output += "\n\n please choose the number of the game you wish to load"; 
			do{
				try{
					gamenum = Integer.parseInt(JOptionPane.showInputDialog(output));//asking the user to choose their file
					valid = true;
				}catch(NumberFormatException a){
					JOptionPane.showMessageDialog(null,"Please enter a whole number");
				}

			}while(!valid );//loop too run until thers is no numberformat exception
			
			u1 = users.get(gamenum);
			u1.setName(users.get(gamenum).getName());
			u1.setAge(users.get(gamenum).getAge());
			u1.setBalance(users.get(gamenum).getBalance());//this block of code gets the details of an element determined by user input  from the arraylist,
		}// end of the actionperformed Loadgame
	}//end of actionperformed
	
	public static void setBal(double bal)
	{
		balance = bal;	
	}//this sets the users balance to the value passed into the method
	
	public void addUser(){
      	users.remove(gamenum);
      	users.add(gamenum, u1); 
	}//end of addUser
	
	public void save() throws IOException {
      		
      		ObjectOutputStream os;
      		os = new ObjectOutputStream(new FileOutputStream ("users.dat"));
      		os.writeObject(users);
      		os.close();
      	
      }//end of save, this allows a user to save there file
      
      public void open() {
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("users.dat"));
          users  = (ArrayList<CardPlayer>) is.readObject();
      	  is.close();
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}

      }//end of open, this allows a user to load their file
}//end of class