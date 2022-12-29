package com.meatup.meatup.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(FirebaseProperties.class)
public class FirebaseConfiguration {
    private final FirebaseProperties firebaseProperties;

    @Bean
    public GoogleCredentials googleCredentials() {
        try {
            if (firebaseProperties.getServiceAccount()!=null) {
                try(InputStream is = firebaseProperties.getServiceAccount().getInputStream()) {
                    return GoogleCredentials.fromStream(is);
                }
            }
            else return GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public FirebaseApp firebaseApp(GoogleCredentials credentials) {
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(credentials).build();
        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore getDB(FirebaseApp app) {
        return FirestoreClient.getFirestore(app);
    }
}
