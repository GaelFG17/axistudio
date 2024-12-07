package repository;

import model.User;
//import com.example.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos adicionales si necesitas búsquedas personalizadas
}