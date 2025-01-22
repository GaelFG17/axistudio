
package com.example.Areas.repositorio;

import com.example.Areas.Area.area;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AreaRepositorio extends JpaRepository<area, Long> {
List<area> findByArea(String area);
    @Override
    public List<area> findAll();
}
