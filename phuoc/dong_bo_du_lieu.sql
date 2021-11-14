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
create table `directory`(
directory_id int auto_increment,
directory_name varchar(30),
folder varchar(30),
check_action bit,
primary key(directory_id)
);
create table `schedule`(
schedule_int int auto_increment,
start_time datetime,
end_time datetime,
count_time int,
primary key(schedule_int)
);
create table directory_user(
directory_user_id int auto_increment,
user_id int,
directory_id int,
primary key(directory_user_id),
foreign key (user_id) references users(user_id),
foreign key (directory_id) references `directory`(directory_id)
);
create table `profile`(
profile_id int auto_increment,
user_id int,
proflie_name varchar(30),
remote_path_server varchar(500),
remote_path_client varchar(500),
directory_user_id int, -- directory_user_id
schedule_int int,
primary key(profile_id),
unique key schedule_int(schedule_int),
foreign key (user_id) references users(user_id),
foreign key (directory_user_id) references directory_user(directory_user_id),
foreign key (schedule_int) references `schedule`(schedule_int)
);


INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('phat@gmail.com', '123456', 'admin');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('khai@gmail.com', '123456', 'admin');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('phuoc@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('hoang@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('long@gmail.com', '123456', 'user');
INSERT INTO `dong_bo_du_lieu`.`users` (`email`, `pass`, `user_roll`) VALUES ('nhan@gmail.com', '123456', 'user');

INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phat', 'java', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phat', 'html', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phat', 'js', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phuoc', 'java', b'1');
INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phuoc', 'html', b'0');
INSERT INTO `dong_bo_du_lieu`.`directory` (`directory_name`, `folder`, `check_action`) VALUES ('phuoc', 'js', b'0');

INSERT INTO `dong_bo_du_lieu`.`schedule` (`start_time`, `end_time`, `count_time`) VALUES ('2021-10-30 14:00:00', '2021-10-30 15:00:00', '3600');
INSERT INTO `dong_bo_du_lieu`.`schedule` (`start_time`, `end_time`, `count_time`) VALUES ('2021-10-29 16:00:00', '2021-10-30 16:00:00', '86400');

INSERT INTO `dong_bo_du_lieu`.`directory_user` (`user_id`, `directory_id`) VALUES ('1', '1');
INSERT INTO `dong_bo_du_lieu`.`directory_user` (`user_id`, `directory_id`) VALUES ('1', '3');
INSERT INTO `dong_bo_du_lieu`.`directory_user` (`user_id`, `directory_id`) VALUES ('3', '3');
INSERT INTO `dong_bo_du_lieu`.`directory_user` (`user_id`, `directory_id`) VALUES ('3', '5');

INSERT INTO `dong_bo_du_lieu`.`profile` (`user_id`, `proflie_name`, `remote_path_server`, `remote_path_client`, `directory_user_id`, `schedule_int`) VALUES ('1', 'phat', 'java', 'phat', '1', '1');
INSERT INTO `dong_bo_du_lieu`.`profile` (`user_id`, `proflie_name`, `remote_path_server`, `remote_path_client`, `directory_user_id`, `schedule_int`) VALUES ('3', 'phuoc', 'java', 'phuoc', '3', '2');

DELIMITER //
DROP PROCEDURE IF EXISTS findUser //
CREATE PROCEDURE findUser()
BEGIN
	DECLARE result nvarchar(1000);
    DECLARE ketqua nvarchar(1000);
	SET result = 'Nhung quyen hien tai cua user (';
	select `email` as ketqua from users where user_id = "1"
    union
	select concat(concat(ketqua, `folder`), ', ') as ketquacuoi from users as u
		join directory_user as du on u.user_id = du.user_id
		join `directory` as d on du.directory_id = d.directory_id
		where u.user_id = "1" and d.check_action = 1
	union
	select result = substring(result, 0, length(result));
    select ketquacuoi;
END //
DELIMITER ;
call findUser();

DELIMITER //
DROP PROCEDURE IF EXISTS checkUser //
CREATE PROCEDURE checkUser()
BEGIN
	DECLARE result bit;
    DECLARE thongbao varchar(255);
	select check_action into result from users as u
		join directory_user as du on u.user_id = du.user_id
		join `directory` as ds on du.directory_id = ds.directory_id
		where u.user_id = 3 and ds.folder = 'html';
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

-- lay email, password
SELECT email,pass FROM users WHERE email = ? AND pass = ?;
-- lay duong dan 
-- lay thoi gian profile
SELECT `profile`.`proflie_name`, `schedule`.start_time, `schedule`.end_time FROM `profile` inner join `schedule` on `schedule`.schedule_int = `profile`.schedule_int;