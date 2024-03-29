package com.oawg.io.web;

import com.oawg.io.dao.DriveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oawg.io.domain.DrivePlaceMarkerVO;

import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/json") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DriveDataRepository driveDataRepository;

//    @GetMapping(path="/findByStateAndZip") // Map ONLY GET Requests
//    public @ResponseBody
//    List<DrivePlaceMarkerVO> getDriveDataByStateAndZip (@RequestParam String state, @RequestParam String zipCode) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        DrivePlaceMarkerVO n = new DrivePlaceMarkerVO();
//        return driveDataRepository.findByStateAndZipIgnoreCase(state, zipCode);
//    }

    @GetMapping(path="/byState") // Map ONLY GET Requests
    public @ResponseBody
    List<DrivePlaceMarkerVO> getDriveDataByState (@RequestParam String state) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        DrivePlaceMarkerVO n = new DrivePlaceMarkerVO();

        List<DrivePlaceMarkerVO> drivePlaceMarkerVOList =  driveDataRepository.findByLocStIgnoreCase(state);
        return drivePlaceMarkerVOList;
    }

    @GetMapping(path="/byStateAndCounty") // Map ONLY GET Requests
    public @ResponseBody
    List<DrivePlaceMarkerVO> getDriveDataByStateAndCounty (@RequestParam String state, @RequestParam String county) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        DrivePlaceMarkerVO n = new DrivePlaceMarkerVO();

        List<DrivePlaceMarkerVO> drivePlaceMarkerVOList =  driveDataRepository.findByLocStAndLocCntyIgnoreCase(state, county);
        return drivePlaceMarkerVOList;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<DrivePlaceMarkerVO> getAllDriveData() {
        // This returns a JSON or XML with the users
        Iterable<DrivePlaceMarkerVO> drivePlaceMarkerVOList = driveDataRepository.findAll();
        return drivePlaceMarkerVOList;
    }
}