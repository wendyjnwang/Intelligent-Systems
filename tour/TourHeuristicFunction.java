package tour;
import java.util.Set;

import search.Node;
import search.NodeFunction;

public class TourHeuristicFunction implements NodeFunction{

	Set<City> allCities;
	City goalCity;
	
	public TourHeuristicFunction(Set<City> allCities,City GoalCity) {
		this.allCities = allCities;
		this.goalCity = GoalCity; 
	}

	@Override	
	public int computeCost(Node node) {
		TourState tourState = (TourState)node.state;
		City currentCity = tourState.currentCity;
		Set<City>visitedCities = tourState.getVisitedCities();
		int furthest = 0;
		City furthestCity = goalCity;
		for (City c: allCities) {
			if (visitedCities.contains(c)) {
//				System.out.print(c.name);
				continue;			
			}
			else if (c.name == currentCity.name) {
				continue;
			}
			else {
				int shortestByCity = currentCity.getShortestDistanceTo(c)+c.getShortestDistanceTo(goalCity);
					if (shortestByCity > furthest) {
						furthest = shortestByCity;
						furthestCity = c;}
				}
			}
//		System.out.println(currentCity.name);		
//		System.out.println(furthestCity.name);
//		int cost = furthest +furthestCity.getShortestDistanceTo(goalCity);
//		System.out.println(cost);
//		System.out.println(visitedCities.size());
//		return furthest +furthestCity.getShortestDistanceTo(goalCity);
//		System.out.print(furthest);
//		System.out.println();
		return furthest;
	}

}
