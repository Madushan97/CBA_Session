package com.session.nipuna.session_nipuna.mapper;

import com.session.nipuna.session_nipuna.dto.responseDto.StudentResponseDto;
import com.session.nipuna.session_nipuna.model.Student;
import com.session.nipuna.session_nipuna.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final ModelMapper modelMapper;

    public StudentResponseDto entityToResponseDto(Student student) {
        return modelMapper.map(student, StudentResponseDto.class);
    }
}
