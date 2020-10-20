/*
package com.amt.example.fullstackapp.model.req;


import org.apache.tomcat.jni.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;


class UserDTOTest {

    private static Validator validator;

    @Before
    public static void setupValidatorInstance() {
        validator = buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotBlankName_thenNoConstraintViolations(){
        UserDTO userDTO = new UserDTO("Amrit Malla");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        assertTrue(violations.size() == 0);
    }

    @Test
    public void whenBlankName_thenOneConstraintViolation(){
        UserDTO userDTO = new UserDTO(" ");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        assertTrue(violations.size() == 1);
    }
}*/
