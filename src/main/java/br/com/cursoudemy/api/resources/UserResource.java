package br.com.cursoudemy.api.resources;

import br.com.cursoudemy.api.domain.dto.UsersDTO;
import br.com.cursoudemy.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok()
                .body(mapper.map(service.findById(id), UsersDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<UsersDTO>> findAll() {
        return ResponseEntity.ok()
                .body(service.findAll()
                        .stream().map(x->mapper.map(x,UsersDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UsersDTO>create(@RequestBody UsersDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UsersDTO> update(@PathVariable Integer id, @RequestBody UsersDTO obj){
        obj.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(obj), UsersDTO.class));
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<UsersDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
