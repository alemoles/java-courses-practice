package com.devstromo.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public void run(List<Vertex> vertexList, List<Edge> edgeList) {
        var disjointSet = new DisjointSet(vertexList);
        var mst = new ArrayList<Edge>();
        // use merge sort to sort the edges
        Collections.sort(edgeList);
        for (var edge : edgeList) {
            var u = edge.start();
            var v = edge.target();
            // the edge is in the MST is the nodes are in different sets
            if (disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())) {
                mst.add(edge);
            }
            //we have to merge the sets
            disjointSet.union(u.getNode(), v.getNode());

        }
        // show mst
        for (var edge : mst) {
            System.out.println(edge);
        }
    }
}
