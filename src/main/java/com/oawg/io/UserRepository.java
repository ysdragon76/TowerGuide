package com.oawg.io;

import com.oawg.io.domain.DrivePlaceMarkerVO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DrivePlaceMarkerVO, Long> {

}
