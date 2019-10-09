
create table category(
                         id bigint primary key auto_incriment,
                         name varchar (100)
);

create table product(
                        id bigint primary key auto_inrement,
                        name vacrchar(100),
                        category id foreign key references category(id)
);

