package com.revature.firebaseSecurity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UnauthenticatedLibraryCard extends UsernamePasswordAuthenticationToken {

    public UnauthenticatedLibraryCard(String bearerToken) {
        super(null, bearerToken);
    }
}