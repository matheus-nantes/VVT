package view;

public class AnimalFrontend {
	
	 public String retornarAnimal(Boolean carnivoro, Boolean venenoso, Boolean patas, Boolean aquatico) {
    	if(carnivoro) {
    		if(venenoso) {
    			if(patas) {
    				if(aquatico) 
    					return "Carangueijo Ferradura";
    				else
    					return "Dragão de Komodo";
    			}
    			else {
    				if(aquatico)
    					return "Enguia";
    				else
    					return "Naja";
    			}
    		}
    		else {
    			if(patas) {
    				if(aquatico)
    					return "Polvo";
    				else
    					return "Tigre";
    			}
    			else {
    				if(aquatico)
    					return"Moreia";
    				else
    					return "Python";
    			}
    		}
    	}
    	else {
	    	if(venenoso) {
    			if(patas) {
    				if(aquatico) 
    					return "Tritão";
    				else
    					return "Sapo";
    			}
    			else {
    				if(aquatico)
    					return "Anêmona";
    				else
    					return "Taturana";
    			}
    		}
    		else {
    			if(patas) {
    				if(aquatico)
    					return "Camarão";
    				else
    					return "Boi";
    			}
    			else {
    				if(aquatico)
    					return"Peixe Boi";
    				else
    					return "Lesma";
    			}
    		}
	    	
	    }
	 }
}
