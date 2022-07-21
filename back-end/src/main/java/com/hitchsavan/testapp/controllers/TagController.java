package com.hitchsavan.testapp.controllers;

import java.util.List;
import java.util.Objects;

import com.hitchsavan.testapp.models.Tag;
import com.hitchsavan.testapp.repository.TagRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    
    private final TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public List<Tag> getTags() {
        return (List<Tag>) tagRepository.findAll();
    }
    
    @PostMapping
    void addTag(@RequestBody Tag tag) {
        tagRepository.save(tag);
    }

    @DeleteMapping(path = "{id}")
    void deleteTag(@PathVariable("id") Long id) {
        if(!tagRepository.existsById(id)) {
            throw new IllegalStateException(
                "Tag with " + id + "does not exist"
            );
        }
        tagRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    void updateProduct( @PathVariable("id") Long id,
                        @RequestParam(required = false) String name) {
        Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "Report with " + id + "does not exist"
            ));

        if(name != null &&
            !Objects.equals(tag.getName(), name)) {
            tag.setName(name);
            }
    }
}
