package com.busanit501.serverprogramtest2.todo.service;

import com.busanit501.serverprogramtest2.todo.dao.Menu2DAO;
import com.busanit501.serverprogramtest2.todo.domain.Menu2VO;
import com.busanit501.serverprogramtest2.todo.dto.Menu2DTO;
import com.busanit501.serverprogramtest2.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum Menu2Service {
    INSTANCE;

    private Menu2DAO menu2DAO;
    private ModelMapper modelMapper;

   Menu2Service() {
       menu2DAO = new Menu2DAO();

       modelMapper = MapperUtil.INSTANCE.get();
   }

   public void register2(Menu2DTO menu2DTO) throws Exception{
       Menu2VO menu2VO = modelMapper.map(menu2DTO, Menu2VO.class);

       log.info("menu2VO : " + menu2VO);

       menu2DAO.insert(menu2VO);
   }

   public List<Menu2DTO> listAll() throws Exception{
       List<Menu2VO> sampleList = menu2DAO.selectAll();
       log.info("Menu2Service , 확인 , samplelist : " + sampleList);
       List<Menu2DTO> sampleDatatoList = sampleList.stream()
               .map(vo -> modelMapper.map(vo,Menu2DTO.class))
               .collect(Collectors.toList());
       return sampleDatatoList;
   }

    public void register(Menu2DTO dto) {
        System.out.println("debug register dto 확인중 : " + dto);
    }

    public List<Menu2DTO> getList() {
        List<Menu2DTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            Menu2DTO dto = new Menu2DTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo Title " + i);
            dto.setMenuRegDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    }

    public List<Menu2DTO> getList2() {
        List<Menu2DTO> sampleList = new ArrayList<>();
    for (int i = 0; i <10; i++) {
            Menu2DTO dto = new Menu2DTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo" + i);
            dto.setMenuRegDate(LocalDate.now());
            sampleList.add(dto);
        }
        return sampleList;
    }
}