create database dong_bo_du_lieu;
use dong_bo_du_lieu;
drop database dong_bo_du_lieu;
create table users(
user_id int auto_increment,
email varchar(30),
pass varchar(30),
user_roll varchar(30),
primary key(user_id)
);
create table directory_server(
directory_server_id int auto_increment,
user_id int,
action_name varchar(30),
folder varchar(30),
check_action bit,
primary key(directory_server_id),
foreign key (user_id) references users(user_id)
);
create table `schedule`(
schedule_int int auto_increment,
start_time datetime,
end_time datetime,
count_time int,
primary key(schedule_int)
);
create table `profile`(
profile_id int auto_increment,
user_id int,
proflie_name varchar(30),
remote_path_server varchar(500),
remote_path_client varchar(500),
directory_server_id int,
schedule_int int,
primary key(profile_id),
unique key schedule_int(schedule_int),
foreign key (user_id) references users(user_id),
foreign key (directory_server_id) references directory_server(directory_server_id),
foreign key (schedule_int) references `schedule`(schedule_int)
);
create table directory_user(
directory_user_id int auto_increment,
user_id int,
directory_server_id int,
profile_id int,
primary key(directory_user_id),
foreign key (user_id) references users(user_id),
foreign key (directory_server_id) references directory_server(directory_server_id),
foreign key (profile_id) references `profile`(profile_id)
);

INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('phat@gmail.com', '123456', 'admin');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('khai@gmail.com', '123456', 'admin');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('phuoc@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('hoang@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('long@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('nhan@gmail.com', '123456', 'user');

INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('1', 'them', 'java', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('1', 'sua', 'html', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('1', 'xoa', 'js', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('3', 'them', 'java', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('3', 'sua', 'html', b'0');
INSERT INTO `dong_bo_du_lieu`.`directory_server` (`user_id`, `action_name`, `folder`, `check_action`) VALUES ('3', 'xoa', 'js', b'0');

INSERT INTO `dong_bo_du_lieu`.`schedule` (`start_time`, `end_time`, `count_time`) VALUES ('2021-10-30 14:00:00', '2021-10-30 15:00:00', '3600');
INSERT INTO `dong_bo_du_lieu`.`schedule` (`start_time`, `end_time`, `count_time`) VALUES ('2021-10-29 16:00:00', '2021-10-30 16:00:00', '86400');



DELIMITER //
DROP PROCEDURE IF EXISTS checkUser //
CREATE PROCEDURE checkUser()
BEGIN
	DECLARE result bit;
    DECLARE thongbao varchar(255);
	select check_action into result from users as u
		join directory_user as du on u.user_id = du.user_id
		join directory_server as ds on du.directory_server_id = ds.directory_server_id
		where u.user_id = 13 and ds.folder = 'html';
	begin
		if result = 1 then
			set thongbao = 'Ban CO quyen dong bo thu muc html';
		else
			set thongbao = 'Ban KHONG CO quyen dong bo thu muc html';
            end if;
		select thongbao;
	end;
END //
DELIMITER ;
call checkUser();