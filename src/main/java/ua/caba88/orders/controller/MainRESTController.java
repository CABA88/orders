package ua.caba88.orders.controller;

import java.util.List;

import ua.caba88.orders.dao.OrdDao;
import ua.caba88.orders.model.Ord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MainRESTController {
 
    @Autowired
    private OrdDao ordDao;
 
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees
    // http://localhost:8080/SpringMVCRESTful/employees.xml
    // http://localhost:8080/SpringMVCRESTful/employees.json
    @RequestMapping(value = "/orders", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Ord> getOrds() {
        List<Ord> list = ordDao.getAllOrds();
        return list;
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.xml
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.json
    @RequestMapping(value = "/ord/{idOrders}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ord getOrd(@PathVariable("idOrders") int idOrders) {
        return ordDao.getOrd(idOrders);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json
    @RequestMapping(value = "/orders", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ord addEmployee(@RequestBody Ord ord) {
 
        return ordDao.addOrd(ord);
 
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json
    @RequestMapping(value = "/ord", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ord updateEmployee(@RequestBody Ord ord) {
 
        return ordDao.updateOrd(ord);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteOrd(@PathVariable("idOrders") int idOrders) {
        ordDao.deleteOrd(idOrders);
    }
 
}