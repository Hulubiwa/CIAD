package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import BancPoissons.Ocean;
import BancPoissons.Poisson;
import BancPoissons.ZoneAEviter;

public class OceanJPanel extends JPanel implements MouseListener, PropertyChangeListener {

	//Attributs
	protected Ocean ocean;
	protected Timer timer;
	
	//Constructeur
	public OceanJPanel() {
		this.setBackground(new Color(150, 255, 255));
		this.addMouseListener(this);
	}
	
	//Méthodes
	public void Lancer() {
		ocean = new Ocean(250, this.getWidth(), this.getHeight());
		ocean.AjouterChangeListener(this);
		TimerTask tache = new TimerTask() {
			@Override
			public void run() {
				ocean.MiseAJourOcean();
			}
		};
		
		timer = new Timer();
		timer.scheduleAtFixedRate(tache, 0, 15);
	}
	
	protected void DessinerPoisson(Poisson p, Graphics g) {
		g.drawLine((int) p.posX, (int) p.posY, (int) (p.posX - 10 * p.getVitesseX()), (int) (p.posY - 10 * p.getVitesseY()));
	}
	
	protected void DessinerObstacle(ZoneAEviter o, Graphics g) {
		g.drawOval((int) (o.posX - o.getRayon()), (int) (o.posY - o.getRayon()), (int) o.getRayon(), (int) o.getRayon() *2);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Poisson p : ocean.getPoissons()) {
			DessinerPoisson(p,g);
		}
		
		for(ZoneAEviter o : ocean.getObstacles()) {
			DessinerObstacle(o, g);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) {
		ocean.AjouterObstacle(evt.getX(), evt.getY(), 10);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
