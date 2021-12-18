package com.webLibrary.library.repositori;

import com.webLibrary.library.models.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepository extends JpaRepository<Graph,Long> {
    Graph findByName(String name);
}
