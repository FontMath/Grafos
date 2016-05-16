/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;


/**
 *
 * @author 0160670
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
		Graph graph = new SingleGraph("Tutorial 1");

		graph.addNode("A").addAttribute("xy",0,0);
		graph.addNode("B").addAttribute("xy",0,1);
		graph.addNode("C").addAttribute("xy",1,0);
		graph.addNode("D").addAttribute("xy",1,1);
		graph.addNode("E").addAttribute("xy",0.5,1);
		graph.addEdge("AB", "A", "B").addAttribute("weight",2);
		graph.addEdge("BC", "B", "C").addAttribute("weight",4);
		graph.addEdge("CA", "C", "A").addAttribute("weight",1);
		graph.addEdge("CD", "C", "D").addAttribute("weight",2);
		graph.addEdge("DE", "E", "D").addAttribute("weight",1);
                
                for(Node n:graph){
                    n.addAttribute("label", n.getId());
                }
                
                for(Edge e:graph.getEachEdge()){
                    e.addAttribute("label", (int)e.getNumber("weight"));
                }
                
                Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.NODE, null, "weight");
		dijkstra.init(graph);
		dijkstra.setSource(graph.getNode("B"));
		dijkstra.compute();
                System.out.println(dijkstra.getPath(graph.getNode("E")));

		graph.display(false);
	}
    
}
