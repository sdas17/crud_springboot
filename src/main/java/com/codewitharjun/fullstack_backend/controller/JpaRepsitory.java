package com.codewitharjun.fullstack_backend.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepsitory extends JpaRepository<User, Long> {

}
