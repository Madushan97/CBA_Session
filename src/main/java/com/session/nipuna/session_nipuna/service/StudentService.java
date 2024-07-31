package com.session.nipuna.session_nipuna.service;

import com.session.nipuna.session_nipuna.dto.requestDto.StudentRequestDto;
import com.session.nipuna.session_nipuna.dto.responseDto.StudentResponseDto;

public interface StudentService {

    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);
    StudentResponseDto getStudentById(Integer studentId);
}
