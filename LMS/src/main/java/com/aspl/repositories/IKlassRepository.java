package com.aspl.repositories;

import com.aspl.entities.Klass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IKlassRepository extends CrudRepository<Klass,Integer> {
    Klass findByName(String name);
}
