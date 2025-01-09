package com.example.springpractice.service.impl;

import com.example.springpractice.dto.PositionDto;
import com.example.springpractice.entity.User;
import com.example.springpractice.mapper.PositionDtoMapper;
import com.example.springpractice.service.PositionService;
import com.example.springpractice.entity.Position;
import com.example.springpractice.repository.PositionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostionServiceImpl implements PositionService {
    private final PositionRepository repo;
    private final PositionDtoMapper pdt;

    @Override
    public List<PositionDto> findByAll() {
        List<Position> positions = repo.findAll();
        return positions.stream()
                .map(pdt::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDto findById(Long id) {
        Optional<Position> positionOptional = repo.findById(id);
        if(positionOptional.isPresent())
        {
            Position position = positionOptional.get();
            return pdt.entityToDto(position);
        }
        else{
            throw new EntityNotFoundException("Position not found with  id:"+id);
        }
    }

    @Override
    public PositionDto savePosition(PositionDto positionDto) {
        Position position = pdt.dtoToEntity(positionDto);
        Position positionSave= repo.save(position);
        return pdt.entityToDto(positionSave);
    }

    @Override
    public PositionDto updatePosition(PositionDto positionDto) {
        Position position =  repo.findById(positionDto.getId()).orElseThrow(()->new RuntimeException("Position not found"));
        pdt.updateDto(positionDto,position);
        Position updatePosition = repo.save(position);
        return pdt.entityToDto(updatePosition);
    }

    @Override
    @Transactional
    public void deletePosition(Long id) {
        repo.deleteById(id);
    }
}
