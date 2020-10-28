import java.util.Stack;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Example 1:
 *
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * Output: 3
 *
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 */

public class GasStation {

    /**
     * This algorithm only considers starting points where the cost of traveling to the next gas station is less than the amount of fuel a person can get at the station
     * With the starting points in stack, a while loop keeps popping elements from the stack and tests each starting point
     * starting point is returned if a successful loop can be made
     *
     * @param gas array of gas each gas station can provide
     * @param cost cost of gas to travel to next gas station from the current gas station
     * @return valid starting point or -1 if it's impossible to make a loop from any starting point
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //stack data structure to keep track of valid starting points
        Stack<Integer> startingLocations = new Stack<>();
        for(int x = 0; x < gas.length; x++) {
            if (gas[x] >= cost[x]) {
                startingLocations.add(x);
            }
        }
        //run the algo for each valid starting point
        while(!startingLocations.isEmpty()){
            int start = startingLocations.pop();
            int currGas = gas[start];
            boolean success = true;

            //loops through the array n times (where n is the length of the array), to see if a person could loop through
            //index of the gas and cost arrays is updated using curr+x and mod n
            for(int x = 0; x < gas.length; x++) {
                int costToNext = cost[(start+x)%n];
                int nextFuel = gas[(start+x+1)%n];
                currGas -= costToNext ;
                if (currGas < 0) {
                    success = false;
                    break;
                }
                currGas += nextFuel;
            }
            if(success == true) {
                return start;
            }

        }
        return -1;
    }
}
