package com.bhagavatula.spring5.cms.domain.resources;


import com.bhagavatula.spring5.cms.domain.models.Category;
import com.bhagavatula.spring5.cms.domain.vo.CategoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api( tags = "Category", description = "Category API")
public class CategoryResource {

    @GetMapping(value =  "/{id}")
    @ApiOperation(value = "Find category", notes = "Find category by id")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "category found"),
            @ApiResponse(code = 404, message = "Category not found ")
        })
    public ResponseEntity<Category> fineOne(@PathVariable("id") String id){

        return ResponseEntity.ok(new Category());

    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "categories found"),
            @ApiResponse(code = 404, message = " Category not found")
    })
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits creation of new categories")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Invalid Request")
    })
    public ResponseEntity<Category> newCategory(CategoryRequest category){
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Remove Category", notes="it helps delete categories")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message="category removed successfully"),
                    @ApiResponse(code = 404, message = "Category not found")
            }
    )
    public void removeCategory(@PathVariable("id") String id){

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Category", notes = "It permits updating category")
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "category updated"),
            @ApiResponse(code = 404 , message = "category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id){
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }


}
