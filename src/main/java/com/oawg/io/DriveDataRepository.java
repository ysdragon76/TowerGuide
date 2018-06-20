package com.oawg.io;

import com.oawg.io.domain.DrivePlaceMarkerVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DriveDataRepository extends CrudRepository<DrivePlaceMarkerVO, Long> {
//    public List<DrivePlaceMarkerVO> findByStateAndZipIgnoreCase(String state, String zip);
    public List<DrivePlaceMarkerVO> findByLocStIgnoreCase(String state);
    public List<DrivePlaceMarkerVO> findByLocCntyIgnoreCase(String cnty);
    public List<DrivePlaceMarkerVO> findByLocStAndLocCntyIgnoreCase(String state, String cnty);
    public Iterable<DrivePlaceMarkerVO> findAllById(Iterable<Long> iterable);
}
