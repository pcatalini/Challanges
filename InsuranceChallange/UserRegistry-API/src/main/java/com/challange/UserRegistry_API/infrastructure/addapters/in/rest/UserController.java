package com.challange.UserRegistry_API.infrastructure.addapters.in.rest;


import com.challange.UserRegistry_API.application.dtos.request.UserRequest;
import com.challange.UserRegistry_API.application.dtos.response.UserResponse;
import com.challange.UserRegistry_API.application.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;


    @Operation(summary = "Create a new user", description = "Add a new user to the database")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest user) {
        final UserResponse createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a user By Id", description = "Delete just one user By Id")
    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a user By Id", description = "Update just one user By Id")
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String userId, @Valid @RequestBody UserRequest user) {
        final Optional<UserResponse> userResponseDTO = userService.updateUserById(userId, user);
        return userResponseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Operation(summary = "Get user", description = "Get a single user")
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
        final Optional<UserResponse> userById = userService.getUser(userId);
        return userById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
