package com.helloIftekhar.springJwt.repository;


import com.helloIftekhar.springJwt.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findById(Long id);
}
