package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

//    public String buildTrelloCardEmail(String message) {
//
//        List<String> functionality = new ArrayList<>();
//        functionality.add("You can manage your tasks");
//        functionality.add("Provides connection with Trello Account");
//        functionality.add("Application allows sending tasks to Trello");
//
//        Context context = new Context();
//        context.setVariable("message", message);
//        context.setVariable("tasks_url", "https://localhost:3306/task_crud/");
//        context.setVariable("button", "Visit website");
//        context.setVariable("admin_name", adminConfig.getAdminName());
//        context.setVariable("show_button", false);
//        context.setVariable("is_friend", false);
//        context.setVariable("admin_config", adminConfig);
//        context.setVariable("application_functionality", functionality);
//        context.setVariable("goodbye_message", "Good bye");
//        context.setVariable("company_details", adminConfig.getCompanyName());
//        return templateEngine.process("mail/created-trello-card-mail", context);
//    }

    public String buildInformationEmail(String message) {

        List <String> tasksList = taskRepository.findAll().stream()
                .map(Task::getTitle)
                .collect(Collectors.toList());

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("preview_message", "Available tasks: " + taskRepository.count());
        context.setVariable("tasks_url", "https://gtrofimiec.github.io/");
        context.setVariable("button", "Check on CRUD App");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("admin_config", adminConfig);
        context.setVariable("company_details", adminConfig.getCompanyName());
        context.setVariable("tasks_list", tasksList);
        return templateEngine.process("mail/number-of-tasks-available-in-the-database", context);
    }
}