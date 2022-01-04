//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Mail;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//class SimpleEmailServiceTest {
//
//    @InjectMocks
//    private SimpleEmailService simpleEmailService;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
//    @Test
//    public void shouldSendEmail() throws MessagingException {
//
//        //Given
//        Mail mail = Mail.builder()
//                .mailTo("test@test.com")
//                .subject("test")
//                .message("Test Message")
////                .toCc("cc@test.com")
//                .build();
//
////        SimpleMailMessage mailMessage = new SimpleMailMessage();
////        mailMessage.setTo(mail.getMailTo());
////        mailMessage.setSubject(mail.getSubject());
////        mailMessage.setText(mail.getMessage());
////        mailMessage.setCc(mail.getToCc());
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setTo(mail.getMailTo());
//        helper.setSubject(mail.getSubject());
//        helper.setText(mail.getMessage());
////        helper.setCc(mail.getToCc());
//
//        //When
//        simpleEmailService.send(mail);
//
//        //Then
//        verify(javaMailSender, times(1)).send(message);
//    }
//}