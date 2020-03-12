package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.Adopt;
import com.example.animals.pojo.Goods;
import com.example.animals.request.AddAdoptRequest;
import com.example.animals.request.AdoptRequest;
import com.example.animals.service.AdoptService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-21 17:48
 **/
@RestController
@RequestMapping("/adopt")
public class AdoptController {
    @Autowired
    private AdoptService adoptService;

    @GetMapping("/find/all")
    public SzpJsonResult<List<Adopt>> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(adoptService.findAll(page, size));
    }

    @GetMapping("/find/{id}")
    public SzpJsonResult<Adopt> findById(@PathVariable("id") Long id) {
        return SzpJsonResult.ok(adoptService.findById(id));
    }

    @GetMapping("/find/animal/{animalId}")
    public SzpJsonResult<Adopt> findAdoptByAnimalId(@PathVariable("animalId") Long animalId) {
        return SzpJsonResult.ok(adoptService.findAdoptByAnimalId(animalId));
    }


    @GetMapping("/find/user/{userId}")
    public SzpJsonResult<Adopt> findAdoptByUserId(@PathVariable("userId") Long userId) {
        Adopt adoptByUserId = adoptService.findAdoptByUserId(userId);
        return SzpJsonResult.ok(adoptByUserId);
    }

    @PostMapping("/insert")
    public SzpJsonResult<Integer> insertAdopt(@RequestBody AddAdoptRequest addAdoptRequest) {
        return SzpJsonResult.ok(adoptService.insertAdopt(addAdoptRequest));
    }

    @PutMapping("/update")
    public SzpJsonResult<Integer> updateAdopt(@RequestBody AdoptRequest adoptRequest) {
        return SzpJsonResult.ok(adoptService.updateAdopt(adoptRequest));
    }

    @PutMapping("/update/status")
    public SzpJsonResult<Integer> updateStatus(@RequestBody AdoptRequest adoptRequest) {
        return SzpJsonResult.ok(adoptService.updateStatus(adoptRequest));
    }

}
