import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class BlackJackGUI extends JFrame implements ActionListener {  // inheriting from JFrame Class and implenting the absract class/interface ActionListener
	
	private int i=0, j =0, f =0, ace =0;//declaring nts that will act as counntrs throughout the GUI
	private double balance =0, dbalance =0;//declaring user and dealer balances set to default of 0
	private  String name = "";//declaring username set to  a default of empty string
	private JMenuBar menu;//declarng Jmenubar to hold Jmenu
	private JMenu file;//declaing Jmenu to hold JmenuItems
	private JMenuItem exit, back;//Declaring JmenuItems  to exit from the system or go back to main menu
	private JButton hitbtn, stickbtn, dealbtn, stakebtn;//declaring JButtons to be Used for game commands
	private JLabel userCard1, userCard2, userCard3, userCard4, userCard5, usersHand,infoHold, infoHold2;//declaring Jpanels to hold (Jlabels with ImageIcons Attached) and also JLabels to hold text
	private JLabel dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5, dealersHand;//declaring Jpanels to hold (Jlabels with ImageIcons Attached)
	private JPanel crdholder, crdholder2, btnholder, spaceholder, spaceholder2;//declaring Jpanels to hold (Jlabels with ImageIcons Attached)
	private ImageIcon bcard, card1, card2, card3, card4, card5, dcard1, dcard2, dcard3, dcard4, dcard5;//declaring imageIcons to hold paths assigned to image lateer in program
	private PlayingCard[] shuffled = new PlayingCard[52];// declaring a card array to hold 52 cards in a random sequence
	private int userValue =0 , dealerValue=0;// declaring the values of users and dealers hand
	//private double stake = 0;//declaring the stake attribute original value before the user alters it
	CardDealer dealer;//declaring a dealer attribute
	CardPlayer cardPlayer = new CardPlayer();
	Deck deck;//declaring a deck attribute
	private MainMenuGUI mainMenu;// declaring a Main Menu Attribute
	private PlayingCard[] shuffledDeck;
	private Pot pot;
    private WinLoseCheck winCheck;
    private String chosenGame;
    private Boolean isBust;

    public BlackJackGUI(MainMenuGUI mainMenu, String GameChoice){//passing in instance of mainmenuGUI to balckjack gui
		super("BlackJack");
		this.mainMenu = mainMenu;// setting mainmenu to Main
		pot = new Pot();
		setSize(800,600);
		setLocation(350,100);
		setLayout(new GridLayout(5,1));//setting grid layout so 5 Jpanels can be addded
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// setting  a default close operation
		Font font = new Font("Arial", Font.BOLD, 12);// instaisting font
		back = new JMenuItem("Back");////instaniating jMenu items
		exit = new JMenuItem("Exit");//instaniating jMenu items
		file = new JMenu("file");// instaniatinn Jmenu file
		exit.addActionListener(this);
		back.addActionListener(this);
		file.add(back);//adding jmenuItem to Jmenu
		file.add(exit);//adding jmenuItem to Jmenu
		menu = new JMenuBar();// instaniating a JMenuBar
		menu.add(file);//adding Jmenu to JmenuBar
		setJMenuBar(menu);//adding JmenuBar to Gui
    	btnholder = new JPanel(new FlowLayout());
    	crdholder = new JPanel(new FlowLayout());
        crdholder2 = new JPanel(new FlowLayout());
        spaceholder = new JPanel(new FlowLayout());
        spaceholder2 = new JPanel(new FlowLayout());//instainatn JPanels with a flowlayout
		bcard = new ImageIcon("cards/backOfCard.jpg");//instaiating and setting image icon path
		userCard1 = new JLabel();
		userCard2 = new JLabel();
		userCard3  = new JLabel();
		userCard4  = new JLabel();
		userCard5  = new JLabel();
		dealerCard1 = new JLabel();
		dealerCard2 = new JLabel();
		dealerCard3 =new JLabel();
    	dealerCard4 =new JLabel();
    	dealerCard5 =new JLabel();//instaniating jLabels to later hold ImageIcons
        Color custom = new Color(14, 96, 20);//instaniating a new color
		usersHand = new JLabel();//insaniating a JLabel
        usersHand.setFont(font);//setting font of Jlabel
        usersHand.setText(name +"Hand: ");//setting text of Jlabel
        usersHand.setForeground(Color.white);//setting text color of jlabel
		dealersHand = new JLabel();//insaniating a JLabel
        dealersHand.setFont(font);//setting font of Jlabel
        dealersHand.setText("Dealers Hand: ");//setting text of jlabel
        dealersHand.setFont(font);//setting font of jlabel
        dealersHand.setForeground(Color.white);//setting text color of jlabel
        infoHold = new JLabel();
        infoHold.setFont(font);
        infoHold.setForeground(Color.white);
		infoHold2 = new JLabel();
        infoHold2.setFont(font);
        infoHold2.setForeground(Color.white);//setting Jlabel infromation holder for user and dealer details sand setting font and color
		dealerCard1.setIcon(bcard);
		dealerCard2.setIcon(bcard);
	    userCard1.setIcon(bcard);
	    userCard2.setIcon(bcard);//setting Jlabels to hold default  imageicon back of card
		dealbtn = new JButton("Deal");
		hitbtn = new JButton("Hit");
		stickbtn = new JButton("Stick");
		stakebtn = new JButton("Set Stake");//instaniating Jbuttons and giving them text values
		Font font2 = new Font("Arial", Font.BOLD, 24);//instaniating a secong Font
		dealbtn.setBackground(Color.white);
		dealbtn.setForeground(Color.black);
		dealbtn.setFont(font2);
		hitbtn.setBackground(Color.white);
		hitbtn.setForeground(Color.black);
		hitbtn.setFont(font2);
		stickbtn.setBackground(Color.white);
		stickbtn.setForeground(Color.black);
	    stickbtn.setFont(font2);
	    stakebtn.setBackground(Color.white);
		stakebtn.setForeground(Color.black);
		stakebtn.setFont(font2);//setting background , foregound colors and font of buttons
	    crdholder2.add(dealersHand);
	    crdholder2.add(dealerCard1);
	    crdholder2.add(dealerCard2);//adding details to let user know its dealers hand and also adding dealer card to Janel
	    crdholder2.setBackground(custom);//setting background colou of GUI
	    add(crdholder2);//ading Jpanel to gui
	    spaceholder.setBackground(custom);
	    spaceholder.add(infoHold);//adding information about dealer balance to a jpanel
	    add(spaceholder);//adding jppanel to gui
	    crdholder.add(usersHand);
	    crdholder.add(userCard1);
	    crdholder.add(userCard2);//adding details to let user know its the users hand and also adding users cards to Janel
	    crdholder.setBackground(custom);//setting bg colour of Jpanel
	    add(crdholder);//adding jpanel to gui
	    spaceholder2.setBackground(custom);
	    spaceholder2.add(infoHold2);//adding inforamtion about user name and balance and stake to Jpanel
	    add(spaceholder2);//adding jpanel to gui
	    btnholder.add(stakebtn);
	    btnholder.add(dealbtn);
		btnholder.add(hitbtn);
		btnholder.add(stickbtn);//adding buttons to Jpanel
		btnholder.setBackground(Color.black);//setting backgrounnd color of bthholder
		add(btnholder);// adding the Jpanel Buton holder to the GUI
		hitbtn.addActionListener(this);//adding actionlisteners
		dealbtn.addActionListener(this);
		stickbtn.addActionListener(this);
		stakebtn.addActionListener(this);
		stickbtn.setVisible(false);//setting to false as user wont need till stake is set
		hitbtn.setVisible(false);//setting to false as user wont need till stake is set
		dealbtn.setVisible(false);//setting to false as user wont need till stake is set
		setResizable(false);// disabling GUI to be resized
		dealer = new CardDealer();//instaniatiing a new dealer
		dealer.setBalance(50000);//setting dealers balance
		dealer.setName("Dealers");//setting dealers name
		pot.registerObserver(dealer); // adding dealer to listener
	    deck = Deck.getDeck(); // instaniaaiting a new deck
        infoHold.setText(dealer.getName() +" Balance: €" + dealer.getBalance());//setting text of dealers details
        infoHold2.setText(cardPlayer.getName() +" Balance: €" + String.format("%.2f",cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));//setting text of users deatails
	    shuffledDeck = dealer.shuffleBehaviour.shuffleDeck();//calling shuffeld deck method
        chosenGame = GameChoice;


		for(int i = 0; i < shuffled.length; i++)
		{
			shuffled[i] = shuffledDeck[i];
		}//in here the shuffled array takes on the values of the deck.shuffled array
	}//end of BlackJackgui Constructor

		public void actionPerformed(ActionEvent e) {

            if(chosenGame.equals("BlackJack")){
                winCheck = new WinLoseTwentyOne();
                winCheck.setBustValue(21);
            }

            if(chosenGame.equals("FortyFive")){
                winCheck = new WinLoseFortyFive();
                winCheck.setBustValue(45);
            }

			if (e.getSource() == hitbtn){
					if(i == 0){
						card1 = new ImageIcon(shuffled[j].getImage());
						userCard1.setIcon(card1);
						userValue += shuffled[j].getValue();
						if(shuffled[j].getName().equals("Ace"))
								{
									ace++;
								}
						j++;
						crdholder.add(userCard1);
					}//adding first card to screen, J is used as the counter to keep track of the elements of the shuffled array
					if(i == 1)
					{
					
						card2 = new ImageIcon(shuffled[j].getImage());
						userCard2.setIcon(card2);
						crdholder.add(userCard2);
						userValue += shuffled[j].getValue();
							if(shuffled[j].getName().equals("Ace"))
								{
									ace++;
								}
						
						crdholder.revalidate();
						crdholder.repaint();
						j++;
					}// adding users 2nd cards to screen and setting 1st and 2nd card visible to user
					
				
					
					if(i==2){
						card3 = new ImageIcon(shuffled[j].getImage());
						userCard3.setIcon(card3);
						crdholder.add(userCard3);
						userValue += shuffled[j].getValue();
						if(shuffled[j].getName().equals("Ace"))
							{
						
								ace++;
							}
						crdholder.revalidate();
						crdholder.repaint();
						j++;
					}// adding users 3rd card to screen i is used as ac ounter and is implemented when the hit button is used
					
					if(i==3){
						card4 = new ImageIcon(shuffled[j].getImage());
						userCard4.setIcon(card4);
						crdholder.add(userCard4);
						userValue += shuffled[j].getValue();
						if(shuffled[j].getName().equals("Ace"))
							{
								ace++;
							} 
						crdholder.revalidate();
						crdholder.repaint();
						j++;
					}// adding users 4th card to screen i is used as ac ounter and is implemented when the hit button is used
			   		if(i==4){
			   			card5 = new ImageIcon(shuffled[j].getImage());
						userCard5.setIcon(card5);
						crdholder.add(userCard5);
						userValue += shuffled[j].getValue();
						if(shuffled[j].getName().equals("Ace"))
								{
									ace++;
								}
						crdholder.revalidate();
				        crdholder.repaint();
						j++;
			   		}// adding users 5th card to screen i is used as ac ounter and is implemented when the hit button is used
			   	    
			   	    if(i > 4){
			   	    
			   	    JOptionPane.showMessageDialog(null,"Maximum number of cards Selected");	
			   	    
			   	    }//message letting user know they cant take any more cards
			   	    
					
						   	   
					if(userValue >11)
					{
						stickbtn.setVisible(true);
					}//seting stick button to visible once user value is 12 or greater
					
					if(userValue == 11 && ace >  0)
					{
						hitbtn.setVisible(false);
					}//seting stick button to  false as user has best hand possible
					
					if(userValue >= 2 && ace > 0)
					{
						stickbtn.setVisible(true);
					}//seting stick button to visible once user value is 12 or greater
				
					if(j > 50)
			   	   		{
			   	   			shuffledDeck = dealer.shuffleBehaviour.shuffleDeck();


			   	   			for(int x =0; x < shuffled.length; x++)
					   	   			{
					   	   				shuffled[x] = shuffledDeck[x];
					   	   			}
			   	   		   JOptionPane.showMessageDialog(null,"The current deck in use is now empty....\n\n\nplease wait while the dealer shuffles a new deck");
			   	   	
			   	   			j=0;
			   	  		 }//calling shuffled method if the element of the shuffled array is greater than 50 to stop an index out of bounds error


                     isBust = winCheck.checkIfBust(userValue, dealer, cardPlayer, pot);


                    if(isBust)
                    {
			   	   	   dealbtn.setVisible(true);
			  		   stickbtn.setVisible(false);
			  		   hitbtn.setVisible(false);
			  		   stakebtn.setVisible(true);
			  		   infoHold2.setText(cardPlayer.getName() +"'s Balance: €" + String.format("%.2f",cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));
			  		   infoHold.setText(dealer.getName() +" Balance: €" + String.format("%.2f", dealer.getBalance()));

                    }//checking user has bust before dealers has to take any cards
			   	   
			   	   
			   	  
			   	i++;
			}//end of action performed hit button
			
			if(e.getSource() == dealbtn){
				ace = 0;
					if(pot.getStake() > dealer.getBalance()){
                        JOptionPane.showMessageDialog(null,"that stake is more money than the dealer has at this table\n +" +
                                "please wait while we get more money to the table");
                        dealer.setBalance(dealer.getBalance() +(pot.getStake()*10));
					}//changing dealer balances it will always be greater than stake placed

                    ace =0;//reseting ace to zero  as its used as a counter t determine the value of an ace
					stakebtn.setVisible(false);
					dealbtn.setVisible(false);
					hitbtn.setVisible(true);
			  		stickbtn.setVisible(false);
					userValue = 0;//reseting user and dealer vlues to zero
			   	   	dealerValue = 0;

					crdholder.remove(userCard1);
					crdholder.remove(userCard2);
					crdholder.remove(userCard3);
				    crdholder.remove(userCard4);
				    crdholder.remove(userCard5);
					userCard1.setIcon(bcard);
					userCard2.setIcon(bcard);
				    crdholder.add(userCard1);
				    crdholder.add(userCard2);
					crdholder.revalidate();
					crdholder.repaint();
					
					crdholder2.remove(dealerCard1);
					crdholder2.remove(dealerCard2);
					crdholder2.remove(dealerCard3);
				    crdholder2.remove(dealerCard4);
				    crdholder2.remove(dealerCard5);
				    dealerCard1.setIcon(bcard);
				    dealerCard2.setIcon(bcard);
				    crdholder2.add(dealerCard1);
				    crdholder2.add(dealerCard2);
					crdholder2.revalidate();
					crdholder2.repaint();//the above two blocks of code are removing the cards from the GUI and setting back to original state with the back of car Imageicon
					
					if(j >50)
			   	   		{
			   	   			shuffledDeck = dealer.shuffleBehaviour.shuffleDeck();

			   	   			for(int x =0; x < shuffled.length; x++)
					   	   			{
					   	   				shuffled[x] = shuffledDeck[x];
					   	   			}
			   	   		   JOptionPane.showMessageDialog(null,"The current deck in use is now empty....\n\n\nplease wait while the dealer shuffles a new deck");
			   	   	
			   	   			j=0;
			   	  		 }//calling shuffled method if the element of the shuffled array is greater than 50 to stop an index out of bounds error
			   	  		 
			   	  	while(pot.getStake() > cardPlayer.getBalance()){
			   	  	
			   	  		boolean valid = false;
			   	  		do{
			   	  		try{
			   	  				int yesNO = 0;
			   	  				yesNO =JOptionPane.showConfirmDialog(null,"Your balance does not\n cover your stake \n\n"+
			   	  						"Would you like deposit Money","Insuffiecnt Funds",JOptionPane.YES_NO_OPTION);
			   	  				if(yesNO == 0)
			   	  					{
			   	  						cardPlayer.updateBalance(Integer.parseInt(JOptionPane.showInputDialog(null,"how much would you like to deposit:")));
			   	  					}
			   	  				else
			   	  					{
			   	  						var tempStake  = Double.parseDouble(JOptionPane.showInputDialog(null,"please reudce your Stake as it\n" +
			   	  						"it is greater than you balance\n enter new stake here:"));

										pot.setStake(tempStake);
			   	  					}
				   	  			
				   	  			
				   	  			valid = true;
			   	  		}catch(NumberFormatException s){
				   	  			JOptionPane.showMessageDialog(null,"please enter a number in the format of \"99.99\"");
				   	  		}
			   	  		}while(valid == false);//end of do while statement to catch a number format exception
			   	  		
			   	  	}// end of if ststement so user cant bet more money than whats in their balance
					i = 0;
                    infoHold2.setText(cardPlayer.getName() +"'s Balance: €" + String.format("%.2f", cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));
                    infoHold.setText( dealer.getName() +" Balance: €" + String.format("%.2f", dealer.getBalance()));//these two lines are reseting  users/dealers detailson screen

            }//end of actionPerformed Deal Button
			
		
				if (e.getSource() == stickbtn){
						int k =0;

						if(j > 45)
			   	   		{

			   	   			shuffledDeck = dealer.shuffleBehaviour.shuffleDeck();
			   	   			for(int x =0; x < shuffled.length; x++)
					   	   			{
					   	   				shuffled[x] = shuffledDeck[x];
					   	   			}
			   	   		   JOptionPane.showMessageDialog(null,"The current deck in use is now empty....\n\n\nplease wait while the dealer shuffles a new deck");
			   	   	
			   	   			j=0;
			   	  		 }// calling the shuffled method when array reaches element 45 as the dealer may take 5 cards, this stops an index out of bounds error
			   	  		 
						if(userValue <=11 && ace > 0)
						{
							userValue += 10;
						}//Setting aces value so it will be either one or eleven based on when the user sticks


						ace = 0;// reseting aces after user
						crdholder2.remove(dealerCard1);
					    crdholder2.remove(dealerCard2);
			   	    	dcard1 = new ImageIcon(shuffled[j].getImage());
						dealerCard1.setIcon(dcard1);
						dealerValue += shuffled[j].getValue();
					    if(shuffled[j].getName().equals("Ace"))
							{
								ace++;
							}
						crdholder2.add(dealerCard1);
						j++;
						
						dcard2 = new ImageIcon(shuffled[j].getImage());
						dealerCard2.setIcon(dcard2);
						dealerValue += shuffled[j].getValue();
					    if(shuffled[j].getName().equals("Ace"))
							{
								ace++;
							}
						crdholder2.add(dealerCard2);
					    if(dealerValue <= (userValue - 10) && ace > 0 || dealerValue ==11 && ace > 0)
							{
								dealerValue+=10;

							}
						j++;
						crdholder2.revalidate();
						crdholder2.repaint(); //the above two blocks of code remove the back of card image from screen and replace with two random card images
							
				   if(dealerValue < userValue && dealerValue < winCheck.getBustValue())
				   {
					   	dcard3 = new ImageIcon(shuffled[j].getImage());
						dealerCard3.setIcon(dcard3);
						dealerValue +=  shuffled[j].getValue();
					    if(shuffled[j].getName().equals("Ace"))
						   {
							   ace++;
						   }
						crdholder2.add(dealerCard3);
						crdholder2.revalidate();
						crdholder2.repaint();
						j++;//this block of code is adding new dealer card to screen
					    if(dealerValue <= (userValue - 10) && ace > 0 || dealerValue ==11 && ace > 0)
						   {
							   dealerValue+=10;

						   }

								if(dealerValue < userValue && dealerValue < winCheck.getBustValue())
									{
									  dcard4 = new ImageIcon(shuffled[j].getImage());
									  dealerCard4.setIcon(dcard4);
									  dealerValue += shuffled[j].getValue();
										if(shuffled[j].getName().equals("Ace"))
										{
											ace++;
										}
									  crdholder2.add(dealerCard4);
									  crdholder2.revalidate();
									  crdholder2.repaint();
										if(dealerValue == (userValue - 10) && ace > 0 || dealerValue ==11 && ace > 0)
										{
											dealerValue+=10;

										}
									  j++;//this block of code is adding new dealer card to screen
									}//end of if statement
										   	 if(dealerValue < userValue && dealerValue < winCheck.getBustValue())
											   {
												   	dcard5 = new ImageIcon(shuffled[j].getImage());
										  			dealerCard5.setIcon(dcard5);
										  			dealerValue += shuffled[j].getValue();
												    if(shuffled[j].getName().equals("Ace"))
													   {
														   ace++;
													   }
												   	crdholder2.add(dealerCard5);
												   	crdholder2.revalidate();
													crdholder2.repaint();
												    if(dealerValue == (userValue - 10) && ace > 0 || dealerValue ==11 && ace > 0)
													   {
														   dealerValue+=10;

													   }
													k=5;
													j++;//this block of code is adding new dealer card to screen
											   }
				   
		    	}//end of nested if statement where dealer checks if user value i greater than dealers value and takes another card based on this
		    	
		    	




				                winCheck.winLoseCheck(userValue, dealerValue, cardPlayer, dealer, pot);


		    					//(dealerValue < 21 && dealerValue < userValue && k==5)
								//	{
								//	   	JOptionPane.showMessageDialog(null,"***Congratulations***\nYou win The CardDealer has " + dealerValue +" You have " + userValue,"Results",JOptionPane.INFORMATION_MESSAGE);
								//		pot.gameFinished(cardPlayer);
								//	}// end of if statement checking if dealer has five cards and comparing users/dealers values
			
								//(dealerValue > 21)
								//	{
								//	   	JOptionPane.showMessageDialog(null,"***Congratulations***\nThe CardDealer has Bust\nYou win this Time" +"\nYou had: " + userValue,"Results",JOptionPane.INFORMATION_MESSAGE);
			  					//		pot.gameFinished(cardPlayer);
								//	}// end of if staement checking if dealer has bust
								//
								//(dealerValue > userValue && dealerValue <= 21)
								//	{
								//		JOptionPane.showMessageDialog(null,"***Conmiserations*** \nThe dealer wins with " + dealerValue +"\nYou had: " + userValue,"Results",JOptionPane.INFORMATION_MESSAGE);
								//		pot.gameFinished(dealer);
								//	}//end of if statement comparing users and deales values
								
								//(dealerValue == userValue)
								//	{
								//	    JOptionPane.showMessageDialog(null,"unfortunatley its a tie as you had " + userValue +
								//	    	" the dealer had " + dealerValue  ,"Results",JOptionPane.INFORMATION_MESSAGE);// message explaining this hand was a draw
								//	}


                                infoHold2.setText(cardPlayer.getName() +"'s Balance: €" + String.format("%.2f", cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));
								infoHold.setText( dealer.getName() +" Balance: €" + String.format("%.2f", dealer.getBalance()));//these two lines are reseting  users/dealers detailson screen


                                dealerValue =0; // reseting dealer and user values to zero fo next hand
								userValue =0;
								   
							
					
						stakebtn.setVisible(true);// setting buttons to visible and not visible
					    dealbtn.setVisible(true);
						hitbtn.setVisible(false);
			  		    stickbtn.setVisible(false);
						
						
				}// end of actionPerformed stickbutton
			if (e.getSource() == stakebtn)
			{
				dealbtn.setVisible(true);// setting the deal button to visible as a stake will be set
				boolean valid=false;
				do{
					//try catch implement to try and catch any number formatting problems when setting the stake size
				    try{
				    	pot.setPotValues(Double.parseDouble(JOptionPane.showInputDialog("Set Your Stake:")));//asking user to set stake size);
				    	valid = true;// setting valid to true to break loop when the value supplied is a number of type double
				    }catch(NumberFormatException x)
				    {
				          JOptionPane.showMessageDialog(null,"Please enter number in the form of \"99.99\"");// number format errror message
				    }
					
					
				}while(valid == false);//end of do while statement

                infoHold2.setText(cardPlayer.getName() +"'s Balance: €" + String.format("%.2f", cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));//
                infoHold.setText( dealer.getName() +" Balance: €" + String.format("%.2f", dealer.getBalance()));
                usersHand.setText(cardPlayer.getName()+"'s Hand: ");//the three lines of code above are resetting text of user details, dealer details and stake incase of changes


			}//end of actionPerformed StakeBtn
			
			if(e.getSource() == back)
			{
					    MainMenuGUI.setBal(cardPlayer.getBalance());
					    mainMenu.setVisible(true);
						this.setVisible(false);
						pot.removeObserver(dealer); // removing from listener when game ends
			      		pot.removeObserver(cardPlayer); // removing from listener when game ends

						
			}//end of action performed Back
			
			if(e.getSource() == exit)
			{
				int x= 0;
			
				x = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit without Saving","Exit",JOptionPane.YES_NO_OPTION);
				if(x == 0)
					{
							
							System.exit(0);
							pot.removeObserver(dealer); // removing from listener when game ends
							pot.removeObserver(cardPlayer); // removing from listener when game ends
					}	
				else
					{
						  JOptionPane.showMessageDialog(null,"To save game go back to menu");
					}				  
			}// end of actionperformed Exit
		}// end of actionPerformed statements
	public void setCardPlayer(CardPlayer player)
	{
		cardPlayer = player;
		infoHold2.setText(cardPlayer.getName() +"'s Balance: €" + String.format("%.2f", cardPlayer.getBalance()) + " Stake €:" + String.format("%.2f", pot.getStake()));
		pot.registerObserver(cardPlayer);

	}//end of getnamebal method

}//end of BlackJackGUI class