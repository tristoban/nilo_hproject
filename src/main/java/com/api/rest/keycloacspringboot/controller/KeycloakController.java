package com.api.rest.keycloacspringboot.controller;


import com.api.rest.keycloacspringboot.controller.dto.UserDTO;
import com.api.rest.keycloacspringboot.service.IKeycloakService;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping ("/keycloak/user")
@PreAuthorize("hasRole('admin_client_role')")
public class KeycloakController {


    @Autowired
    private IKeycloakService keycloakService;

    @GetMapping("/search/{username}")
    public ResponseEntity<?> findAllsUsers(@PathVariable String username){
        return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        String response = keycloakService.createUser(userDTO);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        return ResponseEntity.noContent().build();
    }
}
