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
create table `profile`(
profile_id int auto_increment,
user_id int,
proflie_name varchar(30),
remote_path varchar(500),
directory_server_id int,
primary key(profile_id),
foreign key (user_id) references users(user_id),
foreign key (directory_server_id) references directory_server(directory_server_id)
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