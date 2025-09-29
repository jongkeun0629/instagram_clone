package com.jongkeun.backend.controller;

import com.jongkeun.backend.dto.UserResponse;
import com.jongkeun.backend.dto.UserUpdateRequest;
import com.jongkeun.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        UserResponse user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@Valid @RequestBody UserUpdateRequest request) {
        UserResponse updatedUser = userService.updateProfile(request);
        return ResponseEntity.ok(updatedUser);
    }
}
