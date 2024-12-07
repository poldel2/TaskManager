package com.example.TaskManager.service;

import com.example.TaskManager.model.RefreshToken;
import com.example.TaskManager.model.User;

import java.util.Optional;

public interface RefreshTokenService {
    public RefreshToken createRefreshToken(User user);
    public RefreshToken verifyExpiration (RefreshToken refreshToken);
    public void deleteByUser(User user);
    public Optional<RefreshToken> findByToken(String token);
}
