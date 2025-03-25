package com.chrzsean.projects.Spring.Boot.Web.App.Todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {


    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();

        this.todoRepository = todoRepository;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedinUsername(model);

        // Debug output: shows the logged-in username in the console
        System.out.println("Logged in username: " + username);

        // Get todos from the database by username
        List<Todo> todos = todoRepository.findByUsername(username);

        // Add todos to the model for the view (Thymeleaf/JSP/whatever you're using)
        model.addAttribute("todos", todos);

        // Return the view name (list-todos.html or list-todos.jsp)
        return "list-todos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedinUsername(model);
        Todo todo = new Todo(username, "", LocalDate.now().plusYears(1), false); // ✅ No ID assigned
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);

//        todoService.addTodo(username, todo.getDescription(),
//                todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
//        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//        Todo todo = todoService.findById(id);
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            model.put("todo", todo);
            return "todo";
        }

        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }


    private static String getLoggedinUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }




}
