create table address
(
    id         int AUTO_INCREMENT primary key,
    line_1     varchar(255) not null,
    line_2     varchar(255),
    line_3     varchar(255),
    postalCode int          not null
);

create table contact_details
(
    id     int AUTO_INCREMENT primary key,
    mobile varchar(10) not null,
    home   varchar(10),
    work   varchar(10)
);

create table customer
(
    id int AUTO_INCREMENET primary key,
    id_number int unique not null,
    contact_details int not null,
    full_name varchar(255) not null,
    address int not null,
    foreign key (contact_details) references contact_details(id),
    foreign key (address) references address(id)
)

create table account
(
    id                  int AUTO_INCREMENT primary key,
    account_number      decimal(12) unique not null,
    account_holder_name varchar(255)       not null,
    account_holder_id_number           decimal(13) unique not null,
    address             int                not null,
    contact_details     int                not null references contact_details (id),
    foreign key (account_holder_id_number) references customer(id_number),
    foreign key (address) references address (id),
    foreign key (account_holder_name) references customer(full_name),
    foreign key (contact_details) references contact_details (id)
);

create table bill
(
    id          int AUTO_INCREMENT primary key,
    bill_date   date       not null,
    account     int        not null,
    bill_period varchar(7) not null,
    charges     decimal    not null,
    outstanding decimal    not null,
    due_date    date       not null,
    foreign key (account) references account (id)
);

create table statement
(
    id           int AUTO_INCREMENT primary key,
    statement_id varchar(20) not null unique,
    account      int         not null,
    foreign key (account) references account (id)
);
