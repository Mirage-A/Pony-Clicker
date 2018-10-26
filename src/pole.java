import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
public class pole extends JPanel{
Image fon;
Image pony100;
Image damage;
Image healthy;
Image gold;
Image pole;
public Timer timerDraw;
public int ram=6;
Image pony75;
Image pony50;
Image pony25;
Image pony0;
public int maxhealth=1000;
public int health=1000;
Image poloska;
int x;
public pole(){
	
	try{
		fon = ImageIO.read(new File("c://PonyClicker//Images//fon.png"));
	}
	catch(IOException ex){}
	try{
		pony100 = ImageIO.read(new File("c://PonyClicker//Images//pony100.png"));
	}
	catch(IOException ex){}
	try{
		damage = ImageIO.read(new File("c://PonyClicker//Images//damage.png"));
	}
	catch(IOException ex){}
	try{
		healthy = ImageIO.read(new File("c://PonyClicker//Images//health.png"));
	}
	catch(IOException ex){}
	try{
		gold = ImageIO.read(new File("c://PonyClicker//Images//gold.png"));
	}
	catch(IOException ex){}
	try{
		pony75 = ImageIO.read(new File("c://PonyClicker//Images//pony75.png"));
	}
	catch(IOException ex){}
	try{
		pony50 = ImageIO.read(new File("c://PonyClicker//Images//pony50.png"));
	}
	catch(IOException ex){}
	try{
		pony25 = ImageIO.read(new File("c://PonyClicker//Images//pony25.png"));
	}
	catch(IOException ex){}
	try{
		pony0 = ImageIO.read(new File("c://PonyClicker//Images//pony0.png"));
	}
	catch(IOException ex){}
	try{
		pole = ImageIO.read(new File("c://PonyClicker//Images//pole.png"));
	}
	catch(IOException ex){}
	try{
		poloska = ImageIO.read(new File("c://PonyClicker//Images//poloska.png"));
	}
	catch(IOException ex){}



timerDraw = new Timer(50,new ActionListener(){
	public void actionPerformed(ActionEvent e){
		repaint();
		
	}

});
timerDraw.start();
}

public void paintComponent(Graphics gr)
{

	super.paintComponent(gr);
	gr.drawImage(fon, 0, 0, null);
	ramka(ram,gr);

	}

public void ramka(int ram,Graphics gr){
	x=421*health*10/(maxhealth*10);
	if(x<0){
		x=0;
	}
	else if(x>421){
		x=421;
	}
	gr.drawImage(poloska,325,505,x,68, null);

	
if(ram==1){
	gr.drawImage(damage, 22, 15, null);
}
else if(ram==2){
	gr.drawImage(damage,22,133,null);
}
else if(ram==3){
	gr.drawImage(damage, 22, 264, null);
}
else if(ram==4){
	gr.drawImage(damage, 22, 383, null);
}
else if(ram==5){
	gr.drawImage(gold, 12, 494, null);
}
else if(ram==6){
	gr.drawImage(pole, 310, 26, null);
}
else if(ram==7){
	gr.drawImage(healthy, 310, 493, null);
}
if((health*100)/(maxhealth)>75){
	gr.drawImage(pony100, 471, 245, null);
	
}
else if((health*100)/maxhealth>50){
	gr.drawImage(pony75, 471, 245, null);
}
else if((health*100)/maxhealth>25){
	gr.drawImage(pony50, 471, 245, null);
}
else if((health*100)/maxhealth>1){
	gr.drawImage(pony25, 471, 245, null);
}
else if(health/maxhealth<=0){
	gr.drawImage(pony0, 471, 245, null);
}
			
		
	
	}


}


