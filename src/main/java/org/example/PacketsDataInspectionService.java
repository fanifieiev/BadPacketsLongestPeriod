package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PacketsDataInspectionService {

    public InspectionResult findLongestAndWorstDataTransfer(final List<PackageData> packages) {
        var qualities = packages.stream().map(
                p -> p.getSuccess() - p.getFailed()).collect(Collectors.toList());

        //Let's use Kadane's algorithm to find minimum sum of any sub array
        //`min` contains the minimum sum of the sub-array or multiple sub arrays
        var min = qualities.get(0);
        int minCurrent = min;

        for(var i = 1; i < qualities.size(); i++) {
            var current = qualities.get(i);
            minCurrent = Math.min(current, minCurrent + current);
            min = Math.min(min, minCurrent);
        }
        //-----------------------------------------------------------------------------

        //Now let's use the algorithm of finding longest sub array having given sum
        var sums = new HashMap<Integer, Integer>();
        var longest = 0;//longest length of subarray
        var currentSum = 0;//prefix sum
        var tail = 0;//end index of the longest subarray
        sums.put(0, -1);

        for(var i =0; i < qualities.size(); i++) {
            currentSum += qualities.get(i);
            sums.putIfAbsent(currentSum, i);//putting current sum with appropriate index
            if(sums.containsKey(currentSum - min)) {
                longest = i - sums.get(currentSum - min);
                tail = i;
            }
        }

        var fromPackage = packages.get(tail - longest + 1);
        var toPackage = packages.get(tail);

        return new InspectionResult(min, fromPackage.getSentAt(), toPackage.getSentAt());
    }
}
