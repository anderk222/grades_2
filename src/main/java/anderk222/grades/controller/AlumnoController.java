package anderk222.grades.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.dto.Response;
import anderk222.grades.entity.Alumno;
import anderk222.grades.service.AlumnoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/grades/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping()
    public Response findAll() {

        return Response.body(service.findAll());

    }

    @PostMapping("/find")
    public Response find(@RequestBody Identificator data) {

        return Response.body(service.find(data.getId()));
         
    }


    @PostMapping()
    public Response save(@RequestBody Alumno alumno) {

        return Response.body(service.save(alumno));

    }

    @PostMapping("/update")
    public Response update(@RequestBody Alumno alumno){

        return Response.body(service.save(alumno));

    }

    @PostMapping("/delete")
    public Response delete(@RequestBody Identificator data){

        return Response.body(service.delete(data.getId()));    
    }


    @PostMapping("/countByMaestro")
    public Response countByMaestro(@RequestBody Identificator data){

        return Response.body(service.countByMaestro(data.getId()));

    }

    
}