package Test;

import javax.swing.JDialog;

import Display.Running;

public class Testrunning {

	
	public static void main(String[] args) {
		
		String[] liste = {"ABC", "DEF"};
		
		Running R = new Running(liste);
		
		R.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        R.pack(); // Adjusts the size of the dialog based on its components
        R.setModal(false);
      //Redimension de la cellule
        R.getIllustration().initDIm(R.getIllustration().getWidth(), R.getIllustration().getHeight());
        R.setVisible(true);
       R.Lancer();
       
	}
	
}
