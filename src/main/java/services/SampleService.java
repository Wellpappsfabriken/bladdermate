package services;

import data.Employee;
import data.Mate;
import data.NightOut;
import org.joda.time.DateTime;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/sampleservice")
public class SampleService {

    private static Map<String, Employee> employees = new HashMap<String, Employee>();

    static {

        Employee employee1 = new Employee();
        employee1.setEmployeeId("1");
        employee1.setEmployeeName("Fabrizio");
        employee1.setJob("Software Engineer");
        employees.put(employee1.getEmployeeId(), employee1);

        Employee employee2 = new Employee();
        employee2.setEmployeeId("2");
        employee2.setEmployeeName("Justin");
        employee2.setJob("Business Analyst");
        employees.put(employee2.getEmployeeId(), employee2);

    }

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";
    }

    @GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;
    }

    @GET
    @Path("/employees")
    @Produces("application/xml")
    public List<Employee> listEmployees(){
        return new ArrayList<Employee>(employees.values());
    }

    @GET
    @Path("/employee/{employeeid}")
    @Produces("application/xml")
    public Employee getEmployee(@PathParam("employeeid")String employeeId){
        return employees.get(employeeId);
    }

    @GET
    @Path("/json/employees/")
    @Produces("application/json")
    public List<Employee> listEmployeesJSON(){
        return new ArrayList<Employee>(employees.values());
    }

    @POST
    @Path("/json/employee/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployeeJSON(Employee employee) {
        employees.put(employee.getEmployeeId(),employee);
    }

    @GET
    @Path("/mate")
    @Produces(MediaType.APPLICATION_JSON)
    public Mate getMate() {
        DateTime now = DateTime.now();
        NightOut no = new NightOut(now);
        no.addBreak(now.plusMinutes(5));
        no.addBreak(now.plusHours(2));
        Mate mate = new Mate("4");
        mate.addRecord(no);
        return mate;
    }

    @GET
    @Path("/json/employee/{employeeid}")
    @Produces("application/json")
    public Employee getEmployeeJSON(@PathParam("employeeid")String employeeId){
        return employees.get(employeeId);
    }

}