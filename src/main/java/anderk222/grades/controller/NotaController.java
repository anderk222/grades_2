package anderk222.grades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anderk222.grades.dto.Identificator;
import anderk222.grades.dto.Response;
import anderk222.grades.entity.Nota;
import anderk222.grades.service.NotaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/grades/nota")
public class NotaController {

    @Autowired
    private NotaService service;

    @GetMapping()
    public Response findAll() {

        return Response.body(service.findAll());

    }

    @PostMapping("/find")
    public Response find(@RequestBody Identificator data) {

        return Response.body(service.find(data.getId()));

    }

    @PostMapping()
    public Response save(@RequestBody Nota nota) {

        return Response.body(service.save(nota));

    }

    @PostMapping("/update")
    public Response update(@RequestBody Nota nota) {

        return Response.body(service.save(nota));

    }

    @PostMapping("/delete")
    public Response delete(@RequestBody Identificator data) {

        return Response.body(service.delete(data.getId()));
    }

    @PostMapping("/countByEstudiante")
    public Response countByEstudiante(@RequestBody Identificator data) {

        return Response.body(service.countByEstudiante(data.getId()));

    }

    @PostMapping("/countByMateria")
    public Response countByMateria(@RequestBody Identificator data) {

        return Response.body(service.countByMateria(data.getId()));

    }

    @PostMapping("/findHightGradesByMaestro")
    public Response findHightGradesByMaestro(
            @RequestBody Identificator data,
            @RequestParam(name = "limit", defaultValue = "5", required = false) int limit) {

                List<Nota> notas = service.findHightGradesByMaestro(data.getId(), limit);
 
                return Response.body(notas);


    }
}