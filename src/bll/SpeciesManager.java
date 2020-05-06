package lab2.bll;
import java.util.Hashtable;
import java.util.List;

import lab2.dao.SpeciesDao;
import lab2.entity.Species;
public class SpeciesManager {
	private static SpeciesDao speciesDao = lab2.util.SpringFactory.getSpeciesDao();

	public java.util.List<Species> getSpecies(){
		return speciesDao.getSpecies();
	}
	public java.util.List<Species> getSpeciesByDescription(String description){
		return speciesDao.getSpeciesByDescription(description); 
		
	}
	
	
	
	
}
