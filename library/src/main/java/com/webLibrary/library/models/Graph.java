package com.webLibrary.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Component
@Entity
public class Graph implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "graph",cascade = CascadeType.ALL)
    @JsonProperty("vertexesList")
    private List<Vertex> vertexesList;

    @OneToMany(mappedBy = "graph",cascade = CascadeType.ALL)
    @JsonProperty("edgesList")
    private List<Edge> edgesList;

    public Graph(List<Vertex> vertexesList, List<Edge> edgesList ,String name) {
        this.vertexesList = vertexesList;
        this.edgesList = edgesList;
        this.name=name;
    }

    public Graph() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getVertexesList() {
        return vertexesList;
    }

    public void setVertexesList(List<Vertex> vertexesList) {
        this.vertexesList = vertexesList;
    }

    public List<Edge> getEdgesList() {
        return edgesList;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(name, graph.name) &&
                Objects.equals(vertexesList, graph.vertexesList) &&
                Objects.equals(edgesList, graph.edgesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vertexesList, edgesList);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Graph{");
        sb.append("name='").append(name).append('\'');
        sb.append(", vertexesList=").append(vertexesList);
        sb.append(", edgesList=").append(edgesList);
        sb.append('}');
        return sb.toString();
    }
}
