package Geometry;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import Biology.Protein;

public class Quadtree {
	
	//Attributes
	private Hashtable<String, Protein> Lst;
	private int limite;
	private Rectangle Rect;
	private Quadtree NorthEast;
	private Quadtree NorthWest;
	private Quadtree SouthEast;
	private Quadtree SouthWest;
	
	
	//Constructor
	public Quadtree(Rectangle R, int l, Hashtable<String, Protein> L) {
		this.Rect = R;
		this.limite = l;
		this.Lst = L;
		
		initComponents();
	}
	
	public Quadtree() {
		this.Rect = new Rectangle();
		this.limite = 0;
		this.Lst = new Hashtable<String, Protein>();
	}
	
	
	//Get and Set
	public Hashtable<String, Protein> getList(){
		return this.Lst;
	}
	
	public void setList(Hashtable<String, Protein> L) {
		this.Lst = L;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void setLimite(int l) {
		this.limite = l;
	}
	
	public Rectangle getRect() {
		return this.Rect;
	}
	
	public void setRect(Rectangle r) {
		this.Rect = r;
	}
	
	public Quadtree getNorthEast() {
		return NorthEast;
	}

	public void setNorthEast(Quadtree northEast) {
		NorthEast = northEast;
	}

	public Quadtree getNorthWest() {
		return NorthWest;
	}

	public void setNorthWest(Quadtree northWest) {
		NorthWest = northWest;
	}

	public Quadtree getSouthEast() {
		return SouthEast;
	}

	public void setSouthEast(Quadtree southEast) {
		SouthEast = southEast;
	}

	public Quadtree getSouthWest() {
		return SouthWest;
	}

	public void setSouthWest(Quadtree southWest) {
		SouthWest = southWest;
	}

	
	//Methods
	private void initComponents() {
		
		Hashtable<String, Protein> lstCopy = new Hashtable<>(this.Lst);
		
		if(lstCopy.size() > this.limite) {
			// Le nombre de protéines présente dans le rectangle est supérieur à  la limite
			
			int x = this.Rect.getX();
			int y = this.Rect.getY();
			int w = this.Rect.getWIDTH();
			int h = this.Rect.getHEIGHT();
			
			//hauteur et largeur des rectangles des autres Quadtrees
			int W = w/2;
			int H = h/2;
			
			Rectangle Nw = new Rectangle(x-W/2, y+H/2, W, H);
			Rectangle Ne = new Rectangle(x+W/2, y+H/2, W, H);
			Rectangle Sw = new Rectangle(x-W/2, y-H/2, W, H);
			Rectangle Se = new Rectangle(x+W/2, y-H/2, W, H);
			
			Rectangle[] LstRect = {Nw, Ne, Sw, Se};
			Hashtable<String, Protein>[] Liste = Listes(LstRect, lstCopy);
			
			this.setNorthWest(new Quadtree(Nw, this.limite, Liste[0]));
			this.setNorthEast(new Quadtree(Ne, this.limite, Liste[1]));
			this.setSouthWest(new Quadtree(Sw, this.limite, Liste[2]));
			this.setSouthEast(new Quadtree(Se, this.limite, Liste[3]));
			
			
		}
		else {
			this.setNorthWest(new Quadtree());
			this.setNorthEast(new Quadtree());
			this.setSouthWest(new Quadtree());
			this.setSouthEast(new Quadtree());
		}
		
	}
	
	private Hashtable<String, Protein>[] Listes(Rectangle[] LR, Hashtable<String, Protein> lst){
		//Renvoie les listes de protéines de chaque Quadtree
		
	    @SuppressWarnings("unchecked")
	    Hashtable<String, Protein>[] Liste = (Hashtable<String, Protein>[]) new Hashtable[4];

	    for (int i = 0; i < 4; i++) {
	        Liste[i] = new Hashtable<String, Protein>();
	    }

	    for (int i = 0; i < 4; i++) {
	        Rectangle R = LR[i];
	        Hashtable<String, Protein> Newliste = new Hashtable<String, Protein>();
	        Iterator<Map.Entry<String, Protein>> iterator = lst.entrySet().iterator();

	        while (iterator.hasNext()) {
	            Map.Entry<String, Protein> entry = iterator.next();
	            Protein P = entry.getValue();
	            int x = P.getX();
	            int y = P.getY();

	            if (R.IsPresent(x, y)) {
	                Newliste.put(P.getNom(), P);
	                iterator.remove();
	            }
	        }

	        Liste[i] = Newliste;
	    }

	    return Liste;
	}


}
