package com.meatup.meatup.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.meatup.meatup.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    @Autowired
    Firestore db;

    @PostMapping("/sendMsg")
    public void sendMessage(@RequestBody Message message) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId()).document(message.getUser());
        ApiFuture<WriteResult> res = docRef.set(message.getContent(), SetOptions.merge());
        System.out.println("Update: "+res.get().getUpdateTime());
    }
}
