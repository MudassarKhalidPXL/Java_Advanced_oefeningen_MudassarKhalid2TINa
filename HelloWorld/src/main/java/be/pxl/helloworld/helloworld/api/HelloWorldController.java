package be.pxl.helloworld.helloworld.api;

import be.pxl.helloworld.helloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class HelloWorldController {

    @Autowired
    private HelloWorldService service;

    private final Map<Integer, String> messages = new HashMap<>();

    public HelloWorldController() {
        messages.put(1, "Hello World!");
        messages.put(2, "Hello PXL!");
    }

    // GET
    // http://localhost:8080/hello
    @GetMapping("/hello")
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(messages);
    }

    // GET met ID
    // http://localhost:8080/hello/1
    @GetMapping("/hello/{id}")
    public HttpEntity<?> getById(@PathVariable int id) {

        String message = messages.get(id);

        if (message == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(message);
    }

    // POST
    // http://localhost:8080/hello/3
    @PostMapping("/hello/{id}")
    public HttpEntity<?> addMessage(
            @PathVariable int id,
            @RequestBody String message) {

        messages.put(id, message);

        return ResponseEntity.ok(message);
    }

    // PUT
    // http://localhost:8080/hello/1
    @PutMapping("/hello/{id}")
    public HttpEntity<?> updateMessage(
            @PathVariable int id,
            @RequestBody String message) {

        if (!messages.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        messages.put(id, message);

        return ResponseEntity.ok(message);
    }

    // DELETE
    // http://localhost:8080/hello/1
    @DeleteMapping("/hello/{id}")
    public HttpEntity<?> deleteMessage(@PathVariable int id) {

        if (!messages.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        messages.remove(id);

        return ResponseEntity.ok().build();
    }

}