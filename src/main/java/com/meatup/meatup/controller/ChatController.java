//package com.meatup.meatup.controller;
//
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.*;
//import com.meatup.meatup.model.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:5173","https://meatup1028.netlify.app/"})
//public class ChatController {
//
//    @Autowired
//    Firestore db;
//
//    @PostMapping("/sendMsg")
//    public ArrayList<Map<String, Object>> sendMessage(@RequestBody Message message) throws ExecutionException, InterruptedException {
//        CollectionReference colRef = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId());
//        DocumentReference docRef = colRef.document();
//        ApiFuture<WriteResult> res = docRef.set(message.getContent(), SetOptions.merge());
//        return getCurrentMsg(message);
//    }
//
//    @PostMapping(path="/getAllMsg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {"application/json"})
//    public ArrayList<Map<String, Object>> getAllMessages(@RequestBody Message message) throws ExecutionException, InterruptedException {
//        return getCurrentMsg(message);
//    }
//
//    private ArrayList<Map<String, Object>> getCurrentMsg(Message message) throws ExecutionException, InterruptedException {
//        ApiFuture<QuerySnapshot> colSnap = db.collection("chatrooms").document(message.getBusinessId()).collection(message.getChatroomId()).get();
//        List<QueryDocumentSnapshot> refList = colSnap.get().getDocuments();
//        Map<String,Map<String,Object>> list = new TreeMap<>();
//        ArrayList<Map<String, Object>> newList = new ArrayList<>();
//        for (QueryDocumentSnapshot doc: refList) {
//            newList.add(doc.getData());
//        }
//        newList.sort(new MapComparator("time"));
//        return newList;
//    }
//}
