package com.webLibrary.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Component
@Entity
public class Edge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("first")
    private String numberFirstVertex;
    @JsonProperty("second")
    private String numberSecondVertex;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="graph_id", nullable=false)
    private Graph graph;
    public Edge(String numberFirstVertex, String numberSecondVertex) {
        this.numberFirstVertex = numberFirstVertex;
        this.numberSecondVertex = numberSecondVertex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Edge() {
    }

    public String getNumberFirstVertex() {
        return numberFirstVertex;
    }

    public void setNumberFirstVertex(String numberFirstVertex) {
        this.numberFirstVertex = numberFirstVertex;
    }

    public String getNumberSecondVertex() {
        return numberSecondVertex;
    }

    public void setNumberSecondVertex(String numberSecondVertex) {
        this.numberSecondVertex = numberSecondVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(numberFirstVertex, edge.numberFirstVertex) &&
                Objects.equals(numberSecondVertex, edge.numberSecondVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberFirstVertex, numberSecondVertex);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Edge{");
        sb.append("numberFirstVertex='").append(numberFirstVertex).append('\'');
        sb.append(", numberSecondVertex='").append(numberSecondVertex).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
