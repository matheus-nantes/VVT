import java.util.ArrayList;
import java.util.List;

class Animal {

    public String retornarAnimal(String classe, String habitat, String formaDeNascimento, String letalidade) {
    	
    	if(formaDeNascimento == "Ovíparo") {
    		
    		if(letalidade == "Alta") {
    			
    			if(classe == "Anfíbio") {
    				
    				if(habitat == "Tropical") {
    					return "Sapo Venenoso";
    				}
    				else {
    					return "Inexistente";
    				}
    				
    			}
    			else if(classe == "Aracnídeo") {
					if(habitat == "Diversos") {
						return "Aranha";
					}
					else {
						return "Inexistente";
					}
				}
    			
    			else if(classe == "Réptil") {
    				if(habitat == "Alagados") {
    					return "Jacaré";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    				
				else {
					return "Inexistente";//caso a classe não seja compatível
				}    			
    		}
    		else if(letalidade == "Baixa") {
    			if(classe == "Anfíbio") {
    				if(habitat == "Alagados") {
    					return "Salamandra";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Ave") {
    				if(habitat == "Antártida") {
    					return "Pinguim";
    				}
    				else if(habitat == "Diversos") {
    					return "Corvo";
    				}
    				else if(habitat == "Florestas") {
    					return "Pavão";
    				}
    				else if(habitat == "Oceano") {
    					return "Albatroz";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Cnidário") {
    				if(habitat == "Oceano") {
    					return "Coral";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Equinodermo") {
    				if(habitat == "Oceano") {
    					return "Estrela do Mar";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Inseto") {
    				if(habitat == "Campos") {
    					return "Borboleta";
    				}
    				else if(habitat == "Florestas") {
    					return "Formiga";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Mamífero") {
    				if(habitat == "Savana") {
    					return "Avestruz";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Réptil") {
    				if(habitat == "Alagados") {
    					return "Axolote";
    				}
    				else if(habitat == "Florestas") {
    					return "Camaleão";
    				}
    				else if(habitat == "Oceano") {
    					return "Tartaruga";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else {
    				return "Inexistente";
    			}
    		}
    		else if(letalidade == "Moderada") {
    			
    			if(classe == "Aracnídeo") {
    				if(habitat == "Deserto") {
    					return "Escorpião";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Ave") {
    				if(habitat == "Montanhas") {
    					return "Águia";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Cnidário") {
    				if(habitat == "Oceano") {
    					return "Medusa";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Molusco") {
    				if(habitat == "Oceano") {
    					return "Polvo";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Peixe") {
    				if(habitat == "Recife") {
    					return "Moréia";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else {
    				return "Inexistente";
    			}
    			
    		}
    		
    	}
    	else if(formaDeNascimento == "Vivíparo"){
    		if(letalidade == "Alta") {
    			if(classe == "Mamífero") {
    				if(habitat == "Ártico") {
    					return "Urso-Polar";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Peixe") {
    				if(habitat == "Oceano") {
    					return "Tubarão";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else {
    				return "Inexistente";
    			}
    		}
    		else if(letalidade == "Baixa") {
    			if(classe == "Mamífero") {
    				if(habitat == "Desertos") {
    					return "Canguru";
    				}
    				else if(habitat == "Florestas") {
    					return "Tamanduá";
    				}
    				else if(habitat == "Tropical") {
    					return "Orangotango";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else if(classe == "Peixe") {
    				if(habitat == "recife") {
    					return "Cavalo Marinho";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else {
    				return "Inexistente";
    			}
    		}
    		else if(letalidade == "Moderada") {
    			if(classe == "Mamífero") {
    				if(habitat == "Florestas") {
    					return "Lobo";
    				}
    				else if(habitat == "Savana") {
    					return "Guepardo";
    				}
    				else {
    					return "Inexistente";
    				}
    			}
    			else {
    				return "Inexistente";
    			}
    		}
    		else {
    			return "Inexistente";
    		}
    	}
    	else {
    		return "Inexistente";
    	}
    	
    	return "Inexistente";
    }
}
