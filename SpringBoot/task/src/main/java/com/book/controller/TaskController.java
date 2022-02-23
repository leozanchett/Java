package com.book.controller;

import com.book.dto.TaskDto;
import com.book.service.TaskService;
import com.book.todo.entity.Task;
import com.book.uri.TaskURI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RepositoryRestController
@RequestMapping("/todo/")
@RequiredArgsConstructor
public class TaskController {
    private final PagedResourcesAssembler pagedResourcesAssembler;
    private final TaskService taskService;

    @GetMapping(path = TaskURI.TASKS)
    public ResponseEntity<?> getTasks(TaskDto taskDto, Pageable pageable, PersistentEntityResourceAssembler resourceAssembler){
        log.info("TaskController: " + taskDto);
        Page<Task> events = taskService.getTasks(pageable);
        PagedModel<?> resource = pagedResourcesAssembler.toModel(events, resourceAssembler);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = TaskURI.TASK)
    public ResponseEntity<?> getTask(@PathVariable("id") int taskId, Pageable pageable, PersistentEntityResourceAssembler resourceAssembler){
        try {
            log.info("TaskController:  " + taskId);
            Task task = taskService.getTask(taskId);
            Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getTask(taskId, pageable, resourceAssembler)).withSelfRel();
            Link allTasksLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash("/tasks").withRel("all tasks");
            EntityModel<Task> entityModel = EntityModel.of(task);
            entityModel.add(selfLink, allTasksLink);
            return ResponseEntity.ok(entityModel);
        }catch (RuntimeException runtimeException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found ", runtimeException);
        }
    }
}
