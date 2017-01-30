package com.aspl.services;

import com.aspl.entities.Klass;
import com.aspl.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {
    private IKlassRepository klassRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    public Klass create(Klass k) {
        return this.klassRepository.save(k);
    }

    public Klass findKlassById(int id) {
        return this.klassRepository.findOne(id);
    }


    public Klass findById(int id){
        return this.klassRepository.findOne(id);
    }

    public Klass findByName(String name){
        return this.klassRepository.findByName(name);
    }

}
