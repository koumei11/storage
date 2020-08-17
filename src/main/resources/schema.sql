CREATE TABLE IF NOT EXISTS USERS (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(20),
  salt VARCHAR(1000),
  password VARCHAR(1000),
  firstname VARCHAR(20),
  lastname VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS NOTES (
    noteid INT PRIMARY KEY auto_increment,
    notetitle VARCHAR(20),
    notedescription VARCHAR(1000),
    userid INT,
    FOREIGN KEY (userid) REFERENCES USERS(userid)
);

CREATE TABLE IF NOT EXISTS FILES (
    fileId INT PRIMARY KEY auto_increment,
    filename VARCHAR(1000),
    contenttype VARCHAR(1000),
    filesize VARCHAR(1000),
    userid INT,
    filedata BLOB,
    FOREIGN KEY (userid) REFERENCES USERS(userid)
);

CREATE TABLE IF NOT EXISTS CREDENTIALS (
    credentialid INT PRIMARY KEY auto_increment,
    url VARCHAR(100),
    username VARCHAR (30),
    encryptionKey VARCHAR(1000),
    password VARCHAR(1000),
    userid INT,
    FOREIGN KEY (userid) REFERENCES USERS(userid)
);