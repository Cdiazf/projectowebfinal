package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.dto.UserRegistrationDto;
import cibertec.edu.pe.projectowebfinal.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
