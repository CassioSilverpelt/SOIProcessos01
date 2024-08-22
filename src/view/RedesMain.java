package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class RedesMain {
	  public static void main (String[] args){
		    RedesController redCon = new RedesController();
		    int opc = 0;
		    
		    //redCon.ip();
		    //redCon.callProcess("regedit.exe");
		    //redCon.readProcess("ipconfig");
		    //redCon.ping();
		    //redCon.readIP("ipconfig");
		    
		    while (opc != 9) {
		    	opc = Integer.parseInt(JOptionPane.showInputDialog(
		    			"==================================\n"
		    			+ "Escolha entre as opções a seguir: \n"
		    			+ "1 - IP Config.\n"
		    			+ "2 - Ping Google.\n"
		    			+ "9 - Sair.\n"
		    			+ "=================================="));
			    switch (opc) {
			    	case 1:
			    		redCon.ip();
			    		break;
			    	case 2:
			    		redCon.ping();
			    		break;
			    	case 9:
			    		JOptionPane.showMessageDialog(null, "Encerrando programa...");
			    		break;
			    }
		    }
	  }
}