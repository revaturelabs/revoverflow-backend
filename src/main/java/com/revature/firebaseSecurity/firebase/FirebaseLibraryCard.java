package com.revature.firebaseSecurity.firebase;

import com.google.firebase.auth.FirebaseToken;
import com.revature.firebaseSecurity.LibraryCard;

public class FirebaseLibraryCard extends LibraryCard {
    public FirebaseLibraryCard(FirebaseToken token) {
        super(token.getClaims());
    }
}
