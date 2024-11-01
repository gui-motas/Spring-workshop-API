package com.gui_motas.workshop_spring_jpa.repositories;

import com.gui_motas.workshop_spring_jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


}
