package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Random;

@RestController
// Rule Trigger: SPRING-OWASP-CORS-PERMISSIVE
// Why: Allowing all origins ('*') is insecure for production.
@CrossOrigin(origins = "*")
public class VulnerableController {

    // Rule Trigger: SPRING-OWASP-HARDCODED-SECRET-HEURISTIC
    // Why: Variable name implies secret + high entropy string literal.
    private static final String API_KEY = "AIzaSyD-1234567890abcdef1234567890";

    @GetMapping("/files")
    public String readFile(@RequestParam String filename) throws Exception {
        // Rule Trigger: SPRING-OWASP-PATH-TRAVERSAL-FILE
        // Why: Request input 'filename' is used directly in File constructor.
        // Attacker could send "../../../etc/passwd".
        File file = new File("user_uploads/" + filename);
        
        if (file.exists()) {
            return "File exists";
        }
        return "File not found";
    }

    @PostMapping("/hash")
    public byte[] hashPassword(@RequestParam String password) throws Exception {
        // Rule Trigger: SPRING-OWASP-WEAK-HASHING-MD5-SHA1
        // Why: MD5 is collision-vulnerable and too fast for passwords.
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(password.getBytes());
    }

    @GetMapping("/token")
    public String generateToken() {
        // Rule Trigger: SPRING-OWASP-INSECURE-RANDOM
        // Why: java.util.Random is not cryptographically secure.
        Random random = new Random();
        return "token-" + random.nextLong();
    }
}
