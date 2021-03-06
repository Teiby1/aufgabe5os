package de.teiby.meldeauskunft.repository;

import java.util.List;

import de.teiby.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}