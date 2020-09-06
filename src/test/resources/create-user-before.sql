delete from user_role;
delete from usr;

insert into usr(id, active, password, username) values
(1, true, '$2a$08$oBjEitCjYLiNs7T.6.RYgO8kHWfW9wTp5gJOKEqGCDWmD4RXu6nCG', 'admin'),
(2, true, '$2a$08$oBjEitCjYLiNs7T.6.RYgO8kHWfW9wTp5gJOKEqGCDWmD4RXu6nCG', 'alex');

insert into user_role(user_id, roles) values
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');
