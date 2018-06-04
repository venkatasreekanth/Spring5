package com.bhagavatula.spring5.cms.domain.resources;


import com.bhagavatula.spring5.cms.domain.models.Category;
import com.bhagavatula.spring5.cms.domain.vo.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Category> fineOne(@PathVariable("id") String id){

        return ResponseEntity.ok(new Category());

    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    public ResponseEntity<Category> newCategory(CategoryRequest category){
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory(@PathVariable("id") String id){

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id){
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }


}
