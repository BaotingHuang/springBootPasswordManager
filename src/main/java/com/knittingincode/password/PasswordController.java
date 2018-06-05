package com.knittingincode.password;

import com.knittingincode.password.repository.Password;
import com.knittingincode.password.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by alisaarnold on 2/1/18.
 */

@RestController
@RequestMapping("/passwords")

public class PasswordController {
    private PasswordRepository passwordRepository;

    @Autowired
    public PasswordController(PasswordRepository passwordRepository){
        this.passwordRepository = passwordRepository;
    }

    @GetMapping
    public Iterable<Password> getAllPasswords(){
        return passwordRepository.findAll();
    }

    @PostMapping
    public Password createPassword(@RequestBody Password password){
        return passwordRepository.save(password);
    }
}
