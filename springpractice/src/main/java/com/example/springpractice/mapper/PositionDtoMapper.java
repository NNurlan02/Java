package com.example.springpractice.mapper;

import com.example.springpractice.dto.PositionDto;
import com.example.springpractice.entity.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PositionDtoMapper {
    public PositionDto entityToDto(Position position)
    {
        return new PositionDto(
                position.getId(),
                position.getPositionName(),
                position.getSalary()
        );
    }
    public Position dtoToEntity(PositionDto positionDto)
    {
        Position position = new Position();
        position.setPositionName(positionDto.getPositionName());
        position.setSalary(positionDto.getSalary());
        return position;
    }
    public void updateDto(PositionDto positionDto,Position position)
    {
        position.setPositionName(positionDto.getPositionName());
        position.setSalary(positionDto.getSalary());
    }
}
