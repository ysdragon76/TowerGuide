package com.oawg.io.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.oawg.io.dao.DriveDataRepository;
import com.oawg.io.domain.DrivePlaceMarkerVO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/webui")
@RestController
public class WebPortalControler {

    @Autowired
    private DriveDataRepository driveDataRepository;

    @RequestMapping(path = "/generateKmlBy/state/{state}", method = RequestMethod.GET, produces = "application/vnd.google-earth.kml+xml")
    String findByState(@PathVariable("state") String state) {
        String result = null;

        List<DrivePlaceMarkerVO> drivePlaceMarkerVOList =  driveDataRepository.findByLocStIgnoreCase(state);
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template template = ve.getTemplate("/templates/kmlTemplate.vm");

        VelocityContext context = new VelocityContext();
        context.put("resultList", drivePlaceMarkerVOList.subList(0,10));

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        result = writer.toString();

        return result;
    }

    @RequestMapping(path = "/generateKmlBy/county/{county}", method = RequestMethod.GET, produces = "application/vnd.google-earth.kml+xml")
    String findByCounty(@PathVariable("county") String county) {
        String result = null;

        List<DrivePlaceMarkerVO> drivePlaceMarkerVOList =  driveDataRepository.findByLocCntyIgnoreCase(county);
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template template = ve.getTemplate("/templates/kmlTemplate.vm");

        VelocityContext context = new VelocityContext();
        context.put("resultList", drivePlaceMarkerVOList);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        result = writer.toString();

        return result;
    }

    @RequestMapping(path = "/generateKmlBy/state/{state}/county/{county}", method = RequestMethod.GET, produces = "application/vnd.google-earth.kml+xml")
    String findByStateAndCounty(@PathVariable("state") String state, @PathVariable("county") String county)  {
        String result = null;

        List<DrivePlaceMarkerVO> drivePlaceMarkerVOList =  driveDataRepository.findByLocStAndLocCntyIgnoreCase(state, county);

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        VelocityContext context = new VelocityContext();
        Template template = ve.getTemplate("/templates/kmlTemplate.vm");

        context.put("resultList", drivePlaceMarkerVOList);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        result = writer.toString();

        return result;
    }

    @RequestMapping(path = "/findByStateAndCounty", method = RequestMethod.GET, produces = "application/vnd.google-earth.kml+xml")
    String generateKMLNetworkLink(@RequestParam String state, @RequestParam String county, HttpServletRequest request) {
        String result;
        String networkLink = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort()
                + "/generateKmlBy/state/"+state+"/county/"+county;

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        VelocityContext context = new VelocityContext();
        Template template = ve.getTemplate("/templates/kmlNetworkLinkTemplate.vm");

        context.put("networkLink", networkLink);
        context.put("name", "Tower Guide Master Data");

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        result = writer.toString();

        return result;
    }


    @RequestMapping(path = "/listDistinctStates.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<String> listDistinctStates() {
        String result = null;
        result = "";
        List<String> states = driveDataRepository.findDistinctStates();
        if(states != null)
            return states;
        else
            return new ArrayList<String>();
    }

    @RequestMapping(path = "/listDistinctCountyByState.json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody List<String> listDistinctStates(@RequestParam String state) {
        String result = null;
        result = "";
        List<String> counties = driveDataRepository.findDistinctCounties(state);
        if(counties != null)
            return counties;
        else
            return new ArrayList<String>();
    }
}
