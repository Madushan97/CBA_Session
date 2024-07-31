package com.session.nipuna.session_nipuna.controller;

import com.session.nipuna.session_nipuna.dto.requestDto.StudentRequestDto;
import com.session.nipuna.session_nipuna.dto.responseDto.StudentResponseDto;
import com.session.nipuna.session_nipuna.service.StudentService;
import com.session.nipuna.session_nipuna.util.StandardResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {

        LOGGER.info("Received request to create student: {}", studentRequestDto);
        StudentResponseDto studentResponseDto = studentService.createStudent(studentRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Create student successfully",
                        studentResponseDto
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/getById/{studentId}")
    public ResponseEntity<StandardResponse> getStudentById(@PathVariable(value = "studentId")Integer studentId) {

        LOGGER.info("Received request to get student: {}", studentId);
        StudentResponseDto studentResponseDto = studentService.getStudentById(studentId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Get student successfully",
                        studentResponseDto
                ),
                HttpStatus.OK
        );
    }
}
