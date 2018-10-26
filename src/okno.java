import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class okno extends JFrame{
	public int ram=6;
	public int click=100; 
	public int gold=20; 
	public int dps=0; 
	public int health=1000; 
	public pole gameP;
	public int maxhealth=1000;

	
	public Timer healthTimer;
	
	
public class myKey implements KeyListener
{
	
	public void keyPressed(KeyEvent e){
		int key_ = e.getKeyCode();
	
		if(key_==27) System.exit(0);
		
	
		else if(key_==37){
			if(ram==6){
				
				gameP.ram=1;
				ram=1;
				
			}
			else if(ram==7){
				ram=5;
				gameP.ram=5;
			}
			
		}

		else if(key_==39){
			if(ram<=4){
				ram=6;
				gameP.ram=6;

			}
			else if(ram==5){
				ram=7;
				gameP.ram=7;
			
			}
		}
	
		else if(key_==38){
			if(ram==2){
				ram=1;
				gameP.ram=1;
			
			}
			else if(ram==3){
				ram=2;
				gameP.ram=2;

			}
			else if(ram==4){
				ram=3;
				gameP.ram=3;

			}
			else if(ram==5){
				ram=4;
				gameP.ram=4;

			}
			else if(ram==7){
				ram=6;
				gameP.ram=6;

			}
		}
		
		else if(key_==40){
			
				if(ram==1){
					ram=2;
					gameP.ram=2;

				}
				else if(ram==2){
					ram=3;
					gameP.ram=3;

				}
				else if(ram==3){
					ram=4;
					gameP.ram=4;

				}
				else if(ram==4){
					ram=5;
					gameP.ram=5;

				}
				else if(ram==6){
					ram=7;
					gameP.ram=7;

				}
		
		}
		else if(key_==32){
		
			if(ram==1){
				JOptionPane.showMessageDialog(null, "Урон от клика: "+click+"");
			}
			
			else if(ram==2){
				
				if(gold>=10){
					gold-=10;
					click+=10;
					JOptionPane.showMessageDialog(null, "Урон от клика повышен на 10! Потрачено 10 золота");
				}
			
				else{
					JOptionPane.showMessageDialog(null, "Недостаточно золота");
				}
			}
		
			else if(ram==3){
				JOptionPane.showMessageDialog(null, "Урон в секунду: "+dps+"");
			}
			
			else if(ram==4){
				
				if(gold>=10){
					gold-=10;
					dps+=10;
					JOptionPane.showMessageDialog(null, "Урон в секунду повышен на 10! Потрачено 10 золота");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Недостаточно золота");
				}
			}
			
			else if(ram==5){
				JOptionPane.showMessageDialog(null, "У вас "+gold+" золота");
			}
		
			else if(ram==6){
				health-=click;
				gameP.health-=click;
			}
		
			else if(ram==7){
				JOptionPane.showMessageDialog(null, "Здоровье пони: "+health+"/"+maxhealth+"");
			}

		}
			
		
		
		
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

}

public okno(){
	addKeyListener(new myKey());
	setFocusable(true);
	setBounds(0,0,800,630);
	setTitle("PonyClicker");
	gameP = new pole();
	Container con = getContentPane();
	con.add(gameP);
	setVisible(true);

	




	healthTimer = new Timer(1000,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			health-=dps;
			
			gameP.health=health;
			if(health<=0){
				maxhealth+=50;
				gameP.maxhealth+=50;
				health=maxhealth;
				gameP.health=maxhealth;
				gold+=5+(int)(Math.random()*5);
				
			}
			
				
			
		
		}

	});
	
	healthTimer.start();

	
	


		
		

}
}
