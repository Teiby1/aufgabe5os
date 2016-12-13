package de.teiby.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.teiby.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

	List<Resident> r = null;

	@Override
	public List<Resident> getResidents() {
		if (r == null) {
			r = new ArrayList<>();
			r.add(new Resident("Karl", "Hauser", "Gassenweg 2", "Berlin", new Date(1990, 1, 5)));
			r.add(new Resident("Helga", "Renner", "Baumstra�e 3", "Berlin", new Date(1990, 1, 5)));
			r.add(new Resident("Herbert", "Herzberger", "Hintere Gasse 4", "Stuttgart", new Date(1990, 1, 5)));
			r.add(new Resident("Hermann", "Dr�lf", "Baumstra�e 5", "M�nchen", new Date(1990, 1, 5)));
			r.add(new Resident("Benjamin", "Herzberger", "Baumstra�e 3", "M�nchen", new Date(1990, 1, 5)));
		}
		return r;
	}

}
