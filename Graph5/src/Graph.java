import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    // store edges in the graph
    Map<T, List<T>> map = new HashMap<>();

    // adds a new vertex to the graph
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    // adds the edge between source to destination
    public void addEdge(T source, T destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + " vertex");
    }

    // gives the count of edges
    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has " + count + " edges");
    }

    // gives whether a vertex is present or not
    public void hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex");
        }
        else {
            System.out.println("The graph does not contain " + s + " as a vertex");
        }
    }

    // gives whether an edge is present or not
    public void hasEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d);
        }
        else {
            System.out.println("The graph has no edge between " + s +  " and "  + d);
        }
    }

    // prints the adjancency list of each vertex
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + ": ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

}
