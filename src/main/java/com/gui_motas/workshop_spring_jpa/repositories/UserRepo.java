package com.gui_motas.workshop_spring_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gui_motas.workshop_spring_jpa.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {



}
