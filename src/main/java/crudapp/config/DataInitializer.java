package crudapp.config;

import crudapp.model.LoginUser;
import crudapp.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Cria um usuário admin se não existir
        if (loginUserRepository.findByUsername("admin").isEmpty()) {
            LoginUser adminUser = new LoginUser();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            loginUserRepository.save(adminUser);
            System.out.println("Usuário admin criado com sucesso!");
        }
    }
}