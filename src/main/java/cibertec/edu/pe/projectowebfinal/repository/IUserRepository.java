package cibertec.edu.pe.projectowebfinal.repository;

import cibertec.edu.pe.projectowebfinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
