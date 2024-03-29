package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Scheduled(fixedDelay = 2000000)
//    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        message(size),
                        null
                )
        );
    }

//    @Scheduled(fixedDelay = 2000000)
//    @Scheduled(cron = "0 0 10 * * *")
//    public void sendTasksAmountEmail() {
//        simpleEmailService.send(
//                new Mail(
//                        adminConfig.getAdminMail(),
//                        SUBJECT,
//                        tasksAmountMessage(),
//                        null
//                )
//        );
//    }

    public String message(long size) {
        String message = "Currently in database you got: " + size + " task";
        if(size!=1) {
            message += "s";
        }
        return message;
    }

//    public String tasksAmountMessage() {
//        String DB_URL = "jdbc:mysql://localhost:3306/task_crud";
//        String USER = "root";
//        String PASS = "George01!";
//        String QUERY = "SELECT COUNT(*) AS total FROM tasks";
//        String result = "";
//
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(QUERY);
//            rs.next();
//            result = Integer.toString(rs.getInt("total"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "Number of tasks available in the database: " + result;
//    }
}