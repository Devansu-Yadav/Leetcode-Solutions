import java.lang.Math;

class AvgSalaryExcludingMinMax {
    // T.C: O(N), Space Complexity: O(1)
    public double average(int[] salary) {
        double sum = 0;

        // finding min and max salaries
        int minSalary = salary[0];
        int maxSalary = salary[0];
        for(int i = 1; i < salary.length; i++) {
            if(salary[i] < minSalary) {
                minSalary = salary[i];
            } else if(salary[i] > maxSalary) {
                maxSalary = salary[i];
            }
        }

        for(int sal: salary) {
            if(sal != minSalary && sal != maxSalary) {
                sum += sal;
            }
        }
        return sum / (salary.length - 2);
    }

    // T.C: O(N), Space Complexity: O(1)
    public double averageOptimized(int[] salary) {
        double sum = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int sal: salary) {
            max = Math.max(max, sal);
            min = Math.min(min, sal);
            sum += sal;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}