CREATE TABLE blog (
blog_id bigint PRIMARY KEY,
blog_title varchar(255) NOT NULL,
category_name varchar(50) NOT NULL,
blog_image varchar(255) NOT NULL,
article text NOT NULL,
account_id bigint NOT NULL REFERENCES account(account_id)
);

CREATE TABLE account (
account_id bigint PRIMARY KEY,
account_name varchar(255) NOT NULL,
account_email varchar(255) NOT NULL,
password varchar(255) NOT NULL
);