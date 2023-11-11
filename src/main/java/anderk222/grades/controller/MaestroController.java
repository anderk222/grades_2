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
import anderk222.grades.entity.Maestro;
import anderk222.grades.service.MaestroService;
import anderk222.grades.validation.JsonValid;
import anderk222.grades.validation.SchemaLocations;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/grades/maestro")
public class MaestroController {

    @Autowired
    private MaestroService service;

    @GetMapping()
    public Response findAll() {

        return Response.body(service.findAll());

    }

    @PostMapping("/find")
    public Response find(@RequestBody @JsonValid(SchemaLocations.ID) Identificator data) {

        return Response.body(service.find(data.getId()));
         
    }


    @PostMapping()
    public Response save(@RequestBody @JsonValid(SchemaLocations.MAESTRO) Maestro maestro) {

        return Response.body(service.save(maestro));

    }

    @PostMapping("/update")
    public Response update(@RequestBody @JsonValid(SchemaLocations.MAESTRO) Maestro maestro){

        return Response.body(service.save(maestro));

    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(SchemaLocations.ID) Identificator data){

        return Response.body(service.delete(data.getId()));    
    }

}