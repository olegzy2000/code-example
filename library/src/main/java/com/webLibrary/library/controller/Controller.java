package com.webLibrary.library.controller;

import com.webLibrary.library.models.Edge;
import com.webLibrary.library.models.Graph;
import com.webLibrary.library.models.Vertex;
import com.webLibrary.library.repositori.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class Controller {
    static Logger LOGGER= Logger.getLogger(Controller.class.getName());
    @Autowired
    private GraphRepository graphRepository;
    @GetMapping("/getAllNames")
    public String getAllWorkNames(){
        StringBuilder result=new StringBuilder();
        List<Graph> graphs=graphRepository.findAll();
        for(Graph graph:graphs){
            result.append(graph.getName())
                    .append(",");
        }
        return result.substring(0,result.length()-1);
    }
    @GetMapping("/find")
    public Graph findByName(@RequestParam String name) {
        Graph graph=graphRepository.findByName(name);
        for (Vertex vertex:graph.getVertexesList())
            vertex.setGraph(null);
        for(Edge edge:graph.getEdgesList())
            edge.setGraph(null);
        LOGGER.info("-------------------------------");
        if(graph!=null)
        LOGGER.info(graph.toString());
        else
            LOGGER.info("GRAPH not found");
        LOGGER.info("-------------------------------");
        return graph;
    }
}
