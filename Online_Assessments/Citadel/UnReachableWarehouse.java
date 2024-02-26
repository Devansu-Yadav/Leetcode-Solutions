package Online_Assessments.Citadel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnReachableWarehouse {
    public static void main(String[] args) {
        int warehouse_node = 6;
        int warehouse_edges = 5;
        List<Integer> warehouse_from = Arrays.asList(1,2,4,5,4);
        List<Integer> warehouse_to = Arrays.asList(2,3,5,6,6);
        System.out.println("Min unreachable nodes - " + countMinimumUnreachableWarehouses(warehouse_node,
                warehouse_edges, warehouse_from, warehouse_to));
    }

    public static int countMinimumUnreachableWarehouses(int warehouse_nodes, int warehouse_edges,
    List<Integer> warehouse_from, List<Integer> warehouse_to) {
        int indegree[] = new int[warehouse_nodes];

        for(int i = 0; i < warehouse_edges; i++) {
            int nodeIdx = warehouse_to.get(i) - 1;
            indegree[nodeIdx]++;
        }

        int count = 0;
        for(int degree: indegree) {
            if(degree == 0) {
                count++;
            }
        }
        return count;
    }
}
