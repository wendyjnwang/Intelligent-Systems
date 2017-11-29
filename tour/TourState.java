package tour;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import npuzzle.Tiles;
import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	
	/* To allow heuristics to access visited cities and Goal City*/
	public Set<City> getVisitedCities(){
		return this.visitedCities;}
	
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}
	@Override
	public boolean equals(State s) {
		if (this == s)
			return true; 
		if (s == null)
			return false; 
		if (getClass()!=s.getClass())
			return false; 
		final TourState other = (TourState)s;
		if (currentCity.getName().equals(other.currentCity.getName()) 
			&& visitedCities.containsAll(other.visitedCities) 
			&& other.visitedCities.containsAll(visitedCities))
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return currentCity.hashCode() + visitedCities.hashCode();
		
	}
}
