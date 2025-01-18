//The time complexity of this code is O(V+E), where V is the number of vertices and E is the number of edges in the graph
//The code performs a breadth-first search,  O(V+E) time.

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphUtils<T> {
    public static <T> Set<T> findReachableNodes(Graph<T> graph, T a, T b){
        // implement your method here
        Set<T> set = new HashSet<>();

        LinkedList<T> visited1 = new LinkedList<>();
        LinkedList<T> visited2 = new LinkedList<>();
        LinkedList<T> queue1 = new LinkedList<>();
        LinkedList<T> queue2 = new LinkedList<>();

        T node = null;

        queue1.add(a);
        queue2.add(b);

        if(graph==null){
            return null;
        }
        if(a==null || b==null){
            return null;
        }

        while(!queue1.isEmpty()){
            node = queue1.get(0);
            queue1.remove(0);
    		visited1.add(node);
    		LinkedList<T> neighbors1 =(LinkedList<T>) graph.neighbors(node);
        	for(T i: neighbors1) {
                if(visited1.contains(i)){
                    queue1.add(i);
                }
            }
        }

        while(!queue2.isEmpty()){
            node = queue2.get(0);
            queue2.remove(0);
    		visited2.add(node);
    		LinkedList<T> neighbors2 =(LinkedList<T>) graph.neighbors(node);
        	for(T i: neighbors2) {
                if(visited2.contains(i)){
                    queue2.add(i);
                }
            }
        }

        for (T t : graph.getVertecesList()) {
            if(visited1.contains(t) && visited2.contains(t)){
                set.add(t);
            }
        }
        return set;

    }
}
