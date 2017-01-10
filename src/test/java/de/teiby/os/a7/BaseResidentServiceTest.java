package de.teiby.os.a7;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import de.teiby.meldeauskunft.domain.Resident;
import de.teiby.meldeauskunft.repository.ResidentRepositoryStub;
import de.teiby.meldeauskunft.service.BaseResidentService;
import de.teiby.meldeauskunft.service.ResidentServiceException;

public class BaseResidentServiceTest {

	@Test
	public void testGetFilteredResidentsList() {
		BaseResidentService baseResidentService = new BaseResidentService();
		baseResidentService.setResidentRepository(new ResidentRepositoryStub());

		Resident filter = null;
		List<Resident> filteredResidentsList;

		// Vorname beginnt mit He
		filter = new Resident();
		filter.setGivenName("He*");
		filteredResidentsList = baseResidentService.getFilteredResidentsList(filter);
		for (Resident r : filteredResidentsList)
			assert (r.getGivenName().startsWith("He"));
		assertEquals(3, filteredResidentsList.size());

		// Exakte Suche nach Straßenname
		filter = new Resident();
		filter.setStreet("Baumstraße 3");
		filteredResidentsList = baseResidentService.getFilteredResidentsList(filter);
		assertEquals(2, filteredResidentsList.size());
		for (Resident r : filteredResidentsList)
			assertEquals(r.getStreet(), "Baumstraße 3");

		// Zwei Filter
		filter = new Resident();
		filter.setStreet("Baumstraße 5");
		filter.setGivenName("Her*");
		filteredResidentsList = baseResidentService.getFilteredResidentsList(filter);
		assertEquals(1, filteredResidentsList.size());

	}

	@Test
	public void testgetUniqueResident() {
		BaseResidentService baseResidentService = new BaseResidentService();
		baseResidentService.setResidentRepository(new ResidentRepositoryStub());

		Resident filter = null;

		// Suche nach einer Person in Straße Baumstraße 5
		try {
			filter = new Resident();
			filter.setStreet("Baumstraße 5");
			Resident uniqueResident = baseResidentService.getUniqueResident(filter);
			assertEquals("Baumstraße 5", uniqueResident.getStreet());
		} catch (ResidentServiceException e) {
			e.printStackTrace();
			assert (false);
		}

		// Zwei Ergebnisse => ResidentServiceException
		try {
			filter = new Resident();
			filter.setStreet("Baumstraße 3");
			baseResidentService.getUniqueResident(filter);
			fail();
		} catch (ResidentServiceException e) {
		}

		// Kein Ergebnis => ResidentServiceException
		try {
			filter = new Resident();
			filter.setGivenName("Lala");
			baseResidentService.getUniqueResident(filter);
			fail();
		} catch (ResidentServiceException e) {
		}
	}
}
