package com.webLibrary.library.controller;

import com.webLibrary.library.models.Edge;
import com.webLibrary.library.models.Graph;
import com.webLibrary.library.models.Vertex;
import com.webLibrary.library.repositori.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class DrawController {
   static Logger LOGGER= Logger.getLogger(DrawController.class.getName());
    @Autowired
    private GraphRepository graphRepository;

    @PostMapping("/save")
    public String save(@RequestBody Graph graph, Model model) {
        LOGGER.info("-------------------------------");
        for(Edge edge:graph.getEdgesList())
            edge.setGraph(graph);
        for(Vertex vertex:graph.getVertexesList())
            vertex.setGraph(graph);
        LOGGER.info(graph.toString());
        LOGGER.info("-------------------------------");
        graphRepository.save(graph);
        return "home";
    }
}
