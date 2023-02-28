
     Можете да въвеждате и ЮЗЪРИ, и АДМИНИ от Register-формата.
!!!! ЗАБЕЛЕЖКА: За да работи приложението правилно, ролите задължително трябва да са: ROLE_USER или ROLE_ADMIN

     По-долу има 4 готови потребителя, които можете да въведете директно в БД :
     ( ИМЕНАТА И ПАРОЛИТЕ СА СЪОТВЕТНО : admin1, admin2, user1 и user2 )


INSERT INTO `users` (`id`, `enabled`, `password`, `role`, `username`) 
VALUES (NULL, b'1', '$2a$12$tOL2nL.g5pjBfg2op.5uS.Pp8eFpVEvkmb57ggob/m2gqa44vXPWm', 'ROLE_ADMIN', 'admin1');

INSERT INTO `users` (`id`, `enabled`, `password`, `role`, `username`) 
VALUES (NULL, b'1', '$2a$12$Rlm.YUYlXjHPMkZDZIriCusByJUm2lIdlpBvxAAayJaXpOyIPL9MG', 'ROLE_ADMIN', 'admin2');

INSERT INTO `users` (`id`, `enabled`, `password`, `role`, `username`) 
VALUES (NULL, b'1', '$2a$12$3J63Gpv9sJOBCdgcNzby6eIfnJgA3yZ5P.7I0pJsOQnrerHy9h.Im', 'ROLE_USER', 'user1');

INSERT INTO `users` (`id`, `enabled`, `password`, `role`, `username`) 
VALUES (NULL, b'1', '$2a$12$LpdDReDLV9Uco8.3/bi./ubbB6FiDTdtbrpYSxyo4rdWmKjtLj4dO', 'ROLE_USER', 'user2');

