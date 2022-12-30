package com.meatup.meatup.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/api")
public class LoginController {

    @Autowired
    Firestore db;
    @PostMapping("/verify")
    public String LoginAndVerifyToken(@RequestBody String token) {
        FirebaseToken decodedToken = null;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (FirebaseAuthException e) {
            System.out.println(e);
        }
        System.out.println(decodedToken.getUid());
        try {
            ApiFuture<DocumentSnapshot> docRef = db.collection("users").document("users").get();
            DocumentSnapshot future = docRef.get();
            System.out.println(future.contains(decodedToken.getUid()));
            if (!future.contains(decodedToken.getUid())) {
                Map<String,Object> newUser = new HashMap<>();
                newUser.put(decodedToken.getUid(), "");
                db.collection("users").document("users").set(newUser);
            }
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        }
        return decodedToken.getUid();
    }
}
