class UndergroundSystem {
    // Stores active customers: customer ID -> (start station, check in time)
    private Map<Integer, Pair<String, Integer>> checkInMap;
    // Stores route stats: start station + end station ->  [total time, trip count]
    private Map<String, int[]> route;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        route = new HashMap<>();
    }

    public void checkIn(int id, String startStation, int t) {
        // Record customer start station and check in time
        // Key: customer ID | Value: (station name, check in time)
        checkInMap.put(id, new Pair<>(startStation, t));
    }

    public void checkOut(int id, String endStation, int t) {
        // Get the customer's stored info
        Pair<String, Integer> entry = checkInMap.get(id);
        // Build the customer's route key with start station + end station
        String routeKey = entry.getKey() + "," + endStation;
        // If this route has not been recorded before, intialize it
        route.putIfAbsent(routeKey, new int[]{0, 0});
        // Add this trip's time to total (end station time - start station time)
        route.get(routeKey)[0] += t - entry.getValue();
        // Increment the trip counter
        route.get(routeKey)[1] += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        // Get the route stats using the start and end station as the key
        int[] data = route.get(startStation + "," + endStation);
        // Calculate the average time using total time / number of trips
        return (double) data[0]/data[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */