package com.idpuwid;

import com.idpuwid.security.AppRole;
import com.idpuwid.security.AppUser;
import com.idpuwid.security.RoleRepository;
import com.idpuwid.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository){
        return args -> {
            AppRole appRole1 = AppRole.builder().roleName("ADMIN").build();
            roleRepository.save(appRole1);

            AppRole appRole2 = AppRole.builder().roleName("USER").build();
            roleRepository.save(appRole2);

            Collection<AppRole> authorities = new ArrayList<>();
            authorities.add(appRole1);
            AppUser appUser = AppUser.builder().username("IDPUWID").password("santika").roles(authorities).build();
            userRepository.save(appUser);
        };
    }
}
