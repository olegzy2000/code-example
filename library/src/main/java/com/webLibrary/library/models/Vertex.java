package com.webLibrary.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Component
@Entity
@JsonRootName(value = "vertex")
public class Vertex implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("xCoordinate")
    private String xCoordinate;
    @JsonProperty("yCoordinate")
    private String yCoordinate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="graph_id", nullable=false)
    private Graph graph;
    public Vertex(String xCoordinate, String yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Vertex() {
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

    public String getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(String xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(String yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(xCoordinate, vertex.xCoordinate) &&
                Objects.equals(yCoordinate, vertex.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vertex{");
        sb.append("xCoordinate=").append(xCoordinate);
        sb.append(", yCoordinate=").append(yCoordinate);
        sb.append('}');
        return sb.toString();
    }
}
