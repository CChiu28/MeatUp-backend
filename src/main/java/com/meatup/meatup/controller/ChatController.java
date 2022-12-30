package com.meatup.meatup.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.meatup.meatup.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class ChatController {

    @Autowired
    Firestore db;

    @PostMapping("/sendMsg")
    public void sendMessage(@RequestBody Message message) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId()).document(message.getUser());
        ApiFuture<WriteResult> res = docRef.set(message.getContent(), SetOptions.merge());
//        ApiFuture<Void> futureTransaction = db.runTransaction(transaction -> {
//           DocumentSnapshot snapshot = transaction.get(docRef).get();
//           transaction.update(docRef,"",message.getContent());
//           return null;
//        });
//        System.out.println("Update: "+res.get().getUpdateTime());
    }

    @PostMapping(path="/getAllMsg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {"application/json"})
    public Map<String,Map<String,Object>> getAllMessages(@RequestBody Message message) throws ExecutionException, InterruptedException {
//        DocumentReference docRef = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId()).document(message.getUser());
//        ApiFuture<DocumentSnapshot> res = docRef.get();
//        DocumentSnapshot snapshot = res.get();
        ApiFuture<QuerySnapshot> colSnap = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId()).get();
        List<QueryDocumentSnapshot> refList = colSnap.get().getDocuments();
        Map<String,Map<String,Object>> list = new HashMap<>();
        for (QueryDocumentSnapshot doc: refList) {
            list.put(doc.getId(),doc.getData());
        }
        return list;
    }
}
