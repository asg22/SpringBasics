package io.springsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.springsecurity.dao.MonitorDao;

@RestController
public class HealthController {

	private static Logger LOG = LoggerFactory.getLogger("HealthController");

	@Autowired
	private MonitorDao monitorDAO;
	
    
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path={"/ping" , "/monitor"})
    public String returnOk() {
        return "OK";
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path="/health")
    public String livenessTest() {
        monitorDAO.pingDB();
        return "OK";
    }
}
