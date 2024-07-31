package com.session.nipuna.session_nipuna.service.impl;

import com.session.nipuna.session_nipuna.dto.requestDto.StudentRequestDto;
import com.session.nipuna.session_nipuna.dto.responseDto.StudentResponseDto;
import com.session.nipuna.session_nipuna.exception.ResourceNotFoundException;
import com.session.nipuna.session_nipuna.exception.StudentAlreadyExistException;
import com.session.nipuna.session_nipuna.mapper.StudentMapper;
import com.session.nipuna.session_nipuna.model.Student;
import com.session.nipuna.session_nipuna.repository.StudentRepository;
import com.session.nipuna.session_nipuna.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        LOGGER.info("Attempting to create student with name: {}", studentRequestDto.getName());
        if (studentRepository.existsByNameAndIsActive(studentRequestDto.getName(), Boolean.TRUE)) {
            LOGGER.warn("Student with name '{}' already exists", studentRequestDto.getName());
            throw new StudentAlreadyExistException("The specified student name already exists. Please choose a different name.");
        } else {
            Student student = new Student();

            student.setName(studentRequestDto.getName());
            student.setAddress(studentRequestDto.getAddress());
            student.setIsActive(studentRequestDto.getIsActive());
            LOGGER.info("Saving new student to repository: {}", student);
            Student savedStudent = studentRepository.save(student);

            StudentResponseDto studentResponseDto = studentMapper.entityToResponseDto(savedStudent);
            LOGGER.info("Student created successfully: {}", studentResponseDto);
            return studentResponseDto;

        }
    }

    @Override
    public StudentResponseDto getStudentById(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + studentId + " not found"));
        return studentMapper.entityToResponseDto(student);
    }
}
